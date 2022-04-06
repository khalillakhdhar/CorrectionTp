package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
Admin findByEmail(String email);
Admin findByNomcomplet(String nom);

}
