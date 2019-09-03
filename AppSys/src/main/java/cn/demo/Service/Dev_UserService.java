package cn.demo.Service;

import org.apache.ibatis.annotations.Param;

import cn.demo.entity.User;
/**
 * 开发者Service接口
 * @author 朱威
 *
 */
public interface Dev_UserService {
	/**
	 * 开发者登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User dev_UserLogin(@Param("userCode")String userCode,@Param("userPassword")String userPassword );
}
