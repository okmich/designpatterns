package com.okmich.designpatterns.fighterjets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.okmich.designpatterns.fighterjets.missiles.AirToAirFirable;

/**
 *
 * @author m.enudi
 */
public interface AirFighterJet {

    String getName();

    void loadAirToAirMissile(AirToAirFirable missile) ;

    void fireAirToAirMissile();
}
