package com.skryl.interview.snippets;

import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author Skryl D.V. on 2023-02-04
 */
public class ReviewSnippet2 {

    @Test
    public void test1() {
        RestAssured.given()
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer token")
                .body("{\"create\":\"record\"}")
                .log().all()
                .post("https://www.company.com")
                .then()
                .log().all()
                .statusCode(201)
                .and()
                .assertThat().body("response with creation", Matchers.is("response with creation"));
    }

    @Test
    public void test2() {
        RestAssured.given()
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer token")
                .log().all()
                .get("https://www.company.com/record")
                .then()
                .log().all()
                .statusCode(200)
                .and()
                .assertThat().body("response with message", Matchers.is("response with message"));
    }

    @Test
    public void test3() {
        RestAssured.given()
                .filter(new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer token")
                .body("{\"update\":\"record\"}")
                .log().all()
                .put("https://www.company.com")
                .then()
                .log().all()
                .statusCode(204)
                .and()
                .assertThat().body("", Matchers.equalTo(Collections.emptyList()));
    }


}
