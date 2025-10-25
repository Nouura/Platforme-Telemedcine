package com.mycompany.platforme_telemedcine.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String notes;
    private String videoURL;

    @OneToOne
    RendezVous rendezVous;
    @OneToOne
    Ordonance ordonance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Ordonance getOrdonance() {
        return ordonance;
    }

    public void setOrdonance(Ordonance ordonance) {
        this.ordonance = ordonance;
    }
}
