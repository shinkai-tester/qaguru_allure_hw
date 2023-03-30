package com.shinkai;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class IssueNameTests extends TestBase {

    private static final String repoName = "DiUS/java-faker";
    private static final String issueName = "FakerValues.loadValues() never closes inputStream";

    @Test
    @Feature("Issue in repo")
    @Story("Search for issue by name")
    @Owner("shinkai-tester")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Java faker issues page", url = "https://github.com/DiUS/java-faker/issues")
    @DisplayName("Search issue in repo " + repoName + " of GitHub")
    public void testIssueNameListener() {
        mainPage.openPage()
                .searchRepo(repoName)
                .goToRepo(repoName);
        repoPage.goToIssues()
                .searchIssueByText(issueName)
                .assertIssueFoundByName(issueName);
    }

    @Test
    @Feature("Issue in repo")
    @Story("Search for issue by name")
    @Owner("shinkai-tester")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Java faker issues page", url = "https://github.com/DiUS/java-faker/issues")
    @DisplayName("Search issue in repo " + repoName + " of GitHub using lambda steps")
    public void testIssueNameLambdaStep() {
        step("Open GitHub main page", () -> {
            mainPage.openPage();
        });

        step("Search for repo " + repoName, () -> {
            mainPage.searchRepo(repoName);
        });

        step("Go to repo" + repoName, () -> {
            mainPage.goToRepo(repoName);
        });

        step("Go to Issues tab of " + repoName, () -> {
            repoPage.goToIssues();
        });

        step("Check issue with name: " + issueName, () -> {
            repoPage.searchIssueByText(issueName)
                    .assertIssueFoundByName(issueName);
            steps.takeScreenshot();
        });
    }

    @Test
    @Feature("Issue in repo")
    @Story("Search for issue by name")
    @Owner("shinkai-tester")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Java faker issues page", url = "https://github.com/DiUS/java-faker/issues")
    @DisplayName("Search issue in repo " + repoName + " of GitHub using annotated steps")
    public void testIssueNameAnnotatedSteps() {
        steps.openMainPage();
        steps.searchForRepository(repoName);
        steps.clickOnRepositoryLink(repoName);
        steps.openIssuesTab(repoName);
        steps.verifyIssueWithNameExists(issueName);
        steps.takeScreenshot();
    }
}
