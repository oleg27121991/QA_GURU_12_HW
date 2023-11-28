package by.veremei.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setupAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserVersion = "118";
        Configuration.baseUrl = "https://github.com";
    }

    @AfterEach
    void closeBrowse() {
        Selenide.closeWebDriver();
    }
}
