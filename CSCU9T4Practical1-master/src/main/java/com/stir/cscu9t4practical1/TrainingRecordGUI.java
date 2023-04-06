// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField entryType = new JTextField(8);

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labType = new JLabel("'Cycle', 'Swim' or 'Sprint'");
    private JButton addR = new JButton("Add");
    private JButton FindAllByDate = new JButton("Find All By Date");
    private JButton lookUpByDate = new JButton("Look Up");


    //Swim
    private JLabel swimLocation = new JLabel("Swim Location:");
    private JTextField swimText = new JTextField(8);

    //Cycle
    private JLabel cycleTerrain = new JLabel("Cycle Terrain:");
    private JTextField cycleTerrainText = new JTextField(8);

    private JLabel cycleTempo = new JLabel("Cycle Tempo:");
    private JTextField cycleTempoText = new JTextField(8);

    //Sprint
    private JLabel rounds = new JLabel("Sprint Rounds:");
    private JTextField roundsText = new JTextField(5);

    private JLabel recovery = new JLabel("Sprint Recovery:");
    private JTextField recoveryText = new JTextField(8);

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main



    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);


        add(swimLocation);
        add(swimText);
        swimText.setEditable(true);

        add(cycleTempo);
        add(cycleTempoText);
        cycleTempoText.setEditable(true);

        add(cycleTerrain);
        add(cycleTerrainText);
        cycleTerrainText.setEditable(true);

        add(rounds);
        add(roundsText);
        roundsText.setEditable(true);
        add(recoveryText);
        recoveryText.setEditable(true);

        add(recovery);
        add(recoveryText);
        recoveryText.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);

        add(labType);
        add(entryType);
        entryType.setEditable(true);


        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();




        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            String s = entryType.getText();
            if(s.equalsIgnoreCase("Swim") || s.equalsIgnoreCase("SwimEntry")){
                message = addSwimEntry("generic");
            } else if (s.equalsIgnoreCase("cycle") || s.equalsIgnoreCase("cycleEntry")){
                message = addCycleEntry("Generic");
            } else if(s.equalsIgnoreCase("Sprint") || s.equalsIgnoreCase("SprintEntry")){
                message = addSprintEntry("generic");
            } else {
                message = addEntry("generic");
            }
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = findAllByDay();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }
    public String addSwimEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String location = swimText.getText();
        SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, location);
        myAthletes.addSwimEntry(e);
        return message;
    }
    public String addCycleEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String terrain = cycleTerrainText.getText();
        String tempo = cycleTempoText.getText();
        CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
        myAthletes.addCycleEntry(e);
        return message;
    }
    public String addSprintEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String rounds = roundsText.getText();
        String recoverytime = recoveryText.getText();
        SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, rounds , recoverytime);
        myAthletes.addSprintEntry(e);
        return message;
    }

    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String findAllByDay() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String output = myAthletes.findAllByDate(d, m, y);
        return output;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

