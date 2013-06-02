package edu.ucsb.cs56.projects.games.connectfour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Circle draws a circle at the specified location and with
 * the specified color.
 * 
 * @author Jake Dumont
 * @author Heneli Kailahi
 * @version CS56, Spring 2013, UCSB
 */
public class Circle
{ 

    private int x;
    private int y;
    private int width;
    private int height;
    private int state = 0;

    /**
     * Constructor for objects of class Circle
     * @param x    x coordinate of upper left hand corner of circle
     * @param y    y coordinate of upper left hand corner of circle
     * @param w    width of circle
     * @param h    height of circle
     */

    public Circle(int x, int y, int w, int h)
    {
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.state = 0;
        
    }

    /**
       Setter for the state variable
       @param state     integer that the state is set equal to
    */

    public void setState(int value) {
	this.state = value;
    }

    /**
       Getter for the state variable 
    */

    public int getState() {
	return this.state;
    }

    /**
       Draw function for the circle. Color depends on the state.
    */

    public void draw(Graphics g) {
	if (state == 1) {
	    g.setColor(Color.red);
	}
	else if (state == 2){
	    g.setColor(Color.yellow);
	}
	else {
	    g.setColor(Color.white);
	}
	g.drawOval(x - width/2, y - height/2, width, height);
	g.fillOval(x - width/2, y - height/2, width, height);
	
    }
}
