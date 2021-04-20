package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

public class FindPath {

    private final Grid grid;

    public FindPath(Grid grid){
        this.grid = grid;
    }

    public void createPath(RegattaGoal regattaGoal){
        regattaGoal.resetPathPoints();
        int[] columnLineOfCheckpoint = grid.getColAndLineOfAPosition(regattaGoal.getPositionActualOptiCheckpoint());
        if(columnLineOfCheckpoint == null)
            return;
        int col = columnLineOfCheckpoint[0];
        int lin = columnLineOfCheckpoint[1];
        int caseWeight;
        Point virtualCheckpoint = regattaGoal.getPositionActualOptiCheckpoint().toPoint();
        while ((caseWeight = grid.getCase(col,lin).getWeight()) > 0){
            if(col+1 < grid.getNB_COL() && grid.getCase(col+1,lin).getWeight() < caseWeight && !grid.getCase(col+1,lin).isReef()) {
                caseWeight = grid.getCase(col+1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col+1,lin).getCentralPoint();
            }
            if(lin+1 < grid.getNB_LIN() && grid.getCase(col,lin+1).getWeight() < caseWeight && !grid.getCase(col,lin+1).isReef()) {
                caseWeight = grid.getCase(col, lin+1).getWeight();
                virtualCheckpoint = grid.getCase(col,lin+1).getCentralPoint();
            }
            if(col-1 >= 0 && grid.getCase(col-1,lin).getWeight() < caseWeight && !grid.getCase(col-1,lin).isReef()) {
                caseWeight = grid.getCase(col-1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col-1,lin).getCentralPoint();
            }
            if(lin-1 >= 0 && grid.getCase(col,lin-1).getWeight() < caseWeight && !grid.getCase(col,lin-1).isReef()) {
                virtualCheckpoint = grid.getCase(col,lin-1).getCentralPoint();
            }
            if(grid.getCaseOfAPosition(virtualCheckpoint.toPosition()).getWeight() > 0) {
                regattaGoal.addPathPoints(virtualCheckpoint);
            }
            columnLineOfCheckpoint = grid.getColAndLineOfAPosition(virtualCheckpoint.toPosition());
            col = columnLineOfCheckpoint[0];
            lin = columnLineOfCheckpoint[1];
        }
    }
}