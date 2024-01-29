/*
 * File:    Agent.java
 * Author:  Duilio Lucio
 * Project: Project 3
 * Course:  CS231
 * Section: B
 * Data:    03/01/2023
*/

package AgentBasedSimulation;
import java.awt.*;

public class SocialAgent extends Agent {
    // monitors if the agent moved in the current iteration or not
    boolean moved;
    // the radius of the agent's sight (or how far it can see other agents)
    int radius;

    public SocialAgent(double x0, double y0, int radius) {
        super(x0, y0);
        // remainder of constructor code
        this.radius = radius;
        alive = true;
        infected = false;
        maxDaysLivedInfected = 100;
        daysLivedInfected = 0;
    }

    // setter for radius
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getter for radius
    public int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics g) {
        if (!alive) g.setColor(gray);
        else if (infected) g.setColor(green);
        else if (!moved) g.setColor(blue);
        else g.setColor(lightBlue);

        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape) {
        LinkedList<Agent> neighbors = scape.getNeighbors(x, y, radius);
        if (neighbors.size() < 4 && alive) {
            getNewMovementCoords(scape);
            moved = true;
        } else {
            moved = false;
        }
        if (infected && alive) {
            if (getDaysLivedInfected() >= getMaxDaysLivedInfected()) {
                setAlive(false);
            }
            for (Agent toBeInfectedAgent : neighbors) {
                toBeInfectedAgent.setInfected(true);
            }
            setDaysLivedInfected();
        }
    }
}