package com.siksha.prototype.utility;

import com.siksha.prototype.enums.Teams;
import com.siksha.prototype.model.Player;
import com.siksha.prototype.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/21/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeamUtility {


    public boolean isTeammate(List<Player> players,String player1){
        for(Player player: players){
            if(player.equals(player1)) return true;
        }
        return false;

    }

    public List<Player> getPlayersForTeam(List<Player> players, Teams teamDetails){
        List<Player> playersForTeam = new ArrayList<Player>();

        for(Player player: players){
            if(teamDetails.equals(player.getTeam())){
                playersForTeam.add(player);

            }
        }
        return playersForTeam;
    }

    public boolean belongsToTeam(Player player, Team team){
        if(player.getTeam().equals(team.getTeamDetails())) return true;
        return false;
    }

    public boolean isTeam(Teams currentTeam, Teams comparedToTeam){
        if(currentTeam.equals(comparedToTeam)) return true;
        else return false;
    }

}
