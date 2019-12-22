package Library.Management.repository.dao;

import Library.Management.entity.mapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends CrudRepository<mapping,Integer>
{

  //  mapping findByBook(int book);

}
