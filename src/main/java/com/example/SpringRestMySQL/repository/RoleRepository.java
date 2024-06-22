package com.example.SpringRestMySQL.repository;

import com.example.SpringRestMySQL.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
