package com.dsimdev.api.exams.repos;

import com.dsimdev.api.exams.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}