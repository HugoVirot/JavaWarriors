package warriors.engine;

public class Potion extends Surprise{

    public Potion (String name, int lifeLevel){
        this.name = name;
        this.lifeLevel = lifeLevel;
        this.type = "potion";
    }

    public String toString() {
        return "C'est une " + name + ", elle peut vous fait gagner + " + lifeLevel + " point(s) de vie" ;
    }

}
