package ru.ksodd.Helpers;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;
import static io.qameta.allure.Allure.step;

public class Screenshoting {

    public static void screen(String text) throws IOException {
        Date date = new Date();
        long millis = date.getTime();
        String mill = String.valueOf(millis);
        screenshot(mill);
        Path content = Paths.get("C:\\Users\\spiridonov_fl\\Desktop\\КоТ_project\\build\\reports\\tests\\" + "" + mill + ".png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(text, is);
        }
    }

}


