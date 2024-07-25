import org.example.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.example.Player;
import org.example.Weapon;

import java.lang.reflect.Field;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    private Point point;
    private Player player;

    @BeforeEach
    void setUp() {
        point = new Point(6, 5);
        player = new Player("John", 100, Weapon.SWORD);
    }

    @DisplayName("Point sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testPointTypesAccessModifiers() throws NoSuchFieldException {
        Field xField = point.getClass().getDeclaredField("x");
        assertEquals(xField.getModifiers(), 2);

        Field yField = point.getClass().getDeclaredField("x");
        assertEquals(yField.getModifiers(), 2);
    }

    @DisplayName("Point sınıf değişkenleri doğru tipte mi ?")
    @Test
    public void testPointTypes() {
        assertThat(point.getX(), instanceOf(Integer.class));
        assertThat(point.getY(), instanceOf(Integer.class));
    }

    @DisplayName("Parametre almayan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithoutParameter() {
        assertEquals(point.distance(0, 0), 7.810249675906654);
    }

    @DisplayName("Parametre alan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithTwoParameter() {
        assertEquals(point.distance(2, 2), 5.0);
    }

    @DisplayName("Point sınıfı parametresi alan distance methodu doğru çalışıyor mu ?")
    @Test
    public void testDistanceMethodWithPointParameter() {
        Point second = new Point(3, 1);
        assertEquals(point.distance(second), 5.0);
    }

    @DisplayName("Player sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testPlayerTypesAccessModifiers() throws NoSuchFieldException {
        Field nameField = player.getClass().getDeclaredField("name");
        assertEquals(nameField.getModifiers(), 2);

        Field healthPercentageField = player.getClass().getDeclaredField("healthPercentage");
        assertEquals(healthPercentageField.getModifiers(), 2);

        Field weaponField = player.getClass().getDeclaredField("weapon");
        assertEquals(weaponField.getModifiers(), 2);
    }

    @DisplayName("Weapon enum değişkenleri doğru tipte mi ?")
    @Test
    public void testWeaponTypesAccessModifiers() throws NoSuchFieldException {
        assertThat(Weapon.SWORD.getDamage(), instanceOf(Integer.class));
        assertThat(Weapon.SWORD.getAttackSpeed(), instanceOf(Double.class));
    }

    @DisplayName("HealthPercentage metodu doğru çalışıyor mu ?")
    @Test
    public void testHealthPercentage() {
        assertEquals(player.healthRemaining(), 100);
        player.loseHealth(20);
        assertEquals(player.healthRemaining(), 80);
    }

    @DisplayName("loseHealth metodu doğru çalışıyor mu ?")
    @Test
    public void testLoseHealth() {
        player.loseHealth(20);
        player.loseHealth(20);
        assertEquals(player.healthRemaining(), 60);
        player.loseHealth(80);
        assertEquals(player.healthRemaining(), 0);
    }

    @DisplayName("restoreHealth metodu doğru çalışıyor mu ?")
    @Test
    public void testRestoreHealth() {
        player.loseHealth(20);
        player.restoreHealth(10);
        assertEquals(player.healthRemaining(), 90);
        player.restoreHealth(20);
        assertEquals(player.healthRemaining(), 100);
    }
}
