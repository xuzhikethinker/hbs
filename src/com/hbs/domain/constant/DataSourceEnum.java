package com.hbs.domain.constant;

public enum DataSourceEnum {
	SYSTEM("sys"), SERVICE_PROVIDER("sp");
	private String code;

	private DataSourceEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static void main(String[] args) {
		System.out.println(DataSourceEnum.SERVICE_PROVIDER.getCode());
	}

}
