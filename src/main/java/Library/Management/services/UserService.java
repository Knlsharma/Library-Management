package Library.Management.services;

import Library.Management.entity.User;
import Library.Management.repository.dao.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository repo;

    //  findALL
    public List<User> gettingAll() {

        return (List<User>) repo.findAll();
    }


      // find by id
    public Optional<User> gettingById(int id) {

        return (Optional<User>) repo.findById(id);
    }

        // Add User
    public ResponseEntity<Object> addingNew(JsonNode formNode) {

        HttpHeaders posthead = new HttpHeaders();

        posthead.add("Lang", "en-Us");
        posthead.getDate();

        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {

            User use = objectMapper.readValue(formJsonData, User.class);
            repo.save(use);
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(formJsonData);

        return new ResponseEntity<>(formJsonData,posthead , HttpStatus.OK);

    }


       // Update User
    public ResponseEntity<Object> updateUser(int id , JsonNode formNode) {


        Optional<User> userdata = repo.findById(id);

        if (userdata == null) {
            return new ResponseEntity<>("Id not found",HttpStatus.NOT_FOUND);
        }
        // formRepository.deleteById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {
            User use = objectMapper.readValue(formJsonData, User.class);
            int UserId=use.getId();
            if(id!=UserId)
                return new ResponseEntity<>("Id mismatch",HttpStatus.BAD_REQUEST);

            repo.save(use);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON DATA = "+ formJsonData);
        return new ResponseEntity<>(formJsonData, HttpStatus.OK);

    }


     //   delete User
    public ResponseEntity<Object> deleteUser(int id) {

            Optional<User> userdata =  repo.findById(id);

            if (userdata == null)
            {
                return new ResponseEntity<>("Record Not exist in db", HttpStatus.OK);
            }

            repo.deleteById(id);
            HttpHeaders delHead = new HttpHeaders();


            delHead.add("Language", "en-US");
            delHead.getDate();

            //	delHead.setLocation();  for sending header
            //	delHead.USER_AGENT;

            return new ResponseEntity<>("Record Deleted", delHead, HttpStatus.OK);


    }
}
