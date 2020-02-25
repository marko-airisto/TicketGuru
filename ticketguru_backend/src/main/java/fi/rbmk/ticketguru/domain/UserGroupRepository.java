package fi.rbmk.ticketguru.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {

	// User findByUsername(String name);

	List<UserGroup> findByName(String name);

	Optional<UserGroup> findById(@Param("id") Long id);
}
