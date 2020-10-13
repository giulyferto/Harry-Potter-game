package ar.com.ada.online.second.harrypottergame;

import java.util.Objects;

public class Wizard extends Character{
    private String wand;

    //Se implementan metodos de la clase
    @Override
    public void attack() {

    }

    @Override
    public void heal() {

    }

    @Override
    public void recovery() {

    }

    @Override
    public void receiveAttack() {

    }

    @Override
    public void isAlive() {

    }

    @Override
    public void addSpell() {

    }

    @Override
    public void characterStatus() {

    }

    @Override
    public void darkOrFree() {

    }
    //hashCode equals and toString

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Wizard that = (Wizard) obj;
        return super.equals(obj) && wand.equals(that.wand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wand);
    }

    @Override
    public String toString() {
         return String.format(
                "Wizard{ wand= %s name= %s, location= $s, life= %d, magicEnergy= %d, spells= %s}",
                wand,
                name,
                location,
                life,
                magicEnergy,
                spells
        );
    }
}
