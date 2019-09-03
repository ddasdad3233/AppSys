package cn.demo.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.demo.Service.Backend_UserService;

/**
 * 超级管理员控制类
 * @author 朱威
 */
@Controller
@RequestMapping("/sys/backend")
public class Backend_UserController {
	@Resource
	private Backend_UserService backend_UserService;
}
