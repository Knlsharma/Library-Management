package Library.Management.controller;

import Library.Management.entity.Issue;
import Library.Management.entity.Books;
import Library.Management.services.BookService;
import Library.Management.services.IssueService;
import Library.Management.services.MappingService;
import Library.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@RestController
@RequestMapping("/library/task")
public class Library_Controller<bg> {

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
    public TreeMap<String, Object> getAllauth(@PathVariable String str) {

        List<Issue> B = serb.checkingfor(str);

       System.out.println(B.get(0).getUser().getId());


        TreeMap<String, Object> tree = new TreeMap<String , Object>();

        for(int i = 0 ; i < B.size() ; i++)
        {
            tree.put("id ", B.get(i).getUser().getId());

        }
        return tree;

    /*
        if (!B.get(0).isStatus())
        {
            return B;
        }
        else
            {
            return Collections.emptyList();
        }

     */
    }



    @RequestMapping(value = "/authorissued/{str}", method = RequestMethod.GET)
    public TreeMap<String, Object> checkAuthStats(@PathVariable String str) {

        List<Issue>  C =  serb.checkingfor(str);

        System.out.println(C);
        System.out.println(C.size());

        TreeMap<String, Object> tree_auth = new TreeMap<String , Object>();

        for(int i = 0 ; i < C.size() ; i++)
        {
            tree_auth.put("isbn_no" , C.get(i).getMap().getIs_no());
            tree_auth.put("status" ,  C.get(i).isStatus());
        }

         System.out.println(tree_auth);

          return  tree_auth;


    }


    // Maths ---->  RD SHARMA ,RS AGGARWAL ,GK TIWARI
    @RequestMapping(value = "/findauthorsbook/{str}", method = RequestMethod.GET)
    public TreeMap<String ,Object> getAllAuthSubject(@PathVariable String str)
    {

        List<Books> bg = serb.findbySubjectdata(str);

        TreeMap<String ,Object>  hash= new TreeMap<String ,Object>();

        System.out.println(bg);
        System.out.println(bg.size());


        hash.put("Author Name",bg.get(0).getAname() );


        System.out.println(hash);

        return hash;


    }

}















