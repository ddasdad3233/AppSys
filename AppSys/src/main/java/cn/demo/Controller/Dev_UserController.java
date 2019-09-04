package cn.demo.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.demo.Service.Dev_UserService;
import cn.demo.entity.User;

/**
 * 开发者控制类
 * 
 * @author 朱威
 *
 */
@Controller
@RequestMapping(value="/dev")
public class Dev_UserController {
	private Logger log = Logger.getLogger(Dev_UserController.class);
	@Resource
	private Dev_UserService dev_UserService;

	/**
	 * 开发者用户登录
	 */
	@RequestMapping(value="/devlogin")
	public String login(){
		log.debug("LoginController welcome AppInfoSystem backend==================");
		return "devlogin";
	}
	/**
	 * 开发者登录判断
	 * @param devCode
	 * @param devPassword
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam(value = "devCode",required = false,defaultValue = "")String devCode,
			   @RequestParam(value = "devPassword",required = false,defaultValue = "")String devPassword,HttpSession session,HttpServletRequest request) {
			User user=dev_UserService.dev_UserLogin(devCode, devPassword);
			if (null!=user) {
			session.setAttribute("user",user);
			return "developer/main";
			}else {
				return "devlogin";
			}	
	}
	/**
	 * 开发者用户注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/exit")
	public String devExit(HttpSession session) {
		session.removeAttribute("user");
		return "devlogin";
	}
}
