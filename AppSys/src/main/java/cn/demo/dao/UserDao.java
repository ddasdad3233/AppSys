package cn.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.demo.entity.User;

@Repository
public interface UserDao {
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public List<User> getAllUserInfo();
}
