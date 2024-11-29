import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Wall;
import Backend.Tiles.Unit.Player.Hunter;
import Backend.Tiles.Unit.Player.Mage;
import Backend.Tiles.Unit.Player.Player;
import Backend.Tiles.Unit.Player.Rogue;
import Backend.Tiles.Unit.Player.Warrior;

public class Factory {
    Map<Heroes, Supplier<Player>> heroes;

    
    public Factory(){
        heroMap();
    }

    private void heroMap(){
        heroes = new HashMap<>();

        heroes.put(Heroes.DALINAR, () -> new Warrior('@', -1, -1, "Dalinar Kholin",
                                                300, 30, 4, 3));
        heroes.put(Heroes.ADOLIN, () -> new Warrior('@', -1, -1, "Adolin Kholin",
                                                400, 20, 6, 5));
        heroes.put(Heroes.JASNAH, () -> new Mage('@', -1, -1, "Jasnah Kholin", 
                                                100, 5, 1, 300, 30, 15, 5, 6)); 
        heroes.put(Heroes.SHALLAN, () -> new Mage('@', -1, -1, "Shallan Davar", 
                                                250, 25, 4, 150, 20, 20, 3, 4));
        heroes.put(Heroes.KALADIN, () -> new Rogue('@', -1, -1, "Kaladin Stormblessed", 
                                                150, 40, 2, 20));
        heroes.put(Heroes.SZETH, () -> new Rogue('@', -1, -1, "Szeth son-son-Vallano", 
                                                250, 35, 3, 50));
        heroes.put(Heroes.LIFT, () -> new Hunter('@', -1, -1, "Lift", 
                                                220, 30, 2, 6));
    }

    public EmptyTile makeEmptyTile(int x, int y){
        return new EmptyTile('.', x, y);
    }

    public Wall makeWall(int x, int y){
        return new Wall('#', x, y);
    }





    public enum Heroes {
        DALINAR, ADOLIN, JASNAH, SHALLAN, KALADIN, SZETH, LIFT
    }


}
