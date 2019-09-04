package cn.demo.Service.Impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.demo.Service.AppInfoService;
import cn.demo.appVsion.AppVersionMapper;
import cn.demo.appinfo.AppInfoMapper;
import cn.demo.entity.Info;
import cn.demo.entity.Version;

@Service
public class AppInfoServiceimpl implements AppInfoService {
	@Resource
	public AppInfoMapper appInfoMapper;

	@Resource
	public AppVersionMapper versionMapper;

	public boolean add(Info appInfo) {
		boolean falg = false;
		if (appInfoMapper.add(appInfo)>0) {
			falg = true;
		}
		return falg;
	}

	public boolean modify(Info appInfo) {
		boolean falg = false;
		if (appInfoMapper.modome(appInfo)>0) {
			falg = true;
		}
		return falg;
	}

	public boolean deleteAppInfoById(Integer delId) {
		boolean falg = false;
		if (appInfoMapper.delectAppInfoByid(delId)>0) {
			falg = true;
		}
		return falg;
	}

	public List<Info> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId,
			Integer currentPageNo, Integer pageSize) throws Exception {

		return appInfoMapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, devId, (currentPageNo-1)*pageSize, pageSize);
	}

	public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId) throws Exception {

		return appInfoMapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2,
				queryCategoryLevel3, queryFlatformId, devId);
	}

	public Info getAppInfo(Integer id, String APKName) {

		return appInfoMapper.getAppInfo(id, APKName);
	}

	public boolean deleteAppLogo(Integer id) {
		boolean falg = false;
		if (appInfoMapper.deleteAppLogo(id)>0) {
			falg = true;
		}
		return falg;
	}

	
	
  	//业务：根据appId删除APP信息
  	//1、通过appId，查询app_verion表中是否有数据
  	//2、若版本表中有该app应用对应的版本信息，则进行级联删除，先删版本信息（app_version），后删app基本信息（app_info）
  	//3、若版本表中无该app应用对应的版本信息，则直接删除app基本信息（app_info）。
  	//注意：事务控制，上传文件的删除
	/**
	 * 	通过appId删除app应用(app_info、app_version)
	 * @param id
	 * @return
	 * @
	 */
	public boolean appsysdeleteAppById(Integer id) throws Exception {

		boolean flag = false;
		int versionCount = versionMapper.getVersionCountByAppId(id);
		List<Version> appVersionList = null;
		if (versionCount > 0) {// 1 先删版本信息
			// <1> 删除上传的apk文件
			appVersionList = versionMapper.getAppVersionList(id);
			for (Version appVersion : appVersionList) {
				if (appVersion.getApkLocPath() != null && !appVersion.getApkLocPath().equals("")) {
					File file = new File(appVersion.getApkLocPath());
					if (file.exists()) {
						if (!file.delete())
							throw new Exception();
					}
				}
			}
			// <2> 删除app_version表数据
			versionMapper.deleteVersionByAppId(id);
		}
		// 2 再删app基础信息
		// <1> 删除上传的logo图片
		Info appInfo = appInfoMapper.getAppInfo(id, null);
		if (appInfo.getLogoLocPath() != null && !appInfo.getLogoLocPath().equals("")) {
			File file = new File(appInfo.getLogoLocPath());
			if (file.exists()) {
				if (!file.delete())
					throw new Exception();
			}
		}
		// <2> 删除app_info表数据
		if (appInfoMapper.deleteAppLogo(id)>0) {
			flag = true;
		}
		return flag;
	}
	
	
	
	
	public boolean appsysUpdateSaleStatusByAppId(Info appInfoObj) throws Exception {
		/*
		 * 上架： 1 更改status由【2 or 5】 to 4 ， 上架时间 2 根据versionid 更新 publishStauts 为 2
		 * 
		 * 下架： 更改status 由4给为5
		 */

		Integer operator = appInfoObj.getModifyBy();
		if (operator < 0 || appInfoObj.getId() < 0) {
			throw new Exception();
		}

		// get appinfo by appid
		Info appInfo = appInfoMapper.getAppInfo(appInfoObj.getId(), null);
		if (null == appInfo) {
			return false;
		} else {
			switch (appInfo.getStatus()) {
			case 2: // 当状态为审核通过时，可以进行上架操作
				onSale(appInfo, operator, 4, 2);
				break;
			case 5:// 当状态为下架时，可以进行上架操作
				onSale(appInfo, operator, 4, 2);
				break;
			case 4:// 当状态为上架时，可以进行下架操作
				offSale(appInfo, operator, 5);
				break;

			default:
				return false;
			}
		}
		return true;
	}
	
	/**
	 * on Sale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @param versionStatus
	 * @throws Exception
	 */
	private void onSale(Info appInfo,Integer operator,Integer appInfStatus,Integer versionStatus) throws Exception{
		offSale(appInfo,operator,appInfStatus);
		setSaleSwitchToAppVersion(appInfo,operator,versionStatus);
	}
	
	
	/**
	 * offSale
	 * @param appInfo
	 * @param operator
	 * @param appInfStatus
	 * @return
	 * @throws Exception
	 */
	private boolean offSale(Info appInfo,Integer operator,Integer appInfStatus) throws Exception{
		Info _appInfo = new Info();
		_appInfo.setId(appInfo.getId());
		_appInfo.setStatus(appInfStatus);
		_appInfo.setModifyBy(operator);
		_appInfo.setOffSaleDate(new Date(System.currentTimeMillis()));
		appInfoMapper.modome(_appInfo);
		return true;
	}
	
	/**
	 * set sale method to on or off
	 * @param appInfo
	 * @param operator
	 * @return
	 * @throws Exception
	 */
	private boolean setSaleSwitchToAppVersion(Info appInfo,Integer operator,Integer saleStatus) throws Exception{
		Version appVersion = new Version();
		appVersion.setId(appInfo.getVersionId());
		appVersion.setPublishStatus(saleStatus);
		appVersion.setModifyBy(operator);
		appVersion.setModifyDate(new Date(System.currentTimeMillis()));
		versionMapper.modify(appVersion);
		return false;
	}

}
