package es.masmovil.phone.app.catalog.persistence;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "phones")
@Getter
@Setter
public class Phone {

    @Transient
    public static final String SEQUENCE_NAME = "phones_sequence";
	
	@Id
	private String identifier;

	private String name;

	private String description;

	private String url;

	private BigDecimal price;

}
