package com.te.springboothibernate.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springboothibernate.validation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(Integer userId);

}
