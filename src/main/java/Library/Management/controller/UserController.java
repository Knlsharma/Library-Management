package Library.Management.controller;

import Library.Management.entity.User;
import Library.Management.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class UserController {

    @Autowired
    private UserService seru;

    public UserController(UserService seru) {
        this.seru = seru;
    }

    //      Finding all User


    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public List<User> getAllUser()
    {
        return seru.gettingAll();
    }

    //        Finding by Bid

    @RequestMapping(value = "/findby/{id}", method = RequestMethod.GET)
    public Optional<User> getOneUser(@PathVariable int id)
    {
        return seru.gettingById(id);
    }

    //         Adding new User

    @PostMapping(value = "/adduser" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addData(@RequestBody JsonNode formNode )
    {
        return seru.addingNew(formNode);
    }

    // Changing User Details

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<Object> updateForm(@PathVariable int id, @Valid @RequestBody JsonNode formNode) {

        return seru.updateUser(id , formNode);

    }

    //        Delete User by Id

    @DeleteMapping(value="/deleteuser/{id}")
    public ResponseEntity<Object> deleteData(@PathVariable int id)
    {
        return seru.deleteUser(id);
    }


}
