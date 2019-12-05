package Library.Management.repository.dao;

import Library.Management.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends CrudRepository<User, Integer>
    {

     //   List<User> findById(int id);

     //   List<User> findByIdAndName(int id);




    }

