package com.w_farooq_group.dogservice.service;

import com.w_farooq_group.dogservice.dto.DogDto;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;

import java.util.List;
import java.util.UUID;

public interface IDogService {

    /**
     *
     * @param dogRegistrationRequest - DogRegistrationRequest Object
     */
    void registerDog (DogRegistrationRequest dogRegistrationRequest);

    /**
     *
     * @param registrationNumber - Integer
     * @return DogDto Object
     */
    DogDto fetchDogByRegistrationNumber (Integer registrationNumber);

    /**
     *
     * @return List of DogDto Objects
     */
    List<DogDto> fetchAllDogs();

    /**
     *
     * @param dogDto - Updated DogDto Object
     * @param dogId - UUID
     * @return True or False based on update
     */
    boolean updateDog (DogDto dogDto, UUID dogId);

    /**
     *
     * @param dogId - UUID
     * @return - True or False based on delete
     */
    boolean deleteDogById(UUID dogId);

}
