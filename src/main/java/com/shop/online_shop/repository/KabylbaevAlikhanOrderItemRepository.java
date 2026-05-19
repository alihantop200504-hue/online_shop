package com.shop.online_shop.repository;

import com.shop.online_shop.entity.KabylbaevAlikhanOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KabylbaevAlikhanOrderItemRepository extends JpaRepository<KabylbaevAlikhanOrderItem, Long> {
    List<KabylbaevAlikhanOrderItem> findByOrderId(Long orderId);
}
