package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.*;

public class IntellectSoftTest extends BaseTest {

    @Test
    @Description("Открытие главной страницы и проверка логотипа")
    void openMainPageTest() {
        new MainPage()
                .openPage()
                .checkLogoVisible();
    }

    @Test
    @Description("Проверка отображения футера")
    void checkFooterTest() {
        new MainPage()
                .openPage()
                .checkFooterVisible();
    }

    @Test
    @Description("Переход на страницу «О компании»")
    void goToAboutPageTest() {
        new MainPage()
                .openPage()
                .goToAboutPage()
                .pageShouldBeLoaded();
    }

    @Test
    @Description("Переход на страницу «Контакты»")
    void goToContactsPageTest() {
        new MainPage()
                .openPage()
                .goToContactsPage()
                .pageShouldBeLoaded();
    }

    @Test
    @Description("Открытие страницы проекта «Платформа Про»")
    void openPlatformProProjectTest() {
        new MainPage()
                .openPage()
                .openPlatformPro()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }

    @Test
    @Description("Открытие страницы проекта «Гостехнадзор Экзамен»")
    void openGtnExamProjectTest() {
        new MainPage()
                .openPage()
                .openGtnExam()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }

    @Test
    @Description("Открытие страницы проекта «Коробка.Онлайн»")
    void openKorobkaOnlineProjectTest() {
        new MainPage()
                .openPage()
                .openKorobkaOnline()
                .titleShouldBeVisible()
                .descriptionShouldBeVisible();
    }

    @Test
    @Description("Проверка отображения формы обратной связи на странице «Контакты»")
    void checkContactFormTest() {
        new MainPage()
                .openPage()
                .goToContactsPage()
                .pageShouldBeLoaded();

        new ContactFormPage()
                .formShouldBeVisible();
    }

    @Test
    @Description("Отправка формы обратной связи с валидными данными")
    void submitContactFormTest() {
        new MainPage()
                .openPage()
                .goToContactsPage();

        new ContactFormPage()
                .fillName("Иван Петров")
                .fillPhone("+79991234567")
                .fillMessage("Тестовое сообщение от автотеста")
                .agreeToTerms()
                .submitForm()
                .successMessageShouldBeVisible();
    }

    @Test
    @Description("Проверка, что на странице «О компании» есть текст о компании")
    void aboutPageContainsCompanyInfoTest() {
        new MainPage()
                .openPage()
                .goToAboutPage()
                .pageShouldBeLoaded()
                .companyDescriptionShouldContain("Интеллект Софт");
    }

    @Test
    @Description("Проверка, что ссылки в футере не битые")
    void footerLinksAreNotBrokenTest() {
        new MainPage()
                .openPage()
                .checkFooterLinks();
    }
}