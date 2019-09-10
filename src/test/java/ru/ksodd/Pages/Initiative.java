package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.ksodd.Helpers.TestHelper;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class Initiative {

    public static void testOpenForm(String form_name){
        $(By.xpath("//span[text()[contains(.,'"+form_name+"')]]/../../../div[@class='fill-height relative']")).should(Condition.exist);
    }

    public static void inputStreetInit(String street) throws IOException {
        String xpath = "//input[@aria-label='Улица']";
        TestHelper.log("Поле Улица найдена","Поле Улица не Найднена", xpath, "should", "");
        TestHelper.log("Клик на поле Улица произошел","Клик на поле Улица не произошло", xpath, "click", "");
        TestHelper.log("Ввод значения на поле Улица произошел","Ввод на поле Улица не произошло", xpath, "setValue", ""+street+"");
        actions().sendKeys(Keys.ENTER).perform();
//        String text = $(By.xpath(xpath)).getText();
//        assert (("" + street + "").equals(text));
    }

    public static void inputJobContent(String jobContent){
        $(By.xpath("//textarea[@aria-label='Содержание работ']")).click();
        $(By.xpath("//textarea[@aria-label='Содержание работ']")).setValue(jobContent);
    }

    public static void uploadFile(String fileName){
        $(By.xpath("//input[@type='file']")).uploadFile(new File("src/test/repository/File/"+fileName));
    }
}
