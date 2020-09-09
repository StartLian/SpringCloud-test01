package com.homepage_user.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.andrewoma.dexx.collection.ArrayList;
import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;
import com.homepage.common.UserInfo;
import com.homepage_user.client.CourseClient;
import com.homepage_user.dao.HomepageUserCourseDao;
import com.homepage_user.dao.HomepageUserDao;
import com.homepage_user.entity.HomepageUser;
import com.homepage_user.entity.HomepageUserCourse;
import com.homepage_user.service.IUserService;
import com.homepage_user.vo.CreateUserRequest;
import com.homepage_user.vo.UserCourseInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * <h1>用户相关服务实现</h1>
 * Created by Qinyi.
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    /** HomepageUser Dao */
    private final HomepageUserDao homepageUserDao;

    /** HomepageUserCourse Dao */
    private final HomepageUserCourseDao homepageUserCourseDao;

    private final CourseClient courseClient;

    @Autowired
    public UserServiceImpl(HomepageUserDao homepageUserDao, HomepageUserCourseDao homepageUserCourseDao,
                           CourseClient courseClient) {
        this.homepageUserDao = homepageUserDao;
        this.homepageUserCourseDao = homepageUserCourseDao;
        this.courseClient = courseClient;
    }

    @Override
    public UserInfo createUser(CreateUserRequest request) {

        if (!request.validate()) {
            return UserInfo.invalid();
        }

        HomepageUser oldUser = homepageUserDao.findByUsername(request.getUsername());
        if (null != oldUser) {
            return UserInfo.invalid();
        }

        HomepageUser newUser = homepageUserDao.save(new HomepageUser(
                request.getUsername(), request.getEmail()
        ));

        return new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        HomepageUser curUser = user.get();
        return new UserInfo(curUser.getId(), curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }

        HomepageUser homepageUser = user.get();
        UserInfo userInfo = new UserInfo(homepageUser.getId(), homepageUser.getUsername(),
                homepageUser.getEmail());

        List<HomepageUserCourse> userCourses = homepageUserCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        for (HomepageUserCourse homepageUserCourse : userCourses) {
        	arrayList.append(homepageUserCourse.getId());
		}
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest((List<Long>) arrayList)
                );
        

        return new UserCourseInfo(userInfo, courseInfos);
    }

}
