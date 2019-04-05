   import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


public class EnemySub extends BaseActor 
{
//mainly taken from the alien fromSPACE ROCKS
    public EnemySub(float x, float y, Stage stage)
    {
       super(x,y,stage);

       setAnimator( new Animator("assets/images/subenemy.png") );
        
       setPhysics( new Physics(0, 50, 0) );
        
       physics.setSpeed(200);
        
       setRotation(90);
       physics.setMotionAngle(180);
       
       this.setBoundaryPolygon(8);
    }
    
    public void act(float deltaTime)
    {
        super.act(deltaTime);
    }

}
