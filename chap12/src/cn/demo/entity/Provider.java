package cn.demo.entity;

/**
 * 供应商实体类
 * 
 * @author 文
 *
 */
public class Provider {
	/**
	 * 编号
	 */
	public Integer id;
	/**
	 * 供应商编码
	 */
	private String procode;
	/**
	 * 公司
	 */
	private String proname;
	/**
	 * 描述
	 */
	private String prodesc;
	/**
	 * 供应商姓名
	 */
	private String proContact;
	/**
	 * 供应商联系电话
	 */
	private String proPhone;
	/**
	 * 供应商地址
	 */
	private String proAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProcode() {
		return procode;
	}

	public void setProcode(String procode) {
		this.procode = procode;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProdesc() {
		return prodesc;
	}

	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}

	public String getProContact() {
		return proContact;
	}

	public void setProContact(String proContact) {
		this.proContact = proContact;
	}

	public String getProPhone() {
		return proPhone;
	}

	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	public String getProAddress() {
		return proAddress;
	}

	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
}
