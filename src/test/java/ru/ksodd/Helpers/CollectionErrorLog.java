package ru.ksodd.Helpers;

import com.beust.jcommander.internal.Console;
import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;


import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;


public class CollectionErrorLog {

    public static void consolsInfo() {

        for (String logEntry : getWebDriverLogs(LogType.BROWSER, Level.SEVERE)) {
//          Reporter.log(logEntry + "<br />");
            Allure.addAttachment("Отчет для разработчика: ", String.valueOf(logEntry));
        }
        }

    }


