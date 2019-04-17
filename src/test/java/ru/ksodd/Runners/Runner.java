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
//        tags = {" @Реализация or @Утверждение or @Согласование or @Проектирование or @Инициатива"}, //Актуализация
//        tags = {"@Реализация_ТЗ or @Согласование_ТЗ or @Проектирование_ТЗ or @Авторизация"},  //ТС
        tags = {"@5_Завершение or @4_Реализация or @Согласование_графика or @Согласование_ПОДД or @Согласование_ТС or @Авторизация"},  //МВК
//        tags = {"@Согласование_графика or @Авторизация"},
        plugin = {"json:target/allure-results"},
        strict = true
)

public class Runner {

    @BeforeClass

    static public void Initialization() throws AWTException {
        WebDriverManager.chromedriver().setup();
        Configuration.timeout = 8000;
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = true;
//        System.setProperty("webdriver.chrome.driver", "src/test/repository/chromedriver.exe");
//        Configuration.headless = true;
//        Configuration.browser = "chrome";
//        Если нужно оставлять браузер открытым по окончании теста, по умолчанию значение false
//            Configuration.holdBrowserOpen = true;
        open("http://172.20.0.78:8181");
        Configuration.savePageSource = false;
    }
}



