package com.siksha.prototype.utility;

import com.siksha.prototype.enums.Venue;
import com.siksha.prototype.model.Match;
import com.siksha.prototype.model.Player;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/21/14
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchUtility {

    @Autowired
    TeamUtility teamUtility;

    public boolean isPlayingIn(Venue source, Venue target){
        if(source.equals(target))
            return true;
        return false;
    }

    public boolean isOwnerComing(Player player,Match match){
        if(teamUtility.belongsToTeam(player, match.getTeamMap().get(match.getHomeTeam())))   return match.isHomeTeamOwnerVisiting();
        else if(teamUtility.belongsToTeam(player, match.getTeamMap().get(match.getVisitingTeam())))   return match.isVisitingTeamOwnerVisiting();

        return false;


    }

   /* public boolean isTeammate(String player1, String player2, Match match){
        for(Team team : match.getTeamMap().values()){
            if(team.getPlayers().contains(player1) && team.getPlayers().contains(player2))
                return true;
        }
        return false;
    }

    public boolean isOpponent(Player player1, Player player2, Match match){
        for(Team team : match.getTeamMap().values()){
            if(team.getPlayers().contains(player1) && team.getPlayers().contains(player2))
                return false;
        }
        return true;
    }*/

}
