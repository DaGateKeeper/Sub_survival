    import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Write a description of class Submarine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Submarine extends BaseActor
{

    public Submarine(float x, float y, Stage stage)
    {
        super(x,y,stage);

        setAnimator( new Animator("assets/images/sub.png") );
        setBoundaryPolygon(10);
        
        physics = new Physics(2000, 600, 8000);
        
    }

    public void act(float dt)
    {
        super.act(dt);
        
        boundToWorld(1600,1200);
       
    }
}
 
