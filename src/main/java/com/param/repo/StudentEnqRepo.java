package com.param.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.param.entity.StudentEnqEntity;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity,Integer> {

}
