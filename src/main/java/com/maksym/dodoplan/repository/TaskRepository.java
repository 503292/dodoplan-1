package com.maksym.dodoplan.repository;

import com.maksym.dodoplan.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
