package at.fhtw.swen3.configuration;

import at.fhtw.swen3.services.ParcelLogic;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ParcelService parcelService(ParcelLogic parcelLogic) {
        return new ParcelService(parcelLogic);
    }
}