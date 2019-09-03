package cn.demo.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.User;
/**
 * 开发者Dao接口
 * @author 朱威
 *
 */
@Repository("dev_UserDao")
public interface Dev_UserDao {
	/**
	 * 开发者登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User dev_UserLogin(@Param("devCode")String devCode,@Param("devPassword")String devPassword );
		
	
}
