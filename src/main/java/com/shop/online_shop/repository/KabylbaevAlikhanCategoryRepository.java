package com.shop.online_shop.repository;

import com.shop.online_shop.entity.KabylbaevAlikhanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KabylbaevAlikhanCategoryRepository extends JpaRepository<KabylbaevAlikhanCategory, Long> {
    Optional<KabylbaevAlikhanCategory> findByName(String name);
}
