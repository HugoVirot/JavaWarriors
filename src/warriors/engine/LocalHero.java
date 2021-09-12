package warriors.engine;

public abstract class LocalHero implements warriors.contracts.Hero {
    protected String heroName;
    protected int lifeLevel;
    protected int attackLevel;
    protected Weapon weapon;
    protected Spell spell;

    public LocalHero(String heroName, int lifeLevel, int attackLevel) {
        this.heroName = heroName;
        this.lifeLevel = lifeLevel;
        this.attackLevel = attackLevel;
    }

    public Weapon getWeapon() {
        if (weapon != null) {
            return weapon;
        } else {
            return null;
        }
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public void deleteWeapon() {
        if (this.weapon != null) {
            attackLevel = attackLevel - weapon.getAttackLevel();
        }
    }

    public void deleteSpell() {
        if (this.spell != null) {
            attackLevel = attackLevel - spell.getAttackLevel();
        }
    }

    @Override
    public String getName() {
        return heroName;
    }

    @Override
    public int getLife() {
        return lifeLevel;
    }

    @Override
    public int getAttackLevel() {
        return attackLevel;
    }

    public void setLifeLevel(int lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public void setAttackLevel(int setAttackLevel) {
        this.attackLevel = setAttackLevel;
    }

    public abstract int getMaxLife();

    public abstract int getMaxAttack();
}
