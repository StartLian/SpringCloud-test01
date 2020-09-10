package com.homepage_user.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	Logger log = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);
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

        log.info("request.getUsername():{}",request.getUsername());
        HomepageUser oldUser = homepageUserDao.findByUsername(request.getUsername());
        log.info("000");
        if (null != oldUser) {
        	log.info("oldUser:{}",oldUser.toString());
            return UserInfo.invalid();
        }
        log.info("111");
        HomepageUser newUser = homepageUserDao.save(new HomepageUser(
                request.getUsername(), request.getEmail()
        ));
        log.info("222");
        log.info("newUser:{}",newUser.toString());
        UserInfo userInfo = new UserInfo(newUser.getId(), newUser.getUsername(), newUser.getEmail());
        log.info("userInfo:{}",userInfo.toString());
        return userInfo;
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
        log.info("userCourses:{}",userCourses.toString());
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }
//        List<Long> arrayList = new List();
//        for (HomepageUserCourse homepageUserCourse : userCourses) {
//        	arrayList.append(homepageUserCourse.getId());
//		}
//        
//        log.info("arrayList:{}",arrayList.toString());
//        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
//                new CourseInfosRequest((List<Long>) arrayList)
//                );
        CourseInfo courseInfo = courseClient.getCourseInfo(15L);
        log.info("courseInfo:{}",courseInfo);
        List<Long> collect = userCourses.stream().map(HomepageUserCourse::getCourseId).collect(Collectors.toList());
        log.info("collect:{}",collect.toString());
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(
                        userCourses.stream().map(HomepageUserCourse::getCourseId).collect(Collectors.toList())
                )
        );
        log.info("courseInfos:{}",courseInfos);
        return new UserCourseInfo(userInfo, courseInfos);
    }

}
