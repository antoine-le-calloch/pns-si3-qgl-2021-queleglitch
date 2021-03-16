package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.ArrayList;
import java.util.List;

public class CreateAction {
    Ship ship;
    Sailor[] sailors;
    ToolsToUse toolsToUse;
    int MAX_ROWER;

    public CreateAction(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        this.ship = ship;
        this.sailors = sailors;
        this.toolsToUse = toolsToUse;
        this.MAX_ROWER = sailors.length;
    }

    public List<Action> buildingActions() {
        /*List<Action> actions = new ArrayList<>();

        int x;
        int y;
        int nbSailorForOar = MAX_ROWER;
        int minx = 5;
        int miny = 5;
        Sailor[] orderSailor = new Sailor[MAX_ROWER];
        int cptRightRames = 0;
        int cptLeftRames = 0;
        int cptSailor;
        List<Rame> rightRames = ship.getRamesAtRight();
        List<Rame> leftRames = ship.getRamesAtLeft();
        List<Sailor> orderSailors = new ArrayList<>();

        for (int k = MAX_ROWER; k >= 0; k--) {
            for (Sailor sailor  : sailors) {
                if(sailor.getX() < minx)
                    orderSailor[k] = sailor;
            }
        }
        sailors = orderSailor;

        if (toolsToUse.getAngleRudder() != 0)
            nbSailorForOar--;
        *//*if (toolsToUse.isWind())
            nbSailorForOar--;*//*

        cptSailor = MAX_ROWER - nbSailorForOar;

        while (nbSailorForOar > 0) {
            if(toolsToUse.moreSailorsOnTheRightThanOnTheLeft >= 0) {
                if (cptRightRames-cptLeftRames < toolsToUse.moreSailorsOnTheRightThanOnTheLeft) {
                    x = rightRames.get(cptRightRames).x - sailors[nbSailorForOar].x;
                    y = rightRames.get(cptRightRames).y - sailors[nbSailorForOar].y;
                    if(Math.abs(x) + Math.abs(x) <= 5) {
                        sailors[nbSailorForOar].x += x;
                        sailors[nbSailorForOar].y += y;
                        actions.add(new Moving(sailors[nbSailorForOar].getId(), x, y));
                        actions.add(new Oar(sailors[nbSailorForOar].getId()));
                    }
                    cptRightRames++;
                    nbSailorForOar--;
                }
                if (nbSailorForOar - toolsToUse.moreSailorsOnTheRightThanOnTheLeft > 0) {
                    x = leftRames.get(cptLeftRames).x - sailors[nbSailorForOar].x;
                    y = leftRames.get(cptLeftRames).y - sailors[nbSailorForOar].y;
                    if(Math.abs(x) + Math.abs(x) <= 5) {
                        sailors[nbSailorForOar].x += x;
                        sailors[nbSailorForOar].y += y;
                        actions.add(new Moving(sailors[nbSailorForOar].getId(), x, y));
                        actions.add(new Oar(sailors[nbSailorForOar].getId()));
                    }
                    cptLeftRames++;
                    nbSailorForOar--;
                }
            }
            else if(toolsToUse.moreSailorsOnTheRightThanOnTheLeft < 0) {
                if (cptLeftRames-cptRightRames < Math.abs(toolsToUse.moreSailorsOnTheRightThanOnTheLeft)) {
                    x = leftRames.get(cptLeftRames).x - sailors[nbSailorForOar].x;
                    y = leftRames.get(cptLeftRames).y - sailors[nbSailorForOar].y;
                    if(Math.abs(x) + Math.abs(x) <= 5) {
                        sailors[nbSailorForOar].x += x;
                        sailors[nbSailorForOar].y += y;
                        actions.add(new Moving(sailors[nbSailorForOar].getId(), x, y));
                        actions.add(new Oar(sailors[nbSailorForOar].getId()));
                    }
                    cptLeftRames++;
                    nbSailorForOar--;
                }
                if (nbSailorForOar - Math.abs(toolsToUse.moreSailorsOnTheRightThanOnTheLeft) > 0) {
                    x = rightRames.get(cptRightRames).x - sailors[nbSailorForOar].x;
                    y = rightRames.get(cptRightRames).y - sailors[nbSailorForOar].y;
                    if(Math.abs(x) + Math.abs(x) <= 5) {
                        sailors[nbSailorForOar].x += x;
                        sailors[nbSailorForOar].y += y;
                        actions.add(new Moving(sailors[nbSailorForOar].getId(), x, y));
                        actions.add(new Oar(sailors[nbSailorForOar].getId()));
                    }
                    cptRightRames++;
                    nbSailorForOar--;
                }
            }
        }
        if (toolsToUse.getAngleRudder() != 0) {
            //MOVING
            x = ship.getGouvernail().getX() - sailors[cptSailor].x;
            y = ship.getGouvernail().getY() - sailors[cptSailor].y;
            sailors[cptSailor].x += x;
            sailors[cptSailor].y += y;
            actions.add(new Moving(sailors[cptSailor].getId(), x, y));
            actions.add(new Turn(toolsToUse.getAngleRudder(),sailors[cptSailor].getId()));
        }
        return actions;*/
        return null;
    }
}

