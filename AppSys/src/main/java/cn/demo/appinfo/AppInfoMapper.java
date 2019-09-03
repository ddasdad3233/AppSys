package cn.demo.appinfo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.demo.entity.Info;

public interface AppInfoMapper {
	
	/**
	 * 	新增APP基础信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Info appInfo);
	/**
	 * 	 修改App基础信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public int modome(Info appInfo);
	/**
	 * 	根据appId删除app应用
	 * @param id
	 * @return
	 */
	public int delectAppInfoByid(@Param(value="id")Integer id);
	
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
	 * @throws Exception
	 */
	public List<Info> getAppInfoList(@Param(value="softwareName")String querySoftwareName,
			@Param(value="status")Integer queryStatus,
			@Param(value="categoryLevel1")Integer queryCategoryLevel1,
			@Param(value="categoryLevel2")Integer queryCategoryLevel2,
			@Param(value="categoryLevel3")Integer queryCategoryLevel3,
			@Param(value="flatformId")Integer queryFlatformId,
			@Param(value="devId")Integer devId,
			@Param(value="from")Integer currentPageNo,
			@Param(value="pageSize")Integer pageSize)throws Exception;
	
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
	 * @throws Exception
	 */
	public int getAppInfoCount(@Param(value="softwareName")String querySoftwareName,
			   @Param(value="status")Integer queryStatus,
			   @Param(value="categoryLevel1")Integer queryCategoryLevel1,
			   @Param(value="categoryLevel2")Integer queryCategoryLevel2,
			   @Param(value="categoryLevel3")Integer queryCategoryLevel3,
			   @Param(value="flatformId")Integer queryFlatformId,
			   @Param(value="devId")Integer devId)throws Exception;
/**
 * 	根据id,apkName查找appInfo
 * @param id
 * @param APKName
 * @return
 */
public Info getAppInfo(@Param(value="id")Integer id,@Param(value="APKName")String APKName);

/**
 * 	删除logo图片
 * @param id
 * @return
 */
public int deleteAppLogo(@Param(value="id")Integer id);

/**
* 	根据appId，更新最新versionId
* @param versionId
* @param appId
* @return
* @throws Exception
*/
public int updateVersionId(@Param(value="versionId")Integer versionId,@Param(value="id")Integer appId);

/**
* updateSaleStatusByAppId
* @param appId
* @return
* @throws Exception
*/
public int updateSaleStatusByAppId(@Param(value="id")Integer appId);

/**
 * 	根据id改变app状态
 * @param status
 * @param id
 * @return
 */
public int updateSatus(@Param(value="status")Integer status,@Param(value="id")Integer id);

}
