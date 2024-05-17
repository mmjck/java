package br.com.mmjck.placeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.mmjck.placeservice.domain.PlaceRepository;
import br.com.mmjck.placeservice.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository repository){
        return new PlaceService(repository);
    }
}
