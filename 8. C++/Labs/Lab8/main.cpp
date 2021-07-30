#include <iostream>
#include "Time.h"
using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");
	Time time1 = Time(0, 0, 1251);
	time1.TimeDisplay();
	Time time2 = Time(0, 120, 1251);
	time2.TimeDisplay();
	Time time3;
	time3 = time1.AddTime2(time2);
	time3.TimeDisplay();
	return 0;
}