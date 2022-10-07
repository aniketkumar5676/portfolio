package com.payment.payment.Repo;

import com.payment.payment.dto.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCredRepo extends JpaRepository<UserCredentials,Integer> {

    UserCredentials findAllByUserid(String userId);
}
