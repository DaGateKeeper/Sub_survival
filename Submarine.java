
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.Screen;

/**
 * Write a description of class Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submarine extends BaseActor
{
    public float shotTimer;
    public int normalAmmo;
    public int specialAmmo;
    public int weapon;
    
    public static Sound shotSFX = Gdx.audio.newSound(Gdx.files.internal("assets/audio/sfx/Missile-Launch.wav"));
    
    public Submarine(float x, float y, Stage stage)
    {
        super(x,y,stage);

        setAnimator( new Animator("assets/images/sub.png") );
        setBoundaryPolygon(10);
        
        physics = new Physics(2000, 600, 8000);
        
        shotTimer = 0;
        normalAmmo = 15;
        specialAmmo = 0;
        weapon = 0;
    }

    @Override
    public void act(float dt)
    {
        super.act(dt);
        shotTimer += dt;
        boundToWorld(800, 600);
    }
    
    public void fire(BaseScreen s)
    {
        if (specialAmmo != 0)
        {
            
        }
        else if (shotTimer >= 1 && normalAmmo > 0)
        {
            Laser laser = new Laser(0, 0, s.mainStage);
            laser.centerAt(this);
            shotSFX.play();
            normalAmmo--;
            shotTimer = 0;
        }
        
        // Resets weapon if out of ammo.
        if (specialAmmo <= 0)
            weapon = 0;
    }
}
 
