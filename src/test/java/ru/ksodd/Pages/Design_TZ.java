package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.ksodd.Helpers.TestHelper;

import java.io.IOException;
import java.nio.ByteBuffer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Design_TZ {

    public static String numberTZ = "";

    public static void inputBase(String name, String text){
        $(By.xpath("//div/input[@aria-label='"+name+"']")).should(Condition.visible);
        $(By.xpath("//input[@aria-label='"+name+"']/..")).click();
        $(By.xpath("//div[@class='v-list__tile__content']/div[text()[contains(.,'"+text+"')]]")).click();
    }


    public static void selectedLastId(){
        sleep(2000);
        numberTZ = $(By.xpath("//div[@data-index='0']/div/div[last()]/div/div[1]/div[3]/div/span[text()]")).getText();
//        $(By.xpath("//div[last()]/div[@data-index='0']/div[1]/div[2]/span[text[contains(.,'"+numberTZ+"')]]")).click();

    }

    public static void clickTusk(String task) throws IOException {
//        String xpath = "//*[text()[contains(.,'"+numberTZ+"')]]/../../../../div[@class='tss-re-card__task-list mb-2 pt-2']/div/div/div/div/*[text()[contains(.,'"+task+"')]]";
        String xpath = "//div[@class='py-1']//span[text()[contains(.,'"+task+"')]]";

        //div[@class='layout row wrap justify-end']//*[text()[contains(.,'117')]]
        //span[text()[contains(.,'Принятие в работу')]]

        sleep(500);
        TestHelper.log("Клик на таск "+task,"Таск "+task+" НЕ был найден",xpath,"click","");
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
