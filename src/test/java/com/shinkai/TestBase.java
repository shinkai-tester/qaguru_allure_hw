package com.shinkai;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.shinkai.pages.GitHubMainPage;
import com.shinkai.pages.RepoPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    GitHubMainPage mainPage = new GitHubMainPage();
    RepoPage repoPage = new RepoPage();
    AnnotatedSteps steps = new AnnotatedSteps();

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = "1680x1050";
        Configuration.baseUrl = "https://github.com";
    }
}
