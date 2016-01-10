/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.fighterjets.missiles;

import com.okmich.designpatterns.fighterjets.AirFighterJet;

/**
 *
 * @author m.enudi
 */
public class PL8Missile implements AirToAirFirable {

    public PL8Missile() {
    }

    @Override
    public void onDeployment(AirFighterJet airFighterJet) throws Exception {
        //do nothing
    }

    @Override
    public void fireMissile() {
        System.out.println("\n\n\n\n");
        System.out.println("PL-8 FIRED = >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("BOOOOMMMMMMMMMMMMMMMMMM!!!!!!!!");
        System.out.println("Enemy target destroyed");
    }

}
