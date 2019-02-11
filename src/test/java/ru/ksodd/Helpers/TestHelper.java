package ru.ksodd.Helpers;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.async.AsyncLoggerConfigDefaultExceptionHandler;
import org.junit.Assert;
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

    @Attachment
    //Ввод текста в Allure report
    public static void logging(String log) {
        step(log);
    }

    //Ввод текста при ошибки и остановка теста
    public static void errorLogging(String log) {
        Assert.fail(log);
    }

    public static void log(String log, String logerr, String Xpath, String command, String setValue) {
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
            Assert.fail(logerr);
        }
    }

    public static void clickButton(String name_button) {
        String xpath = "//div[text()[contains(.,'" + name_button + "')]]";
        sleep(1500);
        TestHelper.log("карточка есть "+number, "Не смог найти карточку "+number, xpath,
                "should","");
        TestHelper.log("Клик на кнопку "+name_button+" произошел", "Клик на кнопку "+name_button+" НЕ произошло", xpath,
                "should","");
        $(By.xpath(xpath)).click();
    }

    public static void testAddCard() {
        $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
        number = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]")).should(exist);
        System.out.println(number);
    }

    public static void testAddCardPackage() {
        $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
        number1 = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]")).should(exist);
        System.out.println("Пакет " + number1);
    }

    public static void clickAddNewCard(String card) {
        String xpath = "//div[@class='flex xs4 d-flex align-content-center justify-start']//span[text()[contains(.,'" + card + "')]]";
        log("Елемент +"+card+" найден","Елемент +"+card+" НЕ найден",xpath,"should","");
        log("Клик на кнопку +"+card,"Клик на кнопку +"+card+" НЕ произошел",xpath,"click","");

    }

    public static void clickTask(String task) {
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]";
        String xpath_1 = "//span[text()[contains(.,'" + number + "')]]/../../../../*//div[2]/span[text()[contains(.,'" + task + "')]]";
        sleep(5000);
        TestHelper.log("Проверка видимости таска"+task,"Таск "+task+" НЕ был найден",xpath,"should","");
        TestHelper.log("Произошел клик на таск"+task,"Клик на таск "+task+" НЕ произошел",xpath_1,"click","");



    }

    public static void clickTaskPackage(String task) {
        sleep(3000);
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]")).shouldBe(visible);
        $(By.xpath("//span[text()[contains(.,'" + number1 + "')]]/../../../../*//div[2]/span[text()[contains(.,'" + task + "')]]")).click();
    }

    public static void inputComment(String text) {
        String xpath = "//textarea[@aria-label='Комментарий']";
        log("Произошел клик на поле комментарии","Клик на поле комментарии не произошел",
                xpath, "click","");
        log("Ввод комментария","Ввод комментария не произошел",
                xpath, "setValue",text);

    }


}


