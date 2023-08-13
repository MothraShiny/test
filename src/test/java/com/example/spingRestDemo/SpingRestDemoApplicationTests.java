package com.example.spingRestDemo;

import com.example.spingRestDemo.pojo.PersonPojo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static io.restassured.RestAssured.given;



@SpringBootTest
class SpingRestDemoApplicationTests {
	private final static String URL = "http://localhost:8080";

	@Test
	void contextLoads() {
	}

	@Test
	void checkIsEmailsNotNullTest() {
		Specification.init(Specification.requestSpecification(URL), Specification.responseOk200());

		List<PersonPojo> personPojoList = given()
				.when()
				.get("/people")
				.then().log().all()
				.extract().body().jsonPath().getList("",PersonPojo.class);

		personPojoList.forEach(element -> Assertions.assertFalse(element.getEmail().isEmpty()));
	}

	@Test
	void successPersonRegistrationTest() {
		Specification.init(Specification.requestSpecification(URL), Specification.responseOk200());

		PersonPojo person = new PersonPojo("Alex", "secret", "mailbox@mail.com");

		given()
				.body(person)
				.when()
				.post("/people")
				.then().log().all();
	}

	@Test
	void successPersonUpdateTest() {
		Specification.init(Specification.requestSpecification(URL), Specification.responseOk200());

		int id = 1; //Metadata
		PersonPojo person = new PersonPojo("Melon", "lookAt", "sendIt@mail.com");

		given()
				.body(person)
				.when()
				.patch("/people/" + id)
				.then().log().all();
	}

}
