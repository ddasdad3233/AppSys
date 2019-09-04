package cn.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.demo.entity.Backend_user;

/**
 * 超级管理员Dao接口
 * @author 朱威
 *
 */
@Repository("backend_UserDao")
public interface Backend_UserDao {
	/**
	 * 超级管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public Backend_user backend_UserLogin(@Param("userCode")String userCode,@Param("userPassword")String userPassword);

}
