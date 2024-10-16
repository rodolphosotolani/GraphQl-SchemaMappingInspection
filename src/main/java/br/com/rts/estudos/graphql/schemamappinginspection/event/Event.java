package br.com.rts.estudos.graphql.schemamappinginspection.event;

import java.time.LocalDate;

public record Event(
        Integer id,
        String name,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        LocalDate cfpStartDate,
        LocalDate cfpEndDate,
        String location,
        String website
) {
}
