package cn.demo.Service;

import java.util.List;

import cn.demo.entity.Version;

public interface AppVersionService {
	/**
	 * 根据Id查询相应的版本列表
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public List<Version> getVersionList(Integer Id)throws Exception;
	/**
	 * 新增版本信息，并更新_info表的versionId字段
	 * @param Version
	 * @return
	 * @throws Exception
	 */
	public boolean sysadd(Version Version)throws Exception;
	/**
	 * 根据id获取Version
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Version getVersionById(Integer id)throws Exception;
	
	/**
	 * 修改版本信息
	 * @param Version
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Version Version)throws Exception;
	
	/**
	 * 删除apk文件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteApkFile(Integer id)throws Exception;
}
