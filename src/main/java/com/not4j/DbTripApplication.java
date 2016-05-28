package com.not4j;

import com.not4j.dao.TripDao;
import com.not4j.dao.UserDao;
import com.not4j.model.Trip;
import com.not4j.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class DbTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbTripApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserDao userDao, TripDao tripDao) {
        tripDao.deleteAllInBatch();
        userDao.deleteAllInBatch();

		return (evt) -> Arrays.asList(
			"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
			.forEach(
					a -> {
                        try {
                            User user = userDao.save(new User(a, "qwerty", a, 30));
                            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                            Trip trip = tripDao.save(new Trip(user, "Moscow",
                                    format.parse("January 2, 2017"),
                                    format.parse("January 12, 2017")));
                        }catch(Exception e) {
                            e.printStackTrace();
                        }
					});
	}
}
