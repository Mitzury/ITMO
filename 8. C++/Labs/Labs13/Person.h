#pragma once
using namespace std;

class Person
{
public:
	virtual void setData()
	{
		cout << "���: " << "\n> ";
		cin >> name;
		cout << "�������: " << "\n> ";
		cin >> surname;
		cout << "��������: " << "\n> ";
		cin >> fname;
	}
	virtual void getData()
	{
		cout << ">>: " << name << " " << surname << " " << fname << endl;
	}

private:
	std::string name;
	std::string surname;
	std::string fname;
};