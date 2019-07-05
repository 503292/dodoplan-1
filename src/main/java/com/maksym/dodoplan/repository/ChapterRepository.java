package com.maksym.dodoplan.repository;

import com.maksym.dodoplan.model.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Long> {

}
