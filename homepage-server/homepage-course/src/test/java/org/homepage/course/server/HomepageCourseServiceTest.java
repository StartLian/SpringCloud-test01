package org.homepage.course.server;

import java.util.Arrays;

import org.homepage.course.Application;
import org.homepage.course.dao.HomepageCourseDao;
import org.homepage.course.entity.HomepageCourse;
import org.homepage.course.service.ICourseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.homepage.common.CourseInfosRequest;

/**
* <h1>课程服务测试</h1>
* Created by Qinyi.
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

   @Autowired
   private HomepageCourseDao courseDao;

   @Autowired
   private ICourseService courseService;

   @Test
   public void testCreateCourseInfo() {

       HomepageCourse course1 = new HomepageCourse(
               "JDK11&12 新特性解读",
               0,
               "https://www.imooc.com/",
               "解读 JDK11 和 JDK12 的新版本特性"
       );
       HomepageCourse course2 = new HomepageCourse(
               "基于Spring Cloud微服务架构 广告系统设计与实现",
               1,
               "https://www.imooc.com/",
               "广告系统的设计与实现"
       );

       System.out.println(courseDao.saveAll(Arrays.asList(course1, course2)).size());
   }

   @Test
   public void testGetCourseInfo() {

       System.out.println(JSON.toJSONString(courseService.getCourseInfo(6L)));
       System.out.println(JSON.toJSONString(courseService.getCourseInfo(10L)));
   }

   @Test
   public void testGetCourseInfos() {

       System.out.println(JSON.toJSONString(courseService.getCourseInfos(
               new CourseInfosRequest(Arrays.asList(6L, 7L, 8L))
       )));
   }
}
