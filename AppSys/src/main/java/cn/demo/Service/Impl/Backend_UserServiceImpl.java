package cn.demo.Service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.demo.Service.Backend_UserService;
import cn.demo.dao.Backend_UserDao;
import cn.demo.entity.Backend_user;
/**
 * 超级管理员业务类
 * @author 朱威
 *
 */
@Service("backend_UserService")
public class Backend_UserServiceImpl implements Backend_UserService {
	@Resource
	private Backend_UserDao backend_UserDao;
	/**
	 * 超级管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public Backend_user backend_UserLogin(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		return backend_UserDao.backend_UserLogin(userCode, userPassword);
	}

}
