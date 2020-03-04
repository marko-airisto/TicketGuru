package fi.rbmk.ticketguru.saleRow;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URISyntaxException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/salerows", produces = "application/hal+json")
public class SaleRowController {

    @Autowired
    private SaleRowRepository salerowRepository;
    @Autowired
    private SaleRowResourceAssembler salerowAssembler;

    // Get all salerows
    @GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<SaleRow>>> findAll() {
        return ResponseEntity.ok(salerowAssembler.toCollectionModel(salerowRepository.findAll()));
    }

    // Get single salerow
    @GetMapping("/{id}")
    EntityModel<SaleRow> getSaleRow(@PathVariable Long id) {
        SaleRow saleRow = salerowRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return salerowAssembler.toModel(saleRow);
    }

    // Create salerow
    @PostMapping
    ResponseEntity<?> setSaleRow(@Valid @RequestBody SaleRow saleRow) throws URISyntaxException {
        EntityModel<SaleRow> entityModel = salerowAssembler.toModel(salerowRepository.save(saleRow));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    // Delete salerow
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteSaleRow(@PathVariable Long id) {
        salerowRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        salerowRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
