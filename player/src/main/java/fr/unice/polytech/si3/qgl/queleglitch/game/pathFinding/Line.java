package fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

import java.util.Objects;

public class Line {
    double coefficient;
    double orderedAtTheOrigin;

    public Line(int coefficient, int orderedAtTheOrigin) {
        this.coefficient = coefficient;
        this.orderedAtTheOrigin = orderedAtTheOrigin;
    }

    public Line(Point p1,Point p2){
        coefficient=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        orderedAtTheOrigin= p1.getY() - coefficient*p1.getX();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Line)) return false;
        Line line = (Line) obj;
        return this.coefficient == line.coefficient && this.orderedAtTheOrigin == line.orderedAtTheOrigin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient, orderedAtTheOrigin);
    }


}

