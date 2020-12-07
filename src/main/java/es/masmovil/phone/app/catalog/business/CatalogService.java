package es.masmovil.phone.app.catalog.business;

import java.util.List;

import es.masmovil.phone.app.catalog.dto.PhoneDTO;

public interface CatalogService {

	/**
	 * Get phone list
	 * 
	 * @return The phone list
	 */
	List<PhoneDTO> getPhoneCatalog();

	/**
	 * Get Phone by id
	 * 
	 * @param id
	 * @return The phone
	 */
	PhoneDTO getPhoneById(String id);

}
