package edu.ucsb.cs56.projects.games.connectfour.Logic;
import java.io.*;

public class UserInfo implements Serializable, Comparable<UserInfo>{
    private String name;
    private int score;

    public UserInfo(){
        name = "empty";
        score = 0;
    }

    public UserInfo(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    
    public int compareTo(UserInfo comparestu){
        if(this.score > comparestu.getScore()){
            return -1;
        }
        if(this.score == comparestu.getScore()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
