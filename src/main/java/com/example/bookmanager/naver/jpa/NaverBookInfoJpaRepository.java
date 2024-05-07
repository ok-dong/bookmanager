package com.example.bookmanager.naver.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NaverBookInfoJpaRepository extends JpaRepository<NaverBookInfoJpo, Long> {
    Optional<NaverBookInfoJpo> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
}
