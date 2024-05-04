import com.example.magicalArena.model.Player;
import com.example.magicalArena.service.MagicalArenaServiceImpl;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TestMagicalArena {
    @Test
    public void testPlayerInitialization() {
        Player playerA = new Player("aniket",50, 5, 10);
        assertEquals(50, playerA.getHealth());
        assertEquals(5, playerA.getStrength());
        assertEquals(10, playerA.getAttack());
    }

    @Test
    public void testPlayerAttack() {
        Player playerA = new Player("aniket", 50, 5, 10);
        Player playerB = new Player("rahul", 100, 10, 5);

        int initialHealth = playerB.getHealth();

        // Simulate attack and defense
        int damage = playerA.attack();
        playerB.receiveDamage(damage * playerA.getAttack());

        // Check if playerB's health has decreased
        assertTrue(playerB.getHealth() <= initialHealth);
    }

    @Test
    public void testPlayerDefend() {
        Player playerA = new Player("aniket", 50, 5, 10);
        int initialHealth = playerA.getHealth();
        int damage = 60;
        playerA.receiveDamage(damage);

        // Verify that health has decreased
        assertTrue(playerA.getHealth() <= initialHealth);
    }


    @Test
    public void testArenaMatch() {
        Player playerA = new Player("aniket",50, 5, 10);
        Player playerB = new Player("rahul",100, 10, 5);

        MagicalArenaServiceImpl arena = new MagicalArenaServiceImpl(playerA, playerB);
        arena.simulateMatch();

        assertFalse(playerA.isAlive() && playerB.isAlive());
    }
}
