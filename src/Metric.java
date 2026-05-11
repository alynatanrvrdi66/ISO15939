public class Metric {
    private String name;
    private double coefficient;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;

    private double value;
    private double score;

    public Metric(String name,double coefficient,String direction,double minValue,
                  double maxValue,String unit,double value){
        this.name=name;
        this.coefficient=coefficient;
        this.direction=direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.value = value;
    }
    public String getName() {
        return name; }
    public double getCoefficient() {
        return coefficient; }
    public String getDirection() {
        return direction; }
    public double getMinValue() {
        return minValue; }
    public double getMaxValue() {
        return maxValue; }
    public String getUnit() {
        return unit; }
    public double getValue() {
        return value; }
    public double getScore() {
        return score; }

    public void setName(String name) {
        this.name = name; }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient; }
    public void setDirection(String direction) {
        this.direction = direction; }
    public void setMinValue(double minValue) {
        this.minValue = minValue; }
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue; }
    public void setUnit(String unit) {
        this.unit = unit; }
    public void setValue(double value) {
        this.value = value; }
    public void setScore(double score) {
        this.score = score; }

    public double calculateScore(){
        if(getDirection().equals("Higher")){
            score = 1 + (value - minValue)/(maxValue - minValue) * 4;
        }
        else if(getDirection().equals("Lower")){
            score = 5 - (value - minValue)/(maxValue - minValue) * 4;
        }
        score = 2 * score;
        score = Math.round(score);
        score = score / 2;

        return score;
    }
}
