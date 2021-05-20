package fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class FindPath {

    private final Grid grid;

    public FindPath(Grid grid){
        this.grid = grid;
    }

    public boolean createPath(RegattaGoal regattaGoal, Case shipCase){
        int col = shipCase.col();
        int lin = shipCase.line();
        Case targetCase;

        if((targetCase = grid.getCaseOfAPosition(regattaGoal.getPositionActualOptiCheckpoint())) == null || targetCase.getWeight() == -1){
            if((targetCase = grid.getCaseOfAPosition(regattaGoal.getActualCheckpoint().getPosition())) == null || targetCase.getWeight() == -1) {
                do {
                    if (col > 0)
                        col--;
                    else {
                        if (lin > 0)
                            lin--;
                        else {
                            return false;
                        }
                    }
                    targetCase = grid.getCase(col, lin);
                } while (targetCase.getWeight() == -1);
            }
        }

        while (targetCase.getWeight() >= 2){
            targetCase = nextCase(targetCase);
        }

        if(targetCase.getWeight() > 0)
            regattaGoal.createPathPoint(targetCase.getCentralPoint());
        else
            regattaGoal.createPathPoint(null);

        return true;
    }

    public Case nextCase(Case targetCase){
        int col = targetCase.col();
        int lin = targetCase.line();
        double caseWeight = targetCase.getWeight();
        if(grid.getCase(col+1,lin+1) != null && grid.getCase(col+1,lin+1).getWeight() < caseWeight && !grid.getCase(col+1,lin+1).isReef()) {
            caseWeight = grid.getCase(col+1, lin+1).getWeight();
            targetCase = grid.getCase(col+1,lin+1);
        }
        if(grid.getCase(col+1,lin-1) != null && grid.getCase(col+1,lin-1).getWeight() < caseWeight && !grid.getCase(col+1,lin-1).isReef()) {
            caseWeight = grid.getCase(col+1, lin-1).getWeight();
            targetCase = grid.getCase(col+1,lin-1);
        }
        if(grid.getCase(col+1,lin) != null && grid.getCase(col+1,lin).getWeight() < caseWeight && !grid.getCase(col+1,lin).isReef()) {
            caseWeight = grid.getCase(col+1, lin).getWeight();
            targetCase = grid.getCase(col+1,lin);
        }
        if(grid.getCase(col-1,lin+1) != null && grid.getCase(col-1,lin+1).getWeight() < caseWeight && !grid.getCase(col-1,lin+1).isReef()) {
            caseWeight = grid.getCase(col-1, lin+1).getWeight();
            targetCase = grid.getCase(col-1,lin+1);
        }
        if(grid.getCase(col-1,lin-1) != null && grid.getCase(col-1,lin-1).getWeight() < caseWeight && !grid.getCase(col-1,lin-1).isReef()) {
            caseWeight = grid.getCase(col-1, lin-1).getWeight();
            targetCase = grid.getCase(col-1,lin-1);
        }
        if(grid.getCase(col-1,lin) != null && grid.getCase(col-1,lin).getWeight() < caseWeight && !grid.getCase(col-1,lin).isReef()) {
            caseWeight = grid.getCase(col-1, lin).getWeight();
            targetCase = grid.getCase(col-1,lin);
        }
        if(grid.getCase(col,lin+1) != null && grid.getCase(col,lin+1).getWeight() < caseWeight && !grid.getCase(col,lin+1).isReef()) {
            caseWeight = grid.getCase(col, lin+1).getWeight();
            targetCase = grid.getCase(col,lin+1);
        }
        if(grid.getCase(col,lin-1) != null && grid.getCase(col,lin-1).getWeight() < caseWeight && !grid.getCase(col,lin-1).isReef()) {
            targetCase = grid.getCase(col,lin-1);
        }
        return targetCase;
    }
}