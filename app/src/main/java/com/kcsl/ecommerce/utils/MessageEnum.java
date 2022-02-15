package com.kcsl.ecommerce.utils;

public enum MessageEnum {
    Message_SUCCESS(1,201),
    Message_FAILED(2,501),
    SERVER_ERROR(3,999);


    private int key;
    private int code;

    MessageEnum(int key, int code) {
        this.key = key;
        this.code = code;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static MessageEnum getByCode(int code){
        for(MessageEnum rs : MessageEnum.values()){
            if(rs.code == code) return rs;
        }

        return null;


    }
}
