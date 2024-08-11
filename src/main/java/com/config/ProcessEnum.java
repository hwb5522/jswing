package com.config;

/**
 *
 */
public enum ProcessEnum {
    XDR("111","XDR测试"),
    XDR1("1111","XDR测试1"),
    XDR2("1112","XDR测试2"),
    XDR3("1113","XDR测试3"),
    XDR5("1113","XDR测试4"),
    XDR6("1114","XDR测试5"),
    XDR7("1115","XDR测试6"),
    D33("12344","D33");
    private String id;
    private String code;
     ProcessEnum(String id,String code) {
        this.id = id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
