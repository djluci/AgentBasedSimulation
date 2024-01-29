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

public abstract class Agent {
    double x; // the x coordinate of the agent
    double y; // the y coordinate of the agent


    /**
     * @param x0: double, the initial x coordinate
     * @param y0: double, the initial y coordinate
     * ***/
    public Agent(double x0, double y0) {
        x = x0;
        y = y0;
    }

    /**
     *
     * @return double, the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return double, the y coordinate
     */
    public double getY() {
        return y;
    }


    /**
     * sets a new x coordinate
     * @param newX: double, the newX to be set
     */
    public void setX(double newX) {
        x = newX;
    }

    /**
     * sets a new y coordinate
     * @param newY: double, the newY to be set
     */
    public void setY(double newY) {
        y = newY;
    }

    /**
     * @return string, a string representation of the agent coordinates
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // how far (left or right / up or down) an agent can move
    public int movementBound = 5;

    /**
     * changes the x and y fields by adding a value in the
     * interval: [-movementBound, movementBound)
     * @param scape: Landscape class, the landscape on which the agents are rendered
     */
    public void getNewMovementCoords(Landscape scape) {
        x = x + Math.random() * movementBound * 2 - movementBound;
        y = y + Math.random() * movementBound * 2 - movementBound;
        if (x >= scape.getWidth()) x = scape.getWidth() - 1;
        if (y >= scape.getHeight()) y = scape.getHeight() - 1;
        if (x < 0) x = 0;
        if (y < 0) y = 0;
    }

    /**
     * Updates the x and y coordinate using the getNewMovementCoords method and the
     * moved field if the agent has moved
     * @param scape: Landscape class, the landscape on which the agents are rendered
     */
    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);

    /*
     *
     *  Extension Methods
     *
     */

    // colors for drawing the agents
    Color blue = new Color(0, 0, 255);
    Color lightBlue = new Color(125, 125, 255);
    Color red = new Color(255, 0, 0);
    Color lightRed = new Color(255, 125, 125);
    Color lightGray = new Color(133, 133, 133);
    Color gray = new Color(45, 45, 45, 255);
    Color black = new Color(0, 0, 0);
    Color green = new Color(67, 173, 0);
    Color lightGreen = new Color(94, 218, 1);


    // monitors the "alive" state of an agent
    // (in other words if it can move or not)
    boolean alive;

    // setter for alive
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // getter for alive
    public boolean getAlive(){
        return alive;
    }

    // monitors the infection status of an agent
    // if the agent comes close to an infected agent => becomes infected
    // if agent lives infected for more than maxDaysLivedInfected => dies
    boolean infected;

    // setter for infected
    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    // number of iterations passed while being infected
    int daysLivedInfected;

    // number of maximum iterations until the agent dies
    int maxDaysLivedInfected;

    // setter for daysLivedInfected
    public void setDaysLivedInfected(){
        daysLivedInfected++;
    }

    // getter for daysLivedInfected
    public int getDaysLivedInfected(){
        return daysLivedInfected;
    }

    // setter for maxDaysLivedInfected
    public void setMaxDaysLivedInfected(int maxDays){
        maxDaysLivedInfected = maxDays;
    }

    // getter for maxDaysLivedInfected
    public int getMaxDaysLivedInfected(){
        return maxDaysLivedInfected;
    }

}