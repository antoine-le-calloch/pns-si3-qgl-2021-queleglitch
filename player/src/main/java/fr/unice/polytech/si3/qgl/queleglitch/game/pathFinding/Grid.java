package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Grid {

    private final int GRID_SIDE;
    private final int CASE_WIDTH;
    private final int CASE_HEIGHT;
    private final int NB_COL;
    private final int NB_LIN;
    private final Case[][] grid;

    public Grid(int gridSide, int caseWidth, int caseHeight){
        this.GRID_SIDE = gridSide;
        this.CASE_WIDTH = caseWidth;
        this.CASE_HEIGHT = caseHeight;
        NB_COL = GRID_SIDE/CASE_HEIGHT;
        NB_LIN = GRID_SIDE/CASE_WIDTH;
        grid = new Case[NB_COL][NB_LIN];
    }

    public void create(Point centralGridPoint, Point checkpointPosition, Spotting spotting){
        double gridOrientation = centralGridPoint.getAngleToAPoint(checkpointPosition);
        Rectangle caseForm = new Rectangle(CASE_WIDTH,CASE_HEIGHT,gridOrientation);
        int lin = 0, col = 0;

        while (col < NB_COL/2.0){
            Point[] points = findCasePoints(col,lin,gridOrientation,centralGridPoint);
            for (int i = 0; i < points.length; i++) {
                int newCol = col;
                int newLin = lin;
                switch (i) {
                    case 1: newCol = NB_COL-col-1;
                            newLin = lin;
                            break;
                    case 2: newCol = NB_COL-col-1;
                            newLin = NB_LIN-lin-1;
                            break;
                    case 3: newCol = col;
                            newLin = NB_LIN-lin-1;
                            break;
                    default: break;
                }
                Case newCase = new Case(caseForm,points[i],newCol,newLin);
                if(spotting.isReefsInARectangle(newCase.getForm().getRealPoints(newCase.getCentralPoint())))
                    newCase.setIsReef(true);
                grid[newCol][newLin] = newCase;
            }
            lin++;
            if(lin > NB_LIN/2.0){
                lin = 0;
                col++;
            }
        }
    }

    public Point[] findCasePoints(int column, int line, double gridOrientation, Point centralGridPoint){
        double width = GRID_SIDE-CASE_WIDTH-line*CASE_WIDTH*2;
        double height = GRID_SIDE-CASE_HEIGHT-column*CASE_HEIGHT*2;
        Rectangle rectangle = new Rectangle(width,height,gridOrientation);
        return rectangle.getRealPoints(centralGridPoint);
    }

    public void processCaseWeight(Point startPoint) {
        Case startCase;
        if((startCase = getCaseOfAPosition(startPoint.toPosition())) != null)
            processCaseWeightByColAndLin(startCase.col(),startCase.line(),0);
    }

    public void processCaseWeightByColAndLin(int column, int line, double weight){
        if(column >= NB_COL || line >= NB_LIN || column < 0 || line < 0)
            return;
        if(grid[column][line].isReef() || (grid[column][line].getWeight() != -1 && grid[column][line].getWeight() <= weight))
            return;

        grid[column][line].setWeight(weight);
        processCaseWeightByColAndLin(column+1,line,weight+1);
        processCaseWeightByColAndLin(column+1,line+1,weight+Math.sqrt(2));
        processCaseWeightByColAndLin(column+1,line-1,weight+Math.sqrt(2));
        processCaseWeightByColAndLin(column-1,line,weight+1);
        processCaseWeightByColAndLin(column-1,line+1,weight+Math.sqrt(2));
        processCaseWeightByColAndLin(column-1,line-1,weight+Math.sqrt(2));
        processCaseWeightByColAndLin(column,line+1,weight+1);
        processCaseWeightByColAndLin(column,line-1,weight+1);
    }

    public Case getCaseOfAPosition(Position position) {
        int column = 0;
        int line = 0;
        while (!Geometry.isThisPointInARectangle(position.toPoint(),grid[column][line].getFormPoints())){
            line++;
            if(line == NB_LIN) {
                column++;
                line = 0;
            }
            if(column == NB_COL){
                return null;
            }
        }
        return grid[column][line];
    }

    public int[] getColAndLineOfAPosition(Position position) {
        int[] columnLine = new int[]{0,0};
        while (!Geometry.isThisPointInARectangle(position.toPoint(),grid[columnLine[0]][columnLine[1]].getFormPoints())){
            columnLine[1]++;
            if(columnLine[1] == NB_LIN) {
                columnLine[0]++;
                columnLine[1] = 0;
            }
            if(columnLine[0] == NB_COL){
                return null;
            }
        }
        return columnLine;
    }

    public void reloadCaseInformation(Spotting spotting){
        for (Case[] columnCases : grid) {
            for (Case gridCase : columnCases) {
                gridCase.setWeight(-1);
                if(spotting.isReefsInARectangle(gridCase.getForm().getRealPoints(gridCase.getCentralPoint())))
                    gridCase.setIsReef(true);
            }
        }
    }

    public Case getCase(int col, int lin){
        if(col >= 0 && col < NB_COL && lin >= 0 && lin < NB_LIN)
            return grid[col][lin];
        return null;
    }


}
