package ru.ksodd.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import ru.ksodd.Helpers.TestHelper;

public class General_step_cucumber {

    @When("^Клик на кнопку \"(.*)\"$")
    public static void createInit(String button_name) {
        TestHelper.clickAddNewCard(button_name);
    }

    @And("^Ввод \"(.*)\" \"(.*)\"$")
    public static void inputComment(String input, String text) {
        TestHelper.inputAll(input, text);
    }
}
