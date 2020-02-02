package Library.Management.controller;

import Library.Management.entity.Issue;
import Library.Management.entity.Books;
import Library.Management.entity.mapping;
import Library.Management.services.BookService;
import Library.Management.services.IssueService;
import Library.Management.services.MappingService;
import Library.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.*;


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
    public TreeMap<String, Set<Integer> > getAllauth(@PathVariable String str) {

        List<Issue> B = seri.gettingAll();

        System.out.println(B.get(0).getUser().getId());

         Set<Integer> hs = new HashSet<>();

        TreeMap<String, Set<Integer>> tree = new TreeMap<String, Set<Integer>>();

        for (int i = 0; i < B.size(); i++)
        {
            if(B.get(i).getMap().getBook().getAname().equals(str))
            {
                hs.add(B.get(i).getUser().getId());
            }

        }
        tree.put("id ", hs);
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


       //   which author_name are ----> Issued / Not issued
    @RequestMapping(value = "/authorissued/{str}", method = RequestMethod.GET)
    public Map<Integer,  List<Integer>> checkAuthStats(@PathVariable String str)
    {

        TreeMap<Integer, List<Integer>> hash12 = new TreeMap<Integer, List<Integer>>();

        List<Integer> al = new ArrayList<Integer>();

        List<Issue> C = seri.gettingAll();

        for(int i = 0 ; i < C.size() ; i++ )
        {
            /*
            if(C.get(i).getMap().getBook().getAname().equals(str))
            {
               al.add(C.get(i).getMap().getIs_no());
                      C.get(i).isStatus();
            }
            NEEEDS  IMPROVEMENT
             */
        }


          return hash12;

    }


    // Maths ---->  RD SHARMA ,RS AGGARWAL ,GK TIWARI
    @RequestMapping(value = "/findauthorsbook/{str}", method = RequestMethod.GET)
    public TreeMap<String, List<String>> getAllAuthSubject(@PathVariable String str) {
        List<String> al = new ArrayList<String>();

        List<Books> bg = serb.findbySubjectdata(str);

        TreeMap<String, List<String>> hash = new TreeMap<String, List<String>>();
        System.out.println(bg);

        System.out.println(bg.size());


        for (int i = 0; i < bg.size(); i++) {
            al.add(bg.get(i).getAname());
        }
        hash.put("Author Name", al);


        System.out.println(hash);

        return hash;


    }

    //  U1 ---> Names of books issued
    @RequestMapping(value = "/userissue/{id}", method = RequestMethod.GET)
    public TreeMap<String, List<String>> getAllauth(@PathVariable int id) {

        List<Issue> B4 = seri.getOnlyUser(id);


        TreeMap<String, List<String>> hash = new TreeMap<String, List<String>>();

        System.out.println(B4.size());

         List<String> al = new ArrayList<>();


        for (int i = 0; i < B4.size(); i++) {
            if(B4.get(i).isStatus() == true && B4.get(i).getRe_date() == null)
            {
                System.out.println(B4.size());

                al.add(B4.get(i).getMap().getBook().getBname());

            }
        }
        hash.put("Book Name", al);


        return hash;
          }


      // Time ----> Users 1,3,2,2
    @RequestMapping(value = "/findusebook/{str}", method = RequestMethod.GET)
    public TreeMap<String, List<Integer>> getByBook(@PathVariable String str)
    {
        List<Issue> match = seri.gettingAll();


        TreeMap<String, List<Integer>> hash = new TreeMap<String, List<Integer>>();

        List<Integer> al = new ArrayList<>();

        for(int i = 0 ; i < match.size() ; i++ )
        {
            if( match.get(i).getMap().getBook().getBname().equals(str) && match.get(i).isStatus() == true )
            {
                al.add(match.get(i).getUser().getId());

            }

        }
        System.out.println(al.size());
        hash.put("Issued by", al);

        return hash;

    }
}















