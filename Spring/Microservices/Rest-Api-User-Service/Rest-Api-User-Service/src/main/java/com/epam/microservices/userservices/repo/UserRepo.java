package com.epam.microservices.userservices.repo;

import com.epam.microservices.userservices.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.email = :email, u.name = :name WHERE u.username = :username")
    int updateUserDetails(String username, String email, String name);

}
