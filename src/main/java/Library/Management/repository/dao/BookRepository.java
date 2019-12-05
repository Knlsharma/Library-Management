package Library.Management.repository.dao;

import Library.Management.entity.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Books, Integer>

{

        List<Books> findByAname(String aname);



}
