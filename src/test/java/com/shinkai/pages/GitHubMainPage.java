package com.shinkai.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubMainPage {

    public GitHubMainPage openPage() {
        open("/");
        return this;
    }

    public GitHubMainPage searchRepo(String repoName) {
        $(".header-search-input").shouldBe(visible);
        $(".header-search-input").sendKeys(repoName);
        $(".header-search-input").submit();
        return this;
    }

    public void goToRepo(String repoName) {
        $(linkText(repoName)).click();
    }
}
