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
    
    
    
    
    
}
