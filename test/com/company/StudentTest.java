package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void konstruktorTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        assertEquals("Berin", student.ime);
        assertEquals("Madzak", student.prezime);
        assertEquals(17897, student.brojIndeksa);
    }

    @Test
    void toStringTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        assertEquals("Madzak Berin (17897)", student.toString());
    }

    @Test
    void promjenaPodatakaTest(){
        Student student = new Student("Berin", "Madzak", 17897);
        student.promijeniIme("Nireb");
        assertEquals("Nireb", student.ime);
        student.promijeniPrezime("Kadzam");
        assertEquals("Kadzam", student.prezime);
        student.promijeniBrojIndeksa(79871);
        assertEquals(79871, student.brojIndeksa);
    }

}