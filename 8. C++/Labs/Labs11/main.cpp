#include "includes.h"

int main()
{
	setlocale(LC_ALL, "Russian");
	Time t0;
	int hour, min, sec;
	double number;

	try
	{
		cout << "��������� �����: ";
		cin >> hour >> min >> sec;
		const Time t1(hour, min, sec);
		t1.showTime();
		cout << "�������� �����: ";
		cin >> hour >> min >> sec;
		const Time t2(hour, min, sec);
		t2.showTime();

		t0 = t0.sum(t1, t2);

		cout << "�����: " << "\n";
		t0.showTime();

		Time tDif = t1 - t2;
		cout << "������� � �����������: ";
		tDif.showTime();

		Time tSum = t1 + t2;
		cout << "����� � �����������: ";
		tSum.showTime();

		Time tReal0 = t1 + 6.5;
		cout << "����� ������� � �������������� ������ (����): ";
		tReal0.showTime();

		Time tReal1 = 4.7 + t2;
		cout << "����� ��������������� ����� (�����) �� ��������: ";
		tReal1.showTime();

		cout << "Double to int: ";
		cin >> number;
		Time tReal2 = number;
		cout << number << " �����: ";
		tReal2.showTime();

		cout << endl;

		if (t1 > t2) {
			cout << "��������� ����� ������ ���������." << endl;
		}
		else if (t1 < t2) {
			cout << "��������� ����� ������ ���������" << endl;
		}
	}
	catch (Time::TimeInputException ex)
	{
		cout << "������: " << ex.origin;
	}
}