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
	
	@RequestMapping(value="changeindex")
	public String changeLogin() {
		return "index";
	}

	/**
	 * 开发者用户登录
	 */
	@RequestMapping(value="/devlogin")
	public String login(){
		log.debug("LoginController welcome AppInfoSystem backend==================");
		return "devlogin";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,HttpServletRequest request,HttpSession session){
		log.debug("doLogin====================================");
		//调用service方法，进行用户匹配
		User user = null;
		try {
			user = dev_UserService.dev_UserLogin(userCode, userPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null != user){//登录成功
			//放入session
			session.setAttribute("user", user);
			//页面跳转（main.jsp）
			return "redirect:/dev/developer/main";
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			request.setAttribute("error", "用户名或密码不正确");
			return "devlogin";
		}
	}
}
