package cn.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class Test {
	@RequestMapping("/test")
	public void testSpringMvc() {
		System.out.println("Test.testSpringMvc()");
	}
}
