package br.com.rts.estudos.graphql.schemamappinginspection.event;

import br.com.rts.estudos.graphql.schemamappinginspection.utils.DataLoaderUtil;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    private final List<Event> events = new ArrayList<>();

    public EventController() {
        for (int count = 0; count < 20; count++) {
            events.add(DataLoaderUtil.getEvent());
        }
    }

    @QueryMapping
    public List<Event> events(){
        return events;
    }
}
