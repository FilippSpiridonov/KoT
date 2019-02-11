package ru.ksodd.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import ru.ksodd.Pages.LoginPage;

import static com.codeborne.selenide.Selenide.sleep;



public class TestLoginPage {


    @When("^ввод логина \"(.*)\"$")
    public static void login(String log) {
        LoginPage.inputLogin(log);
    }

    @And("^ввод пароля \"(.*)\"$")
    public static void password(String pass) {
        LoginPage.inputPassword(pass);
    }

    @And("^Клик на кнопку Войти$")
    public static void come() {
        LoginPage.clickButtonCome();

    }

    @When("^выход из системы$")
    public static void exit(){
        sleep(3000);
        LoginPage.exit();
    }
}
