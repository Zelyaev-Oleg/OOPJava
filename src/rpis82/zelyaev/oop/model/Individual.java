package rpis82.zelyaev.oop.model;
public class Individual
{
    public Account[] accounts;
    public int size;
    //Конструкторы
    //по умолчанию инициализирует массив из 16 элементов со значениями null
    public Individual()
    {
        accounts = new Account[16];
        size = 16;
    }
    //принимающий целое число – емкость массива
    public Individual(int size)
    {
        accounts = new Account[size];
        this.size = size;
    }
    //принимает массив счетов
    public Individual(Account[] accounts)
    {
        this.accounts = accounts;
        size = accounts.length;
    }
    //создание массива в 2 раза больше и перенос элементов из старого
    public void extendAccounts()
    {
        Account[] newAccount = new Account[accounts.length * 2];
        System.arraycopy(accounts, 0, newAccount, 0, accounts.length);
        accounts = newAccount;
    }
    //Добавляет счет в первое место в массиве
    public boolean add(Account account)
    {
        for (int i = 0; i < accounts.length; i++)
        {
            if (accounts[i] == null)
            {
                accounts[i] = account;
                size++;
                return true;
            }
        }
        extendAccounts();
        accounts[accounts.length / 2] = account;
        size++;
        return true;
    }
    //Добавляет счет в указанное место в массиве
    public boolean add(int index, Account account)
    {

        while (accounts.length - 1 < index)
        {
            extendAccounts();
        }
        if (accounts[index] == null)
        {
            size++;
        }
        accounts[index] = account;
        return true;
    }
    //Возвращает ссылку на экземпляр класса по номеру в массиве
    public Account get(int index)
    {
        return accounts[index];
    }
    //Возвращает ссылку на экземпляр класса по номеру счета
    public Account get(String accountNumber)
    {
        for (Account account : accounts)
        {
            if (account != null && account.number.equals(accountNumber))
                return account;
        }
        return null;
    }
    //Проверить есть ли ссылка с заданным номером
    public boolean hasAccount(String accountNumber)
    {
        for (Account account : accounts)
        {
            if (account != null && account.number.equals(accountNumber))
                return true;
        }
        return false;
    }
    //Изменить ссылку на экземпляр класса по его номеру в массиве
    public Account set(int index, Account account)
    {
        Account lastAccount = accounts[index];
        accounts[index] = account;
        return lastAccount;
    }
    //Удаляет по номеру в массиве
    public Account remove(int index)
    {
        if (accounts.length - 1 >= index)
        {
            Account lastAccount = accounts[index];
            System.arraycopy(accounts, index + 1, accounts, index, accounts.length - 1 - index);
            accounts[accounts.length - 1] = null;
            size--;
            return lastAccount;
        }
        return null;
    }
    // удаляет по номеру счета
    public Account remove(String accountNumber)
    {
        for (int i = 0; i < accounts.length; i++)
        {
            if (accounts[i] != null && accounts[i].number.equals(accountNumber))
            {
                Account lastAccount = accounts[i];
                System.arraycopy(accounts, i + 1, accounts, i, accounts.length - 1 - i);
                accounts[accounts.length - 1] = null;
                size--;
                return lastAccount;
            }
        }
        return null;
    }
    // возвращающий число физ. лиц
    public int size()
    {
        return size;
    }
    //возвращающий массив счетов (значений null в массиве быть не должно, его размер должен
    //быть равен числу элементов в исходном массиве)
    public Account[] getAccounts()
    {
        Account[] returnAccount = new Account[size];
        int count = 0;
        for (Account account : accounts)
        {
            if (account != null)
            {
                returnAccount[count] = account;
                count++;
            }
        }
        return returnAccount;
    }
    //сортировка аккаунтов по балансу
    public Account[] sortedAccountByBalance()
    {
        Account[] returnAccount = getAccounts();
        Account copy;
        for (int i = 0; i < returnAccount.length; i++)
        {
            for (int j = 0; j < returnAccount.length - 1; j++)
            {
                if (returnAccount[j].balance > returnAccount[j + 1].balance)
                {
                    copy = returnAccount[j + 1];
                    returnAccount[j + 1] = returnAccount[j];
                    returnAccount[j] = copy;
                }
            }
        }
        return returnAccount;
    }
    // баланс всех счетов
    public double totalBalance()
    {
        double sumBalance = 0;
        for (Account account : accounts)
        {
            if(account != null)
            {
                sumBalance += account.balance;
            }
        }
        return sumBalance;
    }
}
