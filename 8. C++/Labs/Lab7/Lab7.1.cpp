#include <iostream>

using namespace std;

struct Time
{
    long hours;
    long minutes;
    long seconds;

    long timeInSec(const Time& t1)
    {
        return t1.hours * 3600 + t1.minutes * 60 + t1.seconds;
    }

    Time sum(Time& t1, Time& t2)
    {
        Time sumTime;
        long sumSec = timeInSec(t1) + timeInSec(t2);
        sumTime.hours = sumSec / 3600;
        sumSec = sumSec % 3600;
        sumTime.minutes = sumSec / 60;
        sumTime.seconds = sumSec % 60;
        return sumTime;
    }

    Time diff(Time& t1, Time& t2)
    {
        Time diffTime;
        long diffSec = abs(timeInSec(t1) - timeInSec(t2));
        diffTime.hours = diffSec / 3600;
        diffSec = diffSec % 3600;
        diffTime.minutes = diffSec / 60;
        diffTime.seconds = diffSec % 60;
        return diffTime;
    }

    void showTime()
    {
        cout << hours << " hours " << minutes << " minutes " << seconds << " seconds" << endl;
    }
};

Time inputTime();

int main()
{
    setlocale(LC_ALL, "Russian");
    cout << "Введите начальное время: \n";
    Time t1 = inputTime();
    t1.showTime();
    cout << "Количество секунд: " << t1.timeInSec(t1) << endl;

    cout << "Введение конечное время: \n";
    Time t2 = inputTime();
    t2.showTime();
    cout << "Количество секунд: " << t2.timeInSec(t2) << endl;
    Time tS = tS.sum(t1, t2);
    cout << "Сумма чч:мм:сс: ";
    tS.showTime();
    cout << endl;
    cout << "Время в секундах: " << tS.timeInSec(tS) << endl;

    Time tD = tD.diff(t1, t2);
    cout << "Введенный интервал времени: ";
    tD.showTime();
    cout << endl;
    cout << "Время в секундах: " << tD.timeInSec(tD) << endl;
}

Time inputTime()
{
    Time t;
    cout << "Введите время в формате: чч мм сс" << endl;
    cin >> t.hours >> t.minutes >> t.seconds;
    if (t.seconds >= 60)
    {
        t.minutes += t.seconds / 60;
        t.seconds = t.seconds % 60;
    }
    if (t.minutes >= 60)
    {
        t.hours += t.minutes / 60;
        t.minutes = t.minutes % 60;
    }
    return t;
}