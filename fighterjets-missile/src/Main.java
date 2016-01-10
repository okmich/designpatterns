/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.okmich.designpatterns.fighterjets.AirFighterJet;
import com.okmich.designpatterns.fighterjets.missiles.AirToAirFirable;
import com.okmich.designpatterns.fighterjets.missiles.BisnovatMissile;
import com.okmich.designpatterns.fighterjets.missiles.BunkerBusterMissile;
import com.okmich.designpatterns.fighterjets.F15FighterJet;
import com.okmich.designpatterns.fighterjets.MiG31FighterJet;
import com.okmich.designpatterns.fighterjets.missiles.NovatorMissile;
import com.okmich.designpatterns.fighterjets.missiles.PL8Missile;
import com.okmich.designpatterns.fighterjets.missiles.Python5Missile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of a Strategy Design pattern.
 *
 * Scenario:: Two fighter jets that can fire and reload several kinds of
 * missiles. The missiles will be loaded for fire at runtime and as such is
 * decoupled from the design of the jet.
 *
 * An addition was later made to trigger an error should a missile be deployed
 * on the wrong jet. In real life, the is passing an implementation that is not
 * meant for a certain strategy... At a higher level of design, it could be
 * prevented by doing lower level interface declaration but a much lower level,
 * we are using event to trigger a deployment error.
 *
 * @author m.enudi
 */
public class Main {

    public static void main(String[] args) {

        //create first the figher jets
        AirFighterJet f15 = new F15FighterJet();
        AirFighterJet mig31 = new MiG31FighterJet();

        //creeate all the missiles in our armoury
        AirToAirFirable bisnovat = new BisnovatMissile();
        AirToAirFirable bunkerBuster = new BunkerBusterMissile();
        AirToAirFirable novator = new NovatorMissile();
        AirToAirFirable pl8 = new PL8Missile();
        AirToAirFirable python5 = new Python5Missile();

        //fire missile on planes
        f15.fireAirToAirMissile();
        mig31.fireAirToAirMissile();
        sleep();
        //now load missiles - pl8 on f15
        f15.loadAirToAirMissile(pl8);
        f15.fireAirToAirMissile();
        sleep();        //pl8 on mig31
        mig31.loadAirToAirMissile(pl8);
        mig31.fireAirToAirMissile();
        sleep();
        //novator on both
        f15.loadAirToAirMissile(novator);
        f15.fireAirToAirMissile();
        sleep();
        mig31.loadAirToAirMissile(novator);
        mig31.fireAirToAirMissile();
        sleep();
        //load bunkerbuster
        f15.loadAirToAirMissile(bunkerBuster);
        f15.fireAirToAirMissile();
        sleep();
        mig31.loadAirToAirMissile(bunkerBuster);
        mig31.fireAirToAirMissile();
        sleep();
        //load python 5
        f15.loadAirToAirMissile(python5);
        f15.fireAirToAirMissile();
        sleep();
        mig31.loadAirToAirMissile(python5);
        mig31.fireAirToAirMissile();
        sleep();
        //load bisnovat
        f15.loadAirToAirMissile(bisnovat);
        f15.fireAirToAirMissile();
        sleep();
        mig31.loadAirToAirMissile(bisnovat);
        mig31.fireAirToAirMissile();

        System.out.println("\n\n\n\n");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
        System.out.println("***************LAND ALL JETS... AND LIVE IN PEACE********************");
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
