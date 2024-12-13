package com.w_farooq_group.dogservice.repository;

import com.w_farooq_group.dogservice.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DogRepository extends JpaRepository<Dog, UUID> {
    Boolean existsByRegistrationNumber(Integer registrationNumber);
}
