package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.nio.ByteBuffer;

import static com.codeborne.selenide.Selenide.$;

public class Design_TZ {

    static String number = "";

    public static void inputBase(String text){
        $(By.xpath("//div/input[@aria-label='Основания']")).should(Condition.visible);
        $(By.xpath("//input[@aria-label='Основания']/..")).click();
        $(By.xpath("//div[@class='v-list__tile__content']/div[text()[contains(.,'"+text+"')]]")).click();
    }


    public static void selectedLastId(){
        $(By.xpath("//div[last()]/div[@data-index='0']/div[1]/div[2]/span[text()]")).setValue(number);

    }

}
