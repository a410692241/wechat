package com.wei.wechat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信导航
 */
@RestController
@RequestMapping("location")
public class LocationController {

    @RequestMapping("myMap")
    public void myMap() {

    }

    @RequestMapping("getCode")
    public void getCode(HttpServletRequest request) {
        String code = request.getParameter("code");
        System.out.println(code);


    }




}
