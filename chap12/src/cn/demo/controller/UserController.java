package cn.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.demo.entity.User;

@Controller
public class UserController {
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@Valid User user, BindingResult bingResult) {

		return "add";

	}
}
