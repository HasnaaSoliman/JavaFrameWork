package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public  class CookiesUtils {
    public static List<org.openqa.selenium.Cookie> ConvertRestAssuredCookiesToSeleniumCookies(List<Cookie> restAssuredCookies){
        List<org.openqa.selenium.Cookie >SeleniumCookies=new ArrayList<>();
        for (io.restassured.http.Cookie cookie:restAssuredCookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
             SeleniumCookies.add(seleniumCookie);
        }
        return SeleniumCookies;
    }
}
