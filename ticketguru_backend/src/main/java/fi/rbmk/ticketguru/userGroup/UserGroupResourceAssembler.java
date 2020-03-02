package fi.rbmk.ticketguru.userGroup;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class UserGroupResourceAssembler implements RepresentationModelAssembler<UserGroup, EntityModel<UserGroup>> {
    @Override
    public EntityModel<UserGroup> toModel(UserGroup userGroup) {
        return new EntityModel<>(userGroup,
                linkTo(methodOn(UserGroupController.class).one(userGroup.getId())).withSelfRel(),
                linkTo(methodOn(UserGroupController.class).findAll()).withRel("userGroups"));
    }
}