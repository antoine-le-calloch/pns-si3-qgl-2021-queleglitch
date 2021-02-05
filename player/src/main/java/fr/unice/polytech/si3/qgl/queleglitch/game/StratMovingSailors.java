package fr.unice.polytech.si3.qgl.queleglitch.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.queleglitch.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.action.Actions;
import fr.unice.polytech.si3.qgl.queleglitch.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.entitie.Rame;

import java.util.List;

public class StratMovingSailors {


    ObjectMapper objectMapper = new ObjectMapper();
    Ship ship;
    Sailor[] sailors;

    public StratMovingSailors(InitGame initGame) {
        this.ship = initGame.ship;
        this.sailors=initGame.sailors;
    }




    public String balancedTheSailorsOnTheRames(){
        StringBuilder string= new StringBuilder();
        int i=0;

        List<Rame> ramesAtRight=ship.getRamesAtRight();
        List<Rame> ramesAtLeft=ship.getRamesAtLeft();

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
