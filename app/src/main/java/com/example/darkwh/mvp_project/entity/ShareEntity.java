package com.example.darkwh.mvp_project.entity;

/**
 * Created by darkwh on 2016/6/12.
 * 分享数据的实体Bean
 */
public class ShareEntity {

    //描述
    private String desc;
    //提交日期
    private String publishedAt;
    //来源(web,api,chrome)
    private String source;
    //所属种类(福利)
    private String type;
    //图片地址
    private String url;
    private boolean used;
    //提交人
    private String who;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
