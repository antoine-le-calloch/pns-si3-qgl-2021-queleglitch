package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Grid {

    private final int GRID_SIDE = 5000;
    private final int CASE_WIDTH = 30;
    private final int CASE_HEIGHT = 165;
    private final int NB_COL = GRID_SIDE/CASE_HEIGHT;
    private final int NB_LIN = GRID_SIDE/CASE_WIDTH;
    private final Case[][] grid = new Case[NB_COL][NB_LIN];

    public void create(Position shipPosition, Position checkpointPosition, SeaEntities seaEntities){
        double gridOrientation = shipPosition.getAngleToAPosition(checkpointPosition);
        Rectangle caseForm = new Rectangle(CASE_WIDTH,CASE_HEIGHT,gridOrientation);
        Spotting spotting = new Spotting(seaEntities.getVisibleReefs());

        for (int lin = 0, col = 0; col < NB_COL; lin = (lin+1)%NB_LIN, col += (lin==0)?1:0) {
            grid[col][lin] = new Case(caseForm,findNextCaseCentralPoint(col,lin,gridOrientation,shipPosition));
            if(spotting.isReefsInaARectangle(caseForm, grid[col][lin].getCentralCasePoint()))
                grid[col][lin].setIsReef(true);
        }
        processCaseWeight(shipPosition);
    }

    public Point findNextCaseCentralPoint(int column, int line, double gridOrientation, Position shipPosition){
        double opposite = GRID_SIDE/2.0-CASE_WIDTH/2.0-line*CASE_WIDTH;
        double adjacent = GRID_SIDE/2.0-CASE_HEIGHT/2.0-column*CASE_HEIGHT;
        double angle = gridOrientation + Math.atan(opposite/adjacent);
        double hypo = Math.sqrt(Math.pow(opposite,2) + Math.pow(adjacent,2));
        double x = shipPosition.getX() + Math.cos(angle)*hypo;
        double y = shipPosition.getY() + Math.sin(angle)*hypo;
        return new Point(x,y);
    }

    public void processCaseWeight(Position shipPosition) {
        int[] columnLine = getColAndLineOfAPosition(shipPosition);
        processCaseWeightByColAndLin(columnLine[0],columnLine[1],0);
    }

    public void processCaseWeightByColAndLin(int column, int line, int weight){
        if(column >= NB_COL || line >= NB_LIN || column < 0 || line < 0)
            return;
        if(grid[column][line].isReef() || (grid[column][line].getCaseWeight() != -1 && grid[column][line].getCaseWeight() < weight))
            return;
        grid[column][line].setCaseWeight(weight);
        processCaseWeightByColAndLin(column+1,line,weight+1);
        processCaseWeightByColAndLin(column,line+1,weight+1);
        processCaseWeightByColAndLin(column-1,line,weight+1);
        processCaseWeightByColAndLin(column,line-1,weight+1);
    }

    public int[] getColAndLineOfAPosition(Position shipPosition) {
        int[] columnLine = new int[]{0,0};
        while (!Geometry.isThisPointInARectangle(shipPosition.toPoint(),grid[columnLine[0]][columnLine[1]].getCasePoints())){
            if(columnLine[1] == NB_LIN)
                columnLine[1] = 0;
            else
                columnLine[1] ++;
            columnLine[0] += (columnLine[1]==0)?1:0;
        }
        return columnLine;
    }

    public Case getCaseOfAPosition(Position shipPosition) {
        int[] columnLine = new int[]{0,0};
        while (!Geometry.isThisPointInARectangle(shipPosition.toPoint(),grid[columnLine[0]][columnLine[1]].getCasePoints())){
            columnLine[1] += (columnLine[1]==NB_LIN)?-columnLine[1]:1;
            columnLine[0] += (columnLine[1]==0)?1:0;
        }
        return grid[columnLine[0]][columnLine[1]];
    }

    public Case[][] getGrid(){
        return grid;
    }

    public Case getCase(int col, int lin){
        return grid[col][lin];
    }
}
