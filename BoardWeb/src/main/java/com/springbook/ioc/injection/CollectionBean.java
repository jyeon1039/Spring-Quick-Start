package com.springbook.ioc.injection;

import java.util.Set;

public class CollectionBean {
	private Set<String> addressList;
	
	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}
	
	public Set<String> getAddressList(){
		return addressList;
	}
}
