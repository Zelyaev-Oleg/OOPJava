package rpis82.zelyaev.oop.model;
public class AccountManager
{
    public Individual[] individuals;
    private int size;
    //Конструкторы
    //инициализирует массив физ. лиц
    public AccountManager(int size)
    {
        individuals = new Individual[size];
        this.size = size;
    }
    //копирование элементов в новый массив
    public AccountManager(Individual[] individuals)
    {
        this.individuals = individuals;
        size = individuals.length;
    }
    // увеличение размерности масива - доп. метод
    public void extendAccounts()
    {
        Individual[] newAccount = new Individual[individuals.length * 2];
        System.arraycopy(individuals, 0, newAccount, 0, individuals.length);
        individuals = newAccount;
    }
    //Добавляет физ. лицо в первое свободное место
    public boolean add(Individual individual)
    {
        for (int i = 0; i < individuals.length; i++)
        {
            if (individuals[i] == null)
            {
                individuals[i] = individual;
                size++;
                return true;
            }
        }
        extendAccounts();
        individuals[individuals.length / 2] = individual;
        size++;
        return true;
    }
    // добавляет ссылку в заданное место в массиве
    public boolean add(int index, Individual individual)
    {
        while (individuals.length - 1 < index)
        {
            extendAccounts();
        }
        if (individuals[index] == null)
        {
            size++;
        }
        individuals[index] = individual;
        return true;
    }
    //возвращает ссылку по номеру в массиве
    public Individual get(int index)
    {
        return individuals[index];
    }
    //Изменить ссылку на экземпляр с заданным номером
    public Individual set(int index, Individual individual)
    {
        Individual lastAccount = individuals[index];
        individuals[index] = individual;
        return lastAccount;
    }
    //Удаляет элемент из массива по его номеру
    public Individual remove(int index)
    {
        if (individuals.length - 1 >= index)
        {
            Individual lastAccount = individuals[index];
            System.arraycopy(individuals, index + 1, individuals, index, individuals.length - 1 - index);
            individuals[individuals.length - 1] = null;
            size--;

            return lastAccount;
        }
        return null;
    }
    // возвращающий число физ. лиц
    public int size()
    {
        return size;
    }
    //Возвращает массив физ. лиц
    public Individual[] getIndividuals()
    {
        Individual[] returnAccounts = new Individual[size];
        int count = 0;
        for (Individual individual : individuals)
        {
            if(individual != null)
            {
                returnAccounts[count] = new Individual(individual.getAccounts());
                count++;
            }
        }
        return returnAccounts;
    }
    //сортирровка по балансу
    public Individual[] sortedByBalanceIndividuals() {
        Individual[] returnAccount = getIndividuals();
        Individual copy;
        for (int i = 0; i < returnAccount.length; i++)
        {
            for (int j = 0; j < returnAccount.length - 1; j++)
            {
                if (returnAccount[j].totalBalance() > returnAccount[j + 1].totalBalance())
                {
                    copy = returnAccount[j + 1];
                    returnAccount[j + 1] = returnAccount[j];
                    returnAccount[j] = copy;
                }
            }
        }
        return returnAccount;
    }
    //возврат ссылки на экземпляр с заданным номером
    public Account getAccount(String accountNumber)
    {
        for (Individual individual : individuals)
        {
            Account account = individual.get(accountNumber);
            if (account != null)
                return account;
        }
        return null;
    }
    //удаление аккаунта с заданным номером
    public Account removeAccount(String accountNumber)
    {
        for (Individual individual : individuals)
        {
            Account account = individual.remove(accountNumber);
            if (account != null)
                return account;
        }
        return null;
    }
    //изменение ссылки на экземпляр с заданным номером
     public Account setAccount(String accountNumber, Account account)
    {
        for (int i = 0; i < individuals.length; i++)
        {
            for (int j = 0; j < individuals[i].accounts.length; j++)
            {
                if (individuals[i].accounts[j].number.equals(accountNumber))
                {
                    Account lastAccount = individuals[i].accounts[j];
                    individuals[i].accounts[j] = account;
                    return lastAccount;
                }
            }
        }
        return null;
    }
}
