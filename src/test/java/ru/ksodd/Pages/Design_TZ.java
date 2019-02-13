package ru.ksodd.Pages;

import org.openqa.selenium.By;

import java.nio.ByteBuffer;

import static com.codeborne.selenide.Selenide.$;

public class Design_TZ {
    public static void inputBase(String text){
        $(By.xpath("//div/input[@aria-label='Основания']")).click();
        $(By.xpath("//div/input[@aria-label='Основания']")).click();
    }

}
