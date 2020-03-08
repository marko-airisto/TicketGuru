package fi.rbmk.ticketguru.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import javax.validation.Valid;

import fi.rbmk.ticketguru.userGroup.UserGroup;
import fi.rbmk.ticketguru.userGroup.UserGroupController;
import fi.rbmk.ticketguru.userGroup.UserGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.ExposesResourceFor;
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
@ExposesResourceFor(User.class)
@RequestMapping(value = "/api/users", produces = "application/hal+json")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserGroupRepository UserGroupRepository;

    @PostMapping(produces = "application/hal+json")
    ResponseEntity<?> addUser(@Valid @RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Duplicate entry");
        }
        return ResponseEntity.ok(user);
    }

    // PATCH NOT TESTED YET

    @PatchMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<User> saveUser(@Valid @RequestBody User newUser, @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID:" + id));
        if (newUser.getPassword().compareTo("noupdate") != 0) {
            user.setPassword(newUser.getPassword());
        }
        if (newUser.getUserGroup() != null) {
            user.setUserGroup(newUser.getUserGroup());
        }

        user.setActive(newUser.getActive());
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<?> deleteDevice(@PathVariable Long id) {
        return userRepository.findById(id).map(m -> {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Invalid ID:" + id));
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    EntityModel<User> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        Link selfLink = linkTo(UserController.class).slash(id).withSelfRel();
        Link UserGroupLink = linkTo(methodOn(UserController.class).getUserUserGroup(id)).withRel("usergroup");
        user.add(selfLink);
        user.add(UserGroupLink);
        EntityModel<User> result = new EntityModel<User>(user);
        return result;
    }

    @GetMapping(produces = "application/hal+json")
    CollectionModel<User> getUsers() {
        List<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            Long userId = user.getId();
            Link selfLink = linkTo(UserController.class).slash(userId).withSelfRel();
            Link UserGroupLink = linkTo(methodOn(UserController.class).getUserUserGroup(userId)).withRel("usergroup");
            user.add(selfLink);
            user.add(UserGroupLink);
        }
        Link link = linkTo(UserController.class).withSelfRel();
        CollectionModel<User> result = new CollectionModel<User>(allUsers, link);
        return result;
    }

    @GetMapping(value = "/{id}/usergroup", produces = "application/hal+json")
    EntityModel<UserGroup> getUserUserGroup(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        UserGroup userGroup = user.getUserGroup();
        Link selfLink = linkTo(methodOn(UserGroupController.class).getUserGroup(userGroup.getId())).withSelfRel();
        userGroup.add(selfLink);
        EntityModel<UserGroup> result = new EntityModel<UserGroup>(userGroup);
        return result;
    }
}