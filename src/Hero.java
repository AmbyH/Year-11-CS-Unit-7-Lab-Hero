import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String a) {
        name = a;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double random = Math.random();
        if (random < 0.5) {
            opponent.hitPoints = opponent.hitPoints - 10;
        }
        else {
            hitPoints = hitPoints-10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (hitPoints>0 && opponent.hitPoints>0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + "\t" + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int wins = 0;
        int losses = 0;
        while (n>0) {
            senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (hitPoints==0) {
                losses++;
            }
            else {
                wins++;
            }
            n--;
        }
        return new int[]{wins, losses};
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        String s = "";
        int[] array = nFightsToTheDeathHelper(opponent, n);
        if (array[0]>array[1]) {
            s = "Andrew Tate wins!";
        }
        else if (array[1]>array[0]){
            s = "Taylor Swift wins!";
        }
        else {
            s = "OMG! It was actually a draw!";
        }
        return "Andrew Tate: " + array[0] + " wins" + "\n" + "Taylor Swift: " + array[1] + " wins" + "\n" + s;
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        System.out.println("Andrew Tate: " + hitPoints +"\t" + "Taylor Swift: " + opponent.hitPoints);
        Thread.sleep(1000);
    }


}
