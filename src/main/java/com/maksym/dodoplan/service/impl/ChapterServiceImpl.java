package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.ChapterNotFoundException;
import com.maksym.dodoplan.model.Chapter;
import com.maksym.dodoplan.model.dto.ChapterDto;
import com.maksym.dodoplan.repository.ChapterRepository;
import com.maksym.dodoplan.service.ChapterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service(value = "chapterService")
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterRepository chapterRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ChapterDto save(ChapterDto chapterDto) {

        return Optional.of(chapterDto)
                .map(e -> modelMapper.map(e, Chapter.class))
                .map(e -> chapterRepository.save(e))
                .map(e -> modelMapper.map(e, ChapterDto.class))
                .orElseThrow(() -> new ChapterNotFoundException("ChapterDto is null Object. Nothing to save"));
    }

    @Override
    public void delete(ChapterDto chapterDto) {

        Chapter chapter = Optional.of(chapterDto)
                .map(e -> modelMapper.map(e, Chapter.class))
                .orElseThrow(() -> new ChapterNotFoundException("ChapterDto is null Object. Nothing to save"));

        chapterRepository.delete(chapter);
    }

    @Override
    public ChapterDto findById(Long id) {

        return chapterRepository.findById(id)
                .map(e -> modelMapper.map(e, ChapterDto.class))
                .orElseThrow(() -> new ChapterNotFoundException("Chapter with id " + id + "not found"));
    }

    @Override
    public List<ChapterDto> findAll() {

        return chapterRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, ChapterDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChapterDto> findAllByUserId(Long id) {

        return chapterRepository.findAllByUserId(id).stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, ChapterDto.class))
                .collect(Collectors.toList());
    }
}
