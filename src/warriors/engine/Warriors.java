package warriors.engine;

import warriors.contracts.*;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warriors implements WarriorsAPI {
    private final List<Hero> heroesList;
    private final List<Map> mapsList;
    warriors.engine.GameState gameState;
    int diceResult;

    public Warriors() {
        this.heroesList = new ArrayList<>();
        Hero hero1 = new Warrior("Johan", 10, 4);
        Hero hero2 = new Warrior("Alexis", 6, 1);
        Hero hero3 = new Wizard("Merlin", 5, 10);
        Hero hero4 = new Wizard("Steven", 6, 15);
        heroesList.add(hero1);
        heroesList.add(hero2);
        heroesList.add(hero3);
        heroesList.add(hero4);

        this.mapsList = new ArrayList<>();
        warriors.engine.Map niortMap = new warriors.engine.Map("NiortMap", 64);

        Weapon arc = new Weapon("arc", 1);
        Square caseArc = new Square(arc);
        Weapon massue = new Weapon("massue", 3);
        Square caseMassue = new Square(massue);
        Weapon epee = new Weapon("epee", 5);
        Square caseEpee = new Square(epee);

        Spell eclair = new Spell("eclair", 2);
        Square caseEclair = new Square(eclair);
        Spell bouledefeu = new Spell("boule de feu", 7);
        Square caseBouleDeFeu = new Square(bouledefeu);

        Potion potionMineure = new Potion("potion mineure", 1);
        Square casePotionMineure = new Square(potionMineure);
        Potion potionStandard = new Potion("potion standard", 2);
        Square casePotionstandard = new Square(potionStandard);
        Potion superPotion = new Potion("grande potion", 5);
        Square caseSuperPotion = new Square(superPotion);

        //Enemy goblin = new Enemy("gobelin", 3, 4);     ne marche pas car crée le même ennemi sur ttes les cases goblin
        //Square caseGoblin = new Square(goblin);       sa vie reste à -3, etc

        Event vide = new Event();
        Square emptySquare = new Square(vide);

        niortMap.addToMap(emptySquare, 0);
        niortMap.addToMap(caseEclair, 1);
        niortMap.addToMap(caseArc, 2);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 3);
        niortMap.addToMap(caseEclair, 4);
        niortMap.addToMap(caseMassue, 5);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 6);
        niortMap.addToMap(casePotionMineure, 7);
        niortMap.addToMap(caseEclair, 8);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 9);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 10);
        niortMap.addToMap(caseArc, 11);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 12);
        niortMap.addToMap(casePotionMineure, 13);
        niortMap.addToMap(caseArc, 14);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 15);
        niortMap.addToMap(emptySquare, 16);
        niortMap.addToMap(caseEclair, 17);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 18);
        niortMap.addToMap(caseArc, 19);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 20);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 21);
        niortMap.addToMap(caseMassue, 22);
        niortMap.addToMap(caseEclair, 23);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 24);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 25);
        niortMap.addToMap(caseArc, 26);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 27);
        niortMap.addToMap(casePotionMineure, 28);
        niortMap.addToMap(casePotionMineure, 29);
        niortMap.addToMap(new Square(new Enemy("gobelin", 3, 5)), 30);
        niortMap.addToMap(casePotionstandard, 31);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 32);
        niortMap.addToMap(casePotionMineure, 33);
        niortMap.addToMap(emptySquare, 34);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 35);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 36);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 37);
        niortMap.addToMap(caseMassue, 38);
        niortMap.addToMap(casePotionstandard, 39);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 40);
        niortMap.addToMap(caseSuperPotion, 41);
        niortMap.addToMap(caseEpee, 42);
        niortMap.addToMap(casePotionstandard, 43);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 44);
        niortMap.addToMap(new Square(new Enemy("dragon", 15, 9)), 45);
        niortMap.addToMap(emptySquare, 46);
        niortMap.addToMap(new Square(new Enemy("sorcier", 8, 7)), 47);
        niortMap.addToMap(caseBouleDeFeu, 48);
        niortMap.addToMap(caseBouleDeFeu, 49);
        niortMap.addToMap(emptySquare, 50);
        niortMap.addToMap(emptySquare, 51);
        niortMap.addToMap(new Square(new Enemy("dragon", 15, 9)), 52);
        niortMap.addToMap(caseEpee, 53);
        niortMap.addToMap(emptySquare, 54);
        niortMap.addToMap(emptySquare, 55);
        niortMap.addToMap(new Square(new Enemy("dragon", 15, 9)), 56);
        niortMap.addToMap(emptySquare, 57);
        niortMap.addToMap(emptySquare, 58);
        niortMap.addToMap(emptySquare, 59);
        niortMap.addToMap(emptySquare, 60);
        niortMap.addToMap(emptySquare, 61);
        niortMap.addToMap(new Square(new Enemy("dragon", 15, 9)), 62);
        niortMap.addToMap(emptySquare, 63);
        niortMap.addToMap(emptySquare, 64);

        mapsList.add(niortMap);
    }


    @Override
    public List<Hero> getHeroes() {
        return heroesList;
    }

    @Override
    public List<Map> getMaps() {
        return mapsList;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        gameState = new warriors.engine.GameState(playerName, hero, map);
        return gameState;
    }

    @Override
    public GameState nextTurn(String gameID) {

        //générer un résultat de dé entre 1 et 6       pas de system out, stocker dans lastlog
        diceResult = diceRoll();
        Hero hero = gameState.getHero();
        warriors.engine.Map map = (warriors.engine.Map) gameState.getMap();
        String message = "";

        //déplacer le perso et afficher la case actuelle
        gameState.setCurrentSquare(gameState.getCurrentSquare() + diceResult);

        // fin du plateau
        if (gameState.getCurrentSquare() >= 64) {
            gameState.setCurrentSquare(64);
            message = "Vous avez fait un " + diceResult + " et vous etes sur la case " + gameState.getCurrentSquare() + ", VICTOIRE !!!";
            gameState.setGameStatus(GameStatus.FINISHED);

            // partie toujours en cours
        } else {
            Square currentSquare = map.getSquareContent(gameState.getCurrentSquare());
            String currentSquareType = currentSquare.getEvent().getType();

            message = "Vous avez fait un " + diceResult + " et vous êtes sur la case " + gameState.getCurrentSquare() + "\nC'est une case " + currentSquareType;

            switch (currentSquareType) {

                // ***************************** case ennemi *******************************
                case "ennemi":
                    Event enemy = currentSquare.getEvent();
                    message += "\n" + enemy.toString();

                    int ennemyAttackLevel = enemy.getAttackLevel();
                    int heroAttackLevel = hero.getAttackLevel();

                    while (enemy.getLifeLevel() > 0 && hero.getLife() > 0) { // tant que l'ennemi ET le héros sont vivant (=> arrêt si un des deux meurt)
                        // le personnage attaque
                        message += "\nVous le frappez à hauteur de " + heroAttackLevel + "! ";

                        // la vie de l'ennemi baisse
                        enemy.setLifeLevel(enemy.getLifeLevel() - heroAttackLevel);

                        if (enemy.getLifeLevel() <= 0) {  // si ennemi KO => fin du combat
                            message += "\nL'ennemi est vaincu !";

                        } else {         // sinon, le combat continue
                            message += "\nSa vie est maintenant de " + enemy.getLifeLevel() + " PV";

                            // l'ennemi contre-attaque + vie héros actualisée
                            message += "\nL'ennemi contre-attaque ! Vous perdez " + ennemyAttackLevel + " PV !";
                            ((LocalHero) hero).setLifeLevel(hero.getLife() - ennemyAttackLevel);
                        }
                    }

                    if (hero.getLife() <= 0) {
                        message += "\nVous êtes mort ! GAME OVER";
                        gameState.setGameStatus(GameStatus.GAME_OVER);
                    }
                    break;


                // ***************************** case potion *******************************

                case "potion":
                    Event potion = currentSquare.getEvent();
                    message += "\n" + potion.toString();

                    if (hero.getLife() == ((LocalHero) hero).getMaxLife()) {  // si vie au max : on n'applique pas la potion
                        message += "\nVotre vie est déjà au maximum : " + hero.getLife() + " PV";

                    } else {         // sinon : on l'applique
                        ((LocalHero) hero).setLifeLevel(hero.getLife() + potion.getLifeLevel());

                        if (hero.getLife() >= ((LocalHero) hero).getMaxLife()) {  // si la vie dépasse le max, on la réajuste au max, puis on affiche un message le disant
                            ((LocalHero) hero).setLifeLevel(((LocalHero) hero).getMaxLife());
                            message += "\nVotre vie est maintenant de " + ((LocalHero) hero).getMaxLife() + " PV : elle est au maximum !";

                        } else {    // sinon , message normal
                            message += "\nVotre vie est maintenant de " + hero.getLife() + " PV";
                        }
                    }
                    break;


                // ***************************** case arme *******************************

                case "arme":

                    Event weaponEvent = currentSquare.getEvent();  // on récupère l'évènement arme
                    Weapon weapon = (Weapon) weaponEvent;  // on le caste (= transforme) en type Weapon

                    if (hero instanceof Warrior) {  // si le héros est un guerrier

                        message += "\n" + weapon.toString();

                        int maxAttack = ((Warrior) hero).getMaxAttack();  // on récupère son attaque max

                        int currentWeaponAttackLevel;
                        if (((Warrior) hero).getWeapon() != null) {
                            currentWeaponAttackLevel = hero.getAttackLevel() - ((Warrior) hero).getWeapon().getAttackLevel(); // niveau d'attaque de l'ancienne arme
                        } else {
                            currentWeaponAttackLevel = 0;
                        }
                        if (weapon.getAttackLevel() > currentWeaponAttackLevel) {  //si attaque nouvelle arme > à l'ancienne
                            if (hero.getAttackLevel() < maxAttack) {               // si attaque actuelle inférieure à l'attaque max de la classe
                                ((LocalHero) hero).deleteWeapon();      // on lui retire l'ancienne arme
                                ((LocalHero) hero).setWeapon(weapon);   // on lui ajoute la nouvelle
                                ((LocalHero) hero).setAttackLevel(hero.getAttackLevel() + weapon.getAttackLevel());  // on calcule sa nouvelle attaque

                                if (hero.getAttackLevel() > maxAttack) {  // on teste la nouvelle attaque obtenue et on la réajuste si elle dépasse le max autorisé
                                    ((LocalHero) hero).setAttackLevel(maxAttack);
                                    message += "\nL'arme a augmenté votre niveau d'attaque au maximum, soit " + maxAttack;
                                } else {
                                    message += "\nL'arme a augmenté votre niveau d'attaque à " + hero.getAttackLevel();
                                }

                            } else {                                    // si attaque déjà au max : pas de changement
                                message += "\nVotre niveau d'attaque est déjà au maximum : " + maxAttack;
                            }
                        } else {
                            message += "\nL'arme est plus faible que celle déjà équipée ou équivalente";
                        }

                    } else {  // si le héros est un magicien
                        message += "\nCette arme vous est inutile car vous n'êtes pas un guerrier";
                    }
                    break;


                // ***************************** case sort *******************************

                case "sort":

                    Event spellEvent = currentSquare.getEvent();  // on récupère l'évènement sort
                    Spell spell = (Spell) spellEvent;  // on le caste (= transforme) en type Spell

                    if (hero instanceof Wizard) {   // si le héros est un magicien

                        message += "\n" + spell.toString(); // on affiche le message correspondant au sort

                        int maxAttack = ((Wizard) hero).getMaxAttack();  // on récupère l'attaque max de la classe magicien

                        if (hero.getAttackLevel() < maxAttack) {  // si attaque actuelle inférieure à l'attaque max de la classe, on attribue le sort
                            ((LocalHero) hero).deleteSpell();
                            ((LocalHero) hero).setSpell(spell);
                            ((LocalHero) hero).setAttackLevel(hero.getAttackLevel() + spell.getAttackLevel());

                            if (hero.getAttackLevel() > ((LocalHero) hero).getMaxAttack()) {
                                ((LocalHero) hero).setAttackLevel(maxAttack);
                            }
                            message += "\nLe sort a augmenté votre niveau d'attaque au maximum, soit " + maxAttack + " points d'attaque";

                        } else {                                    // sinon, pas de changement
                            message = message + "\nVotre niveau d'attaque est déjà au maximum : " + maxAttack + " points d'attaque";
                        }

                    } else {     // si le héros est un guerrier
                        message += "\nCe sort vous est inutile car vous n'êtes pas un magicien";
                    }
                    break;

                default:
                    break;
            }
        }
        gameState.setLastLog(message);
        return gameState;
    }

    private int diceRoll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}