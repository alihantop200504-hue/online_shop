package com.shop.online_shop.service.impl;

import com.shop.online_shop.dto.request.KabylbaevAlikhanProductRequest;
import com.shop.online_shop.dto.response.KabylbaevAlikhanProductResponse;
import com.shop.online_shop.entity.KabylbaevAlikhanCategory;
import com.shop.online_shop.entity.KabylbaevAlikhanProduct;
import com.shop.online_shop.mapper.KabylbaevAlikhanProductMapper;
import com.shop.online_shop.repository.KabylbaevAlikhanCategoryRepository;
import com.shop.online_shop.repository.KabylbaevAlikhanProductRepository;
import com.shop.online_shop.service.KabylbaevAlikhanProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KabylbaevAlikhanProductServiceImpl implements KabylbaevAlikhanProductService {

    private final KabylbaevAlikhanProductRepository productRepository;
    private final KabylbaevAlikhanProductMapper productMapper;
    private final KabylbaevAlikhanCategoryRepository categoryRepository;
    private final KabylbaevAlikhanAsyncService asyncService;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public KabylbaevAlikhanProductResponse create(KabylbaevAlikhanProductRequest request) {
        KabylbaevAlikhanCategory category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        KabylbaevAlikhanProduct product = productMapper.toEntity(request);
        product.setCategory(category);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public KabylbaevAlikhanProductResponse getById(Long id) {
        return productMapper.toResponse(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")));
    }

    @Override
    public List<KabylbaevAlikhanProductResponse> getAll() {
        return productRepository.findAll().stream().map(productMapper::toResponse).toList();
    }

    @Override
    public KabylbaevAlikhanProductResponse update(Long id, KabylbaevAlikhanProductRequest request) {
        KabylbaevAlikhanProduct product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<KabylbaevAlikhanProductResponse> search(String name, Long categoryId, Pageable pageable) {
        Page<KabylbaevAlikhanProduct> products;
        if (name != null && !name.isEmpty()) {
            products = productRepository.findByNameContainingIgnoreCase(name, pageable);
        } else if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId, pageable);
        } else {
            products = productRepository.findAll(pageable);
        }
        return products.map(productMapper::toResponse);
    }

    @Override
    public String uploadImage(Long id, MultipartFile file) {
        try {
            KabylbaevAlikhanProduct product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
            String fileName = id + "_" + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            product.setImagePath(filePath.toString());
            productRepository.save(product);
            asyncService.logImageUpload(fileName, id);
            return "Image uploaded: " + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image: " + e.getMessage());
        }
    }
}
