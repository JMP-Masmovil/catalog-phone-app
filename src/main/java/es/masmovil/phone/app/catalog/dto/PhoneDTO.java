package es.masmovil.phone.app.catalog.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PhoneDTO {

	private String identifier;

	private String name;

	private String description;

	private String urlImage;

	private BigDecimal price;
}
