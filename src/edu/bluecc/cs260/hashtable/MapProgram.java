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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapProgram {

  public static void main(String[] args) {
    Map<Integer, Student> studentMap = readStudents("C:\\01 working on hard drive - remove files not in use\\BMCC\\cs260\\src\\edu\\bluecc\\cs260\\hashtable\\students.txt");
    System.out.println(studentMap.size());
    showScores(studentMap);
    double average = calculateAverage(studentMap);
    System.out.println("Average is: " + average);
  }

  private List<Map<Integer, Student>>[] a = (List<Map<Integer, Student>>[]) new List[100];
  private int size = 0;

  /**
   * Calculate the average of the scores
   * @param studentMap
   * @return the scores average
   */
  private static double calculateAverage(Map<Integer, Student> studentMap) {
    // Your code here. Loop over all keys, getting the student score
    // for each and adding to a variable representing the total

    int location = getLocation(student.getId());

    double average = 0;
    for (Map<Integer, Student> student : a[location]) {
        average = studentMap.getID() + average;
    }
    average = studentMap.getID()/ a.length;
    return average;
  }

  /**
   * Apply the hash function to this key
   * @param key the key
   * @return the location for this key in the underlying array
   */
  private int getLocation(Map key) {
    return Math.abs(key.hashCode()) % a.length;
  }

  private static void showScores(Map<Integer, Student> studentMap) {
    // Your code here. Loop over each key, showing the student name and score for each entry.
    int location = getLocation(studentMap.getId());

    for (Map<Integer, Student> student : a[location]) {
      System.out.println("Student score: " + studentMap.getScore() + ", " + studentMap.getName());
      }
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

