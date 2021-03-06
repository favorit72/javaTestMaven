package javaTests.pageObjects;

import helpers.DriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UserAccountPage extends DriverWait {

    public UserAccountPage(AndroidDriver androidDriver) {
        super(androidDriver);
    }

    //Click:
    @AndroidFindBy(id = "com.XXX.client:id/logOut")
    public MobileElement logOutBtn;
    @AndroidFindBy(id = "android:id/button1")
    public MobileElement confirmLogoutBth;
    @AndroidFindBy(id = "android:id/button2")
    public MobileElement cancelLogoutBtn;
    @AndroidFindBy(id = "com.XXX.client:id/resetPassword")
    public MobileElement resetPasswordBth;
    @AndroidFindBy(xpath = "//*[@content-desc='Перейти вверх']")
    public MobileElement backBtn;
    //Text:
    @AndroidFindBy(id = "com.XXX.client:id/toolbar_title")
    public MobileElement userAccountTitle;
    @AndroidFindBy(id = "com.XXX.client:id/alertTitle")
    public MobileElement alertLogoutTitle;
    @AndroidFindBy(id = "android:id/message")
    public MobileElement messageAlertLogout;

}
