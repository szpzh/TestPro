package com.hht.test;

import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.List;


public class Test {

    private static AndroidDriver driver;
//    AndroidDriver driver;

    @BeforeClass
    public static void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "192.168.67.57:5555"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "6.0");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity","com.android.calculator2.Calculator");

//        cap.setCapability("appPackage", "com.android.hht.whiteboard");
//        cap.setCapability("appActivity", "com.android.hht.whiteboard.MainActivity");
//
//        //A new session could not be created的解决方法
//        cap.setCapability("appWaitActivity","com.android.hht.whiteboard.MainActivity");

        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @org.testng.annotations.Test
    public void add(){
//      //获取1
        driver.findElementById("com.android.calculator2:id/digit_9").click();
//      //获取+
        driver.findElementById("com.android.calculator2:id/op_add").click();
//      //获取2
        driver.findElementById("com.android.calculator2:id/digit_2").click();
//      //获取=
        driver.findElementById("com.android.calculator2:id/eq").click();
//        driver.findElementByXPath()
    }

    @org.testng.annotations.Test
    public void reduce(){
//      //获取1
        driver.findElementById("com.android.calculator2:id/digit_9").click();
//      //获取-
        driver.findElementById("com.android.calculator2:id/op_sub").click();
//      //获取2
        driver.findElementById("com.android.calculator2:id/digit_2").click();
//      //获取=
        driver.findElementById("com.android.calculator2:id/eq").click();
    }

    @org.testng.annotations.Test
    public void mul(){
//      //获取1
        driver.findElementById("com.android.calculator2:id/digit_9").click();
//      //获取x
        driver.findElementById("com.android.calculator2:id/op_mul").click();
//      //获取2
        driver.findElementById("com.android.calculator2:id/digit_2").click();
//      //获取=
        driver.findElementById("com.android.calculator2:id/eq").click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}