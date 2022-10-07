package com.catalog.catalog.Repo;

import com.catalog.catalog.Entity.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredRepo extends JpaRepository<UserCredentials,Integer> {

}
