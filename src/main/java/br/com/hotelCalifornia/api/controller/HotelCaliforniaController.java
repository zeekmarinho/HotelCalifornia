package br.com.hotelCalifornia.api.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelCalifornia.api.dto.HotelCaliforniaRequestDto;
import br.com.hotelCalifornia.api.dto.HotelCaliforniaResponseDto;
import br.com.hotelCalifornia.domain.service.HotelCaliforniaService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelCaliforniaController {
	
	private final HotelCaliforniaService service;

    @PostMapping
    public ResponseEntity<HotelCaliforniaResponseDto> createHotel(@Valid @RequestBody HotelCaliforniaRequestDto dto) {
        HotelCaliforniaResponseDto response = service.createHotel(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelCaliforniaResponseDto> updateHotel(@PathVariable UUID id, @Valid @RequestBody HotelCaliforniaRequestDto dto) {
        return ResponseEntity.ok(service.updateHotel(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable UUID id) {
        service.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelCaliforniaResponseDto> getHotelById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getHotelById(id));
    }

    @GetMapping("/by-cnpj/{cnpj}")
    public ResponseEntity<HotelCaliforniaResponseDto> getHotelByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(service.getHotelByCnpj(cnpj));
    }

    @GetMapping
    public ResponseEntity<List<HotelCaliforniaResponseDto>> getAllHotels() {
        return ResponseEntity.ok(service.getAllHotels());
    }

}
