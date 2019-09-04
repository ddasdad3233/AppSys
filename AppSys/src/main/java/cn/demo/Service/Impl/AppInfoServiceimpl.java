package cn.demo.Service.Impl;

import java.util.List;

import cn.demo.Service.AppInfoService;
import cn.demo.appVsion.AppVersionMapper;
import cn.demo.entity.Info;

public class AppInfoServiceimpl implements AppInfoService {
	
	public AppInfoService appInfoService;
	
	
	public AppVersionMapper versionMapper;
	
	public boolean add(Info appInfo) {
		boolean falg=false;
		if(appInfoService.add(appInfo)){
			falg = true;
		}
		return falg;
	}

	public boolean modome(Info appInfo) {
		boolean falg=false;
		if (appInfoService.modome(appInfo)) {
			falg=true;
		}
		return falg;
	}

	public boolean delectAppInfoByid(Integer id) {
		boolean falg=false;
		if (appInfoService.delectAppInfoByid(id)) {
			falg=true;
		}
		return falg;
	}

	
	
	public List<Info> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) throws Exception {
		
		return appInfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, 
				queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
	}

	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		return appInfoService.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
	}

	
	public Info getAppInfo(Integer id, String APKName) {
		return appInfoService.getAppInfo(id, APKName);
	}

	
	public boolean deleteAppLogo(Integer id) {
		boolean falg=false;
		if (appInfoService.deleteAppLogo(id)) {
			falg=true;
		}
		return falg;
	}

	public boolean updateVersionId(Integer versionId, Integer appId) {
		boolean falg=false;
		if (appInfoService.updateVersionId(versionId, appId)) {
			falg=true;
		}
		return falg;
	}

	public boolean updateSaleStatusByAppId(Integer appId) {
		boolean falg=false;
		return false;
	}

	public boolean updateSatus(Integer status, Integer id) {
		boolean falg=false;
		return false;
	}

}
