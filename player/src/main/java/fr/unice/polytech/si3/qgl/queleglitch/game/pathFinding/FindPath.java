package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

public class FindPath {

    private final Grid grid;

    public FindPath(Grid grid){
        this.grid = grid;
    }

    public void createPath(RegattaGoal regattaGoal, int[] columnLineOfShip){
        regattaGoal.resetPathPoints();
        Point virtualCheckpoint = regattaGoal.getPositionActualOptiCheckpoint().toPoint();
        int[] columnLineOfCheckpoint;

        if((columnLineOfCheckpoint = grid.getColAndLineOfAPosition(virtualCheckpoint.toPosition())) == null){
            do{
                if(columnLineOfShip[0] > 0)
                    columnLineOfShip[0]--;
                else{
                    if(columnLineOfShip[1] > 0)
                        columnLineOfShip[1]--;
                    else{
                        columnLineOfShip[1]++;
                    }
                }
            }while (grid.getCase(columnLineOfShip[0],columnLineOfShip[1]).isReef());
            virtualCheckpoint = grid.getCase(columnLineOfShip[0],columnLineOfShip[1]).getCentralPoint();
            columnLineOfCheckpoint = columnLineOfShip;
        }

        int col = columnLineOfCheckpoint[0];
        int lin = columnLineOfCheckpoint[1];
        int caseWeight;
        while ((caseWeight = grid.getCase(col,lin).getWeight()) != 0){
            if(grid.getCase(col+1,lin+1) != null && grid.getCase(col+1,lin+1).getWeight() < caseWeight && !grid.getCase(col+1,lin+1).isReef()) {
                caseWeight = grid.getCase(col+1, lin+1).getWeight();
                virtualCheckpoint = grid.getCase(col+1,lin+1).getCentralPoint();
            }
            if(grid.getCase(col+1,lin-1) != null && grid.getCase(col+1,lin-1).getWeight() < caseWeight && !grid.getCase(col+1,lin-1).isReef()) {
                caseWeight = grid.getCase(col+1, lin-1).getWeight();
                virtualCheckpoint = grid.getCase(col+1,lin-1).getCentralPoint();
            }
            if(grid.getCase(col+1,lin) != null && grid.getCase(col+1,lin).getWeight() < caseWeight && !grid.getCase(col+1,lin).isReef()) {
                caseWeight = grid.getCase(col+1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col+1,lin).getCentralPoint();
            }
            if(grid.getCase(col-1,lin+1) != null && grid.getCase(col-1,lin+1).getWeight() < caseWeight && !grid.getCase(col-1,lin+1).isReef()) {
                caseWeight = grid.getCase(col-1, lin+1).getWeight();
                virtualCheckpoint = grid.getCase(col-1,lin+1).getCentralPoint();
            }
            if(grid.getCase(col-1,lin-1) != null && grid.getCase(col-1,lin-1).getWeight() < caseWeight && !grid.getCase(col-1,lin-1).isReef()) {
                caseWeight = grid.getCase(col-1, lin-1).getWeight();
                virtualCheckpoint = grid.getCase(col-1,lin-1).getCentralPoint();
            }
            if(grid.getCase(col-1,lin) != null && grid.getCase(col-1,lin).getWeight() < caseWeight && !grid.getCase(col-1,lin).isReef()) {
                caseWeight = grid.getCase(col-1, lin).getWeight();
                virtualCheckpoint = grid.getCase(col-1,lin).getCentralPoint();
            }
            if(grid.getCase(col,lin+1) != null && grid.getCase(col,lin+1).getWeight() < caseWeight && !grid.getCase(col,lin+1).isReef()) {
                caseWeight = grid.getCase(col, lin+1).getWeight();
                virtualCheckpoint = grid.getCase(col,lin+1).getCentralPoint();
            }
            if(grid.getCase(col,lin-1) != null && grid.getCase(col,lin-1).getWeight() < caseWeight && !grid.getCase(col,lin-1).isReef()) {
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