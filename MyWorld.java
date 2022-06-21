import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage Background;
    int p1;
    int p2;
    PlayerTwo player2;
    PlayerOne player1;

    //rng initializations
    int min = 200;
    int max = 800;
    int x ;
    int dx= 0;   
    int min1 = 100;
    int max1 = 600;
    int y ;
    int low= 0;
    int high= 10000;
    int whichpowerup ;

    //frame counter for spawn limit on powerups
    int pwupframecounter;

    int PowerUpFrameCount;

    public MyWorld(int selection1, int selection2)
    {    
        super(1000, 600, 1);
        int p1=selection1;
        int p2=selection2;
        //adding player on start
        player2= new PlayerTwo(selection1, selection2);
        addObject(player2, 900, 300);
        player1= new PlayerOne(selection1, selection2);
        addObject(player1, 100, 300);
        //adding hp on start
        addObject(new HP1(player1), 100, 100);
        addObject(new HP2(player2), 800, 50);

        GreenfootSound music = new GreenfootSound("BFG Division.mp3");
        //to loop the song when it stops
        if(!music.isPlaying())
        {
            music.play();
        }    

        prepare();
    }

    public void act()
    {
        //determines powerup spawning, and which powerup spawns
        pwupframecounter++;
        x = (int)(Math.random()*(max-min)+min);
        y = (int)(Math.random()*(max1-min1)+min1);
        whichpowerup= (int)(Math.random()*(high-low)+low);
        if(pwupframecounter==360)
        {
            rngpowerups();
            pwupframecounter=0;
            System.out.println("spawned");
        }
        System.out.println("fc"+pwupframecounter);
    }

    public void rngpowerups()
    {
        //determines spawn location for which power up spawns
        if(whichpowerup<=6000)
        {
            addObject(new Heal(), x, y);
        }

        else if(whichpowerup>6000&&whichpowerup<8000)
        {
            addObject(new Damage(), x, y);
        }

        else if(whichpowerup>8000&&whichpowerup<=10000)
        {
            addObject(new Speed(), x, y);
        }
    }

        
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall();
        addObject(wall,160,595);
        Wall wall2 = new Wall();
        addObject(wall2,159,384);
        Wall wall3 = new Wall();
        addObject(wall3,159,316);
        Wall wall4 = new Wall();
        addObject(wall4,159,253);
        Wall wall5 = new Wall();
        addObject(wall5,158,37);
        Wall wall6 = new Wall();
        addObject(wall6,350,136);
        Wall wall7 = new Wall();
        addObject(wall7,347,257);
        Wall wall8 = new Wall();
        addObject(wall8,343,454);
        Wall wall9 = new Wall();
        addObject(wall9,834,297);
        Wall wall12 = new Wall();
        addObject(wall12,831,123);
        Wall wall10 = new Wall();
        addObject(wall10,839,471);
        Wall wall11 = new Wall();
        addObject(wall11,659,208);
        Wall wall13 = new Wall();
        addObject(wall13,656,388);
        Wall wall14 = new Wall();
        addObject(wall14,657,589);
        Wall wall15 = new Wall();
        addObject(wall15,655,8);
        Wall wall16 = new Wall();
        addObject(wall16,502,499);
    }
}
    

    
    

