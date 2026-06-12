package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class ProjectPage {

    //Локаторы
    private final SelenideElement title = $(".h2.my-auto.fw-bold.text-primary.is-slogan");
    private final SelenideElement description = $(".mb-4.fs-4");

    public ProjectPage titleShouldBeVisible() {
        title.shouldBe(visible);
        return this;
    }

    public ProjectPage descriptionShouldBeVisible() {
        description.shouldBe(visible);
        return this;
    }

    public String getTitle() {
        return title.getText();
    }
}
