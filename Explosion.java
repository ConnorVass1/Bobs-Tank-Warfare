import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
     int animinterval= 10;
    int framecounteranim= 0;
    GreenfootImage [] arrow;
    int fc=0;
    
    public void act()
    {
        loadImages();
        animate(arrow);
        fc++;
        if (fc>50)
        {
            getWorld().removeObject(this);
            fc=0;
        }
        
    }
    
    void animate(GreenfootImage[] images)
    {
        if (framecounteranim >= images.length * animinterval)  // Greater or equal (>=) takes care of animations with different number of images.
        {
            framecounteranim = 0;
        }
        
        if (framecounteranim % animinterval == 0)  // If it's time to switch to next animation image.
        {
            setImage(images[framecounteranim/animinterval]);
        }
        
        
        framecounteranim++;
    }
    
    void loadImages()
    {
        arrow= new GreenfootImage[3];
        
        
        for(int i= 0; i<arrow.length;i++)
        {
            String imgpath= "Xp"+i+".png";
            arrow[i]= new GreenfootImage(imgpath);
        }
        
        
    }
}
