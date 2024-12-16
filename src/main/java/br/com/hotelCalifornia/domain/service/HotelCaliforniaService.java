package br.com.hotelCalifornia.domain.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import br.com.hotelCalifornia.api.dto.HotelCaliforniaRequestDto;
import br.com.hotelCalifornia.api.dto.HotelCaliforniaResponseDto;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelCaliforniaService {

	private final HotelCaliforniaRepository repository;

	//Salvar Hotel
	public HotelCaliforniaResponseDto createHotel(HotelCaliforniaRequestDto dto) {
        HotelCaliforniaModel hotel = new HotelCaliforniaModel(null, dto.getNome(), dto.getCnpj(), dto.getLocal(), dto.getCapacidade());
        hotel = repository.save(hotel);
        return toResponseDTO(hotel);
    }

	//Listar Hoteis
    public List<HotelCaliforniaResponseDto> getAllHotels() {
        try{
            return repository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
        }catch (DataAccessException e){
            throw new RuntimeException("Erro ao buscar todos os hoteis: " + e.getMessage(), e);
        }
    }

	//Alterar Hotel
    public HotelCaliforniaResponseDto updateHotel(UUID id, HotelCaliforniaRequestDto dto) {
        HotelCaliforniaModel hotel = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hotel não encontrado."));
        hotel.setNome(dto.getNome());
        hotel.setCnpj(dto.getCnpj());
        hotel.setLocal(dto.getLocal());
        hotel.setCapacidade(dto.getCapacidade());
        return toResponseDTO(repository.save(hotel));
    }

	//Deletar Hotel por Id
    public void deleteHotel(UUID id) {
        repository.deleteById(id);
    }

	//Pesquisar Hotel por Id
	public HotelCaliforniaResponseDto getHotelById(UUID id) {
        try{
            HotelCaliforniaModel hotel = repository.findByIdUsingJPQL(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel não encontrado."));
            return toResponseDTO(hotel);
        }catch (DataAccessException e){
            throw new RuntimeException("Hotel não encontrado, Id de hotel : " + e.getMessage(), e);
        }        
    }

	//Pesquisar Hotel por Cnpj
    public HotelCaliforniaResponseDto getHotelByCnpj(String cnpj) {
        try{
            HotelCaliforniaModel hotel = repository.findByCnpjUsingJPQL(cnpj)
                .orElseThrow(() -> new EntityNotFoundException("Hotel não encontrado."));
            return toResponseDTO(hotel);
        }catch (DataAccessException e){
            throw new RuntimeException("Hotel não encontrado, CNPJ de hotel : " + e.getMessage(), e);
        }
        
    }

    //Conversão DTO/MODEL
    private HotelCaliforniaResponseDto toResponseDTO(HotelCaliforniaModel hotel) {
        HotelCaliforniaResponseDto dto = new HotelCaliforniaResponseDto();
        dto.setNome(hotel.getNome());
        dto.setLocal(hotel.getLocal());
        dto.setCapacidade(hotel.getCapacidade());
        dto.setCnpj(hotel.getCnpj());
        BeanUtils.copyProperties(hotel, dto);
        return dto;
    }
}
