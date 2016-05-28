package com.not4j.dao;

import com.not4j.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 20:14
 */
public interface UserDao extends JpaRepository<User, Long> {
}
