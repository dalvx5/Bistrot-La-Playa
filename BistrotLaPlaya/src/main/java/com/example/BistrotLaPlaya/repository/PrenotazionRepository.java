package com.example.BistrotLaPlaya.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.BistrotLaPlaya.controller.PrenotazioniDetails; // Removed as it cannot be resolved
import com.example.BistrotLaPlaya.model.Prenotazioni;

public interface PrenotazionRepository extends JpaRepository<Prenotazioni, Integer> {

    public default List<Map<String, Prenotazioni>> findAllByGiorno(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllByGiorno'");
    }

    public default Prenotazioni save(Prenotazioni prenotazione) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    default List<Map<String, Prenotazioni>> findAllByGiorno(String sdate) {
        // Return an empty list as a placeholder
        return new ArrayList<>();
    }
}
