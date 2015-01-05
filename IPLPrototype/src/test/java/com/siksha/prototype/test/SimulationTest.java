package com.siksha.prototype.test;

import com.siksha.prototype.RuleExecutor;
import com.siksha.prototype.model.Match;
import com.siksha.prototype.utility.TeamUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/18/14
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(locations = {"classpath:test-application-context.xml","classpath:applicationContext.xml"


})
public class SimulationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    XMLTestDataParser xmlTestDataParser;

    @Autowired
    RuleExecutor ruleExecutor;

    @Autowired
    TeamUtility teamUtility;



    @Test(dataProvider = "testData")
    public void test(TestngExample testngExample){
        /*Team rcb = new Team();
        Team mi = new Team();
        rcb.setTeamDetails(Teams.RCB);
        mi.setTeamDetails(Teams.MI);
        rcb.setPlayers(teamUtility.getPlayersForTeam(players.getPlayers(), rcb.getTeamDetails()));
        mi.setPlayers(teamUtility.getPlayersForTeam(players.getPlayers(), mi.getTeamDetails()));
        Match match = new Match();
        match.setHomeTeam(Teams.RCB);
        match.setVisitingTeam(Teams.MI);
        Map<Teams, Team> teamMap = new HashMap<Teams, Team>();
        teamMap.put(Teams.RCB,rcb);
        teamMap.put(Teams.MI, mi);
        match.setTeamMap(teamMap);
        match.setVenue(Venue.Bangalore);
        match.setHomeTeamOwnerVisiting(true);
        match.setVisitingTeamOwnerVisiting(true);*/
        ruleExecutor.executeRules(testngExample.getMatch());


    }

    @DataProvider(name = "testData")
    public Object[][] testData(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RuleExecutor ruleExecutor1 = (RuleExecutor) classPathXmlApplicationContext.getBean("ruleExecutor");
        Match match = xmlTestDataParser.parseDocument();
        Object[][] testCaseModelForDataProvider = new Object[1][1];
        List<Object[]> testCaseModels = new ArrayList<Object[]>();
        TestngExample testngExample = new TestngExample();
        testngExample.setId(1);
        testngExample.setMatch(match);
        return new Object[][] { { testngExample } };

    }


}
