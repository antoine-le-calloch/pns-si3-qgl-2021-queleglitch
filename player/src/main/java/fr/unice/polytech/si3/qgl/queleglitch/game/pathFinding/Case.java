package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Case {

    private final Point centralCasePoint;
    private final Rectangle caseForm;
    private int caseWeight = -1;
    private boolean isReef = false;
    private boolean isStream = false;

    public Case(Rectangle caseForm, Point centralCasePoint) {
        this.centralCasePoint = centralCasePoint;
        this.caseForm = caseForm;
    }

    public Point[] getCasePoints(){
        return caseForm.getRealPoints(centralCasePoint);
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

    public Point getCentralCasePoint() {
        return centralCasePoint;
    }

    public Rectangle getCaseForm() {
        return caseForm;
    }

    public int getCaseWeight() {
        return caseWeight;
    }

    /**
     * <p>Setter.</p>
     */
    public void setCaseWeight(int caseWeight) {
        this.caseWeight = caseWeight;
    }

    public void setIsReef(boolean reef) {
        isReef = reef;
    }

    public void setIsStream(boolean stream) {
        isStream = stream;
    }
}
