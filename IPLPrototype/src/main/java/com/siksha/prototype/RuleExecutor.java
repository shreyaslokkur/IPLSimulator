package com.siksha.prototype;

import com.siksha.prototype.enums.Teams;
import com.siksha.prototype.model.Match;
import com.siksha.prototype.model.Player;
import com.siksha.prototype.model.Team;
import com.siksha.prototype.utility.MatchUtility;
import com.siksha.prototype.utility.PlayerUtility;
import com.siksha.prototype.utility.TeamUtility;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/18/14
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class RuleExecutor {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    TeamUtility teamUtility;

    @Autowired
    MatchUtility matchUtility;

    @Autowired
    PlayerUtility playerUtility;

    public void executeRules(Match match){

        StatefulKnowledgeSession statefulKnowledgeSession = getKnowledgeSession();
        List<Player> players = new ArrayList<Player>();
        players.addAll(match.getTeamMap().get(match.getHomeTeam()).getPlayers());
        players.addAll(match.getTeamMap().get(match.getVisitingTeam()).getPlayers());
        playerUtility.setPlayersInMatch(players);
        statefulKnowledgeSession.insert(match);
        statefulKnowledgeSession.insert(matchUtility);
        statefulKnowledgeSession.insert(teamUtility);
        for(Player player : players){
            System.out.println("Starting to execute rules on: "+ player.getPlayerName());
            System.out.println("Current Points of "+player.getPlayerName()+" is "+player.getPoints());
            System.out.println("Begin rule execution");
            playerUtility.setCurrentPlayer(player);
            statefulKnowledgeSession.insert(player);
            statefulKnowledgeSession.insert(playerUtility);
            statefulKnowledgeSession.fireAllRules();
            System.out.println("Points of "+player.getPlayerName()+" after rule execution is "+player.getPoints());
            System.out.println("************************************************************************************************************************************");
        }

        int homeTeamPoints = 0;
        int visitingTeamPoints = 0;
        for(Teams team : match.getTeamMap().keySet()){
            if(team.equals(match.getHomeTeam())){
                for(Player player : match.getTeamMap().get(match.getHomeTeam()).getPlayers()){
                    homeTeamPoints+= player.getPoints();
                }
            }else if (team.equals(match.getVisitingTeam())){
                for(Player player : match.getTeamMap().get(match.getVisitingTeam()).getPlayers()){
                    visitingTeamPoints+= player.getPoints();
                }
            }


        }
        System.out.println("Total points of "+ match.getHomeTeam()+" is: "+homeTeamPoints);
        System.out.println("Total points of "+ match.getVisitingTeam()+" is: "+visitingTeamPoints);

    }

    public StatefulKnowledgeSession getKnowledgeSession(){
        return (StatefulKnowledgeSession) applicationContext.getBean("iplKSession");
    }
}
