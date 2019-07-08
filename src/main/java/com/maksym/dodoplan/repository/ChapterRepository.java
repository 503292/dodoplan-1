package com.maksym.dodoplan.repository;

import com.maksym.dodoplan.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
    Optional<Chapter> findById(Long id);

    List<Chapter> findAllByUserId(Long id);
}
