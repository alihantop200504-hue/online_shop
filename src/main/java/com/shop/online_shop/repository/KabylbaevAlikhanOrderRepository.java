package com.shop.online_shop.repository;

import com.shop.online_shop.entity.KabylbaevAlikhanOrder;
import com.shop.online_shop.enums.KabylbaevAlikhanOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KabylbaevAlikhanOrderRepository extends JpaRepository<KabylbaevAlikhanOrder, Long> {
    List<KabylbaevAlikhanOrder> findByUserId(Long userId);
    List<KabylbaevAlikhanOrder> findByStatus(KabylbaevAlikhanOrderStatus status);
}
