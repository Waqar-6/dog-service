package com.w_farooq_group.dogservice.service.impl;

import com.w_farooq_group.dogservice.dto.DogDto;
import com.w_farooq_group.dogservice.entity.Dog;
import com.w_farooq_group.dogservice.exception.AlreadyExistsException;
import com.w_farooq_group.dogservice.exception.ResourceNotFoundException;
import com.w_farooq_group.dogservice.mapper.DogMapper;
import com.w_farooq_group.dogservice.repository.DogRepository;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;
import com.w_farooq_group.dogservice.service.IDogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    /**
     *
     * @param registrationNumber - Integer
     * @return DogDto Object
     */
    @Override
    public DogDto fetchDogByRegistrationNumber(Integer registrationNumber) {
        Dog dog = dogRepository.findByRegistrationNumber(registrationNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Dog", "registrationNumber", registrationNumber.toString()));
        return DogMapper.dogToDogDto(new DogDto(), dog);
    }

    /**
     * @return List of DogDto Objects
     */
    @Override
    public List<DogDto> fetchAllDogs() {
        List<Dog> dogs = dogRepository.findAll();
        return dogs.stream().map(dog -> DogMapper.dogToDogDto(new DogDto(),dog)).toList();
    }

    /**
     * @param dogDto - Updated DogDto Object
     * @param dogId  - UUID
     * @return True or False based on update
     */
    @Override
    public boolean updateDog(DogDto dogDto, UUID dogId) {
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new ResourceNotFoundException("Dog", "id", dogId.toString()));
        Dog updatedDog = DogMapper.dogDtoToDog(dog,dogDto);
        dogRepository.save(updatedDog);
        return true;
    }

    /**
     * @param dogId - UUID
     * @return - True or False based on delete
     */
    @Override
    public boolean deleteDogById(UUID dogId) {
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new ResourceNotFoundException("Dog", "id", dogId.toString()));
        dogRepository.delete(dog);
        return true;
    }


}
