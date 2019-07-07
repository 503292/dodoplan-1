package com.maksym.dodoplan.repository;

import com.maksym.dodoplan.model.Reminder;
import com.maksym.dodoplan.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByChapter_Id(Long id);

    Optional<Task> findByRemindersContains(Reminder remider);


}
