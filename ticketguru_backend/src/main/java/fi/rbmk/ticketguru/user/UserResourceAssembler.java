package fi.rbmk.ticketguru.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import fi.rbmk.ticketguru.userGroup.UserGroupController;

@Component
class UserResourceAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {

        return new EntityModel<>(user, linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).getAll()).withRel("users"),
                linkTo(methodOn(UserGroupController.class).getUserGroup(user.getId())).withRel("userGroup"));
    }
}