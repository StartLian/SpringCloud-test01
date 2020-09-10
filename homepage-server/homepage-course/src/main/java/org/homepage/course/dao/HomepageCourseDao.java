package org.homepage.course.dao;

import org.homepage.course.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>homepage_course 表访问接口定义</h1>
 * Created by Qinyi.
 */
public interface HomepageCourseDao extends JpaRepository<HomepageCourse, Long> {
}
