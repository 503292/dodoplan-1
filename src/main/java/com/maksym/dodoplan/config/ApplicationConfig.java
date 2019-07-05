package com.maksym.dodoplan.config;

import com.maksym.dodoplan.exception.ChapterNotFoundException;
import com.maksym.dodoplan.exception.UserNotFoundException;
import com.maksym.dodoplan.model.Task;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.model.dto.TaskDto;
import com.maksym.dodoplan.repository.ChapterRepository;
import com.maksym.dodoplan.repository.UserRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChapterRepository chapterRepository;

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        return new ModelMapper();
    }

    @Bean
    public ModelMapper TaskModelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//
//        Converter<Long, User> toEntity = context -> context.getSource() == null ? null : userRepository.findById(context.getSource()).orElseThrow(() -> new RuntimeException(""));
//
//
//        modelMapper.typeMap(Task.class, TaskDto.class)
//                .addMapping(src -> src.getChapter().getId(), TaskDto::setChapterId/*(destination, value) -> destination.setChapterId((Long) value)*/)
//                .addMapping(src -> src.getUser().getId(), TaskDto::setUserId/*(destination, value) -> destination.setUserId((Long) value)*/);
//        modelMapper.typeMap(TaskDto.class, Task.class)
//                .addMappings(m -> m.using(toEntity).map(TaskDto::getUserId, Task::setUser));
////                .addMapping(src -> src.getChapterId(),
////                        (destination, value) -> destination.setChapter(
////                                chapterRepository.findById((Long)value)
////                        .orElseThrow(() -> new ChapterNotFoundException(""))))
////                .addMapping(src -> src.getUserId(),
////                        (destination, value) -> destination.setUser(
////                                userRepository.findById((Long) value)
////                        .orElseThrow(() -> new UserNotFoundException(""))));
        return new ModelMapper();
    }
}
