import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GlassCannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GlassCannon extends TankClasses
{
    int HP=5;
    int speedX = 5;
    int speedY = 0;
    int damage=1;
    public void act()
    {
       if (getWorld() instanceof Player2Selection)
        {
            setImage("dmgTankp.png");         
        } 
       if (getWorld() instanceof Player1Selection)
        {
            setImage("dmgTank.png");         
        } 
    }
}
