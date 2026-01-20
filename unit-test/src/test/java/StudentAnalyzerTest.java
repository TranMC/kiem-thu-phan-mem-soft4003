import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.StudentAnalyzer;

public class StudentAnalyzerTest {


    @Test
    public void testCountExcellentStudents_validScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, 9.5, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }


    @Test
    public void testCountExcellentStudents_negativeScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-1.0, -5.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }


    @Test
    public void testCountExcellentStudents_overMaxScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.5, 11.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }


    @Test
    public void testCountExcellentStudents_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }


    @Test
    public void testCountExcellentStudents_nullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_boundaryBelowExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(7.9, 7.99); 
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }


    @Test
    public void testCalculateValidAverage_validScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(6.0, 8.0, 10.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }


    @Test
    public void testCalculateValidAverage_mixedScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }


    @Test
    public void testCalculateValidAverage_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-2.0, 11.0, 20.0);
        assertEquals(0, analyzer.calculateValidAverage(scores), 0.001);
    }


    @Test
    public void testCalculateValidAverage_boundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }


    @Test
    public void testCalculateValidAverage_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }


    @Test
    public void testCalculateValidAverage_nullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.calculateValidAverage(null), 0.001);
    }

    //Kiểm thử kỹ thuật biên JUnit
    @Test
    public void testCountExcellentStudents_scoreJustAboveMax() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0001, 10.01); 
        assertEquals(0, analyzer.countExcellentStudents(scores), "10.0001 should not be excellent");
    }

    @Test
    public void testCountExcellentStudents_listWithNullElements() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.5, null, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), "Should ignore null values and count valid ones");
    }
    @Test
    public void testCalculateValidAverage_boundaryEpsilon() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-0.01, 0.0, 10.0, 10.01);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001, "Should exclude -0.01 and 10.01");
    }

    @Test
    public void testCalculateValidAverage_listWithNullElements() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0, null, 5.0); 
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001);
    }
    @Test
    public void testCountExcellentStudents_containsNullElements() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, null, 6.5); 
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCalculateValidAverage_containsNullElements() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, null, 10.0);
        assertEquals(9.0, analyzer.calculateValidAverage(scores), 0.001);
    }

}
