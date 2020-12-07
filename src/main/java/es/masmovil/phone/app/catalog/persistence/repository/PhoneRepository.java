package es.masmovil.phone.app.catalog.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.masmovil.phone.app.catalog.persistence.Phone;

public interface PhoneRepository extends MongoRepository<Phone, String>{

}
