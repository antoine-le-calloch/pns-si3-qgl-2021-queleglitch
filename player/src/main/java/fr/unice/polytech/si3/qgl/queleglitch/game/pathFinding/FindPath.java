package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

public class FindPath {

    private Grid grid;

    public FindPath(Grid grid){
        this.grid = grid;
    }

    public void createPath(RegattaGoal regattaGoal){
        regattaGoal.resetPathPoints();
        int[] columnLineOfCheckpoint = grid.getColAndLineOfAPosition(regattaGoal.getPositionActualOptiCheckpoint());
        int col = columnLineOfCheckpoint[0];
        int lin = columnLineOfCheckpoint[1];
        int caseWeight;
        Point virtualCheckpoint = regattaGoal.getPositionActualOptiCheckpoint().toPoint();
        while ((caseWeight = grid.getCase(col,lin).getWeight()) > 0){
            if(grid.getCase(col+1,lin).getWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col+1,lin).getCentralPoint();
            }
            if(grid.getCase(col,lin+1).getWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col,lin+1).getCentralPoint();
            }
            if(grid.getCase(col-1,lin).getWeight() < caseWeight) {
                caseWeight = grid.getCase(col + 1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col-1,lin).getCentralPoint();
            }
            if(grid.getCase(col,lin-1).getWeight() < caseWeight) {
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