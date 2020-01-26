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
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.*;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;



@RestController
@RequestMapping("/library/task")
public class Library_Controller<bg>
{

    @Autowired
    private UserService seru;

    @Autowired
    private BookService serb;

    @Autowired
    private IssueService seri;

    @Autowired
    private MappingService serm;

    HashMap<String, ArrayList> hashMap = new HashMap<String, ArrayList>();

    private void addValues(String key, String value)
    {
        ArrayList tempList = null;

        if (hashMap.containsKey(key)) {
            tempList = hashMap.get(key);
            if(tempList == null)
                tempList = new ArrayList();
            tempList.add(value);
        } else {
            tempList = new ArrayList();
            tempList.add(value);
        }
        hashMap.put(key,tempList);
    }


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
    public Map<String, ArrayList> checkAuthStats(@PathVariable String str)
    {

        List<Issue>  C =  serb.checkingfor(str);

        System.out.println(C);
        System.out.println(C.size());



        for(int i = 0 ; i < C.size() ; i++)
        {
            addValues("isbn_no", String.valueOf(C.get(i).getMap().getIs_no()));
            addValues("status",  String.valueOf(C.get(i).isStatus()));
        }

         System.out.println(hashMap);

          return hashMap;

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















