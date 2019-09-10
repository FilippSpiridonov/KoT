package ru.ksodd.Helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static ru.ksodd.Helpers.TestHelper.namefile;

public class Test {
        public static void razmerTest (){
            File file = new File("C:/Users/spiridonov_fl/Downloads/"+""+namefile+"");
            if (file.exists()) {
                System.out.println(getFileSizeBytes(file));
            }
            if(file.delete()){
                System.out.println("файл удален");
            }
        }

        private static String getFileSizeBytes(File file) {
            return file.length() + " bytes";
        }
    }
