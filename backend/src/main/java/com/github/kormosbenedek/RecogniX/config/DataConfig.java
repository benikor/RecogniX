package com.github.kormosbenedek.RecogniX.config;

import com.github.kormosbenedek.RecogniX.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;



@Component
public class DataConfig  {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.exposeIdsFor(Symptom.class);
            config.exposeIdsFor(Patient.class);
            config.exposeIdsFor(Treatment.class);
            config.exposeIdsFor(RequestTreatment.class);
            config.exposeIdsFor(SymptomWithComment.class);
            config.exposeIdsFor(CompletedTreatment.class);
        });
    }
}