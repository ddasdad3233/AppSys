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
@RequestMapping("/sys/developer")
public class Dev_UserController {
	private Logger log = Logger.getLogger(Dev_UserController.class);
	@Resource
	private Dev_UserService dev_UserService;

	/**
	 * 开发者用户登录
	 */
	@RequestMapping(value = "/devlogin", method = RequestMethod.GET)
	public String dev_UserLogin2(
			@RequestParam(value = "userCode", required = false, defaultValue = "") String userCode,
			@RequestParam(value = "userPassword", required = false, defaultValue = "") String userPassword,
			HttpSession session, HttpServletRequest request) {
		log.info("用户名:" + userCode);
		User user = dev_UserService.dev_UserLogin(userCode, userPassword);
		if (null != user) {
			session.setAttribute("user", user);
			return "frame";
		}
		if (!(userCode.equals("") || userPassword.equals(""))) {
			request.setAttribute("error", "用户名或密码不正确");
		}
		return "developer/devlogin";
	}
}
