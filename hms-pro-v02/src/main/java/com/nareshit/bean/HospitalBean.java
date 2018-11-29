package com.nareshit.bean;

import java.io.Serializable;
import java.util.List;

public class HospitalBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int hospId;
	private String name;
	private String email;
	private String phone;
	private String fax;
	private  String status;
	private List<AddressBean> addrInfo;
//setters and getters
	public int getHospId() {
		return hospId;
	}
	public void setHospId(int hospId) {
		this.hospId = hospId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AddressBean> getAddrInfo() {
		return addrInfo;
	}
	public void setAddrInfo(List<AddressBean> addrInfo) {
		this.addrInfo = addrInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrInfo == null) ? 0 : addrInfo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + hospId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalBean other = (HospitalBean) obj;
		if (addrInfo == null) {
			if (other.addrInfo != null)
				return false;
		} else if (!addrInfo.equals(other.addrInfo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hospId != other.hospId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
