package fr.unice.polytech.si3.qgl.queleglitch.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.*;

import java.util.List;

public class Strat {

    ObjectMapper objectMapper = new ObjectMapper();
    Ship ship;
    Sailor[] sailors;
    Position shipPosition;
    Position checkPointPosition;

    public Strat(InitGame initGame) {
        checkPointPosition = ((RegattaGoal) initGame.getGoal()).getCheckpoints()[0].getPosition();
        shipPosition = initGame.getShip().getPosition();
        ship = initGame.getShip();
        sailors = initGame.getSailors();
    }

    public String balancedTheSailorsOnTheRames(){
        StringBuilder string= new StringBuilder();
        int i=0;

        List<Rame> ramesAtRight = ship.getRamesAtRight();
        List<Rame> ramesAtLeft = ship.getRamesAtLeft();

        for(; sailors.length / 2 > i; i++){
            int id=sailors[i].id;
            int xdiff= ramesAtRight.get(i).x-sailors[i].x;
            int ydiff=ramesAtRight.get(i).y-sailors[i].y;

            Actions action=new Moving(id,xdiff,ydiff);

            try{
                string.append(objectMapper.writeValueAsString(action));
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        for(; sailors.length  > i; i++){
            int id=sailors[i].id;
            int xdiff=ramesAtLeft.get(i).x-sailors[i].x;
            int ydiff=ramesAtLeft.get(i).y-sailors[i].y;

            Actions action=new Moving(id,xdiff,ydiff);

            try{
                string.append(",");
                string.append(objectMapper.writeValueAsString(action));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return string.toString();

    }





}
