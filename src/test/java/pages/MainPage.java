package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Локаторы
    private final SelenideElement logo = $(".navbar-brand.z-1.is-logo");
    private final SelenideElement aboutLink = $("a[href='about/']");
    private final SelenideElement contactsLink = $("a[href='contacts/']");
    private final SelenideElement productsMenu = $("a[title='Продукты']");
    private final SelenideElement footer = $("footer");

    // Ссылки на проекты (из выпадающего меню)
    private final SelenideElement platformProLink = $("a[href='products/platformpro/']");
    private final SelenideElement gtnExamLink = $("a[href='products/gtnexam/']");
    private final SelenideElement korobkaOnlineLink = $("a[href='products/korobka.online/']");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Проверить отображение логотипа")
    public MainPage checkLogoVisible() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверить отображение футера")
    public MainPage checkFooterVisible() {
        footer.shouldBe(visible);
        return this;
    }

    @Step("Открыть меню «Продукты»")
    public MainPage openProductsMenu() {
        productsMenu.click();
        return this;
    }

    @Step("Перейти на страницу «О компании»")
    public AboutPage goToAboutPage() {
        aboutLink.click();
        return new AboutPage();
    }

    @Step("Перейти на страницу «Контакты»")
    public ContactsPage goToContactsPage() {
        contactsLink.click();
        return new ContactsPage();
    }

    @Step("Открыть страницу проекта «Платформа Про»")
    public ProjectPage openPlatformPro() {
        openProductsMenu();
        platformProLink.click();
        return new ProjectPage();
    }

    @Step("Открыть страницу проекта «Гостехнадзор Экзамен»")
    public ProjectPage openGtnExam() {
        openProductsMenu();
        gtnExamLink.click();
        return new ProjectPage();
    }

    @Step("Открыть страницу проекта «Коробка.Онлайн»")
    public ProjectPage openKorobkaOnline() {
        openProductsMenu();
        korobkaOnlineLink.click();
        return new ProjectPage();
    }

    @Step("Проверить, что ссылки в футере не битые")
    public MainPage checkFooterLinks() {
        ElementsCollection footerLinks = $$("footer a");
        for (SelenideElement link : footerLinks) {
            link.click();
            back();
        }
        return this;
    }
}