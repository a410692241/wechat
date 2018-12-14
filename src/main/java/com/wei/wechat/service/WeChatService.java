package com.wei.wechat.service;

import com.wei.wechat.bo.WeChatBO;

public interface WeChatService {

    /**
     * @param weChat
     * @return通过调用微信消息接口,返回微信消息的回复的xml
     */
    String Event(WeChatBO weChat);
}
