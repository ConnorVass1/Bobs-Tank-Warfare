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
    int  p1;
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
        
        player2= new PlayerTwo(selection1, selection2);
        addObject(player2, 900, 300);
        player1= new PlayerOne(selection1, selection2);
        addObject(player1, 100, 300);
        
        addObject(new HP1(player1), 100, 100);
        addObject(new HP2(player2), 800, 100);
        
        GreenfootSound music = new GreenfootSound("BFG Division.mp3");
         //to loop the song when it stops
        if(!music.isPlaying())
        {
            music.play();
        }    
        
    }
    
    public void act()
    {

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

        
        
    }
    

    
    
