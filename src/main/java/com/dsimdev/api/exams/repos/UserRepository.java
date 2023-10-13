package com.dsimdev.api.exams.repos;
import com.dsimdev.api.exams.pojos.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

}