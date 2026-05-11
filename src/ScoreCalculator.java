public class ScoreCalculator {

    public double calculateMetricScore(Metric m) {
        return m.calculateScore();
    }

    public double calculateDimensionScore(Dimension d) {
        return d.calculateDimensionScore();
    }
}