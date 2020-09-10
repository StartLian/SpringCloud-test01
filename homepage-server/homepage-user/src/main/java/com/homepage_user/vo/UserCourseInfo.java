package com.homepage_user.vo;

import java.util.Collections;
import java.util.List;

import com.homepage.common.CourseInfo;
import com.homepage.common.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>用户课程信息对象定义</h1>
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfo {

    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    
    
    public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public List<CourseInfo> getCourseInfos() {
		return courseInfos;
	}


	public void setCourseInfos(List<CourseInfo> courseInfos) {
		this.courseInfos = courseInfos;
	}


	public UserCourseInfo(UserInfo userInfo, List<CourseInfo> courseInfos) {
		this.userInfo = userInfo;
		this.courseInfos = courseInfos;
	}


	public static UserCourseInfo invalid() {

        return new UserCourseInfo(
                UserInfo.invalid(),
                Collections.emptyList()
        );
    }
}
