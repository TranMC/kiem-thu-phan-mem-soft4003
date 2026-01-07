package java;
public class StudentAnalyzer {

    public int countExcellentStudents(List<Double> scores) {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (Double score : scores) {
            if (score == null) continue;
            if (score >= 0 && score <= 10 && score >= 8.0) {
                count++;
            }
        }
        return count;
    }

    public static double calculateValidAverage(double[] scores) {
        return 0;
    }
}
