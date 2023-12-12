package entregable.monstruos;

import java.util.Arrays;

import entregable.ataques.FireBreath;
import entregable.ataques.Wind;
import game.types.Type;

public class FireDragon extends Dragon {
    
    public FireDragon(String name) {
        super(name, Arrays.asList(new FireBreath(), new Wind()), Type.FIRE, Type.WINGS);
    }

}
