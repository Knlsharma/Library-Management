package Library.Management.controller;

import Library.Management.entity.mapping;
import Library.Management.services.MappingService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class MappingController {

    @Autowired
    private MappingService serm;

    /* ----------------  Mapping  */


    //        Find all Mappings

    @RequestMapping(value = "/findmap", method = RequestMethod.GET)
    public List<mapping> getAllMapping()
    {
        return serm.gettingAll();
    }

    //        Finding by all isbn


    @RequestMapping(value = "/findbymap/{id}", method = RequestMethod.GET)
    public Optional<mapping> getOneMap(@PathVariable int id)
    {

        return  serm.gettingById(id);
    }

    //         Adding new Issue

    @PostMapping(value = "/addmap" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addNewMap(@RequestBody JsonNode formNode )
    {
        return serm.addingNewMapping(formNode);
    }

    //         update Issue

    /*
    @PutMapping("/updatemap/{id}")
    public ResponseEntity<Object> updateMap(@PathVariable int id, @Valid @RequestBody JsonNode formNode) {

        return serm.updateMapping(id , formNode);

    }

     */

    //        Delete Issue by bid

    @DeleteMapping(value="/deleteMap/{id}")
    public ResponseEntity<Object> deleteMap(@PathVariable int id)
    {
        return serm.deleteAMapping(id);
    }
}
