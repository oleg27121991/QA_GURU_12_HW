package by.veremei.tests;

import by.veremei.data.DisplayLinkData;
import by.veremei.pages.GitHubMainPage;
import by.veremei.pages.GitHubSearchPage;
import by.veremei.steps.DisplayLinkInGitRepoSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка отображения названия ссылок в репозитории")
public class DisplayLinkTest extends BaseTest{
    GitHubMainPage gitHubMainPage = new GitHubMainPage();
    DisplayLinkData linkData = new DisplayLinkData();
    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();
    private final static String ISSUES_TEXT_IN_TAB = "Issues";


    @Test
    @DisplayName("Проверка отображения названия " + ISSUES_TEXT_IN_TAB + " в репозитории")
    @Tag("WEB")
    void checkDisplayLinkInGitHubRepoWithAddListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        gitHubMainPage
                .openPage(baseUrl)
                .searchRepoOnMainPage(linkData.repoName);

        gitHubSearchPage
                .openFirstSearchResultRepo()
                .checkedDisplayIssuesTextOnPage(ISSUES_TEXT_IN_TAB);
    }

    @Test
    @DisplayName("Проверка отображения названия " + ISSUES_TEXT_IN_TAB + " в репозитории")
    @Tag("WEB")
    void checkDisplayLinkInGitHubRepoWithLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            gitHubMainPage.openPage(baseUrl);
        });
        step("Открываем строку поиска и ищем репозиторий " + linkData.repoName, () -> {
            gitHubMainPage.searchRepoOnMainPage(linkData.repoName);
        });
        step("Кликаем на первую ссылку репозитория", () -> {
            gitHubSearchPage.openFirstSearchResultRepo();
        });
        step("Проверяем, что название таба " + ISSUES_TEXT_IN_TAB + " содержится в найденном репозитории", () -> {
            gitHubSearchPage.checkedDisplayIssuesTextOnPage(ISSUES_TEXT_IN_TAB);
        });
    }

    @Test
    @DisplayName("Проверка отображения названия " + ISSUES_TEXT_IN_TAB + " в репозитории")
    @Tag("WEB")
    void checkDisplayLinkInGitHubRepoWithAnnotatedStep() {
        DisplayLinkInGitRepoSteps displaySteps = new DisplayLinkInGitRepoSteps();

        displaySteps.openMainPage(baseUrl);
        displaySteps.openSearchInput();
        displaySteps.findRepo(linkData.repoName);
        displaySteps.clickOnFirstSearchLinkResult();
        displaySteps.checkDisplayIssuesTextOnPage(ISSUES_TEXT_IN_TAB);
    }
}
