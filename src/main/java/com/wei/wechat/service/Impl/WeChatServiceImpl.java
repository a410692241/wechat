package com.wei.wechat.service.Impl;

import com.wei.wechat.bo.WeChatBO;
import com.wei.wechat.service.WeChatService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WeChatServiceImpl implements WeChatService {


    @Override
    public String Event(WeChatBO weChat) {
        StringBuilder sb = new StringBuilder();
        //如果是订阅消息
        if (WeChatBO.SUBSCRIPTION_MSG_TYPE_EVENT.equals(weChat.getMsgType()) && WeChatBO.SUBSCRIPTION_MESSAGE.equals(weChat.getEvent())) {
            //成功订阅则返回图文菜单
            sb.append("<xml>");
            sb.append("<ToUserName>").append(weChat.getFromUserName()).append("</ToUserName>");
            sb.append("<FromUserName>").append(weChat.getToUserName()).append("</FromUserName>");
            sb.append("<MsgType>").append("news").append("</MsgType>");
            sb.append("<CreateTime>").append(System.currentTimeMillis()).append("</CreateTime>");
            sb.append("<ArticleCount>").append(3).append("</ArticleCount>");
            sb.append("<Articles>");

            //京东链接/淘宝链接,第一个图是大图,后面的是小图
            sb.append("<item>");
            sb.append("<Title>").append("点击进入京东").append("</Title>");
            sb.append("<Description>").append("图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息").append("</Description>");
            sb.append("<PicUrl>").append("https://m.360buyimg.com/babel/jfs/t1/17442/21/914/99948/5c0e054aEa60b02a2/b2bfc73ca5f62c00.jpg").append("</PicUrl>");
            sb.append("<Url>").append("http://www.jd.com").append("</Url>");
            sb.append("</item>");

            sb.append("<item>");
            sb.append("<Title>").append("点击进入京东").append("</Title>");
            sb.append("<Description>").append("图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息").append("</Description>");
            sb.append("<PicUrl>").append("https://img.alicdn.com/tfs/TB1AajmvwHqK1RjSZFkXXX.WFXa-520-280.jpg_q90_.webp").append("</PicUrl>");
            sb.append("<Url>").append("http://www.taobao.com").append("</Url>");
            sb.append("</item>");

            sb.append("<item>");
            sb.append("<Title>").append("点击定位").append("</Title>");
            sb.append("<Description>").append("可获取当前您所在的位置!").append("</Description>");
            sb.append("<PicUrl>").append("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=388329788,3347197955&fm=58&bpow=512&bpoh=512").append("</PicUrl>");
            sb.append("<Url>").append("https://www.amap.com/").append("</Url>");
            sb.append("</item>");

            sb.append("</Articles>").append("</xml>");
        } else {
            //准备回复消息
            sb.append("<xml>");
            sb.append("<ToUserName>").append(weChat.getFromUserName()).append("</ToUserName>");
            sb.append("<FromUserName>").append(weChat.getToUserName()).append("</FromUserName>");
            Date date = new Date();
            long time = date.getTime();
            sb.append("<CreateTime>").append(time).append("</CreateTime>");
            sb.append("<MsgType>text</MsgType>");
            sb.append("<Content>呵呵!</Content>");
            sb.append("</xml>");

        }
        return sb.toString();

    }


}
