package fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Case {

    private final Point centralPoint;
    private boolean isStream = false;
    private boolean isReef = false;
    private final Rectangle form;
    private double weight = -1;
    private final int column;
    private final int line;

    public Case(Rectangle form, Point centralPoint, int column, int line) {
        this.centralPoint = centralPoint;
        this.column = column;
        this.line = line;
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

    public double getWeight() {
        return weight;
    }

    public int col() { return column; }

    public int line() { return line; }

    /**
     * <p>Setter.</p>
     */
    public void setWeight(double caseWeight) { this.weight = caseWeight; }

    public void setIsStream(boolean stream) {
        isStream = stream;
    }

    public void setIsReef(boolean reef) { isReef = reef; }
}
