package com.homepage_user.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;

@FeignClient(value = "eureka-client-homepage-course", fallback = CourseClientHystrix.class)
public interface CourseClient {
	@RequestMapping(value = "/homepage-course/get/course", method = RequestMethod.GET)
    CourseInfo getCourseInfo(Long id);

    @RequestMapping(value = "/homepage-course/get/courses", method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
