package warriors.engine;

public class Spell extends Surprise{

    public Spell (String name, int attackLevel){
        this.name = name;
        this.attackLevel = attackLevel;
        this.type = "sort";
    }

    public String toString() {
       return "\nVous etes sur une case sort, c'est un(e) " + name + ", elle peut vous faire gagner +" + attackLevel + " points d'attaque";
    }
}
