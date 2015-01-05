package com.siksha.prototype.model;

import com.siksha.prototype.enums.Venue;
import com.siksha.prototype.enums.Teams;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/22/14
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Match {

    private Map<Teams, Team> teamMap;
    private Teams homeTeam;
    private Teams visitingTeam;
    private Venue venue;
    private boolean isHomeTeamOwnerVisiting;
    private boolean isVisitingTeamOwnerVisiting;


    public Map<Teams, Team> getTeamMap() {
        return teamMap;
    }

    public void setTeamMap(Map<Teams, Team> teamMap) {
        this.teamMap = teamMap;
    }

    public Teams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Teams homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Teams getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeam(Teams visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public boolean isHomeTeamOwnerVisiting() {
        return isHomeTeamOwnerVisiting;
    }

    public void setHomeTeamOwnerVisiting(boolean homeTeamOwnerVisiting) {
        isHomeTeamOwnerVisiting = homeTeamOwnerVisiting;
    }

    public boolean isVisitingTeamOwnerVisiting() {
        return isVisitingTeamOwnerVisiting;
    }

    public void setVisitingTeamOwnerVisiting(boolean visitingTeamOwnerVisiting) {
        isVisitingTeamOwnerVisiting = visitingTeamOwnerVisiting;
    }
}
