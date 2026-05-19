package com.shop.online_shop.service.impl;

import com.shop.online_shop.dto.request.KabylbaevAlikhanOrderItemRequest;
import com.shop.online_shop.dto.request.KabylbaevAlikhanOrderRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanOrderResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanOrder;
import com.shop.online_shop.entity.KabylbaevAlikhanOrderItem;
import com.shop.online_shop.entity.KabylbaevAlikhanProduct;
import com.shop.online_shop.entity.KabylbaevAlikhanUser;
import com.shop.online_shop.enums.KabylbaevAlikhanOrderStatus;
import com.shop.online_shop.mapper.KabylbaevAlikhanOrderMapper;
import com.shop.online_shop.repository.KabylbaevAlikhanOrderRepository;
import com.shop.online_shop.repository.KabylbaevAlikhanProductRepository;
import com.shop.online_shop.repository.KabylbaevAlikhanUserRepository;
import com.shop.online_shop.service.KabylbaevAlikhanOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class KabylbaevAlikhanOrderServiceImpl implements KabylbaevAlikhanOrderService {

    private final KabylbaevAlikhanOrderRepository orderRepository;
    private final KabylbaevAlikhanOrderMapper orderMapper;
    private final KabylbaevAlikhanUserRepository userRepository;
    private final KabylbaevAlikhanProductRepository productRepository;
    private final KabylbaevAlikhanAsyncService asyncService;

    @Override
    public KabylbaevAlikhanOrderResponse create(KabylbaevAlikhanOrderRequest request) {
        KabylbaevAlikhanUser user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        KabylbaevAlikhanOrder order = new KabylbaevAlikhanOrder();
        order.setUser(user);
        order.setStatus(KabylbaevAlikhanOrderStatus.PENDING);

        List<KabylbaevAlikhanOrderItem> items = new ArrayList<>();
        double totalPrice = 0.0;

        for (KabylbaevAlikhanOrderItemRequest itemRequest : request.getItems()) {
            KabylbaevAlikhanProduct product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            KabylbaevAlikhanOrderItem item = new KabylbaevAlikhanOrderItem();
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setPrice(product.getPrice() * itemRequest.getQuantity());
            item.setOrder(order);
            items.add(item);
            totalPrice += item.getPrice();
        }

        order.setItems(items);
        order.setTotalPrice(totalPrice);
        KabylbaevAlikhanOrder saved = orderRepository.save(order);
        asyncService.logOrderCreated(user.getUsername(), totalPrice);
        return orderMapper.toResponse(saved);
    }

    @Override
    public KabylbaevAlikhanOrderResponse getById(Long id) {
        return orderMapper.toResponse(orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found")));
    }

    @Override
    public List<KabylbaevAlikhanOrderResponse> getAll() {
        return orderRepository.findAll().stream().map(orderMapper::toResponse).toList();
    }

    @Override
    public List<KabylbaevAlikhanOrderResponse> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream().map(orderMapper::toResponse).toList();
    }

    @Override
    public KabylbaevAlikhanOrderResponse updateStatus(Long id, KabylbaevAlikhanOrderStatus status) {
        KabylbaevAlikhanOrder order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
