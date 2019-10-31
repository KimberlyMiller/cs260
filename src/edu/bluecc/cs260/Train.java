package edu.bluecc.cs260;

import java.util.Scanner;

public class Train {

  private TrainCar start;
  private TrainCar end;
  private int numCars;

  public Train(TrainCar start) {
    this.start = start;
    this.end = start;
    numCars = 1;
  }

  public void addCar(TrainCar car) {
    end.setNextCar(car);
    end = car;
    numCars++;
  }

  /*
  // show option 1 with the for loop:
  public void show() {
    TrainCar car = start;
    for (int i=0; i<numCars; i++) {
      System.out.print(car);
      car = car.getNextCar();
      if (car != null)
        System.out.print(" -- ");
    }
    System.out.println("");
  }
  */

  // show option 2 with the while loop:
  // Method: show the cars in the terminal, each car in the correct order
  public void show() {
    TrainCar car = start;
    while (car != null) {
      System.out.print(car);
      car = car.getNextCar();
      if (car != null)
        System.out.print(" -- ");
    }
    System.out.println("");
  }




  public static void main(String[] args) {
     // testOriginal();
     testTwo();
  }

  // test: original:
  public static void testOriginal() {
    Scanner scanner = new Scanner(System.in);

    TrainCar start = new TrainCar(1,"Engine");
    Train train = new Train(start);

    System.out.println("How many cars in the train?");
    int numCars = Integer.parseInt(scanner.nextLine());

    for (int i=2; i<=numCars; i++)
      train.addCar(new TrainCar(i,"flux capacitors"));

    System.out.println("Train buildination is complete. Your train:\n");

    train.show();
    scanner.close();
  }

  // test 2
  // Try asking the user to add train cars individually (you can also ask them for the cargo of each car). Keep building the train until the user asks to stop.
  // Note: I should NOT have used an exception here.  Exceptions are only used when we can NOT foresee the problem.
  public static void testTwo() {
    Scanner scanner = new Scanner(System.in);

    TrainCar start = new TrainCar(1,"Engine");
    Train train = new Train(start);

    int totalCars = 0;
    int numCars = 0;

    try {
      for ( int i = 0; i < 3; i++) {
        System.out.println("How many cars in the train?");
        totalCars= Integer.parseInt(scanner.nextLine());
        numCars = numCars + totalCars;
      }
    } catch (Exception e) {
      System.out.println("Stopped " + numCars);
    }

    for (int i=2; i<=numCars; i++)
      train.addCar(new TrainCar(i,"flux capacitors"));

    System.out.println("Train buildination is complete. Your train:\n");

    train.show();
    scanner.close();
  }
}