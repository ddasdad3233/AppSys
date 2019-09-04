package cn.demo.appVsion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.demo.entity.Version;


public interface AppVersionMapper {
	
public List<Version> getAppVersionList(@Param("appId")Integer appId) ;
	
	public int add(Version appVersion);
	
	public int getVersionCountByAppId(@Param("appId")Integer appId)throws Exception;
	
	public int deleteVersionByAppId(@Param("appId")Integer appId)throws Exception;
	
	public Version getAppVersionById(@Param("id")Integer id)throws Exception;
	
	public int modify(Version appVersion)throws Exception;
	
	public int deleteApkFile(@Param("id")Integer id)throws Exception;

}
