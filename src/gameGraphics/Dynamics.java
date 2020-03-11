package gameGraphics;

import models.Minion;
import other.Coordinates;

public class Dynamics {
    Minion minion = new Minion();
    //TODO убрать генерацию миньенов в другой класс
    void actionPerformed(){

        Coordinates startMinionPosition = new Coordinates(1,1);
        minion.move(startMinionPosition);


    }
}
