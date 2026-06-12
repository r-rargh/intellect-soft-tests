package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class IntellectSoftTest extends BaseTest {

    @Test
    void openPlatformProProjectTest() {
        new MainPage()
                .openPage()
                .openPlatformPro()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }

    @Test
    void openGtnExamProjectTest() {
        new MainPage()
                .openPage()
                .openGtnExam()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }

    @Test
    void openKorobkaOnlineProjectTest() {
        new MainPage()
                .openPage()
                .openKorobkaOnline()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }
}