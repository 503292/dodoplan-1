package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.ChapterDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChapterService {

    ChapterDto save(ChapterDto chapterDto);

    void delete(ChapterDto chapterDto);

    ChapterDto findById(Long id);

    List<ChapterDto> findAll();

}
