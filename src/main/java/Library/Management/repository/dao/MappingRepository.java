package Library.Management.repository.dao;

import Library.Management.entity.mapping;
import org.springframework.data.repository.CrudRepository;

public interface MappingRepository extends CrudRepository<mapping,Integer>
{

  //  mapping findByBook(int book);

}
