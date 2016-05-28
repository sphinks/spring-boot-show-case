package com.not4j;

import com.not4j.dao.UserDao;
import com.not4j.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DbTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTripApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserDao userDao) {
        userDao.deleteAllInBatch();
		return (evt) -> Arrays.asList(
			"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
			.forEach(
					a -> {
						User account = userDao.save(new User(a, "qwerty", a, 30));
					});
	}
}
