package com.param.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.param.entity.UserDtlsEntity;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer>{
 public UserDtlsEntity findByEmail(String email);
 public UserDtlsEntity findByEmailAndPwd(String email, String pwd);
}
