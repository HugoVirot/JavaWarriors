package warriors.engine;

public class Weapon extends Surprise{

    public Weapon(String name, int attackLevel) {
        this.name = name;
        this.attackLevel = attackLevel;
        this.type = "arme";
    }

    public String toString() {
        return "\nVous etes sur une case arme, c'est une " + name + ", elle peut vous faire gagner +" + attackLevel + " point(s) d'attaque";
    }

}
