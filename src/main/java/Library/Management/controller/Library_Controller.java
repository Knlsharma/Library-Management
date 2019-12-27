package Library.Management.controller;

import Library.Management.entity.Issue;
import Library.Management.services.BookService;
import Library.Management.services.IssueService;
import Library.Management.services.MappingService;
import Library.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/library/task")
public class Library_Controller {

    @Autowired
    private UserService seru;

    @Autowired
    private BookService serb;

    @Autowired
    private IssueService seri;

    @Autowired
    private MappingService serm;

    public Library_Controller(UserService seru, BookService serb, IssueService seri, MappingService serm) {
        this.seru = seru;
        this.serb = serb;
        this.seri = seri;
        this.serm = serm;
    }


    /***************** liberarian API  Handler ********* */

    //  Using Author Name ----> Which Users have
    @RequestMapping(value = "/findauthor/{str}", method = RequestMethod.GET)
    public List<Issue> getAllauth(@PathVariable String str) {

        List<Issue> B = serb.checkingfor(str);


        if (!B.get(0).isStatus())
        {
            return B;
        }
        else
            {
            return Collections.emptyList();
        }

    }

    @RequestMapping(value = "/authorissued/{str}", method = RequestMethod.GET)
    public List<Issue> checkAuthStats(@PathVariable String str) {

        List<Issue>  C =  serb.checkStatus(str);

        return C;
    }

}















