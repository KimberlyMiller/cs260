package edu.bluecc.cs260.hashtable;

import java.time.LocalDate;
import java.util.Date;

public class Student {

  private int id;
  private String name;
  private int score;
  private LocalDate birthDate;

  public Student(int id, String name, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }
}
