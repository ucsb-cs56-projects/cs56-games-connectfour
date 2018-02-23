class Player{

    private String name;
    private int score;

    public Player(){
	name = "";
	score = 0;
    }
    public Player(String name, int score){
	this.name = name;
	this.score = score;
    }
    public String getName(){
	return this.name;
    } 
    public int getScore(){
	return this.int;
    }
    public void setName(String name){
	this.name = name;
    }
    public void incrementScore(){
	this.score = score+1;
    }
}
