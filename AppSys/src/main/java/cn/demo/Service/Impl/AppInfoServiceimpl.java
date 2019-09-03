package cn.demo.Service.Impl;

import java.util.List;

import cn.demo.Service.AppInfoService;
import cn.demo.entity.Info;

public class AppInfoServiceimpl implements AppInfoService {
	
	public AppInfoService appInfoService;
	
	public boolean add(Info appInfo) {
		boolean falg=false;
		if(appInfoService.add(appInfo)){
			falg = true;
		}
		return falg;
	}

	public boolean modome(Info appInfo) {
		
		
		return false;
	}

	public boolean delectAppInfoByid(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Info> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public Info getAppInfo(Integer id, String APKName) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteAppLogo(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateVersionId(Integer versionId, Integer appId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateSaleStatusByAppId(Integer appId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateSatus(Integer status, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
