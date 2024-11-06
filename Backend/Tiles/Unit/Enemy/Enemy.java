package Backend.Tiles.Unit.Enemy;

import Backend.Tiles.Unit.Unit;
import Backend.Tiles.Unit.Player.Player;
import Backend.VisitorInterfaces.Visitor;

public abstract class Enemy extends Unit{


    public Enemy(char tile, int x, int y, String name, int healthPool, int attackPoints, int defensePoints){
        super(tile, x, y, name, healthPool, attackPoints, defensePoints);
    }


    public int getExperienceValue(){
        return 0;
    }

    public void setName(String name){
        
    }

    @Override
    public void visit(Player player) {
        //TODO check if need anything else
        attack(player);
    }

    @Override
    public void visit(Enemy enemy) {
        return;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public abstract void onTick();

    public void reduceHealth(double damage){
        currentHealth -= (int)Math.floor(damage);
    }

}
