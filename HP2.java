import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP2 extends HPBars
{
    int HP;
    PlayerTwo player;
    public HP2(PlayerTwo p2)
    {
        player= p2;
    }
    
    //sets health bar depending on hp.
    public void act()
    {
        if(player.HP>0)
        {
            String image="hearts/"+player.HP+".png";
            setImage(image);
        }
        else if (player.HP==0)
        {
            setImage("hearts/0.png");
        }
    }
}
