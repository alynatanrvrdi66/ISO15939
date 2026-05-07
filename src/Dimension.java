import java.util.ArrayList;
import java.util.List;

public class Dimension {
    private String name;
    private double coefficient;
    private ArrayList<Metric> metrics;
    private double Dscore;

    public Dimension(String name,double coefficient,List<Metric> metrics,double Dscore){
        this.name = name;
        this.coefficient = coefficient;
        this.metrics = new ArrayList<>();
        this.Dscore = 0;
    }
    public void addMetric(Metric metric){
    metrics.add(metric);
    }
    public double calculateDimensionScore(){
        double totalScore = 0;
        double totalCoefficient = 0;
        for(Metric metric : metrics){
            metric.calculateScore();
            totalScore += metric.getScore() * metric.getCoefficient();
            totalCoefficient += metric.getCoefficient();
    }
        Dscore = totalScore / totalCoefficient;
        return Dscore;
    }
    public String getName() {
        return name; }
    public double getCoefficient() {
        return coefficient; }
    public double getScore() {
        return Dscore; }
    public ArrayList<Metric> getMetrics(){
        return metrics;
    }

    public void setName(String name) {
        this.name = name; }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient; }
    public void setScore(double Dscore) {
        this.Dscore = Dscore; }

}
