package com.homepage_user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homepage_user.entity.HomepageUser;

public interface HomepageUserDao extends JpaRepository<HomepageUser, Long> {

    /**
     * <h2>通过用户名寻找数据记录</h2>
     * */
    HomepageUser findByUsername(String username);
}
