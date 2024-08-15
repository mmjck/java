package org.mmjck.domain.customer;

public class Customer {
    private Integer age;
    private String name;
    private String cpf;
    private Double income;
    private String location;

    public Customer(Integer age, String name, String cpf, Double income, String location) {
        this.age = age;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualOrLowerThan(double value) {
        return income <= value;
    }

    public boolean isIncomeEqualOrGreaterThan(double value) {
        return income >= value;
    }

    public boolean isIncomeBetween(double minValue, double maxValue) {
        return income >= minValue && income <= maxValue;
    }

    public boolean isAgeLowerThan(int value) {
        return age < value;
    }

    public boolean isFromLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
