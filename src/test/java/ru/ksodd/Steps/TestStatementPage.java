package ru.ksodd.Steps;

import cucumber.api.java.en.And;
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
}
