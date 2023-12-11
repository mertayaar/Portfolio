package Utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI_Methods {
    public WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(10));

    public void clickMethod(WebElement element) {
        waitUntilClickable(element);
        waitUntilVisible(element);

        scrollToElement(element);
        element.click();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void sendKeysMethod(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    public void verifyContainsText(WebElement element, String message) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, message));
        Assert.assertTrue(element.getText().toLowerCase().contains(message.toLowerCase()));
    }

    public void waitForNumberOfElements(By locator, int number) {
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
    }


    public void recordOrderReference(WebElement element) {

        String str = element.getText();
        Pattern p = Pattern.compile("(\\breference\\b)(.*?)(\\bin\\b)");
        Matcher m = p.matcher(str);
        StringBuilder match = new StringBuilder();
        while (m.find()) {
            match.append(m.group(2));
        }

        try {

            File newTextFile = new File("src/test/java/UI_Testing/Assets/Files/OrderRefFile.txt");

            FileWriter fileWriter = new FileWriter(newTextFile);
            fileWriter.write(match.toString());
            fileWriter.close();

        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public void hoverFunction(WebElement element) {
        waitUntilVisible(element);
        Actions actions = new Actions(BaseDriver.getDriver());
        scrollToElement(element);
        Action action = actions.moveToElement(element).build();
        action.perform();
    }

    public void verifyListSize(List<WebElement> element, String size) {
        waitUntilVisible(element.get(0));
        Assert.assertEquals(element.size(), Integer.parseInt(size));
    }

    public void contactUsFileUploadAction(WebElement element, String pathName) {
        Actions actions = new Actions(BaseDriver.getDriver());
        actions.click(element).build().perform();

        File file = new File(pathName);
        StringSelection filePath = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        try {

            Robot robot = new Robot();

            Set<String> windowHandles = BaseDriver.getDriver().getWindowHandles();
            for (String handle : windowHandles) {
                BaseDriver.getDriver().switchTo().window(handle);
                if (BaseDriver.getDriver().getTitle().contains("Contact us - Xu Clothing")) {
                    break;
                }
            }

            //FOR MAC
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);

            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


    }

    public String fileReaderMethod(String path) {
        String refNumber;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            refNumber = bufferedReader.readLine();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return refNumber;
    }

    // Kill Process
    public void sendRandomKeysMethod(WebElement element) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(randomEmail());
    }

    public String randomEmail() {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }
}
