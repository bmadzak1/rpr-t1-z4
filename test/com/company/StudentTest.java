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

}