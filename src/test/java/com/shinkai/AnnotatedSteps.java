package com.shinkai;

import com.codeborne.selenide.WebDriverRunner;
import com.shinkai.pages.GitHubMainPage;
import com.shinkai.pages.RepoPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AnnotatedSteps {

    GitHubMainPage mainPage = new GitHubMainPage();
    RepoPage repoPage = new RepoPage();

    @Step("Open GitHub main page")
    public void openMainPage() {
        mainPage.openPage();
    }

    @Step("Search for repo {repo}")
    public void searchForRepository(String repo) {
        mainPage.searchRepo(repo);
    }

    @Step("Go to repo {repo}")
    public void clickOnRepositoryLink(String repo) {
        mainPage.goToRepo(repo);
    }

    @Step("Go to Issues tab of {repo}")
    public void openIssuesTab(String repo) {
        repoPage.goToIssues();
    }

    @Step("Check issue with name: {issueName}")
    public void verifyIssueWithNameExists(String issueName) {
        repoPage.searchIssueByText(issueName)
                .assertIssueFoundByName(issueName);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

