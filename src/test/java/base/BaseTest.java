package base;
import  com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion");
        String screenResolution = System.getProperty("screenResolution", "1920x1080");
        String selenoidUrl = System.getProperty("selenoidUrl",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browser = browser;
        if (!browserVersion.isEmpty()) {
            Configuration.browserVersion = browserVersion;
        }
        Configuration.browserSize = screenResolution;
        Configuration.remote = selenoidUrl;
        Configuration.baseUrl = "https://intellect-soft.ru";
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        System.out.println("=========================================");
        System.out.println("=== Test Configuration ===");
        System.out.println("Browser: " + browser);
        System.out.println("Browser Version: " + (browserVersion.isEmpty() ? "default" : browserVersion));
        System.out.println("Screen Resolution: " + screenResolution);
        System.out.println("Selenoid URL: " + selenoidUrl);
        System.out.println("=========================================");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
    }

    @AfterAll
    static void globalTearDown() {
        closeWebDriver();
    }
}