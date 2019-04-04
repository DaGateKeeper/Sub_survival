import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor
{

    public Laser(float x, float y, Stage stage)
    {
        super(x,y,stage);
        
        setAnimator( new Animator("assets/images/bullet.png") );
        
        setPhysics( new Physics( 0, 500, 0 ) );
        
        this.physics.setSpeed(500);
        
        addAction(
            Actions.sequence(
                Actions.delay(1.0f),
                Actions.fadeOut(0.25f),
                Actions.removeActor()
            )
        );
        
    }

    public void act(float deltaTime)
    {
        super.act(deltaTime);
        

        
    }
}