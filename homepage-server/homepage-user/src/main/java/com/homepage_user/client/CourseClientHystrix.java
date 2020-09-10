package com.homepage_user.client;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;
import com.homepage_user.controller.HomepageUserController;
/**
 * <h1>熔断降级</h1>
 * Created by Qinyi.
 */
@Component
public class CourseClientHystrix implements CourseClient {
	Logger log = (Logger) LoggerFactory.getLogger(CourseClientHystrix.class);
    @Override
    public CourseInfo getCourseInfo(Long id) {
    	log.info("CourseInfo.invalid()");
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
    	log.info("Collections.emptyList()");
        return Collections.emptyList();
    }
}
