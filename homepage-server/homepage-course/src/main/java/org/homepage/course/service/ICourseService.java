package org.homepage.course.service;

import java.util.List;

import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;

/**
 * <h1>课程相关服务接口定义</h1>
 * Created by Qinyi.
 */
public interface ICourseService {

    /**
     * <h2>通过 id 获取课程信息</h2>
     * @param id 课程 id
     * @return {@link CourseInfo}
     * */
    CourseInfo getCourseInfo(Long id);

    /**
     * <h2>通过 ids 获取课程信息</h2>
     * @param request {@link CourseInfosRequest}
     * @return {@link CourseInfo}s
     * */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
