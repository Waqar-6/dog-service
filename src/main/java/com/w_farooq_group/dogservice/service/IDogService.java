package com.w_farooq_group.dogservice.service;

import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;

public interface IDogService {

    /**
     *
     * @param dogRegistrationRequest - DogRegistrationRequest Object
     */
    void registerDog (DogRegistrationRequest dogRegistrationRequest);
}
