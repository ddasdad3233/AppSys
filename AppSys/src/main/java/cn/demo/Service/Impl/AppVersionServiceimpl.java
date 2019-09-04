package cn.demo.Service.Impl;

import java.util.List;

import cn.demo.Service.AppVersionService;
import cn.demo.appVsion.AppVersionMapper;
import cn.demo.appinfo.AppInfoMapper;
import cn.demo.entity.Version;

public class AppVersionServiceimpl implements AppVersionService {

	public AppInfoMapper appInfoMapper;

	public AppVersionMapper versionMapper;

	public List<Version> getAppVersionList(Integer appId) {

		return versionMapper.getAppVersionList(appId);
	}

	public boolean appsysadd(Version appVersion) {
		boolean flag = false;
		Integer verInteger = null;
		if (versionMapper.add(appVersion) > 0) {
			verInteger = appVersion.getId();
			flag = true;
		}
		if (appInfoMapper.updateVersionId(verInteger, appVersion.getAppId()) > 0 && flag) {
			flag = true;
		}
		return flag;
	}

	public Version getAppVersionById(Integer id) throws Exception {

		return versionMapper.getAppVersionById(id);
	}

	public boolean modify(Version appVersion) throws Exception {
		boolean falg = false;
		if (versionMapper.modify(appVersion) > 0) {
			falg = true;
		}
		return falg;
	}

	public boolean deleteApkFile(Integer id) throws Exception {
		boolean falg = false;
		if (versionMapper.deleteApkFile(id) > 0) {
			falg = true;
		}
		return falg;
	}

}
