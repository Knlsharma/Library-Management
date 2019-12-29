package Library.Management.services;

import Library.Management.controller.IssueController;
import Library.Management.entity.Books;
import Library.Management.entity.Issue;
import Library.Management.repository.dao.BookRepository;
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
public class BookService {

    @Autowired
    private BookRepository repob;

    @Autowired
    private MappingService ms;

    @Autowired
    private IssueService iser;


    @Autowired
    private IssueController ic;

    public List<Books> getAllBook()
    {

         return (List<Books>) repob.findAll();

    }


    public Optional<Books> gettingByBId(int id)
    {

        return repob.findById(id);
    }

    public ResponseEntity<Object> addingNewBook(JsonNode formNode)
    {
        HttpHeaders posthead = new HttpHeaders();

        posthead.add("Lang", "en-Us");
        posthead.getDate();

        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {

            Books use = objectMapper.readValue(formJsonData, Books.class);
            repob.save(use);
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(formJsonData);

        return new ResponseEntity<>(formJsonData,posthead , HttpStatus.OK);

    }


    public ResponseEntity<Object> updateBook(int id, JsonNode formNode) {

        Optional<Books> userdata = repob.findById(id);

        if (userdata == null) {
            return new ResponseEntity<>("Id not found",HttpStatus.NOT_FOUND);
        }
        // formRepository.deleteById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String formJsonData = formNode.toString();
        try {
            Books use = objectMapper.readValue(formJsonData, Books.class);
            int UserId=use.getId();
            if(id!=UserId)
                return new ResponseEntity<>("Id mismatch",HttpStatus.BAD_REQUEST);

            repob.save(use);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON DATA = "+ formJsonData);
        return new ResponseEntity<>(formJsonData, HttpStatus.OK);

    }


    public ResponseEntity<Object> deletebook(int id) {
        Optional<Books> bookdata = repob.findById(id);

        if (bookdata == null)
        {
            return new ResponseEntity<>("Record Not exist in db", HttpStatus.OK);
        }

        repob.deleteById(id);
        HttpHeaders delHead = new HttpHeaders();


        delHead.add("Language", "en-US");
        delHead.getDate();

        //	delHead.setLocation();  for sending header
        //	delHead.USER_AGENT;

        return new ResponseEntity<>("Record Deleted", delHead, HttpStatus.OK);
    }


    public List<Issue> checkingfor(String str) {

        List<Books> b = repob.findByAname(str);

       int k = b.get(0).getId();



        System.out.println(b);
        System.out.println(k);

     return ic.getAllIssue(k);

         //  return b;

    }

    /** NEEDS EDITING IN BOOK SERVICE **/

    public List<Issue> checkStatus(String str) {

        List<Books> b1 = repob.findByAname(str);
      //  int n = b1.size();

         return b1.get(0).getId();

    }
}
