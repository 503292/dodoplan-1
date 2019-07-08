package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.ChapterDto;
import java.util.List;

public interface ChapterService {

    ChapterDto save(ChapterDto chapterDto);

    void delete(ChapterDto chapterDto);

    ChapterDto findById(Long id);

    List<ChapterDto> findAll();

    List<ChapterDto> findAllByUserId(Long id);
}
