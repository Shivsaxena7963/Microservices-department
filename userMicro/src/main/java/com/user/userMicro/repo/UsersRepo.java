package com.user.userMicro.repo;

import com.user.userMicro.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {

    Optional<Users> findByPhone(String mblNo);
}
