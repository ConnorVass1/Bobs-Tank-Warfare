import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmogusMKII here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmogusMKII extends TankClasses
{
    int HP=7;
    int speedX = 8;
    int speedY = 0;
    int damage=1;
    public void act()
    {
        if (getWorld() instanceof Player2Selection)
        {
            setImage("SpeedTankp.png");         
        } 
        if (getWorld() instanceof Player1Selection)
        {
            setImage("SpeedTank.png");         
        } 
    }
}
