package ru.ksodd.Steps;

import cucumber.api.java.en.When;
import ru.ksodd.Helpers.TestHelper;

import static com.codeborne.selenide.Selenide.sleep;

public class TestMatchingPage {

    @When("^Клик на таск  \"(.*)\"$")
    public static void clickTask(String task){
        sleep(1500);
        TestHelper.clickTaskPackage(task);
    }

}
