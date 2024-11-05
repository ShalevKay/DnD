package Backend.Tiles.Unit.Player;

import Backend.Tiles.Unit.HeroicUnit;
import Backend.Tiles.Unit.Unit;
import Backend.Tiles.Unit.Enemy.Enemy;

public abstract class Player extends Unit implements HeroicUnit{
    protected int experience;
    protected int level;


    public Player(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);

        this.experience = 0;
        this.level = 1;
    }


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
            experience += enemy.getExperienceValue();
            enemy.setTile('1');

            int x = position.getX();
            int y = position.getY();

            position.setX(enemy.getPosition().getX());
            position.setY(enemy.getPosition().getY());
            enemy.getPosition().setX(x);
            enemy.getPosition().setY(y);

            if(canLevelUp()){
                try{
                    levelUp();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }


}
