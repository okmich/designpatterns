/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.practise.designpattern.employmentprocess;

/**
 * Demonstration of a Chain of Responsibility Design pattern.
 *
 * This use case is a hypothetical work pipeline of how an individual
 * (TxnObject) works into an office. The first meeting would be a receptionist
 * and from there, the files and individual will process the txn by updating the
 * individuals txn log.
 *
 * The code assumes that the individual passes all stages but it is possible
 * that the individual fails a stage at which point the {@link TemplateDesk#doSpecificFunction(com.okmich.practise.designpattern.chainofresponsibility.TxnObject)
 * } will return {@code  false} and the chain will be broken.
 *
 * At the end of the chain or the transaction, we can see all that happened to
 * the individual by printing the txnLog to screen
 *
 * To avoid repetition of code across the Desk implementation, a Template Design
 * pattern was implemented to abstract the general behaviour across the
 * recruitment process and only provided a hook method for specific
 * implementation to all desk.
 *
 *
 * Other patterns used here include
 * <ul>
 * <li>Template Design Pattern</li>
 * </ul>
 *
 * @author Michael Enudi
 */
public class Main {

    public static void main(String[] args) {
        //create and chain all desk
        Desk receptionDesk = new ReceptionDesk();
        Desk catererDesk = new CatererDesk();
        Desk generalSecretaryDesk = new GeneralSecretaryDesk();
        Desk filingSecretaryDesk = new FilingSecretaryDesk();
        Desk interviewCommitteeDesk = new InterviewCommitteeDesk();
        Desk medicalDesk = new MedicalDesk();
        Desk hrSecretaryDesk = new HRSecretaryDesk();
        Desk ceoDesk = new CEODesk();

        //chaining
        receptionDesk.setNextDesk(catererDesk);
        catererDesk.setNextDesk(generalSecretaryDesk);
        generalSecretaryDesk.setNextDesk(filingSecretaryDesk);
        filingSecretaryDesk.setNextDesk(interviewCommitteeDesk);
        interviewCommitteeDesk.setNextDesk(medicalDesk);
        medicalDesk.setNextDesk(hrSecretaryDesk);
        hrSecretaryDesk.setNextDesk(ceoDesk);

        //create the transaction object
        //in real life, this represents the person 
        //who was first an applicant and then became the employee
        TxnObject obj = new TxnObject();

        //in real life, the applicant walks into reception first and only
        //the rest activities are chains of responsibility as his/her file
        //moves from one desk to another
        obj = receptionDesk.processTxn(obj);

        //at the end, let see all that happened to TxnObject
        System.out.println(obj.getTxnLog());
    }
}
