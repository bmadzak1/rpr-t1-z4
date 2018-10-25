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

}