package Library.Management.repository.dao;

import Library.Management.entity.Issue;
import Library.Management.entity.mapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends CrudRepository<Issue , Integer>

{
List<Issue> findById(int id);
List<Issue> findAll();

List<Issue> findByMap(mapping map);


}
