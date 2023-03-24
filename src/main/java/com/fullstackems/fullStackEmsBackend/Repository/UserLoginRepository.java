package com.fullstackems.fullStackEmsBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstackems.fullStackEmsBackend.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{

}
