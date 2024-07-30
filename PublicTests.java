package tests;

// (c) Larry Herman, 2024.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

/* The tests of getPaycheckAmount() use a form of assertEquals() is used to
 * compare two floating-point (real) numbers, which has three arguments:
 * assertEquals(double1, double2, delta).  It will say that the two doubles
 * are equal if their values are within delta of each other.  For instance,
 * a call like assertEquals(2.5, 2.501, 0.01) will be true, while
 * assertEquals(2.5, 2.55, 0.01) will fail.  Comparing real numbers this way
 * is needed due to the imprecision involved with doing arithmetic with
 * them.
 */

/* Although the project grading policies say not to use the form of import
 * using '*' (you should use explicit imports instead), we have to use it in
 * the next line here, because we don't know what classes different students
 * will write in the taPayrollManagerSystem package, so we can't explicitly
 * import them.
 */
import taPayrollManagerSystem.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

    // Tests the basic operation of the LarryList class.
    @Test public void testPublic1() {
        LarryList list1= new LarryList(5);
        LarryList list2= new LarryList(5);
        LarryList list3;

        list1.add(132);  // adding an Integer
        list1.add("giraffe");  // adding a String
        list1.add(true);  // adding a boolean
        list2.add(list1);  // we can even add a LarryList to a LarryList!

        assertEquals(5, list1.getCurrCapacityAmt());
        assertEquals(5, list2.getCurrCapacityAmt());
        assertEquals(2, list1.numCanBeAdded());
        assertEquals(4, list2.numCanBeAdded());

        list3= (LarryList) list2.get(0);
        // note casting the Object references returned by get() to the
        // actual types of the objects being returned
        assertEquals(Integer.valueOf(132), (Integer) list3.get(0));
        assertEquals("giraffe", (String) list3.get(1));
        assertTrue((Boolean) list3.get(2));
        assertTrue(list2.get(0) instanceof LarryList);
    }

    // Just tests creating some ARegularCourse objects and calling
    // getCourseName() on them.
    @Test public void testPublic2() {
        ARegularCourse cmsc132=
            SomeUniversity.createADifferentialCourse("CMSC", 132, 10);
        ARegularCourse math140=
            SomeUniversity.createARegularCourse("MATH", 140, 8);

        assertEquals("CMSC 132", cmsc132.getCourseName());
        assertEquals("MATH 140", math140.getCourseName());
    }

    // Tests calling extraCapacity().
    @Test public void testPublic3() {
        assertEquals(2, TestData.stat400().extraCapacity());
    }

    // Tests the basic operation of getTACapacity().
    @Test public void testPublic4() {
        ARegularCourse engl101= TestData.engl101();
        ARegularCourse psyc100= TestData.psyc100();

        assertEquals(6, engl101.getTACapacity());
        assertEquals(20, psyc100.getTACapacity());
    }

    // Tests calling addUGTA() and addGradTA() to try to hire
    // TAs with the same names as existing TAs.
    @Test public void testPublic5() {
        ARegularCourse psyc100= TestData.psyc100();

        assertFalse(psyc100.addGradTA("Shelly", "Sheep", 19530.0));
        assertFalse(psyc100.addUGTA("Sophie", "Sophomore", 16.0));

        assertEquals(10, psyc100.extraCapacity());
    }

    // Tests trying to hire TAs beyond courses' capacities.
    @Test public void testPublic6() {
        ARegularCourse engl101= TestData.engl101();
        ARegularCourse cmsc132= TestData.cmsc132();

        // non-differential-tuition course
        assertFalse(engl101.addUGTA("Leanne", "Learner", 14.65));
        assertEquals(0, engl101.extraCapacity());
        assertEquals(6, engl101.getTACapacity());

        // differential-tuition course
        assertTrue(cmsc132.addGradTA("Leanne", "Learner", 17010.0));
        assertEquals(2, cmsc132.extraCapacity());
        assertEquals(6, cmsc132.getTACapacity());
    }

    // Tests the basic operation of holdSomeOfficeHours() and
    // numOfficeHoursHeld().
    @Test public void testPublic7() {
        ARegularCourse arec365= TestData.arec365();

        assertEquals(16, arec365.numOfficeHoursHeld("Freddy", "Frog"));
        assertEquals(14, arec365.numOfficeHoursHeld("Peggy", "Penguin"));
        assertEquals(12, arec365.numOfficeHoursHeld("Shelly", "Sheep"));
        assertEquals(10, arec365.numOfficeHoursHeld("Wally", "Walrus"));
    }

    // Tests the basic operation of gradeProjects() and numProjectsGraded().
    @Test public void testPublic8() {
        ARegularCourse cmsc250= TestData.cmsc250();

        assertEquals(44, cmsc250.numProjectsGraded("Emily", "Emu"));
        assertEquals(30, cmsc250.numProjectsGraded("Manuel", "Manatee"));
        assertEquals(32, cmsc250.numProjectsGraded("Otto", "Otter"));
        assertEquals(20, cmsc250.numProjectsGraded("Rhianna",
                                                   "Rhinoceros"));
    }

    // Tests an undergraduate TA trying to hold more than 20 hours of office
    // hours.
    @Test public void testPublic9() {
        ARegularCourse bmgt110=
            SomeUniversity.createARegularCourse("BMGT", 110, 10);

        bmgt110.addUGTA("Sheena", "Sheep", 13.90);

        assertTrue(bmgt110.holdSomeOfficeHours("Sheena", "Sheep", 19));
        assertFalse(bmgt110.holdSomeOfficeHours("Sheena", "Sheep", 2));
        assertEquals(19, bmgt110.numOfficeHoursHeld("Sheena", "Sheep"));
    }

    // Tests a graduate TA trying to grade more than 150 projects.
    @Test public void testPublic10() {
        ARegularCourse hist131=
            SomeUniversity.createARegularCourse("HIST", 131, 10);

        hist131.addGradTA("Arthur", "Aardvark", 21210.0);

        assertTrue(hist131.gradeProjects("Arthur", "Aardvark", 100));
        assertTrue(hist131.gradeProjects("Arthur", "Aardvark", 40));
        assertFalse(hist131.gradeProjects("Arthur", "Aardvark", 20));
        assertEquals(140, hist131.numProjectsGraded("Arthur", "Aardvark"));
    }

    // Tests the basic operation of getPaycheckAmount() for an undergraduate
    // TA who has held some office hours.
    @Test public void testPublic11() {
        ARegularCourse arec365= TestData.arec365();

        assertEquals(192.0, arec365.getPaycheckAmount("Shelly", "Sheep"),
                     0.0001);
    }

    // Tests the basic operation of getPaycheckAmount() for an undergraduate
    // TA who has graded some projects.
    @Test public void testPublic12() {
        ARegularCourse cmsc250= TestData.cmsc250();

        assertEquals(133.5, cmsc250.getPaycheckAmount("Rhianna",
                                                      "Rhinoceros"),
                     0.0001);
    }

    // Tests the basic operation of getPaycheckAmount() for a graduate TA
    // who has held some office hours.
    @Test public void testPublic13() {
        ARegularCourse arec365= TestData.arec365();

        assertEquals(950.0, arec365.getPaycheckAmount("Peggy", "Penguin"),
                     0.0001);
    }

    // Tests the basic operation of getPaycheckAmount() for a graduate TA
    // who has graded some projects.
    @Test public void testPublic14() {
        ARegularCourse cmsc250= TestData.cmsc250();

        assertEquals(870.0, cmsc250.getPaycheckAmount("Emily", "Emu"),
                     0.0001);
    }

    // Tests nonexistent TAs trying to hold office hours and grade projects.
    @Test public void testPublic15() {
        ARegularCourse cmsc250= TestData.cmsc250();

        assertFalse(cmsc250.holdSomeOfficeHours("Antonio", "Antelope", 1));
        assertFalse(cmsc250.gradeProjects("Quinn", "Quokka", 1));
    }

}