/*
        if (toolsToUse.getNumberOfSail() == 1 && !ship.getVoile().openned && compteur < MAX_ROWER) {
            //MOVING
            x = ship.getVoile().getX() - sailors[compteur].x;
            y = ship.getVoile().getY() - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new LIFT_SAIL(sailors[compteur++].getId()));
                ship.getVoile().setOpenned(true);
            }
        }

        else if (toolsToUse.getNumberOfSail() == 0 && ship.getVoile().openned && compteur < MAX_ROWER){
            x = ship.getVoile().getX() - sailors[compteur].x;
            y = ship.getVoile().getY() - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new LOWER_SAIL(sailors[compteur++].getId()));
                ship.getVoile().setOpenned(false);
            }
        }

        while (MAX_ROWER - compteur >= 2 && i < rightRames.size()  && j < rightRames.size()  && toolsToUse.numberOfSailorMaxBeforeSlowDown > compteur) {
            //MOVING
            x = rightRames.get(i).x - sailors[compteur].x;
            y = rightRames.get(i).y - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Oar(sailors[compteur++].getId()));
            }
            //MOVING
            x = leftRames.get(j).x - sailors[compteur].x;
            y = leftRames.get(j).y - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Oar(sailors[compteur++].getId()));
            }
            i++;
            j++;
        }
        return actions;

        if (toolsToUse.getAngleRudder() != 0) {
                //MOVING
                x = ship.getGouvernail().getX() - sailors[compteur].x;
                y = ship.getGouvernail().getY() - sailors[compteur].y;
                if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Turn(sailors[compteur++].getId(), toolsToUse.getAngleRudder()));
                }
                }

                if (compteur < Math.abs(toolsToUse.getNumberOfSailor())) {
        if (toolsToUse.moreSailorsOnTheRightThanOnTheLeft > 0) {
        //MOVING
        for (; i < toolsToUse.moreSailorsOnTheRightThanOnTheLeft; i++) {
        x = rightRames.get(i).x - sailors[compteur].x;
        y = rightRames.get(i).y - sailors[compteur].y;
        if(Math.abs(x) + Math.abs(x) <= 5) {
        sailors[compteur].x += x;
        sailors[compteur].y += y;
        actions.add(new Moving(sailors[compteur].getId(), x, y));
        actions.add(new Oar(sailors[compteur++].getId()));
        }
        }


        } else {
        //MOVING
        double max = toolsToUse.moreSailorsOnTheRightThanOnTheLeft * (-1);
        for (; j < max; j++) {
        x = leftRames.get(j).x - sailors[compteur].x;
        y = leftRames.get(j).y - sailors[compteur].y;
        if(Math.abs(x) + Math.abs(x) <= 5) {
        sailors[compteur].x += x;
        sailors[compteur].y += y;
        actions.add(new Moving(sailors[compteur].getId(), x, y));
        actions.add(new Oar(sailors[compteur++].getId()));
*/