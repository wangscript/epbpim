package com.ryxx.bpim.user.enums;

public enum CertificationTypeEnum {
	
	PLSSELECT(0,"------请选择------"),
	REGIST_SPECIALIST_SETUP(1,"注册造价师（安装）"),
	REGIST_SPECIALIST_BUILD(2,"注册造价师（土建）"),
	REGIST_CONSULT(3,"注册咨询师"),
	REGIST_SUPPERVISOR(4,"注册监理师"),
	REGIST_BIDINVITING(5,"注册招标师"),
	REGIST_ACCOUNTING(6,"注册会计师"),
	REGIST_VALUATION(7,"注册估价师"),
	BUILDING_LEVELONE(8,"一级建筑师"),
	BUILDING_LEVELTWO(9,"二级建筑师"),
	BUILDING_LEVELTHREE(10,"三级建筑师"),
	COST_MEMBER_SETUP(11,"造价员（安装）"),
	COST_MEMBER_BUILD(12,"造价员（建筑）"),
	COST_MEMBER_CITY(13,"造价员（市政）");
	
	private String value;
	private int key;
	
	CertificationTypeEnum(int key, String value) {
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

	public static CertificationTypeEnum getType(int key) {
        for (CertificationTypeEnum type : CertificationTypeEnum.values()) {
            if (type.key == key) {
                return type;
            }
        }
        return PLSSELECT;
    }
	
	public static CertificationTypeEnum getType(String value) {
		for (CertificationTypeEnum type : CertificationTypeEnum.values()) {
	    	if (type.value.equals(value)) {
	        	return type;
	    	}
		}
		return PLSSELECT;
	}
}
