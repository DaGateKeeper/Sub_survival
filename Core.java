import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
 
public class Core extends BaseActor
{
//from the Brick Breaker
    public Core(float x, float y, Stage stage)
    {
        super(x,y,stage);

        setAnimator( new Animator("assets/images/the-core.png") );
    }

}