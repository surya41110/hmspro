package com.nareshit.utility;

import com.nareshit.bean.AddressBean;
import com.nareshit.domain.Address;

public class AddressMapper {

	public static Address mapBeanToDomain(AddressBean adBean) {
		Address address = new Address();
      address.setCity(adBean.getCity());
      address.setCountry(adBean.getCountry());
      address.setState(adBean.getState());
      address.setStreet(adBean.getStreet());
      address.setZipcode(adBean.getZip());
      return address;
		
	
	}
	
	public static AddressBean mapDomainToBean(Address adDomain) {
		AddressBean addressBean = new AddressBean();
		addressBean.setCity(adDomain.getCity());
		addressBean.setCountry(adDomain.getCountry());
		addressBean.setState(adDomain.getState());
		addressBean.setStreet(adDomain.getStreet());
		addressBean.setZip(adDomain.getZipcode());
	      
	      return addressBean;
	}
	
		
}
