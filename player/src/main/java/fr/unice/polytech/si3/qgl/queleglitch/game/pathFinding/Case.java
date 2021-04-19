package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Case {

    private final Point centralPoint;
    private final Rectangle form;
    private int weight = -1;
    private boolean isReef = false;
    private boolean isStream = false;

    public Case(Rectangle form, Point centralPoint) {
        this.centralPoint = centralPoint;
        this.form = form;
    }

    public Point[] getFormPoints(){
        return form.getRealPoints(centralPoint);
    }

    /**
     * <p>Getter.</p>
     */
    public boolean isReef() {
        return isReef;
    }

    public boolean isStream() {
        return isStream;
    }

    public Point getCentralPoint() {
        return centralPoint;
    }

    public Rectangle getForm() {
        return form;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * <p>Setter.</p>
     */
    public void setWeight(int caseWeight) {
        this.weight = caseWeight;
    }

    public void setIsReef(boolean reef) {
        isReef = reef;
    }

    public void setIsStream(boolean stream) {
        isStream = stream;
    }
}
