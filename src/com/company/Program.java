package com.company;

import java.util.Scanner;

public class Program {

     static int zadnjiStudent = 0;
     static int zadnjiPredmet = 0;
     static Predmet[] predmeti = new Predmet[100];
     static Student[] studenti = new Student[100];

    public static void main(String[] args) {
        int unos;
        Scanner ulaz = new Scanner(System.in);

        while(true){
            System.out.println(" ");
            System.out.println("IZABERITE RADNJU:");
            System.out.println("Za kreiranje novog predmeta unesite 1");
            System.out.println("Za kreiranje novog studenta unesite 2");
            System.out.println("Za upis studenta na predmet unesite 3");
            System.out.println("Za ispis studenta sa predmeta unesite 4");
            System.out.println("Za brisanje studenta unesite 5");
            System.out.println("Za brisanje predmeta unesite 6");
            System.out.println("Za ispis spiska studenata na predmetu unesite 7");
            unos = ulaz.nextInt();

            if(unos == 1){
                predmeti[zadnjiPredmet] = kreiranjeNovogPredmeta();
                zadnjiPredmet++;
            }
            else if(unos == 2){
                studenti[zadnjiStudent] = kreiranjeNovogStudenta();
                zadnjiStudent++;
            }
            else if(unos == 3){
                upisStudenta();
            }
            else if(unos == 4){
                ispisStudenta();
            }
            else if(unos == 5){
                brisanjeStudenta();
            }
            else if(unos == 6){
                brisanjePredmeta();
            }
            else if(unos == 7){
                ispisStudenataNaPredmetu();
            }
            else{
                System.out.println("Pogresan unos");
            }
        }
    }

    public static Predmet kreiranjeNovogPredmeta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite naziv predmeta");
        String naziv = ulaz.nextLine();
        System.out.println("Unesite sifru predmeta");
        int sifra = ulaz.nextInt();
        System.out.println("Unesite maksimalan broj studenata na predmetu");
        int brojStudenata = ulaz.nextInt();

        Predmet tempPredmet = new Predmet(naziv, sifra, brojStudenata);
        return tempPredmet;
    }

    public static Student kreiranjeNovogStudenta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite ime studenta");
        String ime = ulaz.nextLine();
        System.out.println("Unesite prezime studenta");
        String prezime = ulaz.nextLine();
        System.out.println("Unesite broj indeksa");
        int indeks = ulaz.nextInt();

        Student tempStudent = new Student(ime, prezime, indeks);
        return tempStudent;
    }

    public static void upisStudenta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj indeksa studenta");
        int indeks = ulaz.nextInt();
        Student tempStudent = nadjiStudentaPoIndeksu(indeks);
        if(tempStudent == null){
            System.out.println("Student sa tim indeksom ne postoji");
        }
        else {
            System.out.println("Unesite sifru predmeta");
            int sifra = ulaz.nextInt();
            Predmet tempPredmet = nadjiPredmetPoSifri(sifra);
            if(tempPredmet == null){
                System.out.println("Predmet sa tom sifrom ne postoji");
            }
            else{
                if(tempPredmet.daLiJeStudentNaPredmetu(tempStudent)){
                    System.out.println("Student je vec upisan na taj predmet");
                }
                else if(tempPredmet.dajTrenutniBrojStudenata() == tempPredmet.maksimalanBrojStudenata)
                    System.out.println("Predmet je pun");
                else {
                    tempPredmet.upisi(tempStudent);
                    System.out.println(tempStudent + " je upisan u predmet " + tempPredmet.dajNaziv());
                }
            }
        }
    }

    public static void ispisStudenta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesi broj indeksa studenta");
        int indeks = ulaz.nextInt();
        Student tempStudent = nadjiStudentaPoIndeksu(indeks);
        if(tempStudent == null){
            System.out.println("Student sa tim indeksom ne postoji");
        }
        else {
            System.out.println("Unesite sifru predmeta");
            int sifra = ulaz.nextInt();
            Predmet tempPredmet = nadjiPredmetPoSifri(sifra);
            if(tempPredmet == null){
                System.out.println("Predmet sa tom sifrom ne postoji");
            }
            else{
                if(!tempPredmet.daLiJeStudentNaPredmetu(tempStudent)) {
                    System.out.println("Student nije upisan na taj predmet");
                }
                else {
                    tempPredmet.ispisi(tempStudent);
                    System.out.println(tempStudent + " je ispisan iz predmeta " + tempPredmet.dajNaziv());
                }
            }
        }
    }

    public static void brisanjeStudenta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesi broj indeksa studenta");
        int indeks = ulaz.nextInt();
        Student tempStudent = nadjiStudentaPoIndeksu(indeks);
        if(tempStudent == null){
            System.out.println("Student sa tim indeksom ne postoji");
        }
        else {
            for(int i = 0; i < zadnjiStudent; i++){
                if(tempStudent == studenti[i]){
                    for (int j = i + 1; j < zadnjiStudent; j++){
                        studenti[j-1] = studenti[j];
                    }
                    studenti[zadnjiStudent-1] = null;
                    zadnjiStudent--;
                    obrisiStudentaSaSvihPredmeta(tempStudent);
                    System.out.println(tempStudent + " je obrisan");
                }
            }
        }
    }

    public static void brisanjePredmeta(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesi sifru predmeta");
        int sifra = ulaz.nextInt();
        Predmet tempPredmet = nadjiPredmetPoSifri(sifra);
        if(tempPredmet == null){
            System.out.println("Predmet sa tom sifrom ne postoji");
        }
        else {
            for(int i = 0; i < zadnjiPredmet; i++){
                if(tempPredmet == predmeti[i]){
                    for (int j = i + 1; j < zadnjiPredmet; j++){
                        predmeti[j-1] = predmeti[j];
                    }
                    predmeti[zadnjiPredmet-1] = null;
                    zadnjiPredmet--;
                    System.out.println("Predmet " + tempPredmet.dajNaziv() + " je obrisan");
                }
            }
        }
    }

    public static void ispisStudenataNaPredmetu(){
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesi sifru predmeta");
        int sifra = ulaz.nextInt();
        Predmet tempPredmet = nadjiPredmetPoSifri(sifra);
        if(tempPredmet == null){
            System.out.println("Predmet sa tom sifrom ne postoji");
        }
        else {
            tempPredmet.ispisiListuStudenata();
        }
    }

    public static Predmet nadjiPredmetPoSifri(int sifra){
        for(int i = 0; i < zadnjiPredmet; i++){
            if(predmeti[i].dajSifru() == sifra){
                return predmeti[i];
            }
        }
        return  null;
    }

    public static Student nadjiStudentaPoIndeksu(int indeks){
        for(int i = 0; i < zadnjiStudent; i++){
            if(studenti[i].dajBrojIndeksa() == indeks){
                return studenti[i];
            }
        }
        return  null;
    }

    public static void obrisiStudentaSaSvihPredmeta(Student student){
        for(int i = 0; i < zadnjiPredmet; i++){
            if(predmeti[i].daLiJeStudentNaPredmetu(student))
                predmeti[i].ispisi(student);
        }
    }
}
