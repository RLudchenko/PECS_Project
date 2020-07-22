package rostyslav.ludchenko;

import java.util.ArrayList;
import java.util.List;

public class PECS {
    public static void main(String[] args) {
        // PECS - Producer Extends Consumer Super
        MilitaryPlane militaryPlane1 = new MilitaryPlane("Military Boeing 1", "A123", 2017);
        MilitaryPlane militaryPlane2 = new MilitaryPlane("Military Boeing 2", "A124", 2015);
        MilitaryPlane militaryPlane3 = new MilitaryPlane("Military Boeing 3", "A125", 2016);
        militaryPlane1.setCountry("Ukraine");
        militaryPlane2.setCountry("USA");
        militaryPlane3.setCountry("France");
        CargoPlane cargoPlane1 = new CargoPlane("Cargo plane 1", "C111", 2018);
        CargoPlane cargoPlane2 = new CargoPlane("Cargo plane 2", "C222", 2019);
        CargoPlane cargoPlane3 = new CargoPlane("Cargo plane 3", "C333", 2020);
        cargoPlane1.setMaxWeight(100.0);
        cargoPlane2.setMaxWeight(150.0);
        cargoPlane3.setMaxWeight(190.0);
        PassengerPlane passengerPlane1 = new PassengerPlane("Passenger plane 1", "P321", 2008);
        PassengerPlane passengerPlane2 = new PassengerPlane("Passenger plane 2", "P421", 2009);
        PassengerPlane passengerPlane3 = new PassengerPlane("Passenger plane 3", "P521", 2010);
        passengerPlane1.setCapacity(77);
        passengerPlane2.setCapacity(129);
        passengerPlane3.setCapacity(266);
        List<MilitaryPlane> militaryPlanes = List.of(militaryPlane1, militaryPlane2, militaryPlane3);
        List<CargoPlane> cargoPlanes = List.of(cargoPlane1, cargoPlane2, cargoPlane3);
        List<PassengerPlane> passengerPlanes = List.of(passengerPlane1, passengerPlane2, passengerPlane3);
        // implement method getAverageYear that will accept the list of planes and return the average year of planes
        //TODO: implement task 1
        //getAverageYear(militaryPlanes);


        System.out.println("Average year of military planes: " + getAverageYear(militaryPlanes));
        System.out.println("Average year of cargo planes: " + getAverageYear(cargoPlanes));
        System.out.println("Average year of passenger planes: " + getAverageYear(passengerPlanes));

        // implement method fill, that will receive the list of planes and the cargoPlane plane object
        // fill all list of planes with cargoPlane
        // there are three lists. What the list will be applicable? Why
        CargoPlane cargoPlane = new CargoPlane("Boeing", "T50");
        List<Plane> defaultPlanes = getDefaultPlanes();
        //List<CargoPlane> cargoPlanes1 = getCargoPlanes();
        //List<CargoChildPlane> cargoChildPlanes = getCargoChildPlanes(); */


        fill(defaultPlanes, cargoPlane);
        //TODO: implement task 2
    }

    private static void fill(List<? super Plane> planes, CargoPlane cargoPlane) {
        for (int i = 0; i < 3; i++) {
            planes.add(i, cargoPlane);
        }
    }

    private static int getAverageYear(List<? extends Plane> planes) {
        int count = 0;
        int average = 0;
        for (int i = 0; i < planes.size(); i++) {
            count += planes.get(i).getYear();
        }

        average = count / planes.size();

        return average;
    }

    public static List<Plane> getDefaultPlanes() {
        List<Plane> planes = new ArrayList<>();
        return planes;
    }
    public static List<CargoPlane> getCargoPlanes() {
        CargoPlane cargoPlane = new CargoPlane("Test", "Test");
        CargoPlane cargoPlane1 = new CargoPlane("Test", "Test");
        CargoPlane cargoPlane2 = new CargoPlane("Test", "Test");
        List<CargoPlane> list = new ArrayList<>();
        list.add(cargoPlane);
        list.add(cargoPlane1);
        list.add(cargoPlane2);

        return list;
    }
    public static List<CargoChildPlane> getCargoChildPlanes() {
        return List.of(null, null, null);
    }
}

abstract class Plane {
    private String maker;
    private String model;
    private Integer year;
    public Plane() {
    }
    public Plane(String maker, String model) {
        this.maker = maker;
        this.model = model;
        this.year = 2020;
    }
    public Plane(String maker, String model, Integer year) {
        this.maker = maker;
        this.model = model;
        this.year = year;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}

class MilitaryPlane extends Plane {
    private String country;
    public MilitaryPlane(String maker, String model) {
        super(maker, model);
        this.setYear(2016);
    }
    public MilitaryPlane(String maker, String model, Integer year) {
        super(maker, model, year);
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}

class PassengerPlane extends Plane {
    private int capacity;
    public PassengerPlane(String maker, String model) {
        super(maker, model);
    }
    public PassengerPlane(String maker, String model, Integer year) {
        super(maker, model, year);
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class CargoPlane extends Plane {
    private double maxWeight;
    public CargoPlane() {
    }
    public CargoPlane(String maker, String model) {
        super(maker, model);
        this.setYear(2018);
    }
    public CargoPlane(String maker, String model, Integer year) {
        super(maker, model, year);
    }
    public double getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}

class CargoChildPlane extends CargoPlane {
    public CargoChildPlane() {
    }
    public CargoChildPlane(String maker, String model) {
        super(maker, model);
    }
}