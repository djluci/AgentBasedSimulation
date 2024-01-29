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
import java.util.ArrayList;

public class Landscape {
    int w; // width of our canvas
    int h; // height of our canvas
    LinkedList<Agent> agents; // all agents on the canvas

    public Landscape(int w, int h) {
        this.w = w;
        this.h = h;
        agents = new LinkedList();

    }

    public int getHeight() {
        return h;
    }

    public int getWidth() {
        return w;
    }

    // add agent on the map using addFirst (which is O(1))
    public void addAgent(Agent a) {
        agents.addFirst(a);
    }

    public String toString() {
        return "" + agents.size();
    }

    // get neighbors around a certain point
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius) {
        double leftBound = x0 - radius;
        double rightBound = x0 + radius;
        double topBound = y0 - radius;
        double bottomBound = y0 + radius;
        LinkedList<Agent> neighbors = new LinkedList<Agent>();
        for (Agent walkerAgent : agents) {
            if (walkerAgent.x > leftBound && walkerAgent.x < rightBound && walkerAgent.y > topBound && walkerAgent.y < bottomBound) {
                neighbors.addFirst(walkerAgent);
            }
        }
        return neighbors;
    }

    public void draw(Graphics g) {
        for (Agent walkerAgent : agents) {
            walkerAgent.draw(g);
        }
    }

    public void updateAgents() {
        for (Agent walkerAgent : agents) {
            walkerAgent.updateState(this);
        }
    }
}