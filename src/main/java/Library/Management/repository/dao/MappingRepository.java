package Library.Management.repository.dao;

import Library.Management.entity.Books;
import Library.Management.entity.mapping;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MappingRepository extends CrudRepository<mapping,Integer>
{

  //  mapping findByBook(int book);

    List<mapping> findByBook(Books book);

}
