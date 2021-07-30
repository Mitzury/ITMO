#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");
	ofstream out("test.txt", ios::out | ios::binary);

	if (!out) {
		cout << "Файл открыть невозможно\n";
		return 1;
	}

	string str;
	getline(cin, str, '\030'); // завершить ввод по нажатию ctrl+x
	out.write(str.c_str(), str.size());

	out.close();
}