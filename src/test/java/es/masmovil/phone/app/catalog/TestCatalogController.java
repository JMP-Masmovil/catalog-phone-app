package es.masmovil.phone.app.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import es.masmovil.lib.catalog.integration.PhoneRSDTO;
import es.masmovil.lib.catalog.integration.client.CatalogFeignClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/test.properties")
class TestCatalogController {

	@Autowired
	private CatalogFeignClient catalogClient;

	private static final int LIST_SIZE = 5;

	@Test
	void testCatalogController() {

		ResponseEntity<List<PhoneRSDTO>> listPhones = catalogClient.getListPhones();

		assertTrue(Optional.of(listPhones).map(ResponseEntity<List<PhoneRSDTO>>::getBody)
				.filter(l -> l.size() == LIST_SIZE).isPresent(), "Verify result number");
	}

	@Test
	void testCatalogControllerById() {

		PhoneRSDTO phoneRSDTO = catalogClient.getListPhones().getBody().get(0);

		ResponseEntity<PhoneRSDTO> respEntity = catalogClient.getPhoneById(phoneRSDTO.getIdentifier());
		assertEquals(HttpStatus.OK, respEntity.getStatusCode());
		
		assertEquals(phoneRSDTO.getIdentifier(), respEntity.getBody().getIdentifier());
		assertEquals(phoneRSDTO.getDescription(), respEntity.getBody().getDescription());
		assertEquals(phoneRSDTO.getName(), respEntity.getBody().getName());
		assertEquals(phoneRSDTO.getPrice(), respEntity.getBody().getPrice());
		assertEquals(phoneRSDTO.getUrlImage(), respEntity.getBody().getUrlImage());
		
		respEntity = catalogClient.getPhoneById("1234");
		assertEquals(HttpStatus.NOT_FOUND, respEntity.getStatusCode());


	}

}
