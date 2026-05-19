package com.shop.online_shop.service;

import com.gym.gym_management.dto.request.DilbarWorkoutRequest;
import com.gym.gym_management.dto.response.DilbarWorkoutResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DilbarWorkoutService {
    DilbarWorkoutResponse create(DilbarWorkoutRequest request);
    DilbarWorkoutResponse getById(Long id);
    List<DilbarWorkoutResponse> getAll();
    DilbarWorkoutResponse update(Long id, DilbarWorkoutRequest request);
    void delete(Long id);
    Page<DilbarWorkoutResponse> search(String title, Long trainerId, Pageable pageable);
    DilbarWorkoutResponse addParticipant(Long workoutId, Long userId);
}
