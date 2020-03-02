package fi.rbmk.ticketguru.userGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/usergroups", produces = "application/hal+json")
public class UserGroupController {

    @Autowired
    private UserGroupRepository uGroupRepository;
    @Autowired
    private UserGroupResourceAssembler uGroupAssembler;

    @GetMapping()
    public ResponseEntity<CollectionModel<EntityModel<UserGroup>>> findAll() {
        return ResponseEntity.ok(uGroupAssembler.toCollectionModel(uGroupRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserGroup>> one(@PathVariable Long id) {
        return uGroupRepository.findById(id).map(uGroupAssembler::toModel).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}