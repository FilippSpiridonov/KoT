package ru.ksodd.Runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;

import static com.codeborne.selenide.Selenide.open;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/ru/ksodd/Features"},
        glue = "ru/ksodd/Steps",
//        tags = {"@Реализация or @Проектирование or @Согласование or @Утверждение or @Инициатива"},
        tags = {"@Проектирование_ТЗ or @Авторизация"},
//        plugin = {"json:target/allure-results"},
        strict = true
)



public class Runner {

    @BeforeClass

    static public void Initialization() throws AWTException {
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 8000;
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled=true;
//        System.setProperty("webdriver.chrome.driver", "src/test/repository/chromedriver.exe");
//        Configuration.headless = true;
//        Configuration.browser = "chrome";
//        Если нужно оставлять браузер открытым по окончании теста, по умолчанию значение false
//            Configuration.holdBrowserOpen = true;
        open("http://172.20.0.78:8181/");
        Configuration.savePageSource = false;


    }
}



