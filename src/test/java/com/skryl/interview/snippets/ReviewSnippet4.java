package com.skryl.interview.snippets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * <a href="https://medium.com/@alexsiminiuc3/bad-coding-practices-for-test-automation-with-selenium-webdriver-4dba947ceed0">Taken from </a>
 * What’s wrong with this?
 */
public class ReviewSnippet4 {
    private static final WebDriver browserDriver;

    static {
        WebDriverManager.chromedriver().setup();
        browserDriver = new ChromeDriver();
    }

    public void waitForPageToLoad(String string) {
        String url = browserDriver.getCurrentUrl();
        Boolean stringExists = url.contains(string);
        int Count = 0;

        while (Boolean.FALSE.equals(stringExists) && Count < 100) {
            url = browserDriver.getCurrentUrl();
            stringExists = url.contains(string);
            Count = Count + 1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //if(stringExists==false)
        if (Boolean.FALSE.equals(stringExists))
            throw new IllegalStateException(
                    "Page not loaded. Current page" + "is: "
                            + browserDriver.getCurrentUrl());
    }
}

