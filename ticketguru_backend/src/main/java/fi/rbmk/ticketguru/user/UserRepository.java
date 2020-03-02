package fi.rbmk.ticketguru.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fi.rbmk.ticketguru.userGroup.UserGroup;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByName(String name);

	List<User> findByUserGroup(UserGroup userGroup);

	List<User> findAll();
}
