package com.cubic.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnumSearchResult {
	private ArrayList<String> enumList;

	public ArrayList<String> getEnumList() {
		return enumList;
	}

	public void setEnumList(ArrayList<String> enumList) {
		this.enumList = enumList;
	}
	

}
