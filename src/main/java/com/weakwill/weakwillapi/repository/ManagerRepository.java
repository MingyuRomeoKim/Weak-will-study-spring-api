package com.weakwill.weakwillapi.repository;


import com.weakwill.weakwillapi.emtity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    // 필요한 메소드 정의
}
