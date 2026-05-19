package com.shop.online_shop.repository;

import com.shop.online_shop.entity.KabylbaevAlikhanProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KabylbaevAlikhanProductRepository extends JpaRepository<KabylbaevAlikhanProduct, Long> {
    Page<KabylbaevAlikhanProduct> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<KabylbaevAlikhanProduct> findByCategoryId(Long categoryId, Pageable pageable);
    List<KabylbaevAlikhanProduct> findByCategoryId(Long categoryId);
}
