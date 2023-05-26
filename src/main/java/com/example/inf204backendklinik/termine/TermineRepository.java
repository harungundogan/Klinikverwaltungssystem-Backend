package com.example.inf204backendklinik.termine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TermineRepository extends JpaRepository<Termine, Long> {
    //@Query("SELECT t FROM Termine t WHERE t.terminDatum=?1")
    @Query(nativeQuery = true, value="SELECT CASE WHEN COUNT(t.termin_datum) > 0 THEN true ELSE false END FROM Termine t WHERE t.termin_datum = :termin_datum")

    Boolean existsTerminByDatum(@Param("termin_datum") LocalDateTime termin_datum);
    @Query("SELECT t FROM Termine t WHERE t.zeit=?1")
    Optional<Termine> findTerminByZeit(String zeit);


}

