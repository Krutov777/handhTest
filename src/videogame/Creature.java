package videogame;

import java.util.Random;

public class Creature {
    private static final Integer MIN_HEALTH = 0;
    private static final Integer MIN_DAMAGE = 1;
    private static final Integer MIN_ATTACK = 1;
    private static final Integer MAX_ATTACK = 30;
    private static final Integer MIN_DEFENDS = 1;
    private static final Integer MAX_DEFENDS = 30;
    private static final Integer DICE_SIDES = 6;
    private static final Integer MIN_SUCCESS_ROLL = 5;
    private final String name;
    private final Integer attack;
    private final Integer defends;
    private final Integer maxHealth;
    private final Integer minDamage;
    private final Integer maxDamage;
    private Integer health;
    private final Random random = new Random();



    public Creature(String name, Integer attack, Integer defends, Integer maxHealth, Integer minDamage, Integer maxDamage, Integer health) {
        if (attack < MIN_ATTACK || MAX_ATTACK > 30)
            throw new IllegalArgumentException("Attack must be in the range from 1 to 30.");
        if (defends < MIN_DEFENDS || defends > MAX_DEFENDS)
            throw new IllegalArgumentException("Defends must be in the range from 1 to 30.");
        if (health < MIN_HEALTH || health > maxHealth)
            throw new IllegalArgumentException("Health must be in the range from 0 to " + maxHealth);
        if (minDamage < MIN_DAMAGE || minDamage > maxDamage)
            throw new IllegalArgumentException("Min damage must be in the range from 1 to " + maxDamage);
        this.name = name;
        this.attack = attack;
        this.defends = defends;
        this.maxHealth = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void dealDamage(Creature enemy) {
        if (isAlive()) {
            Integer attackModifier = attack - enemy.getDefends() + 1;
            for (int i = 0; i < attackModifier; ++i) {
                Integer dice = random.nextInt(DICE_SIDES) + 1;
                if (dice >= MIN_SUCCESS_ROLL) {
                    Integer damage = random.nextInt(maxDamage) + minDamage;
                    System.out.println("The attack from " + name + " dealt " + damage + " damage.");
                    enemy.takeDamage(damage);
                    return;
                }
            }
            System.out.println("The attack from " + name + " missed.");
        }
    }

    public void takeDamage(Integer damage) {
        if (health - damage <= 0) {
            health = 0;
            System.out.println("The attack to creature " + name + " deals " + damage + " damage.\nCreature " + name + " died.");
        } else {
            health -= damage;
            System.out.println("The attack to creature " + name + " deals " + damage + " damage.\nCreature " + name + " is still alive.\nHis current hp = " + health + ".");
        }
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefends() {
        return defends;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public Integer getMinDamage() {
        return minDamage;
    }

    public Integer getMaxDamage() {
        return maxDamage;
    }

    public Integer getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}
