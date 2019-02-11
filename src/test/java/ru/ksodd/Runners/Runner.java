package ru.ksodd.Runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.*;

import static com.codeborne.selenide.Selenide.open;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/ru/ksodd/Features"},
        glue = "ru/ksodd/Steps",
        tags = {"@Реализация or @Проектирование or @Согласование or @Утверждение or @Инициатива"},
        plugin = {"json:target/allure-results"},
        strict = true
)

public class Runner {

    @BeforeClass

    static public void Initialization() throws AWTException {
        Configuration.timeout = 15000;
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src\\test\\repository\\chromedriver.exe");
//        Configuration.headless = true;
        Configuration.browser = "chrome";
//        Если нужно оставлять браузер открытым по окончании теста, по умолчанию значение false
//            Configuration.holdBrowserOpen = true;0
        open("http://172.20.0.78:8181/");
        Configuration.savePageSource = false;


    }
}



