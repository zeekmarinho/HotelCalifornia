package br.com.hotelCalifornia.api.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCaliforniaRequestDto {
	
    @NotBlank(message = "O nome do hotel é obrigatório.")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter exatamente 14 dígitos.")
    private String cnpj;

    @NotBlank(message = "A localização é obrigatória.")
    @Size(max = 255, message = "A localização pode ter no máximo 255 caracteres.")
    private String local;

    @Min(value = 1, message = "A capacidade deve ser no mínimo 1.")
    @Max(value = 1000, message = "A capacidade não pode exceder 1000.")
    private int capacidade;

}


