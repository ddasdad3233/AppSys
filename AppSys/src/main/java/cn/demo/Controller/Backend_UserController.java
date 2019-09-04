package cn.demo.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.demo.Service.Backend_UserService;
import cn.demo.entity.Backend_user;

/**
 * 	超级管理员控制类
 * @author 朱威
 */
@Controller
@RequestMapping("/back")
public class Backend_UserController {
	@Resource
	private Backend_UserService backend_UserService;
	
	/**
	 * 超级管理员登录界面
	 * @return
	 */
	@RequestMapping(value="backendlogin")
	public String backLoginView() {
		return "backendlogin";
	}
	
	/**
	 * 超级管理员登录判断
	 * @param userCode
	 * @param userPassword
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/backlogin",method=RequestMethod.POST)
	public String backendLogin(@RequestParam(value = "userCode",required = false,defaultValue = "")String userCode,
			   @RequestParam(value = "userPassword",required = false,defaultValue = "")String userPassword,
			   HttpSession session,HttpServletRequest request) {
			Backend_user backenduser=backend_UserService.backend_UserLogin(userCode, userPassword);
			if(null!=backenduser) {
				session.setAttribute("backenduser", backenduser);
				return "backend/main";
			}else {
				return "backendlogin";
			}			
	}
	/**
	 * 超级管理员注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="exit")
	public String backExit(HttpSession session) {
		session.removeAttribute("backenduser");
		return "backendlogin";
	}
}
