package com.maksym.dodoplan.config;

import com.maksym.dodoplan.exception.ChapterNotFoundException;
import com.maksym.dodoplan.exception.UserNotFoundException;
import com.maksym.dodoplan.model.Chapter;
import com.maksym.dodoplan.model.Task;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.model.dto.TaskDto;
import com.maksym.dodoplan.model.dto.UserDto;
import com.maksym.dodoplan.repository.ChapterRepository;
import com.maksym.dodoplan.repository.UserRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Type;
import java.util.List;

@Configuration
public class ApplicationConfig {



    @Autowired
    UserRepository userRepository;

    @Autowired
    ChapterRepository chapterRepository;



//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//
//        return modelMapper;
//    }
//
//    @Bean
//    @Qualifier(value = "userModelMapper")
//    public ModelMapper userModelMapper() {

//    }


    @Bean
    public ModelMapper modelMapper() {


        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
//        TypeMap<User, UserDto> typeMap = modelMapper.createTypeMap(User.class, UserDto.class);
//        typeMap.addMappings(m -> {
//            m.skip(UserDto::setPassword);
//        })

//        modelMapper.typeMap(Task.class, TaskDto.class)
//                .addMapping(src -> src.getChapter().getId(), TaskDto::setChapterId/*(destination, value) -> destination.setChapterId((Long) value)*/)
//                .addMapping(src -> src.getUser().getId(), TaskDto::setUserId/*(destination, value) -> destination.setUserId((Long) value)*/);
//        modelMapper.typeMap(TaskDto.class, Task.class)
//                .addMapping(TaskDto::getChapterId, (destination, value) -> destination.setChapter(
//                        new Chapter() {{
//                            setId((Long)value);
//                        }}
//                ))
//                .addMapping(TaskDto::getUserId,(destination, value) -> destination.setUser(
//                        new User(){{
//                            setId((Long) value);
//                        }}
//                ));


        return modelMapper;


//
//        Converter<Long, User> toEntity = context -> context.getSource() == null ? null : userRepository.findById(context.getSource()).orElseThrow(() -> new RuntimeException(""));
//
//
//        modelMapper.typeMap(Task.class, TaskDto.class)
//                .addMapping(src -> src.getChapter().getId(), TaskDto::setChapterId/*(destination, value) -> destination.setChapterId((Long) value)*/)
//                .addMapping(src -> src.getUser().getId(), TaskDto::setUserId/*(destination, value) -> destination.setUserId((Long) value)*/);
//        modelMapper.typeMap(TaskDto.class, Task.class)
//                .addMappings(m -> m.using(toEntity).map(TaskDto::getUserId, Task::setUser))
//                .addMapping(src -> src.getChapterId(),
//                        (destination, value) -> destination.setChapter(
//                                chapterRepository.findById((Long)value)
//                        ))
//                .addMapping(src -> src.getUserId(),
//                        (destination, value) -> destination.setUser(
//                                userRepository.findById((Long) value)
//                        .orElseThrow(() -> new UserNotFoundException(""))));
//        return modelMapper;
    }
}
