package ru.ksodd.Steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Design_TZ;

public class TestDesign_TZPage {
    @Then("^Переход в раздел \"(.*)\"$")
    public static void clickTab(String nameTab){
        TestHelper.clickTab(nameTab);
    }

    @When("^Ввод основания \"(.*)\"$")
    public static void inputBase(String text){
        Design_TZ.inputBase(text);
    }

}
