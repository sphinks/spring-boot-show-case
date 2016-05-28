package com.not4j.dao;

import com.not4j.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 23:07
 */
public interface TripDao extends JpaRepository<Trip, Long> {
}
