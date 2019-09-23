package ru.ksodd.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ru.ksodd.Helpers.TestHelper;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Design {

    public static void selectType(String type) throws IOException {
        String xpath = "//input[@aria-label='Тип']";
        String xpath1 = "//div[@class='v-list__tile__content']/div[@class='v-list__tile__title' and text()='" + type + "']";
        TestHelper.log("Элемент Тип найден","Элемент Тип не найден",xpath,"should","");
        TestHelper.log("Элемент Тип кликнулась","Элемент Тип не кликнулась",xpath,"click","");
        TestHelper.log("Элемент Тип  кликнулась","Элемент Тип "+type+" не кликнулась",xpath1,"click","");
    }

    public static void selectProgramm(String program) throws IOException {
        String xpath = "//input[@aria-label='Программа']";
        String xpath1 = "//div[@class='v-list__tile__title' and text()[contains(.,'" + program + "')]]";

        TestHelper.log("Элемент Программа найден","Элемент Программа "+program+" не найден",xpath,"should","");
        TestHelper.log("Элемент Программа  кликнулась","Элемент Программа "+program+" не кликнулась",xpath,"click","");
        TestHelper.log("Программа "+program+" выбрана","Программа "+program+" не выбрана",xpath1,"click","");

    }

    public static void inputVolume(String metr) throws IOException {
        String xpath = "//input[@aria-label='Объем работ']";
        String xpath1 = "//input[@aria-label='Объем работ']";
        TestHelper.log("Элемент Объем работ найден","Элемент Объем работ не найден",xpath,"should","");
        TestHelper.log("Элемент Объем работ кликнулась","Элемент Объем  не кликнлуась",xpath,"click","");
        TestHelper.log("Элемент Объем работ кликнулась","Элемент Объем работ "+metr+" не введено",xpath1,"setValue",metr);
    }

    public static void inputBox(String text) throws IOException {
        String xpath = "//textarea[@aria-label='Планируемые работы']";
        String xpath1 = "//textarea[@aria-label='Планируемые работы']";
        TestHelper.log("Клик на поле Планируемых работ","Клик на поле Планируемых работ не произошел",xpath,"click","");
        TestHelper.log("Ввод значения на поле Планируемых работ","Ввод значения на поле Плангируемых работ НЕ произошел",xpath1,"setValue",text);

    }

    public static void clickCheck(String name) {
            $(By.xpath("//label[text()='"+name+"']")).should(visible);
            $(By.xpath("//label[text()='"+name+"']")).click();
    }

    public static void selectStreet(String street) throws IOException {
        String xpath="//div/input[@id='street_select']";
        TestHelper.log("Клик на поле Улица","Клик на поле Улица НЕ произошел",xpath,"click","");
        TestHelper.log("Ввод значения на поле Улица","Ввод на поле Улица НЕ произошел",xpath,"setValue",street);
        $(By.xpath("//div[@class='v-list__tile__title']/span[contains(.,'" + street + "')]")).click();
        actions().sendKeys(Keys.ESCAPE).perform();
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
        $(By.xpath("//*[text()='" + name_file + "']/../..//input[@type='file']")).uploadFile(new File("src/test/repository/File/" + fileName));
    }

    public static void whileCheck(String task) {
        WebElement ikon = $(By.xpath("//span[text()[contains(.,'" + TestHelper.number + "')]]/../../../../../div/div[4]//i[text()='error_outline']/../../..//span[text()[contains(.,'" + task + "')]]"));

        for (; ; ) {
            try {
                ((SelenideElement) ikon).should(exist);
                break;
            } catch (AssertionError e) {
                sleep(30000);
                refresh();

            }
        }
    }

    public static void inputGoing(String inputName, String text) throws IOException {
        String xpath="//input[@aria-label='" + inputName + "']";
        TestHelper.log("Клик на поле "+inputName+"","Клик на поле "+inputName+" не произошел",xpath,"click","");
        TestHelper.log("Ввод значения на поле "+inputName+"","Ввод на поле "+inputName+" НЕ произошел",xpath,"setValue",text);
    }


    public static void inputZaprosFiltr(String num){
        String xpatch = "//input[@aria-label='Номер ТЗ']";
        String button = "//div[@class='v-btn__content' and text()[contains(.,'Применить')]]";
        $(By.xpath(xpatch)).click();
        $(By.xpath(xpatch)).setValue(num);
        sleep(1500);
        $(By.xpath(button)).click();
        sleep(1500);
        System.out.println("Пакет " + num);

}


}

