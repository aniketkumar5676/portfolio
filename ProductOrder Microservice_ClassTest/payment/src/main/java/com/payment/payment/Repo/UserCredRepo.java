package com.payment.payment.Repo;

import com.payment.payment.dto.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredRepo extends JpaRepository<UserCredentials,Integer> {

    UserCredentials findByUserid(String userId);
}
