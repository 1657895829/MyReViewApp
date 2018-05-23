package com.example.login13.bean;

/**
 * 用户注册数据  http://120.27.23.105/user/reg?mobile=18631090582&password=888888
 */
public class RegBean {

    /**
     * msg : 注册成功
     * code : 0
     */

    private String msg;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
