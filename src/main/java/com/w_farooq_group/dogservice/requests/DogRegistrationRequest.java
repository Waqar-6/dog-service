package com.w_farooq_group.dogservice.requests;

import com.w_farooq_group.dogservice.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class DogRegistrationRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "registration number can not be empty")
    private Integer registrationNumber;

    @NotBlank(message = "Breed is required")
    private String breed;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    public DogRegistrationRequest(String name, String breed, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public DogRegistrationRequest() {}

    public @NotBlank(message = "Name is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Breed is required") String getBreed() {
        return breed;
    }

    public void setBreed(@NotBlank(message = "Breed is required") String breed) {
        this.breed = breed;
    }

    public @NotNull(message = "Gender is required") Gender getGender() {
        return gender;
    }

    public void setGender(@NotNull(message = "Gender is required") Gender gender) {
        this.gender = gender;
    }

    public @Past(message = "Date of birth must be in the past") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@Past(message = "Date of birth must be in the past") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotBlank(message = "registration number can not be empty") Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(@NotBlank(message = "registration number can not be empty") Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
