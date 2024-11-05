package Backend.Tiles.Unit.Player;

import Backend.Tiles.Unit.HeroicUnit;
import Backend.Tiles.Unit.Unit;
import Backend.Tiles.Unit.Enemy.Enemy;

public abstract class Player extends Unit implements HeroicUnit{
    protected int experience;
    protected int level;


    protected boolean canLevelUp(){
        return experience >= level * 50;
    }

    protected void levelUp() throws Exception{
        if(!canLevelUp()){
            throw new Exception("cannot level up");
        }

        experience -= 50 * level;
        level++;
        healthPool += 10 * level;
        currentHealth = healthPool;
        attackPoints += 4 * level;
        defensePoints += level;
    }

    @Override
    public void visit(Player player){
        return;
    }

    @Override
    public void visit(Enemy enemy){
        attack(enemy);

        if(enemy.isDead()){
            
        }
    }


}
