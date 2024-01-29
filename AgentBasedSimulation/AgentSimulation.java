/*
 * File:    Agent.java
 * Author:  Duilio Lucio
 * Project: Project 3
 * Course:  CS231
 * Section: B
 * Data:    03/01/2023
 */

package AgentBasedSimulation;
import java.util.Random;

public class AgentSimulation {
    // test function that creates a new LandscapeDisplay and populates it with 200
    // agents.
    public static void main(String[] args) throws InterruptedException {

        // if the args array of strings is not of length 6 we will fll it with 0s
        String[] parsedArgs;

        parsedArgs = new String[8];

        System.arraycopy(args, 0, parsedArgs, 0, args.length);
        if (args.length < 8) {
            for (int i = args.length; i < 8; i++) {
                parsedArgs[i] = "0";
            }
        }

        int width = Integer.parseInt(parsedArgs[0]);
        int height = Integer.parseInt(parsedArgs[1]);
        int noSocialAgents = Integer.parseInt(parsedArgs[2]);
        int noAntiSocialAgents = Integer.parseInt(parsedArgs[3]);
        int noKillerAgents = Integer.parseInt(parsedArgs[4]);
        int noInfectedAgents = Integer.parseInt(parsedArgs[5]);
        int noMaxInfectedIter = Integer.parseInt(parsedArgs[6]);
        int infectedRadius = Integer.parseInt(parsedArgs[7]);

        Landscape scape = new Landscape(width, height);
        Random gen = new Random();

        // Creates 100 SocialAgents and 100 AntiSocialAgents
        for (int i = 0; i < noSocialAgents; i++) {
            // social agents
            SocialAgent socialAgent = new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    15);

            socialAgent.setMaxDaysLivedInfected(noMaxInfectedIter);

            scape.addAgent(socialAgent);
        }
        for (int i = 0; i < noAntiSocialAgents; i++) {
            // antisocial agents
            AntiSocialAgent antiSocialAgent = new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    15);

            antiSocialAgent.setMaxDaysLivedInfected(noMaxInfectedIter);

            scape.addAgent(antiSocialAgent);
        }

        // killer agents
        for (int i = 0; i < noKillerAgents; i++) {
            scape.addAgent(new KillerAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    25));
        }

        // infected agent
        for (int i = 0; i < noInfectedAgents; i++) {
            SocialAgent infectedAgent = new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    25);

            infectedAgent.setInfected(true);

            infectedAgent.setMaxDaysLivedInfected(noMaxInfectedIter);

            infectedAgent.setRadius(infectedRadius);

            scape.addAgent(infectedAgent);

        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        while (true) {
            Thread.sleep(10);
            scape.updateAgents();
            display.repaint();
        }
    }
}