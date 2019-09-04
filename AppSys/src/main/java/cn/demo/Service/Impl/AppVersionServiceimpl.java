package cn.demo.Service.Impl;

import java.util.List;

import cn.demo.Service.AppInfoService;
import cn.demo.Service.AppVersionService;
import cn.demo.appVsion.AppVersionMapper;
import cn.demo.entity.Version;

public class AppVersionServiceimpl implements AppVersionService {
	
public AppInfoService appInfoService;
	
	
	public AppVersionMapper versionMapper;

	public List<Version> getVersionList(Integer Id)  {
		
		return null;
	}

	public boolean sysadd(Version Version)  {
		return false;
	}

	public Version getVersionById(Integer id)  {
		return null;
	}

	public boolean modify(Version Version)  {
		
		return false;
	}

	public boolean deleteApkFile(Integer id)  {
		
		return false;
	}

}
