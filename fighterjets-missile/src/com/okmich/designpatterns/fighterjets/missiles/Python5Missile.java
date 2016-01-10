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
public class Python5Missile implements AirToAirFirable {

    public Python5Missile() {
    }

    @Override
    public void onDeployment(AirFighterJet airFighterJet) throws Exception {
        if ("MiG-31".equals(airFighterJet.getName())) {
            throw new Exception("Python5");
        }
    }

    @Override
    public void fireMissile() {
        System.out.println("\n\n\n\n");
        System.out.println("PYTHON5 FIRED = >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("BOOOOMMMMMMMMMMMMMMMMMM!!!!!!!!");
        System.out.println("Enemy target destroyed");
    }

}
