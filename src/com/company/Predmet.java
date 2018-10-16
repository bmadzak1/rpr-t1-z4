package com.company;

public class Predmet {
    private Student[] studenti;
    private int trenutniBrojStudenata = 0;

    String nazivPredmeta;
    int sifraPredmeta;
    int maksimalanBrojStudenata;

    public Predmet(String nazivPredmeta, int sifraPredmeta, int maksimalanBrojStudenata){
        this.nazivPredmeta = nazivPredmeta;
        this.sifraPredmeta = sifraPredmeta;
        this.maksimalanBrojStudenata = maksimalanBrojStudenata;
        studenti = new Student[maksimalanBrojStudenata];
    }

    public String dajNaziv(){
        return nazivPredmeta;
    }

    public int dajSifru(){
        return sifraPredmeta;
    }

    public int dajTrenutniBrojStudenata(){
        return trenutniBrojStudenata;
    }

    public boolean daLiJeStudentNaPredmetu(Student student){
        for(int i = 0; i < trenutniBrojStudenata; i++){
            if(student == studenti[i])
                return true;
        }
        return  false;
    }

    public void promijeniNaziv(String noviNaziv) {
        nazivPredmeta = noviNaziv;
    }

    public void promijeniSifru(int novaSifra){
        sifraPredmeta = novaSifra;
    }

    public void upisi(Student student){
        studenti[trenutniBrojStudenata] = student;
        trenutniBrojStudenata++;
    }

    public  void ispisi(Student student){
    vanjska:for(int i = 0; i < trenutniBrojStudenata; i++){
            if(student == studenti[i]){
                studenti[i] = null;
                for (int j = i+1; i < trenutniBrojStudenata; i++){
                    studenti[j-1] = studenti[j];
                }
                studenti[trenutniBrojStudenata-1] = null;
                trenutniBrojStudenata--;
                break vanjska;
            }
        }
    }

    public void ispisiListuStudenata(){
        if(trenutniBrojStudenata == 0){
            System.out.println("Nema studenata na predmetu");
        }
        else {
            for (int i = 0; i < trenutniBrojStudenata; i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(studenti[i]);
            }
        }
    }
}
