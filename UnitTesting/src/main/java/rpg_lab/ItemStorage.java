package rpg_lab;

import java.util.Collection;
import java.util.Random;

public interface ItemStorage extends Iterable<Weapon>{
    Weapon getWeapons(Random rnd);

    Collection<Weapon> getWeapons();
}

