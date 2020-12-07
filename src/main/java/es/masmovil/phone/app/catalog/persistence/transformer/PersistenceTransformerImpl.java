package es.masmovil.phone.app.catalog.persistence.transformer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import es.masmovil.phone.app.catalog.persistence.Phone;
import lombok.NonNull;

@Service
public class PersistenceTransformerImpl implements PersistenceTransformer {

	@Override
	public PhoneDTO toPhoneDto(@NonNull Phone phone) {

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(phone, PhoneDTO.class);
	}

}
