package videogame;

public class Player extends Creature {
    private Integer healingAttempts = 4;

    public Player(String name, Integer attack, Integer defends, Integer maxHealth, Integer minDamage, Integer maxDamage, Integer health) {
        super(name, attack, defends, maxHealth, minDamage, maxDamage, health);
    }

    public void heal() {
        if (healingAttempts > 0 && getHealth() < getMaxHealth()) {
            healingAttempts--;
            Integer healValue = (getHealth() + (int) (0.3 * getMaxHealth()) > getMaxHealth()) ? getMaxHealth() - getHealth() : (int) (0.3 * getMaxHealth());
            setHealth(getHealth() + healValue);
            System.out.println("Player " + getName() + " was healed by " + healValue + "hp." +
                    "\nHis current hp = " + getHealth() + ".\n" +
                    "Player " + getName() + "can use the heal another " + healingAttempts + "times.");
        }
    }

    public Integer getHealingAttempts() {
        return healingAttempts;
    }
}
