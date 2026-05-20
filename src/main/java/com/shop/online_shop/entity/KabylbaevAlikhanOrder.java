package com.shop.online_shop.entity;

import com.shop.online_shop.enums.KabylbaevAlikhanOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class KabylbaevAlikhanOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private KabylbaevAlikhanOrderStatus status;

    @Column(nullable = false)
    private Double totalPrice;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private KabylbaevAlikhanUser user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<KabylbaevAlikhanOrderItem> items;


}
