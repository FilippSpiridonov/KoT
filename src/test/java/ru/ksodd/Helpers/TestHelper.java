package ru.ksodd.Helpers;


import com.codeborne.selenide.*;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LoggingException;
import org.apache.logging.log4j.core.async.AsyncLoggerConfigDefaultExceptionHandler;
import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.xml.xpath.XPath;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.description;
import static io.qameta.allure.Allure.step;


public class TestHelper {

    public static String number = "";
    public static String number1 = "";
    public static String namefile = "";

//    @Rule
//    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    //Ввод текста в Allure report
//    public static void logging(String log) {
//        step(log);
//    }
//    //Ввод текста при ошибки и остановка теста
//    public static void errorLogging(String log) {
//        Assert.fail(log);
//    }


    private enum stringLog {
        doubleClick,click,setValue,should,shouldNot;
    }

    public static void log(String log, String errorLog, String Xpath, String command, String setValue) throws IOException {
        sleep(500);
        stringLog stringLog1 = stringLog.valueOf(command);
        try {
            switch (stringLog1) {
                case doubleClick:
                    $(By.xpath("" + Xpath + "")).doubleClick();
                    break;
                case click:
                    $(By.xpath("" + Xpath + "")).click();
                    break;
                case setValue:
                    $(By.xpath("" + Xpath + "")).setValue(setValue);
                    break;
                case should:
                    $(By.xpath(""+Xpath+"")).should(exist);
                    break;
                case shouldNot:
                    $(By.xpath(""+Xpath+"")).shouldNot(exist);
                    break;
            }
            try {

                Screenshoting.screen(log);
                CollectionErrorLog.consolsInfo();
            } catch (Error e) {
            }

        } catch (AssertionError e) {

            Screenshoting.screen(errorLog);
            CollectionErrorLog.consolsInfo();
            Assert.fail(errorLog);
            return;
//            close();
        }
    }

    public static void clickButton(String name_button) throws IOException {
        String xpath = "//button/div[text()[contains(.,'" + name_button + "')]]";
        String xpath1 = "//span[@class='caption' and text()[contains(.,'" + name_button + "')]]";
        sleep(1700);

        try {
            $(By.xpath(xpath)).should(visible);
            log("Клик на кнопку " + name_button + " произошел", "Клик на кнопку " + name_button + " НЕ произошло", xpath,
                    "click", "");
        } catch (Error e) {
            $(By.xpath(xpath1)).should(visible);
            log("Клик на кнопку " + name_button + " произошел", "Клик на кнопку " + name_button + " НЕ произошло", xpath1,
                    "click", "");
        }
    }

    public static void testAddCard() throws IOException {
        try {
            sleep(1000);
            $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
            number = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
            $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]")).should(exist);
            System.out.println("Карточка " + number);
        } catch (Error q) {
            log("", "Сообщение не вылезло", "", "", "");
        }
    }

    public static void testAddCardPackage() {
        sleep(900);
        $(By.xpath("//div/div[@class='snotifyToast__body']")).should(exist);
        number1 = $(By.xpath("//div/div[@class='snotifyToast__body']")).getText().replaceAll("\\D+", "");
        $(By.xpath("//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]")).should(exist);
        System.out.println("Пакет " + number1);
    }

    public static void clickAddNewCard(String card) throws IOException {
        String xpath = "//div[@class='flex xs4 d-flex align-content-center justify-start']//span[text()[contains(.,'" + card + "')]]";
//        log("Элемент +"+card+" найден","Елемент +"+card+" НЕ найден",xpath,"should","");
        log("Клик на кнопку +" + card, "Клик на кнопку +" + card + " НЕ произошел", xpath, "click", "");
    }

    public static void clickTask(String task) throws IOException {
        sleep(2000);
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]";
        String xpath_1 = "//span[text()[contains(.,'" + number + "')]]/../../../../*//div[2]/span[text()[contains(.,'" + task + "')]]";

