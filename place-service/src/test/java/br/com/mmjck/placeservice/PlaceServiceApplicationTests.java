package br.com.mmjck.placeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.mmjck.placeservice.api.PlaceRequestDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {
	@Autowired
	WebTestClient webTestClient;
	
	@Test
	public void testCreatePlaceSuccess(){
		var name = "Valid Name";
		var state = "Valid State";
		var slug = "valid-state";
		
		
		webTestClient
			.post()
			.uri("/places/")
			.bodyValue(
				new PlaceRequestDTO(name, state)
			)
			.exchange()
			.expectBody()
			.jsonPath("name").isEqualTo(name)
			.jsonPath("state").isEqualTo(state)
			.jsonPath("slug").isEqualTo(slug)
			.jsonPath("createdAt").isNotEmpty()
			.jsonPath("updatedAt").isNotEmpty();




	}

	@Test
	public void testCreatePlaceFailure(){
		var name = "";
		var state = "";
		
		
		webTestClient
			.post()
			.uri("/places/")
			.bodyValue(
				new PlaceRequestDTO(name, state)
			)
			.exchange()
			.expectStatus().isBadRequest();




	}



}
