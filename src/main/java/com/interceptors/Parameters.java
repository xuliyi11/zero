package com.interceptors;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xly on 2018/5/25.
 */
public class Parameters {

    private static Logger logger = LoggerFactory.getLogger(Parameters.class);

    private long requestNumber;
    private String actionName;

    private String client;          // 客户端类型
    private String clientVersion;   // 客户端版本
    private String uuid;            // 机器唯一编码
    private String openudid;        // 历史遗留原因，部分IOS客户端使用了该参数作为设备号
    private String body;
    private String build;           // 客户端小版本号
    private String pin;             // 用户的京东pin
    private String ip;              // 用户ip
    private String location;        // 根据用户ip计算出的附加信息
    private String osVersion;       // 客户端操作系统版本
    private String screen;          // 屏幕大小
    private String networkType;     // 网络类型,2g,3g,wifi
    private String partner;         // 合作伙伴
    private String forcebot;           // 全链路测试标识，压测时使用军演机器人使用 默认为0,0非测试数据，1测试数据
    private String scalp;           // 防刷token
    private String umg;             // 用户会员级别
    private String urg;             // 用户风险级别
    private String upg;             // plus级别
    private String qt;
    private String callback;
    private String usid;                // cps联盟加密串
    private String appName;
    private String area;
    private String adid;
    private String d_brand;         //设备品牌
    private String d_model;         //设备型号
    private String agent;           // 用户原始请求头中的User-Agent
    private String referer;         // 用户原始请求头中的Referer
    private String port;
    private String spv;
    private String __jda;           // 京东用户标志
    private String lang;            //语言  中：zh_CN   英：en_US    泰：th_TH

    private static InheritableThreadLocal<Parameters> parametersHolder = new InheritableThreadLocal<>();


    public static Parameters get(){
        return parametersHolder.get();
    }

    public static void set(Parameters parameters){
        parametersHolder.set(parameters);
    }

    public long getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(long requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOpenudid() {
        return openudid;
    }

    public void setOpenudid(String openudid) {
        this.openudid = openudid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getForcebot() {
        return forcebot;
    }

    public void setForcebot(String forcebot) {
        this.forcebot = forcebot;
    }

    public String getScalp() {
        return scalp;
    }

    public void setScalp(String scalp) {
        this.scalp = scalp;
    }

    public String getUmg() {
        return umg;
    }

    public void setUmg(String umg) {
        this.umg = umg;
    }

    public String getUrg() {
        return urg;
    }

    public void setUrg(String urg) {
        this.urg = urg;
    }

    public String getUpg() {
        return upg;
    }

    public void setUpg(String upg) {
        this.upg = upg;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getUsid() {
        return usid;
    }

    public void setUsid(String usid) {
        this.usid = usid;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getD_brand() {
        return d_brand;
    }

    public void setD_brand(String d_brand) {
        this.d_brand = d_brand;
    }

    public String getD_model() {
        return d_model;
    }

    public void setD_model(String d_model) {
        this.d_model = d_model;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSpv() {
        return spv;
    }

    public void setSpv(String spv) {
        this.spv = spv;
    }

    public String get__jda() {
        return __jda;
    }

    public void set__jda(String __jda) {
        this.__jda = __jda;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public String toString() {
        String ret = null;
        try{
            ret = JSON.toJSONString(this);
        } catch (Exception e){
            logger.error("Exception when parsing Parameters to String: ",e);
        }
        if (StringUtils.isBlank(ret)) {
            return "{}";
        }
        return ret;
    }
}
