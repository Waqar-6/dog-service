package com.w_farooq_group.dogservice.mapper;

import com.w_farooq_group.dogservice.entity.Dog;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;

public final class DogMapper {

    private DogMapper() {}

    public static Dog dogRegistrationRequestToDog (DogRegistrationRequest dogRegistrationRequest, Dog dog) {
        dog.setName(dogRegistrationRequest.getName());
        dog.setBreed(dogRegistrationRequest.getBreed());
        dog.setGender(dogRegistrationRequest.getGender());
        dog.setDateOfBirth(dogRegistrationRequest.getDateOfBirth());
        return dog;
    }
}
