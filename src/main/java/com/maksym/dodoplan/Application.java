package com.maksym.dodoplan;

import com.maksym.dodoplan.model.Chapter;
import com.maksym.dodoplan.model.Role;
import com.maksym.dodoplan.model.Task;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.model.dto.TaskDto;
import com.maksym.dodoplan.repository.ChapterRepository;
import com.maksym.dodoplan.repository.RoleRepository;
import com.maksym.dodoplan.repository.TaskRepository;
import com.maksym.dodoplan.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

@EnableSwagger2
@SpringBootApplication
public class Application implements ApplicationRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	TaskRepository taskRepository;
//
//	@Autowired
//	ChapterRepository chapterRepository;



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		String email = "admin@admin.admin";
//		String password = passwordEncoder.encode("maxymKa-");
//
//		Role role = new Role();
//		role.setName("ADMIN");
//		role.setDescription("Some admin role");
//
//		User user = new User();
//		user.setEmail(email);
//		user.setPassword(password);
//		user.setFirstname("firstname");
//		user.setSecondname("secondname");
//		user.setRoles(new HashSet<Role>(){{
//			add(role);
//		}});

//		roleRepository.save(role);
//		userRepository.save(user);


		Task task = new Task();
		Chapter chapter = new Chapter();

		task.setTitle("taskTitle");
		task.setBody("TaskBody");

		chapter.setTitle("ChapterTitle");
		task.setChapter(chapter);

		System.out.println(task);
		TaskDto taskDto = modelMapper.map(task, TaskDto.class);
		System.out.println(taskDto);
		task = modelMapper.map(taskDto, Task.class);
		System.out.println(task);

	}
}
