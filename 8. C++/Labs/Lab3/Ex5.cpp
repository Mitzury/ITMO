#include <iostream>
using namespace std;

void binary(int n) {
      
    if (n < 0) {
        cout << "������ ������������� �����";
    }
    else if (n < 2) {
        cout << n;
    }
    else {
        binary(n / 2);
        int res = n % 2;
        cout << res;
    }
}

int main()
{
    setlocale(LC_ALL, "Russian");

    int n;
    cout << "������� ���������� ����� ��� �������� � �������� ���: ";
    cin >> n;
    binary(n);
}