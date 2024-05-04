import com.example.magicalArena.model.Player;
import com.example.magicalArena.service.MagicalArenaServiceImpl;

public class TestMagicalArena {
    public static void main(String[] args) {
        testPlayerInitialization();
        testPlayerAttack();
        testPlayerDefend();
        testArenaMatch();
    }

    public static void testPlayerInitialization() {
        Player playerA = new Player("aniket", 50, 5, 10);
        assert playerA.getHealth() == 50 : "Player health initialization failed";
        assert playerA.getStrength() == 5 : "Player strength initialization failed";
        assert playerA.getAttack() == 10 : "Player attack initialization failed";
        System.out.println("testPlayerInitialization passed");
    }

    public static void testPlayerAttack() {
        Player playerA = new Player("aniket", 50, 5, 10);
        Player playerB = new Player("rahul", 100, 10, 5);

        int initialHealth = playerB.getHealth();

        // Simulate attack and defense
        int damage = playerA.attack();
        playerB.receiveDamage(damage * playerA.getAttack());

        // Check if playerB's health has decreased
        if (playerB.getHealth() <= initialHealth) {
            System.out.println("testPlayerAttack passed");
        } else {
            System.out.println("testPlayerAttack failed: PlayerB health did not decrease after attack");
        }
    }

    public static void testPlayerDefend() {
        Player playerA = new Player("aniket", 50, 5, 10);
        int initialHealth = playerA.getHealth();
        int damage = 60;
        playerA.receiveDamage(damage);

        // Verify that health has decreased
        if (playerA.getHealth() <= initialHealth) {
            System.out.println("testPlayerDefend passed");
        } else {
            System.out.println("testPlayerDefend failed: PlayerA health did not decrease after receiving damage");
        }
    }

    public static void testArenaMatch() {
        Player playerA = new Player("aniket", 50, 5, 10);
        Player playerB = new Player("rahul", 100, 10, 5);

        MagicalArenaServiceImpl arena = new MagicalArenaServiceImpl(playerA, playerB);
        arena.simulateMatch();

        if (!playerA.isAlive() || !playerB.isAlive()) {
            System.out.println("testArenaMatch passed");
        } else {
            System.out.println("testArenaMatch failed: Both players are still alive after match simulation");
        }
    }
}
