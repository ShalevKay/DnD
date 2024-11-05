package Backend.Tiles.Unit;

import java.util.List;

import Backend.Tiles.Unit.Enemy.Enemy;
import Backend.Tiles.Unit.Player.Player;

public interface HeroicUnit {

    void castAbility(List<Enemy> enemies);

    void castAbility(Player player);


}
