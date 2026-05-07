import java.util.ArrayList;

public class Scenario {
    private String name;
    private String mode;
    private ArrayList<Dimension> dimensions;

    public Scenario(String name,String mode){
        this.name = name;
        this.mode = mode;
    }
    public void addDimension(Dimension dimension){
        dimensions.add(dimension);
    }
    public ArrayList<Dimension> getDimensions(){
        return dimensions;
    }
}
