package com.maksym.dodoplan.repository;

import com.maksym.dodoplan.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Long> {

}
