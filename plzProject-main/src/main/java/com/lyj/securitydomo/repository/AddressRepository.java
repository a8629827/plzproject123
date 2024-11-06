package com.lyj.securitydomo.repository;

import com.lyj.securitydomo.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // 기본 CRUD는 JpaRepository가 자동으로 제공

    // userId로 주소를 조회하는 메서드 예시
    List<Address> findByUser_UserId(int userId);  // userId는 User 엔티티의 필드

    // 도시와 구로 주소를 조회하는 메서드 예시
    List<Address> findByCityAndState(String city, String state);
}