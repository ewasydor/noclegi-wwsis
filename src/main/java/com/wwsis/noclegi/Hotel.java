package com.wwsis.noclegi;

import javax.persistence.*;

@Entity
@Table(name="Noclegi")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazwa;
    @Column(name ="numer", nullable=false)
    private String telefon;
    private String email;
    private Integer liczbaGwiazdek;
    @Column(length = 2048)
    private String opis;

    public Hotel(String nazwa, String telefon, String email, Integer liczbaGwiazdek, String opis) {
        this.nazwa = nazwa;
        this.telefon = telefon;
        this.email = email;
        this.liczbaGwiazdek = liczbaGwiazdek;
        this.opis = opis;
    }

    public Hotel(Integer id, String nazwa, String telefon, String email, Integer liczbaGwiazdek, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.telefon = telefon;
        this.email = email;
        this.liczbaGwiazdek = liczbaGwiazdek;
        this.opis = opis;
    }

    public Hotel() {
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNazwa() { return nazwa; }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLiczbaGwiazdek() {
        return liczbaGwiazdek;
    }

    public void setLiczbaGwiazdek(Integer liczbaGwiazdek) {
        this.liczbaGwiazdek = liczbaGwiazdek;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", liczbaGwiazdek='" + liczbaGwiazdek + '\'' +
                ", email='" + email + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
