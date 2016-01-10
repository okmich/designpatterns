/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okmich.designpatterns.familytree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * This is a demonstration of the Interpreter and Visitor Design pattern.
 *
 * The case study is one of which a family tree is built using simple statements
 * like
 *
 * <p>
 * John married Judith <br />
 * They gave birth to Anna <br />
 * Anna married David <br />
 * They gave birth to Max,Mike,Mary
 * </p>
 *
 * The application then offers a command line interface to answer questions like
 *
 * <p>
 * who are Mary's first cousins <br />
 * who is Anna grandmother-inlaw <br />
 * who is David's nephew
 * </p>
 *
 * Other patterns used here include :
 * <ul>
 * <li>Composite</li>
 * <li>Factory</li>
 * <li>Visitor</li>
 * </ul>
 *
 * @author Michael Enudi
 */
public class Main {

    public static void main(String[] args) {
        //get the content of the genealogy
        List<String> storyLine = readGenelogyStoryLine();
        //next thing is pass the storyLine to the interpreter to build the family tree
        for (String line : storyLine) {
            
        }
    }

    /**
     *
     * @return
     */
    private static List<String> readGenelogyStoryLine() {
        JFrame jframe = new JFrame();
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));

        int response = fileChooser.showOpenDialog(jframe);
        List<String> storyLines = null;
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                storyLines = Files.readAllLines(file.toPath());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("could not read content from file");
            }
        }
        return storyLines;
    }
}
