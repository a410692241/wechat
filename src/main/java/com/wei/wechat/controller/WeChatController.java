package com.wei.wechat.controller;

import com.wei.wechat.bo.WeChatBO;
import com.wei.wechat.service.WeChatService;
import com.wei.wechat.util.MsgUtil;
import com.wei.wechat.util.SecuritySHA1Utils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.TreeSet;

@RestController
@RequestMapping("/")
public class WeChatController {

    public static final String token = "myToken";
    @Autowired
    private WeChatService weChatService;

    /**利用get请求,校验请求来自微信服务器,检验服务通畅
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String wechatIndex(String signature,String timestamp,String nonce,String echostr) {
        //校验请求是否来自微信服务器

        TreeSet<String> set = new TreeSet<>();
        set.add(token);
        set.add(timestamp);
        set.add(nonce);
        //将token、timestamp、nonce三个参数进行字典序排序
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            sb.append(next);
        }
        try {
            String equalStr = SecuritySHA1Utils.shaEncode(sb.toString());
            if (equalStr.equals(signature)) {
                return echostr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param content
     * @return  @RequestBody表示可以将请求体中的JSON字符串绑定到相应的对象或者字符串上。
     * @throws DocumentException
     */
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String wechatIndex(@RequestBody String content) throws DocumentException {
        WeChatBO weChat = MsgUtil.parse(content);
        System.out.println(weChat.toString());
        return weChatService.Event(weChat);
    }



}
