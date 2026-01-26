import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.StudentAnalyzer;

public class StudentAnalyzerTest {

    // ===== KIỂM THỬ CƠ BẢN - countExcellentStudents =====
    
    @Test
    public void testCountExcellentStudents_nullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(null));
    }

    @Test
    public void testCountExcellentStudents_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCountExcellentStudents_allExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0, 9.5, 10.0);
        assertEquals(3, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_noneExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(5.0, 6.0, 7.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_mixedWithNull() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.5, null, 9.0, 7.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_allNulls() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(null, null, null);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // ===== KIỂM THỬ GIÁ TRỊ BIÊN - countExcellentStudents =====
    
    @Test
    public void testCountExcellentStudents_boundary_lowerLimit() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(7.9, 7.99, 8.0);
        assertEquals(1, analyzer.countExcellentStudents(scores), "Only 8.0 is excellent");
    }

    @Test
    public void testCountExcellentStudents_boundary_upperLimit() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0, 10.0001, 10.01);
        assertEquals(1, analyzer.countExcellentStudents(scores), "Only 10.0 is excellent");
    }

    @Test
    public void testCountExcellentStudents_boundary_precision() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.00001, 10.0000001);
        assertEquals(0, analyzer.countExcellentStudents(scores), "Both exceed 10.0");
    }

    // ===== KIỂM THỬ PHÂN VÙNG TƯƠNG ĐƯƠNG - countExcellentStudents =====
    
    @Test
    public void testCountExcellentStudents_equivalence_lowExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(8.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_equivalence_midExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_equivalence_highExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(10.0);
        assertEquals(1, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_equivalence_nonExcellent() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 5.0, 7.9);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_equivalence_invalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-5.0, 12.5);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // ===== KIỂM THỬ CƠ BẢN - calculateValidAverage =====
    
    @Test
    public void testCalculateValidAverage_nullList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.001);
    }

    @Test
    public void testCalculateValidAverage_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }

    @Test
    public void testCalculateValidAverage_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 5.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_someValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(5.0, -1.0, 10.0, 11.5);
        assertEquals(7.5, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_allInvalid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-5.0, 11.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_withNulls() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(null, 6.0, null, 8.0);
        assertEquals(7.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_allNulls() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(null, null, null);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ===== KIỂM THỬ GIÁ TRỊ BIÊN - calculateValidAverage =====
    
    @Test
    public void testCalculateValidAverage_boundary_exactBounds() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_boundary_outsideBounds() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(-0.01, 0.0, 10.0, 10.01);
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_boundary_precision() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(5.0, 10.00000001);  // 10.00000001 phải bị loại
        assertEquals(5.0, analyzer.calculateValidAverage(scores), 0.00001, "Should exclude 10.00000001 (> 10.0)");
    }

    @Test
    public void testCalculateValidAverage_boundary_mixedPrecision() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.9999, 10.0, 10.0001);
        assertEquals(9.99995, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ===== KIỂM THỬ PHÂN VÙNG TƯƠNG ĐƯƠNG - calculateValidAverage =====
    
    @Test
    public void testCalculateValidAverage_equivalence_mixedScores() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }

}
