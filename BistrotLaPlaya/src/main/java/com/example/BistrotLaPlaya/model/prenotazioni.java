package com.example.BistrotLaPlaya.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prenotazione;

    @Column(name = "Giorno")
    private LocalDate Giorno;
    
    @Column(name = "ora")
    private LocalTime ora;

    public int getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(int id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }

    public LocalDate getGiorno() {
        return Giorno;
    }

    public void setGiorno(LocalDate giorno) {
        Giorno = giorno;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    @Override
    public String toString() {
        return "prenotazioni [id_prenotazione=" + id_prenotazione + ", Giorno=" + Giorno + ", ora=" + ora + "]";
    }

    
    

    
}
