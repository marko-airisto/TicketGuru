package fi.rbmk.ticketguru.saleEvent;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

import java.util.Arrays;
import java.util.List;

public class SaleEventLinks {

    private Link selfLink, userLink, saleEventsLink;
    private List<Link> linkList;

    public SaleEventLinks(SaleEvent saleEvent) {
        Long id = saleEvent.getSaleEvent_ID();
        this.selfLink = linkTo(SaleEventController.class).slash(id).withSelfRel();
        this.userLink = linkTo(methodOn(SaleEventController.class).getUser(id)).withRel("user");
        this.saleEventsLink = linkTo(methodOn(SaleEventController.class).getSaleEvents(id)).withRel("dateTime");
        this.linkList = Arrays.asList(
                selfLink,
                userLink,
                saleEventsLink
        );
    }

    // Getters
    public Link getSelfLink() {
        return selfLink;
    }

    public Link getUserLink() {
        return userLink;
    }

    public Link getSaleEventsLink() {
        return saleEventsLink;
    }

    public List<Link> getAll() {
        return linkList;
    }
}