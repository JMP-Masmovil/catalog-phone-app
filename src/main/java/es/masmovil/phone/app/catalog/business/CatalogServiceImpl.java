package es.masmovil.phone.app.catalog.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import es.masmovil.phone.app.catalog.persistence.Phone;
import es.masmovil.phone.app.catalog.persistence.repository.PhoneRepository;
import es.masmovil.phone.app.catalog.persistence.transformer.PersistenceTransformer;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private PersistenceTransformer persistenceTransformer;
	
	@Override
	public List<PhoneDTO> getPhoneCatalog() {

		List<PhoneDTO> listPhoneDto = new ArrayList<>();
		Iterable<Phone> iterablePhoneRepository = phoneRepository.findAll();
		
		for (Phone phone : iterablePhoneRepository) {
			listPhoneDto.add(persistenceTransformer.toPhoneDto(phone));
		}

		return listPhoneDto;
	}

	@Override
	public PhoneDTO getPhoneById(String id) {


		Optional<Phone> optionalPhone = phoneRepository.findById(id);
		
		if(optionalPhone.isPresent()) {
			return persistenceTransformer.toPhoneDto(optionalPhone.get());
		}
		
		return null;
	}

}
