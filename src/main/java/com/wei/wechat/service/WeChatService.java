package com.wei.wechat.service;

import com.wei.wechat.bo.WeChatBO;

public interface WeChatService {

    /**
     * @param weChat 关注公众号的事件
     * @return
     */
    String Event(WeChatBO weChat);
}
