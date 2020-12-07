package es.masmovil.phone.app.catalog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.masmovil.lib.catalog.integration.PhoneRSDTO;
import es.masmovil.phone.app.catalog.business.CatalogService;
import es.masmovil.phone.app.catalog.controller.transformer.ClientControllerTransformer;
import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("${ms.api.basepath}")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;

	@Autowired
	private ClientControllerTransformer clientControllerTransformer;

	@GetMapping("/phones")
	public ResponseEntity<List<PhoneRSDTO>> getPhones() {
		
		log.debug("inicio - getPhones");
		
		List<PhoneDTO> listPhone = catalogService.getPhoneCatalog();
		List<PhoneRSDTO> listPhoneResponseDTO = clientControllerTransformer.toPhoneResponseDto(listPhone);

		log.debug("fin - getPhones");

		return new ResponseEntity<>(listPhoneResponseDTO,HttpStatus.OK);
	}

	@GetMapping("/phones/{id}")
	public ResponseEntity<PhoneRSDTO> getPhonesById(@PathVariable String id) {
	
		log.debug("inicio - getPhonesById");
		PhoneDTO phoneDto = catalogService.getPhoneById(id);
		
		ResponseEntity<PhoneRSDTO> response;

		if (Optional.ofNullable(phoneDto).isPresent()) {
			PhoneRSDTO phoneRsDto = clientControllerTransformer.toPhoneResponseDto(phoneDto);
			response = new ResponseEntity<>(phoneRsDto, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

		log.debug("fin - getPhonesById");
		return response;

		
	}
	
}
