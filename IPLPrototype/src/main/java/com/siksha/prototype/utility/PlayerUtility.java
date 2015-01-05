package com.siksha.prototype.utility;

import com.siksha.prototype.enums.Teams;
import com.siksha.prototype.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/21/14
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerUtility {
    private Player currentPlayer;
    private List<Player> playersInMatch;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Player> getPlayersInMatch() {
        return playersInMatch;
    }

    public void setPlayersInMatch(List<Player> playersInMatch) {
        this.playersInMatch = playersInMatch;
    }

    public boolean isTeammate(String playerName){
        Teams teamOfCurrentPlayer = currentPlayer.getTeam();
        for(Player player : playersInMatch){
            if(player.getPlayerName().equals(playerName) && teamOfCurrentPlayer.equals(player.getTeam()))
                return true;

        }
        return false;
    }

    public boolean isOpponent(String playerName){
        Teams teamOfCurrentPlayer = currentPlayer.getTeam();
        for(Player player : playersInMatch){
            if(player.getPlayerName().equals(playerName) && (!teamOfCurrentPlayer.equals(player.getTeam())))
                return true;

        }
        return false;
    }
}
