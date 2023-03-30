package com.shinkai.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RepoPage {

    public RepoPage goToIssues() {
        $("#issues-tab").shouldBe(visible);
        $("#issues-tab").click();
        return this;
    }

    public RepoPage searchIssueByText(String issueName) {
        $("#js-issues-search").clear();
        $("#js-issues-search").sendKeys(issueName);
        $("#js-issues-search").pressEnter();
        return this;
    }

    public void assertIssueFoundByName(String issueName) {
        $(withText(issueName)).should(exist);
    }
}
