package cn.demo.Service;

import java.util.List;


import cn.demo.entity.Info;

public interface AppInfoService {
	/**
	 * 新增app
	 * @param appInfo
	 * @return
	 * @
	 */
	public boolean add(Info appInfo) ;
	/**
	 * 修改app信息
	 * @param appInfo
	 * @return
	 * @
	 */
	public boolean modify(Info appInfo);
	
	/**
	 * 根据appId删除app应用
	 * @param delId
	 * @return
	 * @
	 */
	public boolean deleteAppInfoById(Integer delId);
	
	/**
	 * 	根据条件查询出app列表
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @
	 */
	public List<Info> getAppInfoList(String querySoftwareName,Integer queryStatus,
								Integer queryCategoryLevel1,Integer queryCategoryLevel2,
								Integer queryCategoryLevel3,Integer queryFlatformId,
								Integer devId,Integer currentPageNo,Integer pageSize)throws Exception;
	
	/**
	 * 	根据条件查询appInfo表记录数
	 * @param querySoftwareName
	 * @param queryStatus
	 * @param queryCategoryLevel1
	 * @param queryCategoryLevel2
	 * @param queryCategoryLevel3
	 * @param queryFlatformId
	 * @param devId
	 * @return
	 * @
	 */
	public int getAppInfoCount(String querySoftwareName,Integer queryStatus,
							Integer queryCategoryLevel1,Integer queryCategoryLevel2,
							Integer queryCategoryLevel3,Integer queryFlatformId,Integer devId)throws Exception;
	/**
	 * 	根据id、apkName查找appInfo
	 * @param id
	 * @return
	 * @
	 */
	public Info getAppInfo(Integer id,String APKName);
	
	/**
	 * 	删除logo图片
	 * @param id
	 * @return
	 * @
	 */
	public boolean deleteAppLogo(Integer id);
	
	/**
	 * 	通过appId删除app应用(app_info、app_version)
	 * @param id
	 * @return
	 * @
	 */
	public boolean appsysdeleteAppById(Integer id)throws Exception;
	
	
	/**
	 * update Sale Status By AppId and Operator
	 * @param appId
	 * @return
	 * @
	 */
	public boolean appsysUpdateSaleStatusByAppId(Info appInfo)throws Exception ;
}
