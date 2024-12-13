package com.w_farooq_group.dogservice.controller;

import com.w_farooq_group.dogservice.constants.ResponseConstants;
import com.w_farooq_group.dogservice.constants.StatusConstants;
import com.w_farooq_group.dogservice.dto.DogDto;
import com.w_farooq_group.dogservice.dto.ResponseDto;
import com.w_farooq_group.dogservice.requests.DogRegistrationRequest;
import com.w_farooq_group.dogservice.service.IDogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/dogs", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DogController {

    private final IDogService iDogService;
    public DogController(IDogService iDogService) {
        this.iDogService = iDogService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> registerDog (DogRegistrationRequest dogRegistrationRequest) {
        iDogService.registerDog(dogRegistrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(StatusConstants.STATUS_201, ResponseConstants.RESPONSE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<DogDto> fetchByRegistrationNumber (@RequestParam Integer registrationNumber) {
        DogDto dogDto = iDogService.fetchDogByRegistrationNumber(registrationNumber);
        return ResponseEntity.status(HttpStatus.OK).body(dogDto);
    }

    @PutMapping("/update/{dogId}")
    public ResponseEntity<ResponseDto> updateDog (@PathVariable UUID dogId, @RequestBody DogDto dogDto) {
        boolean isUpdated = iDogService.updateDog(dogDto, dogId);
        return isUpdated ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(StatusConstants.STATUS_200,ResponseConstants.RESPONSE_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(StatusConstants.STATUS_417,ResponseConstants.RESPONSE_417_UPDATE));
    }

    @PutMapping("/delete/{dogId}")
    public ResponseEntity<ResponseDto> updateDog (@PathVariable UUID dogId) {
        boolean isDeleted = iDogService.deleteDogById(dogId);
        return isDeleted ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(StatusConstants.STATUS_200,ResponseConstants.RESPONSE_200)) :
                ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(StatusConstants.STATUS_417,ResponseConstants.RESPONSE_417_DELETE));
    }
}
