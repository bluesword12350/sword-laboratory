package weread;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author 李林峰
 */
class WebDriverTest {

    @Test
    void get() {
        System.setProperty("webdriver.edge.driver","driver/msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://www.baidu.com/");
        webDriver.manage().window().minimize();
        webDriver.quit();
    }
}
