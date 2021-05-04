package ru.mitzury;

public class Main {

    public static void main(String[] args) {

        Client client = new Client("Сбер", "Вася", "Пупкин");
        client.display();
        client.stat();
        Employee employee = new Employee("Тинькофф","Сергей","Иванов");
        employee.display();
    }
}
