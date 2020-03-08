package fi.rbmk.ticketguru.saleRow;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class SaleRowResourceAssembler implements RepresentationModelAssembler<SaleRow, EntityModel<SaleRow>> {
    @Override
    public EntityModel<SaleRow> toModel(SaleRow salerow) {
        return new EntityModel<>(salerow,
                linkTo(methodOn(SaleRowController.class).getSaleRow(salerow.getId())).withSelfRel(),
                linkTo(methodOn(SaleRowController.class).findAll()).withRel("salerows"));
    }
}
