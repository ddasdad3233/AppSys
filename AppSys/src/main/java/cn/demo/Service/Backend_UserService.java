package cn.demo.Service;
import org.apache.ibatis.annotations.Param;
import cn.demo.entity.Backend_user;

/**
 * 超级管理员Service接口
 * @author 朱威
 *
 */
public interface Backend_UserService {
	/**
	 * 超级管理员登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public Backend_user backend_UserLogin(@Param("userCode")String userCode,@Param("userPassword")String userPassword);

}
