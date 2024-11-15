package Backend.Tiles.Unit.Player;

import java.util.List;

import Backend.Board;
import Backend.Tiles.Unit.Enemy.Enemy;

public class Hunter extends Player {
    private final int range;
    private int currentArrows;
    private int ticksCount;


    public Hunter(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints, int range) {
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.range = range;
        this.currentArrows = 10;
        this.ticksCount = 0;
    }

    @Override
    protected void levelUp() throws Exception {
        super.levelUp();

        currentArrows += 10 * level;
        attackPoints += 2 * level;
        defensePoints += level;
    }

    @Override
    public void onTick(char action, Board board, List<Enemy> enemies) throws Exception {
        super.onTick(action, board, enemies);

        if(ticksCount == 10){
            currentArrows += level;
            ticksCount = 0;
        }
        else{
            ticksCount++;
        }

    }

    @Override
    public void castAbility(List<Enemy> enemies){
        if(currentArrows == 0){
            return;
        }

        Enemy closest = null;
        double minRange = Double.MAX_VALUE;
        double enemyRange;

        for(Enemy e : enemies){
            enemyRange = range(e);

            if(enemyRange < range){
                if(closest == null || enemyRange < minRange){
                    closest = e;
                    minRange = enemyRange;
                }
            }
        }

        if(closest != null){
            currentArrows--;
            closest.defend(attackPoints);

            deadEnemy(closest);
        }
    }

}
