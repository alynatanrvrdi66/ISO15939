import java.util.ArrayList;

public class Scenario {
    private String name;
    private String mode;
    private ArrayList<Dimension> dimensions;

    public Scenario(String name,String mode){
        this.name = name;
        this.mode = mode;
        dimensions = new ArrayList<>();
    }
    public void addDimension(Dimension dimension){
        dimensions.add(dimension);
    }
    public ArrayList<Dimension> getDimensions(){
        return dimensions;
    }
    public String getName() {
        return name;
    }
    public String getMode() {
        return mode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
}
