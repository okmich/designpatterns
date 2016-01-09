/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.fighterjets;

/**
 *
 * @author m.enudi
 */
public class MiG31FighterJet implements AirFighterJet {

    private AirToAirFirable airToAirFirable;

    @Override
    public void loadAirToAirMissile(AirToAirFirable missile) {
        try {
            missile.onDeployment(this);
        } catch (Exception ex) {
            System.out.println("\n\n\n\nERROR LOADING MISSILE::::::::::::::::::::you can't deploy " + ex.getMessage() + " on MiG-31");
        }
        this.airToAirFirable = missile;
    }

    @Override
    public void fireAirToAirMissile() {
        if (airToAirFirable == null) {
            System.out.println("(In Russian) No Missile installed on board MiG-31.. out ot armourexception");
            return;
        }
        this.airToAirFirable.fireMissile();
        this.airToAirFirable = null;
    }

    @Override
    public String getName() {
        return "MiG-31";
    }

}
