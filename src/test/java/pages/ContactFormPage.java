package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactFormPage {

    private final SelenideElement nameField = $("#name");
    private final SelenideElement phoneField = $("#contact");
    private final SelenideElement messageField = $("#message");
    private final SelenideElement confirmCheckbox = $("#confirm");
    private final SelenideElement submitButton = $("button[type='submit']");
    private final SelenideElement successMessage = $(".form-success");

    @Step("Проверить, что форма обратной связи отображается")
    public ContactFormPage formShouldBeVisible() {
        nameField.shouldBe(visible);
        phoneField.shouldBe(visible);
        messageField.shouldBe(visible);
        confirmCheckbox.shouldBe(visible);
        return this;
    }

    @Step("Заполнить поле Имя")
    public ContactFormPage fillName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Заполнить поле Телефон")
    public ContactFormPage fillPhone(String phone) {
        phoneField.setValue(phone);
        return this;
    }

    @Step("Заполнить поле Сообщение")
    public ContactFormPage fillMessage(String message) {
        messageField.setValue(message);
        return this;
    }

    @Step("Согласиться на обработку персональных данных")
    public ContactFormPage agreeToTerms() {
        confirmCheckbox.scrollTo().click();
        return this;
    }

    @Step("Отправить форму")
    public ContactFormPage submitForm() {
        submitButton.click();
        return this;
    }

    @Step("Проверить, что форма успешно отправлена")
    public ContactFormPage successMessageShouldBeVisible() {
        successMessage.shouldBe(visible);
        return this;
    }
}