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
    void daLiJeStudentNaPredmetuTest()
    {
        Student student = new Student("Berin", "Madzak", 17897);
        Predmet predmet = new Predmet("RPR", 12345, 120);
        predmet.upisi(student);
        assertEquals(true, predmet.daLiJeStudentNaPredmetu(student));
    }

}