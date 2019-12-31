/* ************************************************************
MapProgram.java
Created by Kim Miller on 31 December 2019
CS260 Fall 2019

Description: This program ...

Client: MapProgram.java
Object: Student.java

Library: java.io.File;
Library: java.io.FileNotFoundException;
Library: java.time.LocalDate;
Library: java.time.format.DateTimeFormatter;
Library: java.util.HashMap;
Library: java.util.Map;
Library: java.util.Scanner;

% java MapProgram

//Sample Output:
.
************************************************************ */
package edu.bluecc.cs260.hashtable;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapProgram {

  public static void main(String[] args) {
    Map<Integer, Student> studentMap = readStudents("students.txt");
    System.out.println(studentMap.size());
    showScores(studentMap);
    double average = calculateAverage(studentMap);
    System.out.println("Average is: " + average);
  }

  private static double calculateAverage(Map<Integer, Student> studentMap) {
    // Your code here. Loop over all keys, getting the student score
    // for each and adding to a variable representing the total
  }

  private static void showScores(Map<Integer, Student> studentMap) {
    // Your code here. Loop over each key, showing the student name and score for each entry.

  }



  private static Map<Integer,Student> readStudents(String filename) {
    Map<Integer,Student> map = new HashMap<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

    try {
      Scanner s = new Scanner(new File(filename));
      while (s.hasNext()) {
        String line = s.nextLine();
        String[] split = line.split(",");
        int id = Integer.valueOf(split[0]);
        LocalDate date = LocalDate.parse(split[3],formatter);
        Student student = new Student(id, split[1], date);
        student.setScore(Integer.valueOf(split[2]));
        map.put(id, student);
      }
      return map;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


}

