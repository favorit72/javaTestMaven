package javaTests.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javaTests.pageObjects.FooterPage;
import javaTests.steps.AddDeviceSmartConfigSteps;
import javaTests.steps.AddDeviceSteps;
import javaTests.steps.DeviceListSteps;
import javaTests.steps.HouseSteps;
import javaTests.steps.MenuSteps;
import javaTests.steps.RoomSteps;
import javaTests.steps.SmartConfigCommonScreenSteps;
import javaTests.steps.SpinnerSteps;
import utils.BaseTest;
import utils.RetryAnalyzerCount;
import utils.data.Strings;
import utils.listener.Listener;

@Listeners(Listener.class)
public class AddSocketTest extends BaseTest {

    private AddDeviceSteps addDevice;
    private HouseSteps house;
    private SpinnerSteps spinner;
    private DeviceListSteps deviceList;
    private MenuSteps menu;
    private AddDeviceSmartConfigSteps smartConfig;
    private SmartConfigCommonScreenSteps smartConfigCommonScreen;
    private RoomSteps room;
    private FooterPage footer;

    @BeforeClass
    public void beforeClass() {
        addDevice = new AddDeviceSteps(driver());
        house = new HouseSteps(driver());
        spinner = new SpinnerSteps(driver());
        deviceList = new DeviceListSteps(driver());
        menu = new MenuSteps(driver());
        smartConfigCommonScreen = new SmartConfigCommonScreenSteps(driver());
        smartConfig = new AddDeviceSmartConfigSteps(driver());
        room = new RoomSteps(driver());
        footer = new FooterPage(driver());
    }

    @Test(retryAnalyzer = RetryAnalyzerCount.class)
    public void addWifiSocket() throws InterruptedException {

        System.out.println("Start test add socket");
        baseAction.restartApp();
        house.chooseWifiHouse();
        spinner.checkCurrentHouseWiFi();
        deviceList.checkNotAvailableDevicesText();
        menu.clickOptionsBtn();
        menu.checkMenuElements();
        baseAction.pressBackHW();
        addDevice.clickAddDeviceBtn();
        addDevice.checkAddDeviceGroupEmptyHouse();
        addDevice.clickAddWifiSocket();
        smartConfigCommonScreen.checkSmartConfigScreen();
        smartConfigCommonScreen.inputPasswordSmartConfig(Strings.WIFI_PASSWORD);
        smartConfigCommonScreen.clickNextBtn();
        smartConfig.checkViewBtnIsNotEnable();
        smartConfig.clickHelpBtn();
        baseAction.pressBackBtn();
        smartConfig.checkPrepareSocketSmartConfigScreen();
        //long wait for user click view button
        smartConfig.smartConfigIsStarted();
        smartConfig.checkScreenDuringSmartConfigSocket();
        //long wait for complete of smartConfig
        smartConfig.checkScreenAfterSmartConfig();
        smartConfig.clickNextBtnAfterSmartConfig();
        room.checkChooseRoomScreen();
        room.clickCreateNewRoomBtn();
        room.checkCreateNewRoomWindow();
        room.inputNewRoomNameField(Strings.NAME_ROOM_WIFI);
        room.clickConfirmCreateNewRoom();
        room.chooseRoomWifi();
        deviceList.checkWifiSocketInDeviceList();
        footer.waitForElementIsDisplayed(footer.deviceList);

    }
}