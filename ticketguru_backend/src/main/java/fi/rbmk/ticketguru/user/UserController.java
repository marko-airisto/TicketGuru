package fi.rbmk.ticketguru.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
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
import fi.rbmk.ticketguru.userGroup.UserGroupRepository;
import fi.rbmk.ticketguru.userGroup.UserGroupController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/users", produces = "application/hal+json")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserGroupRepository userGroupRepository;

    @PostMapping(produces = "application/hal+json")
    ResponseEntity<?> add(@Valid @RequestBody User user) {
        try {
            Long id = userRepository.save(user).getUser_ID();
            Link selfLink = linkTo(UserController.class).slash(id).withSelfRel();
            Link userGroupLink = linkTo(methodOn(UserController.class).getUserGroup(id)).withRel("userGroup");
            user.add(selfLink);
            user.add(userGroupLink);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Duplicate entry");
        }
        Resource<User> resource = new Resource<User>(user);
        return ResponseEntity.ok(resource);
    }

    @PatchMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<User> edit(@Valid @RequestBody User newUser, @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        if (newUser.getPassword() != "") {
            user.setPassword(newUser.getPassword());
        }
        if (newUser.getName() != "") {
            user.setName(newUser.getName());
        }
        if (newUser.getUserGroup() != null) {
            user.setUserGroup(newUser.getUserGroup());
        }
        if (newUser.getActive() != user.getActive()) {
            user.setActive(newUser.getActive());
        }
        userRepository.save(user);
        return ResponseEntity.created(URI.create("/api/users/" + user.getUser_ID())).build();
    }

    @DeleteMapping(value = "/{id}", produces = "application/hal+json")
    ResponseEntity<?> delete(@PathVariable Long id) {
        return userRepository.findById(id).map(m -> {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
    }

    @GetMapping(produces = "application/hal+json")
    ResponseEntity<Resources<User>> all() {
        List<User> users = userRepository.findAll();
        Link link = linkTo(UserController.class).withSelfRel();
        if (users.size() != 0) {
            for (User user : users) {
                Long id = user.getUser_ID();
                Link selfLink = linkTo(UserController.class).slash(id).withSelfRel();
                Link userGroupLink = linkTo(methodOn(UserController.class).getUserGroup(id)).withRel("userGroup");
                user.add(selfLink);
                user.add(userGroupLink);
            }
            Resources<User> resources = new Resources<User>(users, link);
            return ResponseEntity.ok(resources);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public ResponseEntity<Resource<User>> one(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        Link selfLink = linkTo(UserController.class).slash(id).withSelfRel();
        Link userGroupLink = linkTo(methodOn(UserController.class).getUserGroup(id)).withRel("userGroup");
        user.add(selfLink);
        user.add(userGroupLink);
        Resource<User> resource = new Resource<User>(user);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/{id}/userGroup", produces = "application/hal+json")
    ResponseEntity<Resource<UserGroup>> getUserGroup(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid ID: " + id));
        UserGroup userGroup = user.getUserGroup();
        Link selfLink = linkTo(methodOn(UserGroupController.class).one(userGroup.getUserGroup_ID())).withSelfRel();
        Link usersLink = linkTo(methodOn(UserGroupController.class).getUsers(id)).withRel("users");
        userGroup.add(selfLink);
        userGroup.add(usersLink);
        Resource<UserGroup> resource = new Resource<UserGroup>(userGroup);
        return ResponseEntity.ok(resource);
    }
}