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
public class BisnovatMissile implements AirToAirFirable {

    public BisnovatMissile() {
    }

    @Override
    public void onDeployment(AirFighterJet airFighterJet) throws Exception {
        if ("F-15".equals(airFighterJet.getName())) {
            throw new Exception("Bisnovat R-4");
        }
    }

    @Override
    public void fireMissile() {
        System.out.println("\n\n\n\n");
        System.out.println("Bisnovat R-4 FIRED = >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("BOOOOMMMMMMMMMMMMMMMMMM!!!!!!!!");
        System.out.println("Enemy target destroyed");
    }

}
