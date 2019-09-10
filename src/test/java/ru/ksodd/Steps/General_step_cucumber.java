package ru.ksodd.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import ru.ksodd.Helpers.Test;
import ru.ksodd.Helpers.TestHelper;

import java.io.IOException;

public class General_step_cucumber {

    @When("^Клик на кнопку \"(.*)\"$")
    public static void createInit(String button_name) throws IOException {
        TestHelper.clickAddNewCard(button_name);
    }

    @And("^Ввод \"(.*)\" \"(.*)\"$")
    public static void inputComment1(String input, String text) throws IOException {
        TestHelper.inputAll(input, text);
    }

    ////div[@role='listitem'][1]//div[@class='v-list__tile__content']/div[text()='МВК']
//    @And("^Ввод МВК$")
//    public static void inputComment2() throws IOException {
//        TestHelper.inputAll();
//    }

    @When("^Открыть карточку$")
    public static void openCard(){
        TestHelper.clickCard();
        TestHelper.clickDownFile();
        Test.razmerTest();
    }

}
