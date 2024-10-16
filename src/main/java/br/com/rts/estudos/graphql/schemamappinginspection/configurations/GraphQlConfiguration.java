package br.com.rts.estudos.graphql.schemamappinginspection.configurations;

import graphql.scalars.ExtendedScalars;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Log4j2
@Configuration
public class GraphQlConfiguration {

    @Bean
    public RuntimeWiringConfigurer getRuntimeWiringConfigurer(){
        return wiringgBuilder -> wiringgBuilder
                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.Url);
    }

    @Bean
    public GraphQlSourceBuilderCustomizer getGraphQlSourceBuilderCustomizer(){
        return source -> source.inspectSchemaMappings(schemaReport -> log.info(schemaReport.toString()));
    }
}
