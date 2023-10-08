package videogame;

public class Main {

    public static void main(String[] args) {
        Player player = new Player(
                "Player1",
                4,
                3,
                30,
                1,
                10,
                30
        );
        Monster monster = new Monster(
                "Monster1",
                3,
                4,
                60,
                1,
                6,
                60
        );
        System.out.println("Game beginning.");
        System.out.println("Player characteristics: name " + player.getName() + ", " +
                "attack " + player.getAttack() + ", " +
                "defense " + player.getDefends() + ", " +
                "maximum health " + player.getMaxHealth() + ", " +
                "damage from " + player.getMinDamage() + " to " + player.getMaxDamage() + ".");
        System.out.println("Monster characteristics: name " + monster.getName() + ", " +
                "attack " + monster.getAttack() + ", " +
                "defense " + monster.getDefends() + ", " +
                "maximum health " + monster.getMaxHealth() + ", " +
                "damage from " + monster.getMinDamage() + " to " + monster.getMaxDamage() + ".\n");

        while (monster.isAlive() && player.isAlive()) {
            if (player.getHealingAttempts() > 0 && player.getHealth() < player.getMaxHealth() * 0.7) {
                System.out.println("The player is healing.\n");
                player.heal();
            }
            System.out.println("The player attacks!");
            player.dealDamage(monster);
            if (monster.isAlive())
                System.out.println("The monster attacks!");
            monster.dealDamage(player);
        }
    }
}
