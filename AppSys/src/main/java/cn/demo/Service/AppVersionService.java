package cn.demo.Service;

import java.util.List;

import cn.demo.entity.Version;

public interface AppVersionService {
	/**
	 * 根据appId查询相应的app版本列表
	 * 
	 * @param appId
	 * @return
	 */
	public List<Version> getAppVersionList(Integer appId);

	/**
	 * 新增app版本信息，并更新app_info表的versionId字段
	 * 
	 * @param appVersion
	 * @return
	 */
	public boolean appsysadd(Version appVersion);

	/**
	 * 根据id获取AppVersion
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Version getAppVersionById(Integer id) throws Exception;

	/**
	 * 修改app版本信息
	 * 
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean modify(Version appVersion) throws Exception;

	/**
	 * 删除apk文件
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteApkFile(Integer id) throws Exception;
}
