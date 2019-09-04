package cn.demo.Service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.demo.Service.Dev_UserService;
import cn.demo.dao.Dev_UserDao;
import cn.demo.entity.User;
/**
 * 开发是业务类
 * @author 朱威
 *
 */
@Service("dev_UserService")
public class Dev_UserServiceImpl implements Dev_UserService {
	@Resource
	private Dev_UserDao dev_UserDao;
	/**
	 * 开发者登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User dev_UserLogin(String devCode, String devPassword) {	
		return dev_UserDao.dev_UserLogin(devCode, devPassword);
	}

}
