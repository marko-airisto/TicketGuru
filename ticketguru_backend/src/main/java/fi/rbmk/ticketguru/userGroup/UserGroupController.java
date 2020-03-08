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
import org.springframework.hateoas.Link;

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
    UserGroupRepository repository;

    @GetMapping(produces = "application/hal+json")
    public CollectionModel<UserGroup> getAllUserGroups() {
        List<UserGroup> allUserGroups = repository.findAll();

        for (UserGroup userGroup : allUserGroups) {
            Long userGroupId = userGroup.getId();
            Link selfLink = linkTo(UserGroupController.class).slash(userGroupId).withSelfRel();
            userGroup.add(selfLink);
        }
        Link link = linkTo(UserGroupController.class).withSelfRel();
        CollectionModel<UserGroup> result = new CollectionModel<UserGroup>(allUserGroups, link);
        return result;
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public EntityModel<UserGroup> getUserGroup(@PathVariable Long id) {
        UserGroup userGroup = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid ID:" + id));
        Link selfLink = linkTo(UserGroupController.class).slash(id).withSelfRel();
        userGroup.add(selfLink);
        Link link = linkTo(UserGroupController.class).withSelfRel();
        EntityModel<UserGroup> result = new EntityModel<UserGroup>(userGroup, link);
        return result;
    }

}