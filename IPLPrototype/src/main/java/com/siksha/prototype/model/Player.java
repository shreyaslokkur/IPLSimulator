package com.siksha.prototype.model;

import com.siksha.prototype.enums.Cricketer;
import com.siksha.prototype.enums.Teams;
import org.drools.definition.type.PropertyReactive;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/18/14
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
@PropertyReactive
public class Player {

    private String playerName;
    private Teams team;
    private int id;
    private Cricketer cricketer;
    private int points;
    private int coachingPoints;



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cricketer getCricketer() {
        return cricketer;
    }

    public void setCricketer(Cricketer cricketer) {
        this.cricketer = cricketer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points){
        this.points= this.points + points;
    }

    public int getCoachingPoints() {
        return coachingPoints;
    }

    public void setCoachingPoints(int coachingPoints) {
        this.coachingPoints = coachingPoints;
    }
}
