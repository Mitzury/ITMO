#pragma once;
#include "includes.h"

class teacher : public Person {
public:
	void setData()
	{
		Person::setData();
		cout << "������� ������� ����: ";
		cin >> work_time;
	}
	void getData()
	{
		Person::getData();
		cout << "����� �������� �������: " << this->work_time << endl;
	}
private:
	unsigned int work_time;
};