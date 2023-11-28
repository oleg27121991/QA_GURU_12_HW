package by.veremei.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DisplayLinkInGitRepoSteps {
    private final ElementsCollection listWithSearchResultLink = $$("[data-testid='results-list'] a");
    private final SelenideElement btnOpenSearchInput = $(".header-search-button"),
            searchInput = $("#query-builder-test"),
            spanWithIssuesText = $("#issues-tab span");
    private final static String ISSUES_TEXT_IN_TAB = "Issues";
    @Step("Открываем главную страницу")
    public void openMainPage(String url) {
        Selenide.open(url);
    }

    @Step("Открываем строку поиска")
    public void openSearchInput() {
        btnOpenSearchInput.click();
    }

    @Step("Ищем репозиторий")
    public void findRepo(String repoName) {
        searchInput.setValue(repoName).pressEnter();
    }

    @Step("Кликаем на первую ссылку репозитория")
    public void clickOnFirstSearchLinkResult() {
        listWithSearchResultLink.filterBy(exist).first().click();
    }

    @Step("Проверяем, что название таба " + ISSUES_TEXT_IN_TAB + " содержится в найденном репозитории")
    public void checkDisplayIssuesTextOnPage(String name) {
        spanWithIssuesText.shouldBe(visible);
        Assertions.assertEquals(spanWithIssuesText.text(), name);
    }
}
