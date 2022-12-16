package com.shigal.springsecuritydemoapp;

import com.shigal.springsecuritydemoapp.model.Authority;
import com.shigal.springsecuritydemoapp.model.User;
import com.shigal.springsecuritydemoapp.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityDemoAppApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
	}

	@PostConstruct
	protected void init(){
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(createAuthority("USER", "user role"));
		authorityList.add(createAuthority("ADMIN", "admin role"));

		User user = new User();
		user.setUsername("fifa");
		user.setPassword(passwordEncoder.encode("qatar"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);

		userDetailsRepository.save(user);
	}

	private Authority createAuthority(String roleCode, String roleDescription){
		Authority authority = new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
