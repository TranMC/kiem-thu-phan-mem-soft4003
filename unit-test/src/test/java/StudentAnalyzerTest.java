import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.StudentAnalyzer;

public class StudentAnalyzerTest {

    @Test
    public void testCountExcellentStudents_normalCase() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_allValid() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(3, analyzer.countExcellentStudents(Arrays.asList(8.0, 9.0, 10.0)));
    }

    @Test
    public void testCountExcellentStudents_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()));
    }

    @Test
    public void testCalculateValidAverage_mixedValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        double avg = analyzer.calculateValidAverage(
                Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0)
        );
        assertEquals(8.17, avg, 0.01);
    }

    @Test
    public void testCalculateValidAverage_boundaryValues() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(5.0,
                analyzer.calculateValidAverage(Arrays.asList(0.0, 10.0)),
                0.001);
    }

    @Test
    public void testCalculateValidAverage_emptyList() {
        StudentAnalyzer analyzer = new StudentAnalyzer();
        assertEquals(0,
                analyzer.calculateValidAverage(Collections.emptyList()),
                0.001);
    }
}
