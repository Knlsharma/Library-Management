package Library.Management.controller;

import Library.Management.entity.Issue;
import Library.Management.services.IssueService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/library")
public class IssueController {

    @Autowired
    private IssueService seri;

    public IssueController(IssueService seri) {
        this.seri = seri;
    }

    /*    ------------------- ISSUE*/

    //        Find all Issues

    @RequestMapping(value = "/findissues", method = RequestMethod.GET)
    public List<Issue> getAllIssue()
    {
        return seri.gettingAll();
    }

    //        Finding by Iid

    @RequestMapping(value = "/findbyissues/{id}", method = RequestMethod.GET)
    public List<Issue> getOneIssue(@PathVariable int id)
    {
        return seri.gettingById(id);
    }

    //         Adding new Issue

    @PostMapping(value = "/addissue" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addNewIssue(@RequestBody JsonNode formNode )
    {
        return seri.addingNewIssue(formNode);
    }

    //         update Issue

    @PutMapping("/updateissue/{id}")
    public ResponseEntity<Object> updateIssue(@PathVariable int id, @Valid @RequestBody JsonNode formNode) {

        return seri.updateIssues(id , formNode);

    }

    //        Delete Issue by bid

    @DeleteMapping(value="/deleteIssue/{id}")
    public ResponseEntity<Object> deleteIssue(@PathVariable int id)
    {

        return seri.deleteAIssue(id);
    }

  // @RequestMapping(value = "/getisbn/{id}", method = RequestMethod.GET)
    public List<Issue> getAllIssue( int id)
    {

        return seri.getOnlyIsbn(id);
    }

}
