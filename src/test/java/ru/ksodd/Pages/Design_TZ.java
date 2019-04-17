package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.ksodd.Helpers.TestHelper;

import java.nio.ByteBuffer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Design_TZ {

    public static String numberTZ = "";

    public static void inputBase(String text){
        $(By.xpath("//div/input[@aria-label='Основания']")).should(Condition.visible);
        $(By.xpath("//input[@aria-label='Основания']/..")).click();
        $(By.xpath("//div[@class='v-list__tile__content']/div[text()[contains(.,'"+text+"')]]")).click();
    }


    public static void selectedLastId(){
        sleep(3000);
        numberTZ = $(By.xpath("//div[last()]/div[@data-index='0']/div[1]/div[2]/span[text()]")).getText();
//        $(By.xpath("//div[last()]/div[@data-index='0']/div[1]/div[2]/span[text[contains(.,'"+numberTZ+"')]]")).click();

    }

    public static void clickTusk(String task) {
        String xpath = "//*[text()[contains(.,'"+numberTZ+"')]]/../../../div[5]//*[text()[contains(.,'"+task+"')]]";
        sleep(5000);
        TestHelper.log("Клик на таск"+task,"Таск "+task+" НЕ был найден",xpath,"click","");
    }

    public static void clickZnak(String status){

        switch (status){
            case "green":
                $(By.xpath("//input[@name='add_tsodd']")).click();
                $(By.xpath("//input[@name='add_tsodd']")).setValue("3");
                break;
            case "red":
                $(By.xpath("//input[@name='remove_tsodd']")).click();
                $(By.xpath("//input[@name='remove_tsodd']")).setValue("3");
                break;
            case "grey":
                $(By.xpath("//input[@name='illum_tsodd']")).click();
                $(By.xpath("//input[@name='illum_tsodd']")).setValue("3");
                break;
        }
    }

    public static void inputDate(){
        $(By.xpath("//span[text()[contains(.,'Реализовать до')]]/../span[2]/div/div")).click();
        $(By.xpath("//tr[last()]/td[last()]/button[@type='button']/div[@class='v-btn__content']")).click();
    }


}
