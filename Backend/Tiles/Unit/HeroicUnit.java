package Backend.Tiles.Unit;

import java.util.List;

import Backend.Tiles.Unit.Enemy.Enemy;
import Backend.Tiles.Unit.Player.Player;

public interface HeroicUnit {

    default void castAbility(List<Enemy> enemies){
        return;
    }

    default void castAbility(Player player){
        return;
    }


}
