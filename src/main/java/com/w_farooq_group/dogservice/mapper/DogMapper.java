package com.w_farooq_group.dogservice.mapper;

import com.w_farooq_group.dogservice.dto.DogDto;
import com.w_farooq_group.dogservice.entity.Dog;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;

public final class DogMapper {

    private DogMapper() {}

    public static Dog dogRegistrationRequestToDog (DogRegistrationRequest dogRegistrationRequest, Dog dog) {
        dog.setName(dogRegistrationRequest.getName());
        dog.setRegistrationNumber(dogRegistrationRequest.getRegistrationNumber());
        dog.setBreed(dogRegistrationRequest.getBreed());
        dog.setGender(dogRegistrationRequest.getGender());
        dog.setDateOfBirth(dogRegistrationRequest.getDateOfBirth());
        return dog;
    }

    public static DogDto dogToDogDto (DogDto dogDto, Dog dog) {
        dogDto.setDogId(dog.getDogId());
        dogDto.setRegistrationNumber(dog.getRegistrationNumber());
        dogDto.setName(dogDto.getName());
        dogDto.setBreed(dogDto.getBreed());
        dogDto.setGender(dogDto.getGender());
        dogDto.setDateOfBirth(dogDto.getDateOfBirth());
        return dogDto;
    }

    public static Dog dogDtoToDog (Dog dog, DogDto dogDto) {
        dog.setName(dogDto.getName());
        dog.setRegistrationNumber(dogDto.getRegistrationNumber());
        dog.setBreed(dogDto.getBreed());
        dog.setGender(dogDto.getGender());
        dog.setDateOfBirth(dogDto.getDateOfBirth());
        return dog;
    }
}
