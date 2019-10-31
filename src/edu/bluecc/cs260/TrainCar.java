package edu.bluecc.cs260;

public class TrainCar {
  private TrainCar nextCar;
  private int num;
  private String cargo;

  public TrainCar(int num, String cargo) {
    this.num = num;
    this.cargo = cargo;
  }

  public int getNum() {
    return num;
  }
  public String getCargo() {
    return cargo;
  }

  public TrainCar getNextCar() {
    return nextCar;
  }

  public void setNextCar(TrainCar nextCar) {
    this.nextCar = nextCar;
  }

  public String toString() {
    return String.format("[ %d: %s ]",num,cargo);
  }
}