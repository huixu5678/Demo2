package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {
    //定义email等定位方式   把所有可能用到的元素定义出来
    public static By emailInput= By.name("email");
    public static By pwdInput = By.name("password");
    public static By loginButton=By.id("dologin");
    public static By registerButton=By.id("changepage");
}
