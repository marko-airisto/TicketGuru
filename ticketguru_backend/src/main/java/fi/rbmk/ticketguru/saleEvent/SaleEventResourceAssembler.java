package fi.rbmk.ticketguru.saleEvent;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Optional;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;
import fi.rbmk.ticketguru.saleEvent.SaleEvent;
import fi.rbmk.ticketguru.saleEvent.SaleEventController;

@Component
public class SaleEventResourceAssembler {
    @Override
	public EntityModel<SaleEvent> toModel(SaleEvent saleEvent) {
        return new EntityModel<>(saleEvent,
        		linkTo(methodOn(SaleEventController.class).getSaleEvent(saleEvent.getId())).withSelfRel(),
                linkTo(methodOn(SaleEventController.class).findAll()).withRel("saleEvents"));
    }
}
