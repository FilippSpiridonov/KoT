package ru.ksodd.Pages;

import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Steps.TestLoginPage;
//import ru.yandex.qatools.allure.annotations.Description;


import static com.codeborne.selenide.Selenide.$;
import static ru.ksodd.Helpers.TestHelper.errorLogging;
import static ru.ksodd.Helpers.TestHelper.logging;

@Deprecated

public class LoginPage {

    //Логин
    public static void inputLogin(String log) {

        //клик на поле емайл
        try {
            $(By.xpath("//input[@aria-label='E-mail']")).click();
            TestHelper.logging("Клик по полю E-mail");
        } catch (AssertionError error) {
            errorLogging("Не произошел КЛИК на поле E-mail");
        }
        //ввод значения в поле емайл
        try {
            $(By.xpath("//input[@aria-label='E-mail']")).setValue(log);
            logging("Ввод логина в поле E-mail");
        } catch (AssertionError error) {
            errorLogging("Не произошел ВВОД в поле E-mail");
        }
    }

    //Пароль
    public static void inputPassword(String pass) {
        //клик на поле пароль
        try {
            $(By.xpath("//input[@aria-label='Пароль']")).click();
            TestHelper.logging("Клик на поле Пароль");
        } catch (AssertionError error) {
            errorLogging("Не произошел КЛИК в поле Пароль");
        }
        //ввод пароля в поле пароль
        try {
            $(By.xpath("//input[@aria-label='Пароль']")).setValue(pass);
            TestHelper.logging("Произошел ВВОД на поле Пароль");
        } catch (AssertionError error) {
            errorLogging("Не произошел ВВОД в поле Пароль");
        }
    }

    //Клик на кнопку Войти
    public static void clickButtonCome() {
        //клик на кнопку
        String xpath = "//span[text()='Войти']";
        TestHelper.log("Клик на кнопку Войти", "Не произошел КЛИК на кнопку Войти",xpath,"click","");



//        try {
//          $(By.xpath("//span[text()='Войти']")).click();
//          logging("Клик на кнопку Войти");
//        } catch (AssertionError error) {
//            errorLogging("Не произошел КЛИК на кнопку Войти");
//        }

        //Проверка наличия текста в главной форме после клика на кнопку Войти
        try {
          $(By.xpath("//div[@class='layout kanban column']")).should(Condition.exist);
          logging("Проверка что после клика на кнопку главное поле открылась");
        } catch (AssertionError error){
            errorLogging("Форма/актуализация НЕ открылась");
        }

    }

    public static void exit(){
        $(By.xpath("//div[text()[contains(.,'Выход')]]")).click();
    }


}
