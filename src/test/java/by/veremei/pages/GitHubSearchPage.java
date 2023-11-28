package by.veremei.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubSearchPage {

    private final ElementsCollection listWithSearchResultLink = $$("[data-testid='results-list'] a");
    private final SelenideElement spanWithIssuesText = $("#issues-tab span");
    public GitHubSearchPage openFirstSearchResultRepo() {
        listWithSearchResultLink.filterBy(exist).first().click();

        return this;
    }

    public void checkedDisplayIssuesTextOnPage(String name) {
        spanWithIssuesText.shouldBe(visible);
        Assertions.assertEquals(spanWithIssuesText.text(), name);
    }
}
