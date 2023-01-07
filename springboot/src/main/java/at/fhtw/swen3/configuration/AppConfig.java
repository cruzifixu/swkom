package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.impl.*;
import at.fhtw.swen3.services.mapper.*;
import at.fhtw.swen3.services.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository, ParcelMapper parcelMapper, Validator validator) {
        return new ParcelServiceImpl(parcelRepository, parcelMapper, validator);
    }

    @Bean
    public Validator getValidator(){
        return new Validator();
    }

    @Bean
    public ParcelMapper getParcelMapper() {
        return new ParcelMapperImpl();
    }
}