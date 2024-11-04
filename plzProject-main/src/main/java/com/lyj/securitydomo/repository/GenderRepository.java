package com.lyj.securitydomo.repository;

import com.lyj.securitydomo.domain.Gender;
import com.lyj.securitydomo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
    User findByUsername(String genderName);
}
