package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTest {
    @Test
    public void attackedTargetLoosesHealth() {

        Dummy dummy = new Dummy(10, 10);
        dummy.takeAttack(5);

        Assert.assertTrue(dummy.getHealth() == 5);

    }
    @Test
    public void deadDummyAttacked(){
        Dummy dummy = new Dummy(10,10);
        dummy.takeAttack(10);

    }

// TODO: Write the rest of the tests

}