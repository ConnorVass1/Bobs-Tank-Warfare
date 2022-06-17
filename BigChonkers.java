import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BigChonkers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BigChonkers extends TankClasses
{//sets values for tank on selection 
    int HP=15;
    int speedX = 2;
    int speedY = 0;
    int damage=1;
    public void act()
    {
       if (getWorld() instanceof Player2Selection)
        {
            setImage("Tankyp.png");         
        } 
        if (getWorld() instanceof Player1Selection)
        {
            setImage("Tanky.png");         
        } 
    }
}
