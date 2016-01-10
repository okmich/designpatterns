/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.fighterjets;

import com.okmich.designpatterns.fighterjets.missiles.AirToAirFirable;

/**
 *
 * @author m.enudi
 */
public class F15FighterJet implements AirFighterJet {

    private AirToAirFirable airToAirFirable;

    private final String name = "F-15";

    public F15FighterJet() {
    }

    @Override
    public void loadAirToAirMissile(AirToAirFirable missile) {
        try {
            missile.onDeployment(this);
        } catch (Exception ex) {
            this.airToAirFirable = null;
            System.out.println("\n\n\n\nERROR LOADING MISSILE::::::::::::::::::::you can't deploy " + ex.getMessage() + " on " + this.name);
        }
        this.airToAirFirable = missile;
    }

    @Override
    public void fireAirToAirMissile() {
        if (airToAirFirable == null) {
            System.out.println("(In English) No Missile installed on board F-15.. out ot armourexception");
            return;
        }
        airToAirFirable.fireMissile();
        this.airToAirFirable = null;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
