package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Steps.TestLoginPage;
//import ru.yandex.qatools.allure.annotations.Description;


import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static ru.ksodd.Helpers.TestHelper.*;

//@Deprecated

public class LoginPage {

    //Логин
    public static void inputLogin(String log) throws IOException {
        //клик на поле емайл
        String xpath = "//input[@aria-label='E-mail']";
        log("Клик по полю E-mail", "Поле E-mail не найдено", xpath, "click", "");
        log("Ввод логина в поле E-mail", "Ввод в поле E-mail не произошел", xpath, "setValue", log);
    }

    //Пароль
    public static void inputPassword(String pass) throws IOException {
        //клик на поле пароль
        String xpath = "//input[@aria-label='Пароль']";
        log("Клик по полю Пароль", "Поле Пароль не найдено", xpath, "click", "");
        log("Ввод пароля в поле Пароль", "Ввод в поле Пароль не произошел", xpath, "setValue", pass);
    }

    //Клик на кнопку Войти
    public static void clickButtonCome() throws IOException {
//        sleep(500);
        //клик на кнопку
        String xpath = "//span[text()='Войти']";
        log("Клик на кнопку Войти", "Не произошел КЛИК на кнопку Войти", xpath, "click", "");


//        try {
//          $(By.xpath("//span[text()='Войти']")).click();
//          logging("Клик на кнопку Войти");
//        } catch (AssertionError error) {
//            errorLogging("Не произошел КЛИК на кнопку Войти");
//        }

        //Проверка наличия текста в главной форме после клика на кнопку Войти
//        try {
//          $(By.xpath("//div[@class='layout kanban column']")).should(Condition.exist);
//          logging("Проверка что после клика на кнопку главное поле открылась");
//        } catch (AssertionError error){
//            errorLogging("Форма/актуализация НЕ открылась");
//        }
    }

    public static void exit() throws IOException {
        String xpath = "//div[@class='v-btn__content' and text()[contains(.,'Выход')]]";
        log("Клик на кнопку Выход", "Не произошел КЛИК на кнопку Выход", xpath, "click", "");

    }

//    public static void pixelbot(){
//        Robot robot = new Robot();
//        WebElement x = $(By.xpath("//div[@class='v-btn__content']"));
//
//
//
//    }



}
