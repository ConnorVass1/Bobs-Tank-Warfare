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
    
    public MyWorld(int selection1, int selection2)
    {    
        super(1000, 600, 1);

        int p1=selection1;
        int p2=selection2;
        addObject(new PlayerTwo(), 900, 300);
        PlayerOne playerone = new PlayerOne(selection1, selection2);

        addObject(playerone, 100, 300);
    }
    
    
}
