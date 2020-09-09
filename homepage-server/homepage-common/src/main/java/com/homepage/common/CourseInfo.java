package com.homepage.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>课程信息</h1>
 * Created by Qinyi.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {

	private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;
    
    public CourseInfo(Long id, String courseName, String courseType, String courseIcon, String courseIntro) {
    	this.id = id;
    	this.courseName = courseName;
    	this.courseType = courseType;
    	this.courseIcon = courseIcon;
    	this.courseIntro = courseIntro;
    }

    public static CourseInfo invalid() {

        return new CourseInfo(-1L, "", "", "", "");
    }
}
