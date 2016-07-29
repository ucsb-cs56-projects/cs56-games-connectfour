package edu.ucsb.cs56.projects.games.connectfour.AI;

/**
 * Created by Joel on 7/27/2016.
 */
public class AIDebuggingOutput {
    public static boolean debugOn = true;

    public static void println(String s) {
        if(debugOn){
            System.out.println(s);
        }
    }
}
