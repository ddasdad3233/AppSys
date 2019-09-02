package cn.demo.entity;

import java.util.Date;
/**
 *  	平台
 * @author 许鹏章
 *
 */
public class Data_dictionary {
	/**
	 * 	主键id
	 */
	private Integer id;
	/**
	 *  类型编码
	 */
	private String typeCode;
	/**
	 * 	类型名称
	 */
	private String typeName;
	/**
	 * 	类型值ID
	 */
	private Integer valueId;
	/**
	 * 	类型值name
	 */
	private String valueName;
	/**
	 * 	创建者
	 */
	private Integer createdBy;
	/**
	 * 	创建时间
	 */
	private Date creationDate;
	/**
	 * 	更新者
	 */
	private Integer modifyBy;
	/**
	 * 	更新时间
	 */
	private Date modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getValueId() {
		return valueId;
	}
	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	

}
