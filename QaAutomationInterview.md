# QA Automation Interview

> I will describe and show the tasks that are often used in QA Automation interviews and why they are not correct from
> my point of view, and why they do not show the right automation engineer skill. Also, I will try to show the "right"
> questions that will lead to understanding the experience and mindset of a candidate.

## Standard task on QA Automation interview, that does not check proper knowledge

[Task number 1](src/test/java/com/skryl/interview/logical/TaskNumber1.java),
[Task number 2](src/test/java/com/skryl/interview/logical/TaskNumber2.java),
[Task number 3](src/test/java/com/skryl/interview/logical/TaskNumber3.java),
[Task number 4](src/test/java/com/skryl/interview/logical/TaskNumber4.java),
...

So we have a bunch of interesting logical tasks. And let's answer a question, why they are bad for QA automation
interviews?
First of all, QA automation rarely writes a logical block of code, moreover, it is a bad practice to write such a thing
in tests. Why? Because every logic can contain a potential bug, besides the product bugs we will write tests that also
has bugs.

And the question arises, What should we give to verify the proper QA automation engineer skill, because our goal is
to find an engineer who will solve the test automation properly, not the logical Guru? Which skill are we trying to
find? Let's see:

- Engineer who knows the capabilities of choosing a programming language
- Engineer who writes clean and understandable test
- Engineer with knowledge of test design technique that leads to good coverage of product using fewer tests
- Engineer who tests are fast as possible, and who can find the solution to increase the test speed by verifying
  particular features, and will provide feedback as faster as possible.
- Engineer who writes a test that will show a meaningful error that will lead to easy and fast debug
- Engineer who knows common libraries and approaches to not reinvent the wheel every time.
- Engineer who can say and prove where automation is good and where is a complex and hard solution that will take a
  lot of effort and lead to test result flakiness

1. I am propose to give an easy task for exmple (...) that will check knowledge of language syntaksys, that is what we
   want, no to check logical mind set, but knowledge of the landuage, and also ask to write proper test cases that show
   us the experienct of engineer, because that is what he must doing all the time.
2. We can prepare in advance a complex logic with a bug and also with sneaky bug (like concurency issue) and ask to
   verify that peace of code, and check how much bugs did he found.
3. We can also show the test snippets with mistake that can be adjust.

## What will you improve in those snippets

[Snippet 1](src/test/java/com/skryl/interview/snippets/ReviewSnippet1.java)
Correct answer:

- substitute logic in test by using common libraries to not reinvent the wheel.

[Snippet 2](src/test/java/com/skryl/interview/snippets/ReviewSnippet2.java)
Correct answer:

- If you know the library (RestAssured or other language specific libraries) interviewer can suggest to move repeatable
  part to one place and reuse it.
- Extract the request for reusing and assertion part can stay in test where it belong.
- replace base url domain with properties that are usually many of them for different environment

[Snippet 3](src/test/java/com/skryl/interview/snippets/ReviewSnippet3.java)
Correct answer:

- Assertion error in test 2 "Expecting actual not to be empty" does not describe what it really happening. **Use
  assertJ [as()](https://javadoc.io/doc/org.assertj/assertj-core/latest/org/assertj/core/api/Descriptable.html) method
  to describe the expectation.**
- Unhandled error in test 3 with nondescript value "java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for
  length 2". **catch Exception and retrouw it with more miningfull description**
- Unclear selector name, that does not help to understand what is actually searching.
- All nondescript error lead to hard debug process

[Snippet 4](src/test/java/com/skryl/interview/snippets/ReviewSnippet4.java)
Correct answer:

<a href="https://medium.com/@alexsiminiuc3/bad-coding-practices-for-test-automation-with-selenium-webdriver-4dba947ceed0">
Taken from Medium portal</a>

- the method name is misleading; the method waits for the url to include a keyword and not for the page to load; a
  better name is isUrlCorrect()
- do while() would work better than while
- Boolean.FALSE.equals(stringExists) is the same with stringExists == false or !stringExists
- the try/catch for waiting can be extracted in a method
- the code for checking if the url contains a keyword can be extracted in a method
- the exception does not say which page is not loaded
- the parameter should be named keyword instead of string
- Count should be count
- Comments all over the place; not even // TODO Auto-generated catch block is removed

```java
public class Answer {

    private final WebDriver driver;
    
    public Answer(WebDriver driver) {
        this.driver = driver;
    }

    public void isUrlCorrect(String keyword) throws PageNotDisplayedException {
        int count = 0;
        do {
            count++;
            waitFor();
        } while (!urlContains(keyword) && count < 30);
        if (count == 30)
            throw new PageNotDisplayedException("Page not loaded with keyword: %s".formatted(keyword));
    }

    private void waitFor() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private boolean urlContains(String keyword) {
        return driver.getCurrentUrl().contains(keyword);
    }

    static class PageNotDisplayedException extends Exception {
        public PageNotDisplayedException(String message) {
            super(message);
        }
    }

}
```

and this task has a better solution using existing method in Selenium WebDriver

```java
public class BetterAnswer {
    public void isUrlCorrectNative(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.urlContains(keyword));
    }
}
```

## Tasks for interviwer to write automation code

Notes:
> it will be a live demo were you can create a project in advance and give the link to project on interview. This will
> also verify git knowledge as well. The interviewer must clone the repo. It will be good if he create separate branch
> to
> not working in main and will create a PR.

Task 1 : Automate the login functionality of a web application
@author ChatGPT

Instructions:
- Choose a web application that you are familiar with, or use a publicly available web application that allows for
  testing.
- Write an automated test script that will simulate a user logging in to the application.
- The test should verify that the user is able to successfully log in with valid credentials, and that they are not able
  to log in with invalid credentials.
- The test should also handle any error messages or pop-ups that appear during the login process.
- The test script should be written in a programming language of your choice, and should use a suitable testing
  framework (e.g. Selenium WebDriver or Appium).
- You can use any automation tools or libraries that you are familiar with, as long as they meet the requirements of the
  task.
- Once the script is complete, provide a brief report or documentation that includes instructions for how to run the
  test, any dependencies or requirements, and any observations or notes about the testing process.

Conclusion:
- This task should allow the interviewer to assess your ability to write automated test scripts using a testing
  framework and programming language of your choice, as well as your understanding of handling error messages and
  pop-ups that can occur during the testing process. It is also a practical task that simulates a real-world testing
  scenario, which can help the interviewer understand your ability to apply your testing knowledge and skills in a
  practical setting.

Task 2 : Bad code example
@author ChatGPT

```java
public class BadCodeExample {

    public void login(String username, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://example.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.quit();
    }

}
```

Here are some of the issues with this code:
- The WebDriver is created and destroyed every time the login() method is called. This is inefficient and can slow down test execution.
- The Thread.sleep(5000) call is used to add an arbitrary delay to allow time for the page to load. This is a fragile and unreliable way to wait for the page to load, as it doesn't take into account variations in page load time. A better approach would be to use an explicit wait that waits for a specific element to appear on the page.
- The driver.quit() call is used to close the browser window, but it doesn't clean up any resources associated with the WebDriver instance. This can cause memory leaks and other issues, especially when running tests in a loop or in parallel.
- Overall, this code is not very robust, maintainable, or efficient, and could be improved by addressing these issues.

