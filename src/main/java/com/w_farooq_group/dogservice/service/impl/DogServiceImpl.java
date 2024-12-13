package com.w_farooq_group.dogservice.service.impl;

import com.w_farooq_group.dogservice.entity.Dog;
import com.w_farooq_group.dogservice.exception.AlreadyExistsException;
import com.w_farooq_group.dogservice.mapper.DogMapper;
import com.w_farooq_group.dogservice.repository.DogRepository;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;
import com.w_farooq_group.dogservice.service.IDogService;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements IDogService {

    private final DogRepository dogRepository;
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    /**
     * @param dogRegistrationRequest - DogRegistrationRequest Object
     */
    @Override
    public void registerDog(DogRegistrationRequest dogRegistrationRequest) {
        Boolean exists = dogRepository.existsByRegistrationNumber(dogRegistrationRequest.getRegistrationNumber());
        if (exists)
            throw new AlreadyExistsException("Dog", "registrationNumber", dogRegistrationRequest.getRegistrationNumber().toString());
        Dog newDog = DogMapper.dogRegistrationRequestToDog(dogRegistrationRequest, new Dog());
        dogRepository.save(newDog);
    }
}
