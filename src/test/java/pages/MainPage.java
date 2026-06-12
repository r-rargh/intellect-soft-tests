package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement productsMenu = $("a[title='Продукты']");

    private final SelenideElement platformProLink = $("a[href='products/platformpro/']");
    private final SelenideElement gtnExamLink = $("a[href='products/gtnexam/']");
    private final SelenideElement korobkaOnlineLink = $("a[href='products/korobka.online/']");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public ProjectPage openPlatformPro() {
        productsMenu.click();
        platformProLink.click();
        return new ProjectPage();
    }

    public ProjectPage openGtnExam() {
        productsMenu.click();
        gtnExamLink.click();
        return new ProjectPage();
    }

    public ProjectPage openKorobkaOnline() {
        productsMenu.click();
        korobkaOnlineLink.click();
        return new ProjectPage();
    }
}