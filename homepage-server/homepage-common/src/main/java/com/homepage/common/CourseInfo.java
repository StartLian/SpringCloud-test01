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
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseIcon() {
		return courseIcon;
	}

	public void setCourseIcon(String courseIcon) {
		this.courseIcon = courseIcon;
	}

	public String getCourseIntro() {
		return courseIntro;
	}

	public void setCourseIntro(String courseIntro) {
		this.courseIntro = courseIntro;
	}

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

	@Override
	public String toString() {
		return "CourseInfo [id=" + id + ", courseName=" + courseName + ", courseType=" + courseType + ", courseIcon="
				+ courseIcon + ", courseIntro=" + courseIntro + "]";
	}
    
}
