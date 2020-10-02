package pl.zeropark.recruitment.sdit.httpbin.ui;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.zeropark.recruitment.sdit.httpbin.Constants;
import pl.zeropark.recruitment.sdit.httpbin.WebDriverFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpBinUiTest {

    private WebDriverFactory webDriverFactory;
    private WebDriver webDriver;

    @BeforeClass
    public void createWebDriver() {
        webDriverFactory = new WebDriverFactory();
    }

    @Test
    public void shouldOpenHttpBiInLocalChrome() {
        webDriver = webDriverFactory.createLocalChromeWebdriver();
        webDriver.get(Constants.HTTPBIN_URL);
        assertThat(webDriver.getTitle()).isEqualTo("httpbin.org");
    }

    @Test
    public void shouldOpenHttpBinInDockerChrome() {
        webDriver= webDriverFactory.createDockerChromeWebdriver();
        webDriver.get(Constants.HTTPBIN_URL);
        assertThat(webDriver.getTitle()).isEqualTo("httpbin.org");
    }


    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }

}
