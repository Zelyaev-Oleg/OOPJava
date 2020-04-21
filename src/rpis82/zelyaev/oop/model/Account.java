package rpis82.zelyaev.oop.model;

public class Account {
    String number;
    double balance;
    public double getBalance;
    public String getNumber;
    //конструктор принимающий два параметра – номер счета и баланс
    public Account(String number, double balance)
    {
        this.number = number;
        this.balance = balance;
    }
    //по-умолчанию, инициализирует номер – пустой строкой, баланс – значением 0
    public Account()
    {
        this.number = null;
        this.balance = 0;
    }
    //возвращает значение баланса
    public double getBalance()
    {
        return balance;
    }
    //возвращает значение номера
    public String getNumber()
    {
        return number;
    }
    //изменяет значение баланса
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    //изменяет значение номера
    public void setNumber(String number)
    {
        this.number = number;
    }
}
