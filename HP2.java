import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP2 extends HPBars
{
    PlayerTwo p2= new PlayerTwo();
    public void act()
    {
        while(p2.HP>0)
        {
            String image="folder/hp"+p2.HP+".png";
            setImage("image");
        }
        if (p2.HP==0)
        {
            setImage("folder/hp0.png");
        }
    }
}
