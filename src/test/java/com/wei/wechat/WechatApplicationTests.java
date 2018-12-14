package com.wei.wechat;

import com.wei.wechat.util.MenuUtil;
import com.wei.wechat.util.TokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {

    public static final String appID = "wxa3c220d935cba583";
    public static final String appsecret = "bacc6d6a0a630283d3f4bf3b30b49b7c";
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret=" + appsecret;
    public static final String ACCESS_TOKEN = "16_47eWoSU7t4GpCoeAjudMU6z-RWRKk1C-DJsruieFD8GUTUJ8IP7Sj-ZetY9NBVe5HWsoJ2-HUK-5GdP_0OMoumS57ECI5EWccgvsIk8TieMb8NX4gfdhxg66eqPvsPFsPdeZzbneOfVDVpXyGEPcAAAXVG";
    public static final String MENU_URL = "http://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ACCESS_TOKEN;
    @Test
    public void contextLoads() {
    }

    /**
     * 刷新微信公众号menu,
     * 只要执行了setMenu就会改变公众号的按钮样式,一直有效
     */
    @Test
    public void setMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"button\":[");

        sb.append("{");
        sb.append("\"name\":").append("\"刷新消息\",");
        sb.append("\"type\":").append("\"click\",");
        sb.append("\"key\":").append("\"rset_my_menu\"");
        sb.append("},");

        sb.append("{");
        sb.append("\"name\":").append("\"第二按钮\",");
        sb.append("\"sub_button\":[");

        //二级菜单
        sb.append("{");
        sb.append("\"name\":").append("\"二级菜单\",");
        sb.append("\"type\":").append("\"view\",");
        sb.append("\"url\":").append("\"http://www.baidu.com\"");
        sb.append("}");

        sb.append("]");
        sb.append("}");

        sb.append("]");
        sb.append("}");
        MenuUtil.postMenu(sb.toString(),MENU_URL);
    }


    /**
     * 获取token
     */
    @Test
    public void getAccessToken() {
        TokenUtil.getUrl(GET_ACCESS_TOKEN_URL);
    }

}

