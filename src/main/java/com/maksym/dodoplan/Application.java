package com.maksym.dodoplan;

import com.maksym.dodoplan.model.Role;
import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.repository.RoleRepository;
import com.maksym.dodoplan.repository.UserRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String email = "admin@admin.admin";
		String password = passwordEncoder.encode("admin");

		Role role = new Role();
		role.setName("ADMIN");
		role.setDescription("Some admin role");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRoles(new HashSet<Role>(){{
			add(role);
		}});

//		roleRepository.save(role);
//		userRepository.save(user);

	}
}
