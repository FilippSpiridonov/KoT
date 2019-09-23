package ru.ksodd.Runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;
import ru.ksodd.Helpers.Run_Browsers;

import java.awt.*;
import java.net.URL;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.open;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/ru/ksodd/Features"},
        glue = "ru/ksodd/Steps",
//        tags = {"@Реализация or @Утверждение or @Согласование or @Проектирование or @Инициатива or @Авторизация"}, //Актуализация
        tags = {"@Реализация_ТЗ or @Утверждение_ТЗ or @Согласование_ТЗ or @Проектирование_ТЗ"},  //ТС
//        tags = {"@5_Завершение or @4_Реализация or @Согласование_графика or @Согласование_ПОДД or @Согласование_ТС or @Авторизация"},  //МВК
//        tags = {"@Сущпол or @Авторизация"}, //Сущпол
//        tags = {"@Предписание or @Авторизация"}, //Предписание

//          tags = {"@Согласование_ТС_Тест or @Авторизация"},  //МВК
//        tags = {"@Предписание or @Сущпол or @5_Завершение or @4_Реализация or @Согласование_графика or @Согласование_ПОДД or @Согласование_ТС or @Реализация or @Утверждение or @Согласование or @Проектирование or @Инициатива or @Реализация_ТЗ or @Согласование_ТЗ or @Проектирование_ТЗ or @Авторизация "}, //Тест111
//        tags = {"@Предписание or @Сущпол or @5_Завершение or @4_Реализация or @Согласование_графика or @Согласование_ПОДД or @Согласование_ТС or @Реализация_ТЗ or @Согласование_ТЗ or @Проектирование_ТЗ or @Авторизация "}, //Тест111



//        plugin = {"json:target/allure-results"},
        strict = true
)
@Test
public class Runner {

    @BeforeClass

    static public void Initialization() throws AWTException {

        Configuration.timeout = 5000;
//        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = true;
        Configuration.screenshots = true;
        Configuration.browserSize = "1920x1080";
//        System.setProperty("webdriver.edge.driver", "src/test/repository/msedgedriver.exe");
//        Configuration.headless = true;
//        Configuration.browser = "";
//        Если нужно оставлять браузер открытым по окончании теста, по умолчанию значение false
//            Configuration.holdBrowserOpen = true;

        open("http://172.20.0.78:9494");
//        new Run_Browsers();
        Configuration.savePageSource = false;
    }
}



