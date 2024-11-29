import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import Backend.Tiles.EmptyTile;
import Backend.Tiles.Wall;
import Backend.Tiles.Unit.Enemy.Monster;
import Backend.Tiles.Unit.Enemy.Trap;
import Backend.Tiles.Unit.Player.Hunter;
import Backend.Tiles.Unit.Player.Mage;
import Backend.Tiles.Unit.Player.Player;
import Backend.Tiles.Unit.Player.Rogue;
import Backend.Tiles.Unit.Player.Warrior;

public class Factory {
    private Map<Heroes, Supplier<Player>> heroes;
    private Map<Monsters, Supplier<Monster>> monsters;
    private Map<Traps, Supplier<Trap>> traps;
    

    
    public Factory(){
        heroMap();
        monsterMap();
        trapMap();
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

    private void monsterMap(){
        monsters = new HashMap<>();

        monsters.put(Monsters.NIMBLE_PARSHENDI,
                        () -> new Monster('s', -1, -1, "Nimble Parshendi", 80, 8, 3, 25, 3));
        monsters.put(Monsters.WORK_PARSHENDI,
                        () -> new Monster('k', -1, -1, "Work Parshendi", 200, 14, 8, 50, 4));
        monsters.put(Monsters.SADEAS_SOLDIER,
                        () -> new Monster('q', -1, -1, "Sadeas Soldier", 400, 20, 15, 100, 5));
        monsters.put(Monsters.WAR_PARSHENDI,
                        () -> new Monster('z', -1, -1, "War Parshendi", 600, 30, 15, 100, 3));
        monsters.put(Monsters.WHITESPINE, 
                        () -> new Monster('b', -1, -1, "Whitespine", 1000, 75, 30, 250, 4));
        monsters.put(Monsters.STORM_PARSHENDI,
                        () -> new Monster('g', -1, -1, "Storm Parshendi", 1500, 100, 40, 500, 5));
        monsters.put(Monsters.SHARD_PARSHENDI,
                        () -> new Monster('w', -1, -1, "Shard Parshendi", 1000, 60, 25, 500, 6));
        monsters.put(Monsters.ESHONAI,
                        () -> new Monster('M', -1, -1, "Eshonai", 2000, 15, 50, 1000, 6));
        monsters.put(Monsters.TYN,
                        () -> new Monster('C', -1, -1, "Tyn", 100, 10, 10, 1000, 1));
        monsters.put(Monsters.CHASMFIEND,
                        () -> new Monster('K', -1, -1, "Chasmfiend", 5000, 300, 150, 5000, 8));
    }
    
    private void trapMap(){
        traps = new HashMap<>();

        traps.put(Traps.BONUS,
                    () -> new Trap('B', -1, -1, "Bonus Trap", 1, 1, 1, 1, 5, 250));
        traps.put(Traps.ILLUSION,
                    () -> new Trap('Q', -1, -1, "Illusion", 250, 50, 10, 3, 7, 100));
        traps.put(Traps.UNMADE,
                    () -> new Trap('D', -1, -1, "Unmade", 500, 100, 20, 1, 10, 250));
    }

    public EmptyTile makeEmptyTile(int x, int y){
        return new EmptyTile('.', x, y);
    }

    public Wall makeWall(int x, int y){
        return new Wall('#', x, y);
    }

    public Player makePlayer(Heroes hero, int x, int y){
        Player p =  heroes.get(hero).get();
        
        p.getPosition().setX(x);
        p.getPosition().setY(y);
        
        return p;
    }

    public Monster makeMonster(Monsters monster, int x, int y){
        Monster m = monsters.get(monster).get();

        m.getPosition().setX(x);
        m.getPosition().setY(y);

        return m;
    }

    public Trap makeTrap(Traps trap, int x, int y){
        Trap t = traps.get(trap).get();

        t.getPosition().setX(x);
        t.getPosition().setY(y);

        return t;
    }



    public enum Heroes {
        DALINAR, ADOLIN, JASNAH, SHALLAN, KALADIN, SZETH, LIFT
    }

    public enum Monsters {
        NIMBLE_PARSHENDI, WORK_PARSHENDI, SADEAS_SOLDIER, WAR_PARSHENDI, WHITESPINE,
        STORM_PARSHENDI, SHARD_PARSHENDI, ESHONAI, TYN, CHASMFIEND
    }

    public enum Traps {
        BONUS, ILLUSION, UNMADE
    }

}
