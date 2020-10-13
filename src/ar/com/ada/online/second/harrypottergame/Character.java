package ar.com.ada.online.second.harrypottergame;

import java.util.Objects;

public abstract class Character {
    protected String name;
    protected char location;
    protected Integer life;
    protected Integer magicEnergy;
    protected String spells;

//Constructor vacio

    public Character() {
    }

//getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public String getSpells() {
        return spells;
    }

    public void setSpells(String spells) {
        this.spells = spells;
    }

    //metodos abstractos
    public abstract void attack();

    public abstract void heal();

    public abstract void recovery();

    public abstract void receiveAttack();

    public abstract void isAlive();

    public abstract void addSpell();

    public abstract void characterStatus();

    public abstract void darkOrFree();

    //

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Character that = (Character) obj;
        return location == that.location &&
                name.equals(that.name) &&
                life.equals(that.life) &&
                magicEnergy.equals(that.magicEnergy) &&
                spells.equals(that.spells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, life, magicEnergy, spells);
    }

    @Override
    public String toString() {
        return String.format(
                "Character{ name= %s, location= $s, life= %d, magicEnergy= %d, spells= %s}",
                name,
                location,
                life,
                magicEnergy,
                spells
        );

    }
}
