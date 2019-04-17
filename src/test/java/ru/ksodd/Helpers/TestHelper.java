package ru.ksodd.Helpers;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.async.AsyncLoggerConfigDefaultExceptionHandler;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.Allure.story;
import static org.bouncycastle.crypto.tls.AlertLevel.fatal;


public class TestHelper {

    public static String number = "";
    public static String number1 = "";

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @Attachment
    //Ввод текста в Allure report
    public static void logging(String log) {
        step(log);
    }

    //Ввод текста при ошибки и остановка теста
    public static void errorLogging(String log) {
        Assert.fail(log);
    }

    public static void log(String log, String errorLog, String Xpath, String command, String setValue) {
        try{
            switch (command){
                case "click":
                    $(By.xpath(""+Xpath+"")).click();
                    break;
                case "setValue":
                    $(By.xpath(""+Xpath+"")).setValue(setValue);
                    break;
                case "should":
                    $(By.xpath(""+Xpath+"")).should(exist);
                    break;
            }
            step(log);
        } catch (AssertionError e) {
            ScreenShooter.failedTests();
            Assert.fail(errorLog);
        }
    }

    public static void clickButton(String name_button) {
        String xpath = "//button/div[text()[contains(.,'" + name_button + "')]] | //span[@class='caption' and text()[contains(.,'" + name_button + "')]]";
        sleep(1700);
//        TestHelper.log("карточка есть "+number, "Не смог найти карточку "+number, xpath,
//                "should","");
        TestHelper.log("Кнопка "+name_button+" существует", "Кнопка "+name_button+" НЕ существует", xpath,
                "should","");
        TestHelper.log("Клик на кнопку "+name_button+" произошел", "Клик на кнопку "+name_button+" НЕ произошло", xpath,
                "click","");
    }

    public static void testAddCard() {
        sleep(900);
        $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
        number = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]")).should(exist);
        System.out.println("Карточка " + number);
    }

    public static void testAddCardPackage() {
        sleep(900);
        $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
        number1 = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]")).should(exist);
        System.out.println("Пакет " + number1);
    }

    public static void clickAddNewCard(String card) {
        String xpath = "//div[@class='flex xs4 d-flex align-content-center justify-start']//span[text()[contains(.,'" + card + "')]]";
        log("Элемент +"+card+" найден","Елемент +"+card+" НЕ найден",xpath,"should","");
        log("Клик на кнопку +"+card,"Клик на кнопку +"+card+" НЕ произошел",xpath,"click","");

    }

    public static void clickTask(String task) {
        sleep(2000);
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]";
        String xpath_1 = "//span[text()[contains(.,'" + number + "')]]/../../../../*//div[2]/span[text()[contains(.,'" + task + "')]]";
        sleep(1000);
        TestHelper.log("Проверка видимости таска"+task,"Таск "+task+" НЕ был найден",xpath,"should","");
        TestHelper.log("Произошел клик на таск"+task,"Клик на таск "+task+" НЕ произошел",xpath_1,"click","");
    }

    public static void clickTask1(String task) {
        sleep(2000);
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]";
        String xpath_1 = "//span[text()[contains(.,'" + number + "')]]/../../../../*//div[@data-id='23']//span[text()[contains(.,'" + task + "')]]";
        sleep(1000);
        TestHelper.log("Проверка видимости таска"+task,"Таск "+task+" НЕ был найден",xpath,"should","");
        TestHelper.log("Произошел клик на таск"+task,"Клик на таск "+task+" НЕ произошел",xpath_1,"click","");
    }



    public static void clickTaskPackage(String task) {
        sleep(3000);
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]")).shouldBe(visible);
        $(By.xpath("//div[@data-id='container-id-3']" +
                "//div[3]/div/span[normalize-space()='" + number1 + "']/../../../.." +
                "//div[2]/span[normalize-space()='"+ task +"']")).click();
        //div[@data-id='container-id-3']//div[3]/div/span[normalize-space()='" + number1 + "']/../../../..//div[2]/span[normalize-space()='"+ task +"']

    }

    public static void inputAll(String input, String text) {
        String xpath = "//*[@aria-label='"+input+"']";
        log("Произошел клик на поле "+input+"","Клик на поле "+input+" не произошел",
                xpath, "click","");
        log("Ввод "+input+"","Ввод "+input+" не произошел",
                xpath, "setValue",text);

    }

    public static void clickTab(String nameTab){
//        $(By.xpath("//div[@class='v-tabs__div']/a[text()[contains(.,'"+nameTab+"')]]")).click();
        open("http://172.20.0.78:8181/sp/"+nameTab+"/kanban");
    }


}


