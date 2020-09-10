package com.homepage.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>课程信息请求对象定义</h1>
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {

   

	private List<Long> ids;

	
	public List<Long> getIds() {
		return ids;
	}


	public void setIds(List<Long> ids) {
		this.ids = ids;
	}


	public CourseInfosRequest(List<Long> ids) {
		this.ids = ids;
	}



	public CourseInfosRequest() {
		super();
	}
	
}