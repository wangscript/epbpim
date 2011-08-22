package com.ryxx.bpim.user.enums;

public enum InsuranceTypeEnum {
	
	PLSSELECT(0,"-----请选择-----"),
	INSURANCE_CITY(1,"城保"),
	INSURANCE_TOWN(2,"镇保"),
	INSURANCE_BLANKET(3,"综合保险");
	
	private String value;
	private int key;
	
	InsuranceTypeEnum(int key, String value) {
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

	public static InsuranceTypeEnum getType(int value) {
        for (InsuranceTypeEnum type : InsuranceTypeEnum.values()) {
            if (type.key == value) {
                return type;
            }
        }
        return INSURANCE_CITY;
    }
	
	public static InsuranceTypeEnum getType(String name) {
		for (InsuranceTypeEnum type : InsuranceTypeEnum.values()) {
	    	if (type.value.equals(name)) {
	        	return type;
	    	}
		}
		return INSURANCE_CITY;
	}
}
