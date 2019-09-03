package cn.demo.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.demo.Service.UserService;
import cn.demo.dao.UserDao;
import cn.demo.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userdao;

	public List<User> getAllUserInfo() {
		return userdao.getAllUserInfo();
	}

}
