package fi.rbmk.ticketguru.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

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

import fi.rbmk.ticketguru.userGroup.UserGroup;
import fi.rbmk.ticketguru.userGroup.UserGroupResourceAssembler;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/users", produces = "application/hal+json")
public class UserController {

    @Autowired
    private UserRepository uRepository;

    @Autowired
    private UserResourceAssembler uAssembler;

    @Autowired
    private UserGroupResourceAssembler uGroupAssembler;

    @GetMapping
    CollectionModel<EntityModel<User>> getAll() {
        List<EntityModel<User>> users = uRepository.findAll().stream().map(uAssembler::toModel)
                .collect(Collectors.toList());
        return new CollectionModel<>(users, linkTo(methodOn(UserController.class).getAll()).withSelfRel());
    }

    // Get single User
    @GetMapping("/{id}")
    EntityModel<User> getUser(@PathVariable Long id) {
        User user = uRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        return uAssembler.toModel(user);
    }

    // Create User
    @PostMapping
    ResponseEntity<?> setUser(@RequestBody User user) throws URISyntaxException {
        EntityModel<User> entityModel = uAssembler.toModel(uRepository.save(user));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    // Get user groups

    /*
     * @GetMapping("/{id}/usergroup") CollectionModel<EntityModel<UserGroup>>
     * getUserGroups(@PathVariable Long id) { User user =
     * uRepository.findById(id).orElseThrow(() -> new
     * ResourceNotFoundException("Invalid ID: " + id)); List<EntityModel<UserGroup>>
     * userGroups = user.getUserGroup().stream().map(uGroupAssembler::toModel)
     * .collect(Collectors.toList()); return new CollectionModel<>(userGroups,
     * linkTo(methodOn(UserController.class).getUserGroups(id)).withSelfRel()); }
     */

    // Edit User
    @PatchMapping("/{id}")
    ResponseEntity<?> editUser(@RequestBody User newUser, @PathVariable Long id) throws URISyntaxException {
        User updatedUser = uRepository.findById(id).map(User -> {
            if (newUser.getName() != "") {
                User.setName(newUser.getName());
            }
            if (newUser.getUserGroup() != null) {
                User.setUserGroup(newUser.getUserGroup());
            }

            return uRepository.save(User);
        }).orElseGet(() -> {
            return uRepository.save(newUser);
        });
        EntityModel<User> entityModel = uAssembler.toModel(updatedUser);
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }

    // Delete User
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        uRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}