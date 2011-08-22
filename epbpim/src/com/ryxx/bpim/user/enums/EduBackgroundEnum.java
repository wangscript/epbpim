package com.ryxx.bpim.user.enums;

public enum EduBackgroundEnum {
	
	PLSSELECT(0,"-----请选择-----"),
	JUNIOR(1,"初中"),
	TECHNICAL(2,"技校"),
	SECONDARY(3,"中专"),
	HIGH(4,"高中"),
	JUNIORCOLLEGE(5,"大专"),
	REGULARCOLLEGE(6,"本科"),
	MASTER(7,"硕士"),
	DOCTOR(8,"博士"),
	POSTDOCTOR(9,"博士后");
	
	private String value;
	private int key;
	
	EduBackgroundEnum(int key, String value) {
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

	public static EduBackgroundEnum getType(int value) {
        for (EduBackgroundEnum type : EduBackgroundEnum.values()) {
            if (type.key == value) {
                return type;
            }
        }
        return JUNIOR;
    }
	
	public static EduBackgroundEnum getType(String name) {
		for (EduBackgroundEnum type : EduBackgroundEnum.values()) {
	    	if (type.value.equals(name)) {
	        	return type;
	    	}
		}
		return JUNIOR;
	}
}
