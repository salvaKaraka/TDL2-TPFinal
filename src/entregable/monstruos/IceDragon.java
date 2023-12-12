package entregable.monstruos;

import java.util.Arrays;

import entregable.ataques.Wind;
import game.attacks.ColdBreath;
import game.types.Type;

public class IceDragon extends Dragon {
    
    public IceDragon(String name) {
        super(name, Arrays.asList(new ColdBreath(), new Wind()), Type.COLD, Type.WINGS);
    }

}
