package br.com.rts.estudos.graphql.schemamappinginspection;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchemaMappingInspectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchemaMappingInspectionApplication.class, args);
    }

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
