package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class Initiative {

    public static void testOpenForm(String form_name){
        $(By.xpath("//span[text()[contains(.,'"+form_name+"')]]/../../../div[@class='fill-height relative']")).should(Condition.exist);
    }

    public static void inputStreetInit(String street){
        $(By.xpath("//input[@aria-label='Улица']")).click();
        $(By.xpath("//input[@aria-label='Улица']")).setValue(street);
        $(By.xpath("//div[@class='v-list__tile__title']")).click();
        sleep(1000);
    }

    public static void inputJobContent(String jobContent){
        $(By.xpath("//textarea[@aria-label='Содержание работ']")).click();
        $(By.xpath("//textarea[@aria-label='Содержание работ']")).setValue(jobContent);
    }

    public static void uploadFile(String fileName){
        $(By.xpath("//input[@type='file']")).uploadFile(new File("src/test/repository/File/"+fileName));
    }
}
