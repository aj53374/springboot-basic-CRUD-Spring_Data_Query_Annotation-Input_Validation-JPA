package com.abhishek.restful.webservices.restfulservice.repo;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.restful.webservices.restfulservice.model.User;

@Repository

public interface UsrRepository extends JpaRepository<User,Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE User SET emp_name =?1,dob=?2 WHERE emp_id = ?3")
	void update(String empName,Date DoB,Integer id);
}
