package br.com.rts.estudos.graphql.schemamappinginspection.utils;

import br.com.rts.estudos.graphql.schemamappinginspection.event.Event;
import br.com.rts.estudos.graphql.schemamappinginspection.session.Session;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataLoaderUtil {

    public static Event getEvent() {
        Faker faker = new Faker();

        var startDate = LocalDate.ofInstant(
                faker.timeAndDate().future(faker.number().randomNumber(3, true), TimeUnit.DAYS), ZoneId.systemDefault());
        var endDate = startDate.plusDays(faker.number().numberBetween(1, 10));
        var cfpStartDate = LocalDate.ofInstant(
                faker.timeAndDate().past(faker.number().numberBetween(1, 180), TimeUnit.DAYS), ZoneId.systemDefault());
        var cfpEndDate = cfpStartDate.minusDays(faker.number().numberBetween(1, 180));

        return new Event(faker.number().numberBetween(1, 100),
                faker.marvelSnap().event(),
                faker.marvelSnap().toString(),
                startDate,
                endDate,
                cfpStartDate,
                cfpEndDate,
                faker.address().fullAddress(),
                faker.internet().url());
    }

    public static List<Session> getSessions() {
        var sessions = new ArrayList<Session>();

        for (int count = 0; count < 50; count++) {
            sessions.add(getSession());
        }
        return sessions;
    }

    public static Session getSession() {
        Faker faker = new Faker();

        return new Session(faker.number().numberBetween(1, 200),
                faker.esports().event(),
                faker.lorem().paragraph());
    }
}
