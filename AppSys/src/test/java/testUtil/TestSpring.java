package testUtil;
/**
 * 测试Spring的配置文件是否可用
 * @author 文
 *
 */

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.demo.Service.UserService;
import cn.demo.dao.UserDao;
import cn.demo.entity.User;

public class TestSpring {
	private Logger log = Logger.getLogger(TestSpring.class);
	@Test
	public void testGetAllUserInfo() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		List<User> list = userService.getAllUserInfo();
		log.info(list.size());

	}
}
