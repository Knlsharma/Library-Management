package Library.Management.services;

import Library.Management.entity.Issue;
import Library.Management.entity.mapping;
import Library.Management.repository.dao.IssueRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class IssueService


{
    @Autowired
    private IssueRepository repoi;


    public List<Issue> gettingAll()
    {
        List<Issue> hello =  repoi.findAll();
        return hello;
    }

    public List<Issue> gettingById(int id)
    {
        return repoi.findById(id);
    }

    public ResponseEntity<Object> addingNewIssue(JsonNode formNode) {

        HttpHeaders posthead = new HttpHeaders();

        posthead.add("Lang", "en-Us");
        posthead.getDate();

        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {

            Issue use = objectMapper.readValue(formJsonData, Issue.class);
            repoi.save(use);
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(formJsonData);

        return new ResponseEntity<>(formJsonData,posthead , HttpStatus.OK);

    }

    public ResponseEntity<Object> updateIssues(int id, JsonNode formNode) {

        List<Issue> userdata = repoi.findById(id);

        if (userdata == null) {
            return new ResponseEntity<>("PLease Write Id after Url",HttpStatus.NOT_FOUND);
        }
        // formRepository.deleteById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {

            Issue use = objectMapper.readValue(formJsonData, Issue.class);
            mapping isbnId=use.getMap();

            /*
            if(id != isbnId)
                return new ResponseEntity<>("Id mismatch",HttpStatus.BAD_REQUEST);


             */

            repoi.save(use);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("JSON DATA = "+ formJsonData);
        return new ResponseEntity<>(formJsonData, HttpStatus.OK);

    }

    public ResponseEntity<Object> deleteAIssue(int id) {

        List<Issue> bookdata = repoi.findById(id);

        if (bookdata == null)
        {
            return new ResponseEntity<>("Record Not exist in db", HttpStatus.OK);
        }

        repoi.deleteById(id);
        HttpHeaders delHead = new HttpHeaders();


        delHead.add("Language", "en-US");
        delHead.getDate();

        //	delHead.setLocation();  for sending header
        //	delHead.USER_AGENT;

        return new ResponseEntity<>("Record Deleted", delHead, HttpStatus.OK);
    }

    public List<Issue> findBybid(int k) {

        mapping m = new mapping();
        m.setIs_no(k);

        return repoi.findByMap(m);

    }

    public List<Issue> getOnlyIsbn(int id) {

        mapping m = new mapping();
          m.setIs_no(id);


        return repoi.findByMap(m);

    }
}
