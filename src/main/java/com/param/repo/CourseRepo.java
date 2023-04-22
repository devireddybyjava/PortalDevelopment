package com.param.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.param.entity.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer>{

}
