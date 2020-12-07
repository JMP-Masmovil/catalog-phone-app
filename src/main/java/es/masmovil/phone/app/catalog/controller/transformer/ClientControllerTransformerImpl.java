package es.masmovil.phone.app.catalog.controller.transformer;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import es.masmovil.lib.catalog.integration.PhoneRSDTO;
import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import lombok.NonNull;

@Service
public class ClientControllerTransformerImpl implements ClientControllerTransformer {
	

	@Override
	public List<PhoneRSDTO> toPhoneResponseDto(@NonNull List<PhoneDTO> listPhoneDto) {

		List<PhoneRSDTO> listPhoneResponseDTO = new ArrayList<>();

		for (PhoneDTO phoneDTO : listPhoneDto) {
			listPhoneResponseDTO.add(toPhoneResponseDto(phoneDTO));
		}

		return listPhoneResponseDTO;
	}

	@Override
	public PhoneRSDTO toPhoneResponseDto(PhoneDTO phoneDTO) {

		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(phoneDTO, PhoneRSDTO.class);		
		
	}

}
