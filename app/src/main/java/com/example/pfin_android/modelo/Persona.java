package com.example.pfin_android.modelo;

import java.util.GregorianCalendar;

public class Persona {
    private int id;
    private String nom;
    private String ape1;
    private String ape2;
    private String curso;
    private GregorianCalendar fec_nac;

    public Persona(){}

    public Persona(int i, String no, String ap1, String ap2, String cur, GregorianCalendar fec){
        this.id = i;
        this.nom = no;
        this.ape1 = ap1;
        this.ape2 = ap2;
        this.curso = cur;
        this.fec_nac =  fec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public GregorianCalendar getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(GregorianCalendar fec_nac) {
        this.fec_nac = fec_nac;
    }
}
