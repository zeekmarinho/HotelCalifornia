package br.com.hotelCalifornia.infraestructure.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;

@Repository
public interface HotelCaliforniaRepository extends JpaRepository<HotelCaliforniaModel, UUID> {

	// Busca por ID utilizando JPQL
    @Query("SELECT h FROM Hotel h WHERE h.id = :id")
    Optional<HotelCaliforniaModel> findByIdUsingJPQL(@Param("id") UUID id);

    // Busca por CNPJ utilizando JPQL
    @Query("SELECT h FROM Hotel h WHERE h.cnpj = :cnpj")
    Optional<HotelCaliforniaModel> findByCnpjUsingJPQL(@Param("cnpj") String cnpj);
	
}
