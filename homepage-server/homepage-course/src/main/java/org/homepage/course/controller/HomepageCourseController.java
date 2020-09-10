package org.homepage.course.controller;

import java.util.List;

import org.homepage.course.service.ICourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.homepage.common.CourseInfo;
import com.homepage.common.CourseInfosRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * <h2>课程对外服务接口</h2>
 * Created by Qinyi.
 */
@Slf4j
@RestController
public class HomepageCourseController {
	Logger log = (Logger) LoggerFactory.getLogger(HomepageCourseController.class);
    /** 课程服务接口 */
    private final ICourseService courseService;

    @Autowired
    public HomepageCourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * <h2>获取课程信息</h2>
     * 127.0.0.1:7001/homepage-course/get/course?id=
     * 127.0.0.1:9000/imooc/homepage-course/get/course?id=
     * */
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id) {

        log.info("<homepage-course>: get course -> {}", JSON.toJSONString(id));
        return courseService.getCourseInfo(id);
    }

    /**
     * <h2>获取课程信息</h2>
     * 127.0.0.1:7001/homepage-course/get/courses
     * 127.0.0.1:9000/imooc/homepage-course/get/courses
     * */
    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {

        log.info("<homepage-course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
