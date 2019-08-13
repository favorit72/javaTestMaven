package javaTests.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javaTests.steps.LoginSteps;
import javaTests.steps.MenuSteps;
import utils.BaseTest;
import utils.Listener.Listener;


@Listeners(Listener.class)
public class LogoutTest extends BaseTest {
    private MenuSteps menu;
    private LoginSteps login;

    @BeforeClass
    public void beforeClass() {
        menu = new MenuSteps(driver());
        login = new LoginSteps(driver());
    }

    @Test
    public void Logout() {
        System.out.println("Start Logout Test");
        menu.clickOptions();
        menu.clickAppSettings();
    }
}
