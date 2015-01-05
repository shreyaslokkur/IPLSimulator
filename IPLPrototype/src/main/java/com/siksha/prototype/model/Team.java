package com.siksha.prototype.model;

import com.siksha.prototype.enums.Teams;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/18/14
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Team {

    private int id;
    private Teams teamDetails;
    private List<Player> players;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teams getTeamDetails() {
        return teamDetails;
    }

    public void setTeamDetails(Teams teamDetails) {
        this.teamDetails = teamDetails;
    }


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
