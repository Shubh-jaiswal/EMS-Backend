package com.fullstackems.fullStackEmsBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstackems.fullStackEmsBackend.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
