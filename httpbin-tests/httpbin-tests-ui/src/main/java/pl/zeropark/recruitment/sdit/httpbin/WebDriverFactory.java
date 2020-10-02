package pl.zeropark.recruitment.sdit.httpbin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class WebDriverFactory {

    public WebDriver createLocalChromeWebdriver() {
        var os = OsCheck.getOperatingSystemType();
        switch (os) {
            case MacOS:
                setChromeWebDriverPropertyPath("/usr/local/bin/chromedriver");
                break;
            default:
                throw new IllegalStateException("Unable to setup chromedriver path for OS: " + os);
        }
        return new ChromeDriver();
    }

    public WebDriver createDockerChromeWebdriver() {
        var container = new BrowserWebDriverContainer<>()
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.SKIP, null)
                .withCapabilities(new ChromeOptions()
                        .addArguments("start-maximized")
                );
        container.start();
        return container.getWebDriver();
    }

    private void setChromeWebDriverPropertyPath(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }
}
