import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class PlayerOne extends Players
{
    //String setImage("folder/hp"+player.hp+".png"):
    
    int HP=0;
    int speedX = 0;
    int speedY = 0;
    int damage;
    int FrameCount = 0;
    int HPFrameCount;
    int PowerUpframecount=0;
    int KnockbackFrameCount = 0;
    int P1class;
    int P2class;
    
    GreenfootSound shoot = new GreenfootSound("shoot.mp3");
    GreenfootSound move = new GreenfootSound("move.mp3");
    
    AmogusMKII amog= new AmogusMKII();
    BigChonkers chonk= new BigChonkers();
    Bob bob= new Bob();
    GlassCannon glass= new GlassCannon();
    
    
    MyWorld myworld;
    
    
    
    public PlayerOne(int sel, int sel2)
    {
        P1class=sel;
        P2class=sel2;
        setclass();
       
    }
    
    
     protected void addedToWorld​(World world)
    {
        myworld= (MyWorld) world;
    }
    
    
    public void act()
    {
        if (HP==0||myworld.player2.HP==0)
        {
            return;
        }
        movement();
        HPMechanics();
        bulletmovement();
        collision();
        PowerUps();
        Knockback();

        

        System.out.println(HP);

        //System.out.println("stats are:HP1 "+HP+"SPeed1"+speedX+"Damage1"+damage);
        PlayerOne player2;

    }
    
    public void collision()
    {
        Wall s1=(Wall) getOneObjectAtOffset(0- getImage().getWidth()/2,0, Wall.class);
        if (s1!=null) 
        {
            setLocation(s1.getX()+s1.getImage().getWidth()/2
            +getImage().getWidth()/2,getY());
        }
        
        Wall s2=(Wall) getOneObjectAtOffset(0+ getImage().getWidth()/2,0, Wall.class);
        if (s2!=null) 
        {
            setLocation(s2.getX()-s2.getImage().getWidth()/2
            -getImage().getWidth()/2,getY());   
        }
        
        Wall pf=(Wall) getOneObjectAtOffset(0, getImage().getHeight()/2, Wall.class);
        if (pf!=null) 
        {
            setLocation(getX(),pf.getY()-pf.getImage().getHeight()/2
            -getImage().getHeight()/2+1);
        }
        
        Wall sg=(Wall) getOneObjectAtOffset(0,- getImage().getHeight()/2, Wall.class);
        if (sg!=null) 
        {
            setLocation(getX(), sg.getY()+sg.getImage().getHeight()/2
            +getImage().getHeight()/2);
        }
    }
    
    
    public void movement()
    {
        //stopspeedX = speedX - speedX;
        //stopspeedY = speedY - speedY;
        
        if(Greenfoot.isKeyDown("D"))
        {
            turn(speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("A"))
        {
            turn(-speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("W"))
        {
            move(speedX);
            move.play();
        }
        if(Greenfoot.isKeyDown("S"))
        {
            move(-speedX);
            move.play();
        }
    }
    
    
    public void bulletmovement()
    {
        FrameCount++;
        if(Greenfoot.isKeyDown("Space") && FrameCount > 30)
        {
             Bullet bullet = new Bullet(5,0);
             bullet.setRotation(getRotation());
             getWorld().addObject(bullet, getX(), getY());
             shoot.play();
             FrameCount = 0;
        }
    }
    
    public void HPMechanics()
    {
        HPFrameCount++;
        if(isTouching(Bullet2.class) && HPFrameCount > 96)
        {
            HP = HP - myworld.player2.damage;
            HPFrameCount = 0;
        }
        
        if (HP==0)
        {
            getWorld().addObject(new PlayerTwoWins(), 500, 300);
            return;
        }
    }
    
    
    
    public void PowerUps()
    {
        
        if(isTouching(Heal.class))
        {
            HP = HP + 1;
        }
        
        if(isTouching(Speed.class))
        {
            PowerUpframecount++;
            if(PowerUpframecount<=100)
            {
                speedX=speedX+5;
            }
        }
        
        if(isTouching(Damage.class))
        {
            PowerUpframecount++;
            if(PowerUpframecount<=100)
            {
                damage=damage+1;
            }
        }
        
        if (PowerUpframecount>=100)
        {
            damage=1;
            speedX=speedX-1;
        }
    }
    
    public void setclass()
    {
        if(P1class==1)
        {
            HP= amog.HP;
            speedX=amog.speedX;
            speedY=amog.speedX;
            damage= amog.damage;
        }
        
        if(P1class==2)
        {
            HP= chonk.HP;
            speedX=chonk.speedX;
            speedY=chonk.speedX;
            damage= chonk.damage;
        }
        
        if(P1class==3)
        {
            HP= bob.HP;
            speedX=bob.speedX;
            speedY=bob.speedX;
            damage= bob.damage;
        }
        
        if(P1class==4)
        {
            HP= glass.HP;
            speedX=glass.speedX;
            speedY=glass.speedX;
            damage= glass.damage;
        }
    }
    
    public void Knockback()
    {
        
        Bullet2 a1=(Bullet2) getOneObjectAtOffset(0 + getImage().getWidth()/2,0, Bullet2.class);
        if (a1!=null) 
        {
            setLocation(getX() - speedX/2, getY());  
        }
        Bullet2 a2=(Bullet2) getOneObjectAtOffset(0 - getImage().getWidth()/2,0, Bullet2.class);
        if (a2!=null) 
        {
            setLocation(getX() + speedX/2, getY());  
        }
        Bullet2 a3=(Bullet2) getOneObjectAtOffset(0, 0 - getImage().getHeight()/2, Bullet2.class);
        if (a3!=null) 
        {
            setLocation(getX(), getY() + speedX/2);  
        }
        Bullet2 a4=(Bullet2) getOneObjectAtOffset(0, 0 + getImage().getHeight()/2, Bullet2.class);
        if (a4!=null) 
        {
            setLocation(getX(), getY() - speedX/2);  
        }
        
        
    }
    
}
