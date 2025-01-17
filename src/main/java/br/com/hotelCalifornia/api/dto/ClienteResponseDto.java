package br.com.hotelCalifornia.api.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDto {

    private UUID id;
    private String nome;
    private String cpf;
    private String endereco;
    private int email;
    
}
