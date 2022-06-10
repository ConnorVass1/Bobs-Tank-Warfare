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

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 600, 1);
<<<<<<< Updated upstream
        
        addObject(new PlayerTwo(), 900, 300);
        PlayerOne playerone = new PlayerOne();
=======
        int p1=selection1;
        int p2=selection2;
        addObject(new PlayerTwo(selection1, selection2), 900, 300);
        PlayerOne playerone = new PlayerOne(selection1, selection2);
>>>>>>> Stashed changes
        addObject(playerone, 100, 300);
    }
    
    
}
