package com.siksha.prototype.test;


import com.siksha.prototype.enums.Cricketer;
import com.siksha.prototype.enums.Venue;
import com.siksha.prototype.enums.Teams;
import com.siksha.prototype.model.Match;
import com.siksha.prototype.model.Player;
import com.siksha.prototype.model.Team;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.annotation.Resource;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/8/14
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */


public class XMLTestDataParser extends DefaultHandler {

    @Resource(name = "testDataResourceInjection")
    ResourceInjection testDataResource;

    private List<Player> playerList;
    private Player player = null;
    private String tempVal;
    private Match match;
    private Team team;
    private Map<Teams, Team> teamMap = new HashMap<Teams, Team>();

    public Match parseDocument() {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs
            /*sp.parse(testDataResource.getResource().getFile().getCanonicalPath(), this);*/
            sp.parse("C:\\Users\\shreyasl\\Sandbox\\mysup\\UpgradeAdvisor\\IPLPrototype\\src\\test\\resources\\SimulationData", this);
            return match;

        }catch(SAXException se) {
            se.printStackTrace();
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch (IOException ie) {
            ie.printStackTrace();
        }
        return null;
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
        if(qName.equalsIgnoreCase("Match")){
            match = new Match();
        }
        else if(qName.equalsIgnoreCase("Team")){
            team = new Team();
            team.setId(Integer.parseInt(attributes.getValue("id")));
            String teamName = attributes.getValue("name");
            Teams teams = Teams.valueOf(teamName);
            team.setTeamDetails(teams);
        }
        else if(qName.equalsIgnoreCase("Players")){
            playerList = new ArrayList<Player>();
        }
        if(qName.equalsIgnoreCase("Player")) {
            //create a new instance of player
            player = new Player();
            player.setId(Integer.parseInt(attributes.getValue("id")));
            player.setTeam(team.getTeamDetails());
        }

    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch,start,length);
    }

    public void endElement(String uri, String localName,
                           String qName) throws SAXException {

        if(qName.equalsIgnoreCase("HomeTeam")){
            Teams teams = Teams.valueOf(tempVal);
            match.setHomeTeam(teams);
        }else if(qName.equalsIgnoreCase("VisitingTeam")){
            Teams teams = Teams.valueOf(tempVal);
            match.setVisitingTeam(teams);
        }else if(qName.equalsIgnoreCase("IsHomeTeamOwnerVisiting")){
            match.setHomeTeamOwnerVisiting(Boolean.parseBoolean(tempVal));
        }else if(qName.equalsIgnoreCase("IsVisitingTeamOwnerVisiting")){
            match.setVisitingTeamOwnerVisiting(Boolean.parseBoolean(tempVal));
        }else if (qName.equalsIgnoreCase("Venue")){
            match.setVenue(Venue.valueOf(tempVal));
        }else if(qName.equalsIgnoreCase("Player")) {
            playerList.add(player);
        }else if (qName.equalsIgnoreCase("Name")) {
            player.setPlayerName(tempVal);
        }else if (qName.equalsIgnoreCase("Cricketer")) {
            player.setCricketer(Cricketer.valueOf(tempVal));
        }else if (qName.equalsIgnoreCase("Points")) {
            player.setPoints(Integer.parseInt(tempVal));
        }else if (qName.equalsIgnoreCase("Coaching")) {
            player.setCoachingPoints(Integer.parseInt(tempVal));
        }else if(qName.equalsIgnoreCase("Players")){
            team.setPlayers(playerList);
            playerList = null;
        }
        else if(qName.equalsIgnoreCase("Team")){
            teamMap.put(team.getTeamDetails(), team);
            team = null;
        }else if(qName.equalsIgnoreCase("Match")){
            match.setTeamMap(teamMap);
        }


    }


}
