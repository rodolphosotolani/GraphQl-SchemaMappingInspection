package br.com.rts.estudos.graphql.schemamappinginspection.event;

import br.com.rts.estudos.graphql.schemamappinginspection.session.Session;
import br.com.rts.estudos.graphql.schemamappinginspection.utils.DataLoaderUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class EventController {

    private final List<Event> events = new ArrayList<>();

    public EventController() {
        for (int count = 0; count < 20; count++) {
            events.add(DataLoaderUtil.getEvent());
        }
    }

    @QueryMapping
    public List<Event> events() {
        return events;
    }

    @SchemaMapping
    public List<Session> sessions(Event event) {
        log.info("Generating Sessions from {} ", event.toString());
        return DataLoaderUtil.getSessions();
    }
}
