package ru.ksodd.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import ru.ksodd.Pages.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;



public class TestLoginPage {

    @Link("http://77.108.87.134:9696")

    @When("^Ввод логина \"(.*)\"$")
    public static void login(String log) throws IOException {
        LoginPage.inputLogin(log);
    }

    @And("^Ввод пароля \"(.*)\"$")
    public static void password(String pass) throws IOException {
        LoginPage.inputPassword(pass);
    }

    @And("^Клик на кнопку Войти$")
    public static void come() throws IOException {
        LoginPage.clickButtonCome();

    }

    @When("^выход из системы$")
    public static void exit() throws IOException {
        sleep(1000);
        LoginPage.exit();
        sleep(2000);
    }

//    @When("Выбор кнопки")
//    public static void testButton() {
//        LoginPage.pixelbot();
//    }

}
