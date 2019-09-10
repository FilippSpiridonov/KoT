package ru.ksodd.Steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.And;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Sushpole;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.sleep;
import static ru.ksodd.Pages.Sushpole.inputSush;

public class TestSushpolePage {


    @And("^Ввод \"(.*)\" \"(.*)\" сущпол$")
    public static void inputComment2(String input, String text) throws IOException {
        inputSush(input, text);
    }

    @And("^Ввод \"(.*)\" \"(.*)\" сущпол1$")
    public static void inputComment3(String input, String text) throws IOException {
        Sushpole.inputForm(input,text);
    }


    @And("^Клик на иконку плюс$")
    public static void clickIconPlus() throws IOException {
        Sushpole.clickIconPlus();
    }

    @And("^Клик на кнопку Создать$")
    public static void clickButton() throws IOException {
        Sushpole.clickButton();
        sleep(5000);
    }

}
