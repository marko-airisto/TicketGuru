package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserRepository urepository;
    @Autowired
    private UserGroupRepository ugrepository;

    @GetMapping("api/userGroups")
    // @RequestMapping(value = "api/rest/v1/userGroups", method = RequestMethod.GET)
    public List<UserGroup> userGroupListRest() {
        return (List<UserGroup>) ugrepository.findAll();
    }

    @GetMapping("api/users")
    // @RequestMapping(value = "api/rest/v1/users", method = RequestMethod.GET)
    public List<User> userListRest() {
        return (List<User>) urepository.findAll();
    }
}