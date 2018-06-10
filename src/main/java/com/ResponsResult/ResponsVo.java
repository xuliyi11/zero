package com.ResponsResult;

/**
 * Created by xly on 2018/4/14.
 */
public class ResponsVo {
    //返回编码
    private String resultCode;
    //返回信息
    private String resultMsg;
    //返回对象
    private Object resultObj;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public void setResultObj(Object resultObj) {
        this.resultObj = resultObj;
    }

}
