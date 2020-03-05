package fi.rbmk.ticketguru.userGroup;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/usergroups", produces = "application/hal+json")
public class UserGroupController {

    @Autowired
    private UserGroupRepository uGroupRepository;
    @Autowired
    private UserGroupResourceAssembler uGroupAssembler;

    // Get User groups
    @GetMapping
    public CollectionModel<EntityModel<UserGroup>> getAll() {
        List<EntityModel<UserGroup>> userGroups = uGroupRepository.findAll().stream().map(uGroupAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(userGroups, linkTo(methodOn(UserGroupController.class).getAll()).withSelfRel());
    }

    // Get single User group
    @GetMapping("/{id}")
    public EntityModel<UserGroup> getUserGroup(@PathVariable Long id) {
        UserGroup userGroup = uGroupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return uGroupAssembler.toModel(userGroup);
    }

    // Create User group
    @PostMapping
    ResponseEntity<?> setUserGroup(@Valid @RequestBody UserGroup userGroup) throws URISyntaxException {
        EntityModel<UserGroup> entityModel = uGroupAssembler.toModel(uGroupRepository.save(userGroup));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    // Delete User group
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUserGroup(@PathVariable Long id) {
        uGroupRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}