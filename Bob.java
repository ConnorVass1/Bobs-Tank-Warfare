import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bob extends TankClasses
{
    int HP=10;
    int speedX = 5;
    int speedY = 0;
    int damage=1;
    public void act()
    {
        if (getWorld() instanceof Player2Selection)
        {
            setImage("Normp2.png");         
        } 
        if (getWorld() instanceof Player1Selection)
        {
            setImage("Normp1.png");         
        } 
    }
}
