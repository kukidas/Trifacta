package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {
    public static void takeScreenshot(WebDriver driver,String fileName) throws IOException {
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/main/Screenshots/"+fileName+".jpg"));
    }
}
