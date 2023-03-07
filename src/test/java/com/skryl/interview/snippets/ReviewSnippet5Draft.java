package com.skryl.interview.snippets;

import com.skryl.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-02-04
 */
public class ReviewSnippet5Draft {

    private User userUnderTest;

    @BeforeEach
    public void receiveUserResponse() {
        userUnderTest = new User();
        userUnderTest.setName("Dmytro");
        userUnderTest.setAge(37);
    }

    @Test
    public void test1() {
        assertThat(userUnderTest.getName()).isEqualTo("Dmytro");
    }

    @Test
    public void test2() {
        assertThat(userUnderTest.getAge()).isEqualTo(37);
    }

    @Test
    public void test3() {
        var actualCity = userUnderTest.getAddress().getCity();
        assertThat(actualCity).isEqualTo("Kiev");
    }

}
