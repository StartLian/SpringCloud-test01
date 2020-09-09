package com.homepage_user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homepage_user.entity.HomepageUserCourse;

public interface HomepageUserCourseDao extends JpaRepository<HomepageUserCourse, Long> {

    /**
     * <h2>通过用户 id 寻找数据记录</h2>
     * */
    List<HomepageUserCourse> findAllByUserId(Long userId);
}
