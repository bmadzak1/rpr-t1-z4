package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void testKonstruktora(){
        Predmet noviPredmet = new Predmet("RPR", 12345, 120);
        assertEquals("RPR", noviPredmet.nazivPredmeta);
        assertEquals(12345, noviPredmet.sifraPredmeta);
        assertEquals(120, noviPredmet.maksimalanBrojStudenata);
    }

    @Test
    void brojStudenataTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        Predmet predmet = new Predmet("RPR", 12345, 120);
        predmet.upisi(student);
        Student student2 = new Student("Berin2", "Madzak", 17888);
        Student student3 = new Student("Berin3", "Madzak", 17297);
        predmet.upisi(student2);
        predmet.upisi(student3);
        assertEquals(3, predmet.dajTrenutniBrojStudenata());
        predmet.ispisi(student3);
        predmet.ispisi(student);
        assertEquals(1, predmet.dajTrenutniBrojStudenata());
    }

    @Test
    void upisStudentaTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        Predmet predmet = new Predmet("RPR", 12345, 120);
        predmet.upisi(student);
        assertEquals(1, predmet.dajTrenutniBrojStudenata());
    }

    @Test
    void daLiJeStudentNaPredmetuTest() {
        Student student = new Student("Berin", "Madzak", 17897);
        Predmet predmet = new Predmet("RPR", 12345, 120);
        predmet.upisi(student);
        assertTrue(predmet.daLiJeStudentNaPredmetu(student));
    }

    @Test
    void promjenaNazivaTest(){
        Predmet predmet = new Predmet("TP", 24643, 90);
        predmet.promijeniNaziv("RPR");
        assertEquals("RPR", predmet.nazivPredmeta);
    }

    @Test
    void promjenaSifreTest(){
        Predmet predmet = new Predmet("TP", 24643, 90);
        predmet.promijeniSifru(8998);
        assertEquals(8998, predmet.sifraPredmeta);
    }

    @Test
    void ispisStudentaTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        Predmet predmet = new Predmet("RPR", 12345, 120);
        predmet.upisi(student);
        assertEquals(1, predmet.dajTrenutniBrojStudenata());
        predmet.ispisi(student);
        assertEquals(0, predmet.dajTrenutniBrojStudenata());
    }

}