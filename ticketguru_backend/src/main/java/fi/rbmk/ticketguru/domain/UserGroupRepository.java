package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {

	// User findByUsername(String name);

	List<UserGroup> findByName(String name);
}
