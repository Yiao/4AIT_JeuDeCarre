package App.Classes;

/**
 * Created by sya on 5/22/2017.
 */
public class Case {
    int  poids=0;
    //color case par défault
    String color ="#FFFFFF";
    Traits traits = new Traits();
    Position positionCase = new Position();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Traits getTraits() {
        return traits;
    }

    public void setTraits(Traits traits) {
        this.traits = traits;
    }

    public Position getPositionCase() {
        return positionCase;
    }

    public void setPositionCase(Position positionCase) {
        this.positionCase = positionCase;
    }
}
