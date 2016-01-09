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
public interface AirToAirFirable {

    /**
     * just added this to be able to check deploying some certain missiles on
     * some certain airfighter jet
     *
     * quite funny deploying a long range missile on a short-range mission air
     * fighter
     *
     * @param airFighterJet
     * @throws Exception
     */
    void onDeployment(AirFighterJet airFighterJet)
            throws Exception;

    void fireMissile();
}
