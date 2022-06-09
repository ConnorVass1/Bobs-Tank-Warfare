import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP1 extends HPBars
{
    PlayerOne p1= new PlayerOne();
    public void act()
    {
        while(p1.HP>0)
        {
            String image="folder/hp"+p1.HP+".png";
            setImage("image");
        }
        if (p1.HP==0)
        {
            setImage("folder/hp0.png");
        }
    }
}
