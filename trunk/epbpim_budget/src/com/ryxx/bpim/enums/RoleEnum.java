package com.ryxx.bpim.enums;

public enum RoleEnum {
	
	NORMAL_USER(1,"普通用户"),
	ENTERPRISE_USER(2,"企业用户"),
	MANAGER(3,"管理员");
	
	private String value;
	private int key;
	
	RoleEnum(int key, String value) {
		this.value = value;
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public static RoleEnum getType(int value) {
        for (RoleEnum type : RoleEnum.values()) {
            if (type.key == value) {
                return type;
            }
        }
        return NORMAL_USER;
    }
	
	public static RoleEnum getType(String name) {
		for (RoleEnum type : RoleEnum.values()) {
	    	if (type.value.equals(name)) {
	        	return type;
	    	}
		}
		return NORMAL_USER;
	}
}
