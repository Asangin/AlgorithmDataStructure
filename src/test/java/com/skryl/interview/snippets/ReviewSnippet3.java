package com.skryl.interview.snippets;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-02-04
 */
public class ReviewSnippet3 {

    @Test
    public void test1() {
        var actualServerResponse = "tp1/123456/city/street";
        assertThat(getTheCity(actualServerResponse))
                .isEqualTo("city");
    }

    @Test
    public void test2() {
        var actualServerResponse = "tp1/123456//street";
        assertThat(getTheCity(actualServerResponse))
                .isNotEmpty();
    }

    @Test
    public void test3() {
        var actualServerResponse = "tp1/123456/";
        assertThat(getTheCity(actualServerResponse))
                .isEqualTo("London");
    }

    @Test
    public void test4() {
        open("https://gsmserver.com/");
        var productKey = "886749";
        var actualSearchText = $("[space='component/product/grid'][key='%s']".formatted(productKey))
                .$(".pr-t_name")
                .shouldHave(Condition.visible)
                .getText();
        String productName = "Z3X Easy-Jtag Plus UFS Kit";
        assertThat(actualSearchText)
                .isEqualTo(productName);
    }

    private String getTheCity(String uri) {
        return uri.split("/")[2];
    }

}
