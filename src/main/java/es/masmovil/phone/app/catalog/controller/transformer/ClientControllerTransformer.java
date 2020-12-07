package es.masmovil.phone.app.catalog.controller.transformer;

import java.util.List;

import es.masmovil.lib.catalog.integration.PhoneRSDTO;
import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import lombok.NonNull;

/**
 * Transformer between service layer and rest layer
 * @author JMP87
 *
 */
public interface ClientControllerTransformer {

	/**
	 * Transform the list of PhoneDto to the list of PhoneResponseDto
	 * @param listPhoneDto The list of PhoneDto
	 * @return The List of PhoneResponseDTO
	 */
	List<PhoneRSDTO> toPhoneResponseDto(@NonNull List<PhoneDTO> listPhoneDto);
	
	/**
	 * Transform the PhoneDto to PhoneResponseDto
	 * @param phoneDto
	 * @return The PhoneRSDTO
	 */
	PhoneRSDTO toPhoneResponseDto(@NonNull PhoneDTO phoneDto);
}
