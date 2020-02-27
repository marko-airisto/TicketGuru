package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventTypeController {

	@Autowired
    private EventTypeRepository etrepository;

    @GetMapping("api/eventTypes")

    public List<EventType> evenTypesListRest() {
        return (List<EventType>) etrepository.findAll();
    }
	
}
