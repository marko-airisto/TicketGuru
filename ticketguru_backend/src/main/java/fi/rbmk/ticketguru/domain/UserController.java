package fi.rbmk.ticketguru.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository urepository;
    @Autowired
    private UserGroupRepository ugrepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/userGroup")
    // @RequestMapping(value = "/sexes", method = RequestMethod.GET)
    public List<UserGroup> userGroupListRest() {
        return (List<UserGroup>) ugrepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/users")
    // @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> userListRest() {
        return (List<User>) urepository.findAll();
    }
}