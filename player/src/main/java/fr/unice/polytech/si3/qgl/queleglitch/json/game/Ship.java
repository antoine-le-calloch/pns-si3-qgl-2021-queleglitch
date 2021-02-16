package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe representant les bâteaux
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Ship {
    public Position position;
    public Entities[] entities;
    public String name;
    public Deck deck;
    public Shape shape;

    public Ship(){
    }

    public Ship(Position position){
        this.position = position;
    }

    public Ship(Position position, Entities[] entities, String name, Deck deck, Shape shape){
        this.position = position;
        this.entities = entities;
        this.name = name;
        this.deck = deck;
        this.shape = shape;
    }

    public double calculateAngleToCheckPoint(Position checkPointPosition){
        double checkPointX = checkPointPosition.getX();
        double checkPointY = checkPointPosition.getY();
        double shipAngle = position.getOrientation();
        double shipX = position.getX();
        double shipY = position.getY();
        double angle = 0;

        if(checkPointY-shipY==0 && checkPointX-shipX < 0){
            angle = Math.PI;
        }
        else if(checkPointX-shipX > 0 && checkPointY-shipY > 0){
            angle = Math.atan((checkPointY-shipY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY > 0){
            angle = -Math.atan((checkPointX - shipX) / (checkPointY - shipY));
            angle += Math.PI / 2;
        }
        else if(checkPointX-shipX > 0 && checkPointY-shipY < 0){
            angle = -Math.atan((shipY-checkPointY)/(checkPointX-shipX));
        }
        else if(checkPointX-shipX <= 0 && checkPointY-shipY < 0){
            angle = Math.atan((shipX-checkPointX)/(checkPointY-shipY));
            angle -= Math.PI/2;
        }
        angle -= shipAngle;
        if(angle > Math.PI) {
            angle = (-2*Math.PI)+angle;
        }
        else if(angle < -Math.PI) {
            angle = (2*Math.PI)+angle;
        }
        return angle;
    }

    /**
     * @return <b>The position of the ship.</b>
     */
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    /**
     * <p>Override of toString method, allow to print a different string to give the Ship's informations</p>
     */
    @Override
    public String toString(){
        return "Bateau | orientation : " + position.orientation +
                " | x : " + position.x + " | y : " + position.y;
    }

    public Entities[] getEntities() {
        return entities;
    }

    public List<Rame> getRames(){
        List<Rame> rames=new ArrayList<>();
        for (Entities entitie:entities){
            if(entitie instanceof Rame) {
                rames.add((Rame) entitie);
            }
        }
        return new ArrayList<>(rames);
    }

    public Gouvernail getGouvernail(){
        for (Entities entitie:entities){
            if(entitie instanceof Gouvernail) {
                return (Gouvernail) entitie;
            }
        }
        return null;
    }

    public List<Rame> getRamesAtRight(){
        return getRames().stream().filter(rame -> rame.getY()==1).collect(Collectors.toList());
    }

    public List<Rame> getRamesAtLeft(){
        return getRames().stream().filter(rame -> rame.getY()==0).collect(Collectors.toList());
    }
}
