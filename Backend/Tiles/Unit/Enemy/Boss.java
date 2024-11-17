package Backend.Tiles.Unit.Enemy;

import Backend.Tiles.Unit.HeroicUnit;
import Backend.Tiles.Unit.Player.Player;

public class Boss extends Monster implements HeroicUnit {
    private final int abilityFrequency;
    private int combatTicks;


    public Boss(char tile, int x, int y, String name, int healthPool,
                int attackPoints, int defensePoints, int experienceValue,
                int visionRange, int abilityFrequency){

        super(tile, x, y, name, healthPool, attackPoints, defensePoints, experienceValue, visionRange);

        this.abilityFrequency = abilityFrequency;
        combatTicks = 0;
    }

    @Override
    public void castAbility(Player player){
        
    }


    
}
