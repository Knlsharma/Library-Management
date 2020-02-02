package Library.Management.services;

import Library.Management.entity.mapping;
import Library.Management.repository.dao.MappingRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MappingService

{
    @Autowired
    private MappingRepository repom;
   // private Object mapping;

    public MappingService(MappingRepository repom) {
        this.repom = repom;
    }

    public Optional<mapping> gettingById(int id) {


        return repom.findById(id);
    }

    public List<mapping> gettingAll() {

       return (List<mapping>) repom.findAll();
    }

    public ResponseEntity<Object> addingNewMapping(JsonNode formNode) {

        HttpHeaders posthead = new HttpHeaders();

        posthead.add("Lang", "en-Us");
        posthead.getDate();

        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {

            mapping use = objectMapper.readValue(formJsonData, mapping.class);
            repom.save(use);
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(formJsonData);

        return new ResponseEntity<>(formJsonData,posthead , HttpStatus.OK);
    }

    /*   For Update Mapping
    public ResponseEntity<Object> updateMapping(int id, JsonNode formNode) {
    }

     */

    public ResponseEntity<Object> deleteAMapping(int id) {

        Optional<mapping> bookdata = repom.findById(id);

        if (bookdata == null)
        {
            return new ResponseEntity<>("Record Not exist in db", HttpStatus.OK);
        }

        repom.deleteById(id);
        HttpHeaders delHead = new HttpHeaders();


        delHead.add("Language", "en-US");
        delHead.getDate();

        //	delHead.setLocation();  for sending header
        //	delHead.USER_AGENT;

        return new ResponseEntity<>("Record Deleted", delHead, HttpStatus.OK);
    }


    /** for bid map **/
    public void findByBid(int k) {

        Set<mapping> s1 = new HashSet<mapping>();


    }


/*
    public List<mapping> gettingAllBook(int id)
    {
        repom.findByBook(id);

    }

 */
}
