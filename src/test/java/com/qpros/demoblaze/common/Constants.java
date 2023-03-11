package com.qpros.demoblaze.common;

import java.io.File;

public class Constants {

    /****** All constants used in this project ******/
    public static final int ELEMENT_WAIT_PERIOD_SEC = 30;
    public static final String DEMO_BLAZE_WEBSITE = "https://www.demoblaze.com/";
    public static final String LOGIN_PASSWORD = "P@ssw0rd@123";
    public static final String REPORT_PATH = System.getProperty("user.dir") + File.separator + "target" + File.separator + "reports" + File.separator;
    public static final String SCREENSHOTS_PATH = System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshots" + File.separator;

    /****** Expected Messages ******/
    public static final String EXPECTED_SIGNUP_SUCCESS_MESSAGE = "Sign up successful.";
    public static final String EXPECTED_ITEM_ADDITION_SUCCESS_MESSAGE = "Product added.";
    public static final String EXPECTED_WELCOME_MESSAGE = "Welcome ";
    public static final String EXPECTED_ORDER_CONFIRMATION_MESSAGE = "Thank you for your purchase!";

    /****** Checkout page values ******/
    public static final String NAME = "Qpros Order";
    public static final String COUNTRY = "Jordan";
    public static final String CITY = "Amman";
    public static final String CREDIT_CARD = "4005550000000001";
    public static final String MONTH = "07";
    public static final String YEAR = "2021";

}
