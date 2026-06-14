package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {

    private final SelenideElement title = $("h1");
    private final SelenideElement companyDescription = $(".about-content");

    @Step("Проверить, что страница «О компании» загрузилась")
    public AboutPage pageShouldBeLoaded() {
        title.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что описание компании содержит текст {expectedText}")
    public AboutPage companyDescriptionShouldContain(String expectedText) {
        companyDescription.shouldHave(text(expectedText));
        return this;
    }
}