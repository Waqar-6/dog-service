package com.w_farooq_group.dogservice.dto;

import com.w_farooq_group.dogservice.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.UUID;

public class DogDto {

    private UUID dogId;
    @NotBlank(message = "name can not be empty")
    private String name;
    @NotBlank(message = "registration number can not be empty")
    private Integer registrationNumber;
    @NotBlank(message = "breed can not be empty")
    private String breed;
    @NotBlank(message = "Gender can not be empty")
    private Gender gender;
    @NotBlank(message = "date of birth can not be empty")
    @Past(message = "date of birth can not be in the future")
    private LocalDate dateOfBirth;

    public DogDto(UUID dogId, String name, Integer registrationNumber, String breed, Gender gender, LocalDate dateOfBirth) {
        this.dogId = dogId;
        this.name = name;
        this.registrationNumber= registrationNumber;
        this.breed = breed;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;

    }

    public DogDto() {}

    public UUID getDogId() {
        return dogId;
    }

    public void setDogId(UUID dogId) {
        this.dogId = dogId;
    }

    public @NotBlank(message = "name can not be empty") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name can not be empty") String name) {
        this.name = name;
    }

    public @NotBlank(message = "breed can not be empty") String getBreed() {
        return breed;
    }

    public void setBreed(@NotBlank(message = "breed can not be empty") String breed) {
        this.breed = breed;
    }

    public @NotBlank(message = "Gender can not be empty") Gender getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "Gender can not be empty") Gender gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "date of birth can not be empty") @Past(message = "date of birth can not be in the future") LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotBlank(message = "date of birth can not be empty") @Past(message = "date of birth can not be in the future") LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotBlank(message = "registration number can not be empty") Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(@NotBlank(message = "registration number can not be empty") Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
