package rpg_tests;

import org.junit.Test;
import org.mockito.Mock.*;

import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    @Test
    public void testHeroGainsXPbyKillingTargets() {
        Weapon weapon = mock(Weapon.class);
        Target target = mock(Target.class);

        when(target.giveExperience()).thenReturn(10);
        when(target.isDead()).thenReturn(true);


        Hero hero = new Hero("Test", weapon);
        hero.attack(target);

        assertEquals(10, hero.getExperience());
    }
    @Test
    public void testItemDropShouldDropCorrectly(){
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Test", weapon);
        Target target = mock(Target.class);

        Random random = mock(Random.class);
        when(random.nextInt(anyInt())).thenReturn(2);
        Weapon weapon1 = mock(Weapon.class);
        Weapon weapon2 = mock(Weapon.class);
        Weapon weapon3 = mock(Weapon.class);

        //when(target.dropWeapon(random)).thenReturn()
    }

}