package com.shinkai;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.shinkai.pages.GitHubMainPage;
import com.shinkai.pages.RepoPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    GitHubMainPage mainPage = new GitHubMainPage();
    RepoPage repoPage = new RepoPage();
    AnnotatedSteps steps = new AnnotatedSteps();
    ChromeOptions options = new ChromeOptions();

    @BeforeEach
    void beforeEach() {
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://github.com";
    }
}
