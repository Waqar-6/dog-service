package com.w_farooq_group.dogservice.repository;

import com.w_farooq_group.dogservice.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DogRepository extends JpaRepository<Dog, UUID> {
    Boolean existsByRegistrationNumber(Integer registrationNumber);
    Optional<Dog> findByRegistrationNumber(Integer registrationNumber);
}
