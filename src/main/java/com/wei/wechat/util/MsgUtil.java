package com.wei.wechat.util;

import com.wei.wechat.bo.WeChatBO;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;

/**
 * 动态解析xml内容解析为实体类
 */
public class MsgUtil {

    /**通过反射将对象的属性set到对象之中
     * @param content
     * @return
     */
    public static WeChatBO parse(String content) {
        //开始解析xml
        WeChatBO weChatBO = new WeChatBO();
        try {
            Class<WeChatBO> weChatBOClass = WeChatBO.class;
            Document document = DocumentHelper.parseText(content);
            Element rootElement = document.getRootElement();
            Field[] fields = weChatBOClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Element element = rootElement.element(field.getName());
                if (element != null) {
                    String Value = element.getStringValue();
                    field.set(weChatBO,Value);
                }
            }
            return weChatBO;

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return weChatBO;
    }
}
