package Backend.Tiles.Unit.Player;

import java.util.List;

import Backend.Board;
import Backend.Tiles.Unit.Enemy.Enemy;

public class Rogue extends Player {
    private final static int ENERGY = 100;
    
    private int currentEnergy;
    private int cost;

    
    public Rogue(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int cost){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.currentEnergy = ENERGY;
        this.cost = cost;
    }

    @Override
    protected void levelUp() throws Exception{
        super.levelUp();

        currentEnergy = ENERGY;
        attackPoints += 3 * level;
    }

    @Override
    public void onTick(char action, Board board, List<Enemy> enemies) throws Exception{
        super.onTick(action, board, enemies);

        currentEnergy += 10;

        if(currentEnergy > ENERGY){
            currentEnergy = ENERGY;
        }

    }

    @Override
    public void castAbility(List<Enemy> enemies) {
        if(currentEnergy < cost){
            return;
        }

        currentEnergy -= cost;

        for(Enemy e : enemies){
            if(range(e) < 2){
                e.defend(attackPoints);

                deadEnemy(e);
            }
        }
    }    
}
