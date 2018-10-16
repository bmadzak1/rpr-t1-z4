package com.company;

public class Student {
    String ime;
    String prezime;
    int brojIndeksa;

    public Student(String ime, String prezime, int brojIndeksa){
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndeksa = brojIndeksa;
    }

    public String dajIme(){
        return ime;
    }

    public String dajPrezime(){
        return prezime;
    }

    public int dajBrojIndeksa(){
        return brojIndeksa;
    }

    public void promijeniIme(String novoIme){
        ime = novoIme;
    }

    public void promijeniPrezime(String novoPrezime){
        prezime = novoPrezime;
    }

    public void promijeniBrojIndeksa(int noviBrojIndeksa){
        brojIndeksa = noviBrojIndeksa;
    }

    public String toString(){
        String ispis = prezime + " " + ime + " (" + brojIndeksa + ")";
        return ispis;
    }
}
