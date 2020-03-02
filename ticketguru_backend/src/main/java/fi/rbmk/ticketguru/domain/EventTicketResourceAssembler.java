package fi.rbmk.ticketguru.domain;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;


@Component
public class EventTicketResourceAssembler implements RepresentationModelAssembler<EventTicket, EntityModel<EventTicket>> {
    @Override
    public EntityModel<EventTicket> toModel(EventTicket eventTicket) {
        return new EntityModel<>(eventTicket,
            linkTo(methodOn(EventTicketController.class).one(eventTicket.getId())).withSelfRel(),
            linkTo(methodOn(EventTicketController.class).findAll()).withRel("eventTickets"));
    }
}