//        log("Проверка видимости таска "+task,"Таск "+task+" НЕ был найден",xpath,"should","");
        log("Произошел клик на таск " + task, "Клик на таск " + task + " НЕ произошел", xpath_1, "click", "");
    }

    public static void clickTask1(String task) throws IOException {
        sleep(2000);
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number + "')]]";
        String xpath_1 = "//span[text()[contains(.,'" + number + "')]]/../../../../*//div[@data-id='23']//span[text()[contains(.,'" + task + "')]]";
        sleep(1000);
//        log("Проверка видимости таска"+task,"Таск "+task+" НЕ был найден",xpath,"should","");
        log("Произошел клик на таск" + task, "Клик на таск " + task + " НЕ произошел", xpath_1, "click", "");
    }


    public static void clickTaskPackage(String task) throws IOException {
        sleep(3000);
        String xpath = "//div[@class='layout row wrap justify-end']/div/div/span[text()[contains(.,'" + number1 + "')]]";
        String xpath1 = "//div[@data-id='container-id-3']" +
                "//div[3]/div/span[normalize-space()='" + number1 + "']/../../../.." +
                "//div[2]/span[normalize-space()='" + task + "']";
//        log("Пакет +"+task+" найден","Пакет +"+task+" НЕ найден",xpath,"should","");
        log("Клик на кнопку " + task + "", "Клик на кнопку +" + task + " НЕ произошел", xpath1, "click", "");
        //div[@data-id='container-id-3']//div[3]/div/span[normalize-space()='" + number1 + "']/../../../..//div[2]/span[normalize-space()='"+ task +"']

    }

    public static void inputAll(String input, String text) throws IOException {
        String xpath = "//*[@aria-label='" + input + "']";
        String xpath1 = "//div[@class='v-st__tile__title' and text()='" + text + "']";
        log("Произошел клик на поле " + input + "", "Клик на поле " + input + " не произошел",
                xpath, "click", "");
        log("Ввод " + input + "", "Ввод " + input + " не произошел",
                xpath, "setValue", text);

    }

    public static void clickTab(String nameTab) {
        sleep(1500);
        $(By.xpath("//div[@class='v-tabs__div']/a[text()[contains(.,'"+nameTab+"')]]")).doubleClick();
//        open("http://172.20.0.78:8181/sp/" + nameTab + "/kanban");  //http://172.20.0.78:8181    //http://77.108.87.134:9696

    }

    public static void clickTab1(String nameTab) {
        sleep(1500);
        $(By.xpath("//div[@class='v-tabs__div']/a[text()[contains(.,'"+nameTab+"')]]")).click();
//        open("http://172.20.0.78:8181/sp/" + nameTab + "");
    }


    public static void verificationOpenForm(String formName) throws IOException {
        String xpath = "//div[@class='card-form']//span[@class='tool-band py-2' and text()[contains(.,'СОЗДАНИЕ ЗАПРОСА')]]";
        log("Форма "+formName+" открылась", "Форма "+formName+" НЕ открылась", xpath, "should","");
    }

    public static void verificationCloseForm(String formName) throws IOException {
        String xpath = "//div[@class='card-form']//span[@class='tool-band py-2' and text()[contains(.,'СОЗДАНИЕ ЗАПРОСА')]]";
        log("Форма "+formName+" закрылась", "Форма "+formName+" НЕ закрылась", xpath, "shouldNot","");
    }

    public static void clickCard(){
            sleep(4000);
            $(By.xpath("//*[@id='card-id-"+TestHelper.number+"-request']/div/div[1]")).doubleClick();
        }

    public static void clickDownFile(){
        sleep(1000);
        $(By.xpath("//*[@id='siema_tss_files']/div/div[1]/div/div/span/span/div/span")).click();
        namefile = $(By.xpath("//*[@id='siema_tss_files']/div/div[1]/div/div/span/span/div/span")).getText();
        try{

        } catch(Error e){

        }

    }

}


