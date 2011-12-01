package com.ryxx.bpim.user.enums;

public enum UserTitleEnum {
	
	PLSSELECT(0,"-----请选择-----"),
	SENIOR_EMP_LEVEL1(1,"正高工"),
	SENIOR_EMP_LEVEL2(2,"副高工"),
	EMP(3,"工程师"),
	ASISTANT_EMP(4,"助理工程师"),
	TECHNICIAN(5,"技术员"),
	SENIOR_ECON(6,"高级经济师"),
	ECON(7,"经济师"),
	SENIOR_ACCOUNTANT(8,"高级会计师"),
	MIDDLE_ACCOUNTANT(9,"中级会计师"),
	ACCOUNTANT(10,"会计师"),
	COST_PERSONNAL(11,"造价员");
	
	private String value;
	private int key;
	
	UserTitleEnum(int key, String value) {
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

	public static UserTitleEnum getType(int value) {
        for (UserTitleEnum type : UserTitleEnum.values()) {
            if (type.key == value) {
                return type;
            }
        }
        return PLSSELECT;
    }
	
	public static UserTitleEnum getType(String name) {
		for (UserTitleEnum type : UserTitleEnum.values()) {
	    	if (type.value.equals(name)) {
	        	return type;
	    	}
		}
		return PLSSELECT;
	}
}
