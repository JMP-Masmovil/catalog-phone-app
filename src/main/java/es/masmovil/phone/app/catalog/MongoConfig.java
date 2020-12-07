package es.masmovil.phone.app.catalog;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClientSettings;

import es.masmovil.phone.app.catalog.persistence.Phone;
import es.masmovil.phone.app.catalog.persistence.repository.PhoneRepository;

@Component
public class MongoConfig {

	@Autowired
	private PhoneRepository phoneRepository;

	@PostConstruct
	public void mongoTemplate() throws IOException {

		Phone phone = new Phone();
		
		phone.setIdentifier(UUID.randomUUID().toString());
		phone.setName("Xiami Redmi Note");
		phone.setPrice(BigDecimal.valueOf(229D));
		phone.setDescription("Móvil - Xiaomi Redmi Note 9S, Azul aurora, 128GB, 6GB, 6.67\\\" Full HD+, SnapDragon™ 720G, 5020 mAh, Android");
		phone.setUrl("https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MMS_74802236/fee_240_148_png/M%C3%B3vil---Xiaomi-Redmi-Note-9S--Azul-aurora--128GB--6GB--6.67%22-Full-HD---SnapDragon%E2%84%A2-720G--5020-mAh--Android");
		phoneRepository.save(phone);
		
		phone = new Phone();
		phone.setIdentifier(UUID.randomUUID().toString());
		phone.setName("Samsung A51");
		phone.setPrice(BigDecimal.valueOf(275D));
		phone.setDescription("Móvil - Samsung Galaxy A51, Negro, 128 GB, 4 GB RAM, 6.5\\\" Full HD+, Exynos9611, 4000 mAh, Android'");
		phone.setUrl("https://www.mediamarkt.es/es/product/_m%C3%B3vil-samsung-galaxy-a51-negro-128-gb-4-gb-ram-6-5-full-hd-exynos9611-4000-mah-android-1471291.html");
		phoneRepository.save(phone);
		
		phone = new Phone();
		phone.setIdentifier(UUID.randomUUID().toString());
		phone.setName("Apple iPhone 11");
		phone.setPrice(BigDecimal.valueOf(689D));
		phone.setDescription("Apple iPhone 11, Blanco, 64 GB, 6.1\\\" Liquid Retina HD, Chip A13 Bionic, iOS");
		phone.setUrl("https://assets.mmsrg.com/isr/166325/c1/-/ASSET_MMS_79039936/fee_240_148_png/Apple-iPhone-11--Blanco--64-GB--6.1%22-Liquid-Retina-HD--Chip-A13-Bionic--iOS");
		phoneRepository.save(phone);
		
		phone = new Phone();
		phone.setIdentifier(UUID.randomUUID().toString());
		phone.setName("OPPO A5");
		phone.setPrice(BigDecimal.valueOf(149D));
		phone.setDescription("Móvil - OPPO A5, Negro, 64 GB, 3 GB RAM, 6.5\\\" HD, Snapdragon 665, 5000 mAh, Android");
		phone.setUrl("https://assets.mmsrg.com/isr/166325/c1/-/ms-shop-mmes-l118202/wcs_overlay_prod_list");
		phoneRepository.save(phone);
		
		phone = new Phone();
		phone.setIdentifier(UUID.randomUUID().toString());
		phone.setName("LG K40s");
		phone.setPrice(BigDecimal.valueOf(129D));
		phone.setDescription("Móvil - LG K40s, Azul, 32 GB, 2 GB RAM, 6.1\\\" HD+, 3500 mAh, Android");
		phone.setUrl("https://www.mediamarkt.es/es/product/_m%C3%B3vil-lg-k40s-azul-32-gb-2-gb-ram-6-1-hd-3500-mah-android-1466283.html");
		phoneRepository.save(phone);
	}

}