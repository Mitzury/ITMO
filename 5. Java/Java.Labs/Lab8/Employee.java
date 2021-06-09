package ru.mitzury;

public class Employee extends Human {

    String BankName;

    Employee(String BankName, String Name, String LastName){
        super(Name,LastName);
        this.BankName = BankName;
    }

    @Override
    public void display() {
        System.out.printf("Банк: %s \t Имя сотрудника: %s  Фамилия сотрудника: %s \n",
                BankName, super.getName(), super.getLastName());
    }
}
