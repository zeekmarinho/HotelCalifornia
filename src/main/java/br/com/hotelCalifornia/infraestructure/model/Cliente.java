package br.com.hotelCalifornia.infraestructure.model;

import java.util.HashSet;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank(message = "O nome do hotel é obrigatório.")
    @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(regexp = "\\d{9}", message = "O cpf deve conter exatamente 14 dígitos.")
    private String cpf;

    @NotBlank(message = "A endereco é obrigatória.")
    @Size(max = 255, message = "A endereco pode ter no máximo 255 caracteres.")
    private String endereco;

    @NotBlank(message = "A email é obrigatória.")
    @Size(max = 255, message = "A email pode ter no máximo 255 caracteres.")
    private String email;
    
}