package ru.ksodd.Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import ru.ksodd.Helpers.TestHelper;
import ru.ksodd.Pages.Statement;

public class TestStatementPage {

    @And("^Клик по чекбоксу \"(.*)\"$")
    public static void clickCheckbox(String word){
        Statement.clickCheck(word);
    }
    @And("^проверка наличия созданной карточки пакет$")
    public static void testAddCardPackage(){
        TestHelper.testAddCardPackage();
    }

    @When("^Выбор даты$")
    public static void inputDate(){
        Statement.inputDate();
    }

    @When("^Выбор поздную дату$")
    public static void inputDateEnd(){
        Statement.inputDateEnd1();
    }

    @When("Выбор поздную дату 2")
    public static void inputDateEnd1(){
        Statement.inputDateEnd1();
    }


}
