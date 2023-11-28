package by.veremei.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GitHubMainPage {
    private final SelenideElement btnOpenSearchInput = $(".header-search-button"),
            searchInput = $("#query-builder-test");
    public GitHubMainPage openPage(String url) {
        Selenide.open(url);

        return this;
    }

    public void searchRepoOnMainPage(String repoName) {
        btnOpenSearchInput.click();
        searchInput.setValue(repoName).pressEnter();
    }
}
