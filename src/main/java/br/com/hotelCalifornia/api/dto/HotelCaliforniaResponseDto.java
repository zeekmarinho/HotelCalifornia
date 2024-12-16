package br.com.hotelCalifornia.api.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCaliforniaResponseDto {

    private UUID id;
    private String nome;
    private String cnpj;
    private String local;
    private int capacidade;
    
}
