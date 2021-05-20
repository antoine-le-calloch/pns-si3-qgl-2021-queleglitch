package fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.Geometry;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;

public class Grid {

    private final int gridSide;
    private final int caseWidth;
    private final int caseHeight;
    private final int nbCol;
    private final int nbLin;
    private final Case[][] otherGrid;

    public Grid(int gridSide, int caseWidth, int caseHeight){
        this.gridSide = gridSide;
        this.caseWidth = caseWidth;
        this.caseHeight = caseHeight;
        nbCol = this.gridSide / this.caseHeight;
        nbLin = this.gridSide / this.caseWidth;
        otherGrid = new Case[nbCol][nbLin];
    }

    public void create(Point centralGridPoint, Point checkpointPosition, Spotting spotting){
        double gridOrientation = centralGridPoint.getAngleToAPoint(checkpointPosition);
        Rectangle caseForm = new Rectangle(caseWidth, caseHeight,gridOrientation);
        int lin = 0;
        int col = 0;

        while (col < nbCol /2.0){
            Point[] points = findCasePoints(col,lin,gridOrientation,centralGridPoint);
            for (int i = 0; i < points.length; i++) {
                int newCol = col;
                int newLin = lin;
                switch (i) {
                    case 1: newCol = nbCol -col-1;
                            newLin = lin;
                            break;
                    case 2: newCol = nbCol -col-1;
                            newLin = nbLin -lin-1;
                            break;
                    case 3: newCol = col;
                            newLin = nbLin -lin-1;
                            break;
                    default: break;
                }
                Case newCase = new Case(caseForm,points[i],newCol,newLin);
                if(spotting.isReefsInARectangle(newCase.getForm().getRealPoints(newCase.getCentralPoint())))
                    newCase.setIsReef(true);
                otherGrid[newCol][newLin] = newCase;
            }
            lin++;
            if(lin > nbLin /2.0){
                lin = 0;
                col++;
            }
        }
    }

    public Point[] findCasePoints(int column, int line, double gridOrientation, Point centralGridPoint){
        double width = gridSide - caseWidth - (double) line* caseWidth *2;
        double height = gridSide - caseHeight - (double) column* caseHeight *2;
        Rectangle rectangle = new Rectangle(width,height,gridOrientation);
        return rectangle.getRealPoints(centralGridPoint);
    }

    public void processCaseWeight(Point startPoint) {
        Case startCase;
        if((startCase = getCaseOfAPosition(startPoint.toPosition())) != null)
            processCaseWeightByColAndLin(startCase.col(),startCase.line(),0);
    }

    public void processCaseWeightByColAndLin(int column, int line, double weight){
        if(column >= nbCol || line >= nbLin || column < 0 || line < 0)
            return;
        if(otherGrid[column][line].isReef() || (otherGrid[column][line].getWeight() != -1 && otherGrid[column][line].getWeight() <= weight))
            return;

        otherGrid[column][line].setWeight(weight);
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
        while (!Geometry.isThisPointInARectangle(position.toPoint(), otherGrid[column][line].getFormPoints())){
            line++;
            if(line == nbLin) {
                column++;
                line = 0;
            }
            if(column == nbCol){
                return null;
            }
        }
        return otherGrid[column][line];
    }

    public int[] getColAndLineOfAPosition(Position position) {
        int[] columnLine = new int[]{0,0};
        while (!Geometry.isThisPointInARectangle(position.toPoint(), otherGrid[columnLine[0]][columnLine[1]].getFormPoints())){
            columnLine[1]++;
            if(columnLine[1] == nbLin) {
                columnLine[0]++;
                columnLine[1] = 0;
            }
            if(columnLine[0] == nbCol){
                return new int[]{0,0};
            }
        }
        return columnLine;
    }

    public void reloadCaseInformation(Spotting spotting){
        for (Case[] columnCases : otherGrid) {
            for (Case gridCase : columnCases) {
                gridCase.setWeight(-1);
                if(spotting.isReefsInARectangle(gridCase.getForm().getRealPoints(gridCase.getCentralPoint())))
                    gridCase.setIsReef(true);
            }
        }
    }

    public Case getCase(int col, int lin){
        if(col >= 0 && col < nbCol && lin >= 0 && lin < nbLin)
            return otherGrid[col][lin];
        return null;
    }


}
