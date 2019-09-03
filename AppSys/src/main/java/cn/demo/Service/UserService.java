package cn.demo.Service;

import java.util.List;

import cn.demo.entity.User;

public interface UserService {
	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	public List<User> getAllUserInfo();
}
