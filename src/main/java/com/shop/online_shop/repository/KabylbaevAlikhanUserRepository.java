package com.shop.online_shop.repository;

import com.shop.online_shop.entity.KabylbaevAlikhanUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KabylbaevAlikhanUserRepository extends JpaRepository<KabylbaevAlikhanUser, Long> {
    Optional<KabylbaevAlikhanUser> findByUsername(String username);
    Optional<KabylbaevAlikhanUser> findByEmail(String email);
    boolean existsByEmail(String email);
    Page<KabylbaevAlikhanUser> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
