package es.masmovil.phone.app.catalog.persistence.transformer;

import es.masmovil.phone.app.catalog.dto.PhoneDTO;
import es.masmovil.phone.app.catalog.persistence.Phone;
import lombok.NonNull;

/**
 * Transformer between persistence layer and business layer
 * @author JMP87
 *
 */
public interface PersistenceTransformer {

	/**
	 * Transform Phone to PhoneDto
	 * @param phone The Phone
	 * @return The PhoneDTO
	 */
	PhoneDTO toPhoneDto(@NonNull Phone phone);
}
