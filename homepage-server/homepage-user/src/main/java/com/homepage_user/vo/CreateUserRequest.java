package com.homepage_user.vo;


import org.apache.commons.lang.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>创建用户请求对象定义</h1>
 * Created by Qinyi.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    /** 用户名 */
    private String username;

    /** 邮箱 */
    private String email;

    
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/**
     * <h2>请求有效性验证</h2>
     * */
    public boolean validate() {

        return StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(email);
    }
}
