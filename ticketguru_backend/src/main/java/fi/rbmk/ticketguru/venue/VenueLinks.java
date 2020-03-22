package fi.rbmk.ticketguru.venue;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;

import java.util.Arrays;
import java.util.List;

public class VenueLinks {

    private Link selfLink, postcodeLink, venueEventsLink;
    private List<Link> linkList;

    public VenueLinks(Venue venue) {
        Long id = venue.getVenue_ID();
        this.selfLink = linkTo(VenueController.class).slash(id).withSelfRel();
        this.postcodeLink = linkTo(methodOn(VenueController.class).getPostcode(id)).withRel("postcode");
        this.venueEventsLink = linkTo(methodOn(VenueController.class).getVenueEvents(id)).withRel("venueEvents");
        this.linkList = Arrays.asList(
                selfLink,
                postcodeLink,
                venueEventsLink
        );
    }

    // Getters
    public Link getSelfLink() {
        return selfLink;
    }

    public Link getPostcode() {
        return postcodeLink;
    }
    
    public Link getVenueEvents() {
        return venueEventsLink;
    }
    
    public List<Link> getAll() {
        return linkList;
    }
}