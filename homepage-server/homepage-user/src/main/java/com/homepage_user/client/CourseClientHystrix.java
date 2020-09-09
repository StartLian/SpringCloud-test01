package com.homepage_user.client;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;
/**
 * <h1>熔断降级</h1>
 * Created by Qinyi.
 */
@Component
public class CourseClientHystrix implements CourseClient {

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
