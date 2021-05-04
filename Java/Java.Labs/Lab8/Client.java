package ru.mitzury;


public class Client extends Human implements IStatus{

    String BankName;

    Client(String BankName,String Name, String LastName){
        super(Name,LastName);
        this.BankName = BankName;
    }

    @Override
    public void display(){
        System.out.printf("Банк: %s \t Имя клиента: %s  Фамилия клиента: %s \n",
                BankName, super.getName(), super.getLastName());
    }

    @Override
    public void stat(){
        System.out.printf("Статус клиента: %s \t %s:  ПРЕМИАЛЬНЫЙ \n",super.getName(), super.getLastName());
    }
}
