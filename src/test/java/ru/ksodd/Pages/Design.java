package ru.ksodd.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.ksodd.Helpers.TestHelper;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Design {

    public static void selectType(String type) {
        $(By.xpath("//input[@aria-label='Тип']")).click();
        $(By.xpath("//div[@class='v-list__tile__content']/div[@class='v-list__tile__title' and text()[contains(.,'" + type + "')]]")).click();
    }

    public static void selectProgramm(String program) {
        $(By.xpath("//input[@aria-label='Программа']")).click();
        $(By.xpath("//div[@class='v-list__tile__title' and text()[contains(.,'" + program + "')]]")).click();
    }

    public static void inputVolume(String metr) {
        $(By.xpath("//input[@aria-label='Объем работ']")).click();
        $(By.xpath("//input[@aria-label='Объем работ']")).setValue(metr);
    }

    public static void inputBox(String text) {
        $(By.xpath("//textarea[@aria-label='Планируемые работы']")).click();
        $(By.xpath("//textarea[@aria-label='Планируемые работы']")).setValue(text);
    }

    public static void clickCheck() {
        try {
            $(By.cssSelector("div.v-input.v-input--selection-controls.v-input--checkbox.theme--light > div > div.v-input__slot > div > div")).should(visible);
            $(By.cssSelector("div.v-input.v-input--selection-controls.v-input--checkbox.theme--light > div > div.v-input__slot > div > div")).click();
        } catch (AssertionError e){
            $(By.cssSelector("#formMVKS > div:nth-child(7) > div > div > div > div > div.v-input__slot > div > div")).should(visible);
            $(By.cssSelector("#formMVKS > div:nth-child(7) > div > div > div > div > div.v-input__slot > div > div")).click();

        }
    }

    public static void selectStreet(String street) {
        $(By.xpath("//input[@aria-label='Улица']")).click();
        $(By.xpath("//input[@aria-label='Улица']")).setValue(street);
        $(By.xpath("//div[@class='v-list__tile__title']/span[contains(.,'" + street + "')]")).click();
    }

    public static void uploadFile(String file, String fileName) {
        try {
            $(By.xpath("//div/div[text()[contains(.,'"+file+"')]]/../div[@class='v-avatar white']")).shouldNotBe(exist);
            $(By.xpath("//div[text()='" + file + "']/../..//input[@type='file']")).uploadFile(new File("src/test/repository/File/" + fileName));
        } catch (AssertionError e) {
            $(By.xpath("//div[@class='v-avatar white']")).should(exist);
        }
    }

    public static void uploadFile1(String name_file, String fileName) {
        $(By.xpath("//p[text()='" + name_file + "']/../..//input[@type='file']")).uploadFile(new File("src/test/repository/File/" + fileName));
    }

    public static void whileCheck(String task) {
        WebElement ikon = $(By.xpath("//span[text()[contains(.,'" + TestHelper.number + "')]]/../../../../../div/div[4]//i[text()='error_outline']/../../..//span[text()[contains(.,'" + task + "')]]"));

        for (; ; ) {
            try {
                ((SelenideElement) ikon).should(exist);
                break;
            } catch (AssertionError e) {
                sleep(60000);
                refresh();

            }
        }
    }

    public static void inputGoing(String inputName, String text) {
        $(By.xpath("//input[@aria-label='" + inputName + "']")).click();
        $(By.xpath("//input[@aria-label='" + inputName + "']")).setValue(text);
    }
}

