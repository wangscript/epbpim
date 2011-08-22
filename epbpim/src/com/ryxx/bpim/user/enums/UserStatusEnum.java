package com.ryxx.bpim.user.enums;

public enum UserStatusEnum {
	
	PLSSELECT(0,"-----请选择-----"),
	INCUMBENT(1,"在职"),
	LEAVE(2,"离职"),
	BACK(3,"返聘"),
	PRACTICE(4,"实习");
	
	private String value;
	private int key;
	
	UserStatusEnum(int key, String value) {
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

	public static UserStatusEnum getType(int value) {
        for (UserStatusEnum type : UserStatusEnum.values()) {
            if (type.key == value) {
                return type;
            }
        }
        return INCUMBENT;
    }
	
	public static UserStatusEnum getType(String name) {
		for (UserStatusEnum type : UserStatusEnum.values()) {
	    	if (type.value.equals(name)) {
	        	return type;
	    	}
		}
		return INCUMBENT;
	}
}
