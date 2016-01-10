/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree;

import com.okmich.practise.designpattern.familytree.Connectable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.enudi
 */
public class Person implements Entity, Connectable {

    /**
     * GENDER_FEMALE
     */
    public static final String GENDER_FEMALE = "F";
    /**
     * GENDER_MALE
     */
    public static final String GENDER_MALE = "M";
    /**
     * DELIMITER
     */
    private static final String DELIMITER = ":";
    private String pId;
    private String name;
    private String gender;
    private int age;
    private Person spouse;
    private Person father;
    private Person mother;
    private final List<Person> children = new ArrayList<>();

    /**
     *
     */
    public Person() {
    }

    /**
     *
     * @param pId
     * @param name
     * @param gender
     * @param age
     */
    public Person(String pId, String name, String gender, int age) {
        this.pId = pId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    /**
     * @return the pId
     */
    public String getpId() {
        return pId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the spouse
     */
    public Person getSpouse() {
        return spouse;
    }

    /**
     * @param person the spouse to set
     */
    public void setSpouse(Person person) {
        this.spouse = person;
        //set the reverse relationship
        //not that this condition prevents an infinite loop
        if (person.getSpouse() == null) {
            person.setSpouse(spouse);
        }
    }

    /**
     *
     * @return the father
     */
    public Person getFather() {
        return father;
    }

    /**
     * @param father the father to set
     */
    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * @return the mother
     */
    public Person getMother() {
        return mother;
    }

    /**
     * @param mother the mother to set
     */
    public void setMother(Person mother) {
        this.mother = mother;
    }

    /**
     * @return the children
     */
    public List<Person> getChildren() {
        return children;
    }

    /**
     *
     * @param person
     */
    public void addChild(Person person) {
        getChildren().add(person);
        //set the reverse relationship
        if (person.getGender() != null && GENDER_FEMALE.equals(person.getGender())) {
            person.setMother(this);
        } else {
            person.setFather(this);
        }
    }

    @Override
    public Entity owner() {
        return this;
    }

    @Override
    public void acceptConnection(Connector connector) {
        connector.findConnection(this);
    }

    /**
     * a string of format p:NAME:GENDER:AGE
     *
     * @param token
     * @return
     */
    public static Person newInstance(String token) {
        String[] tokens = token.split("");

        return null;
    }
}
