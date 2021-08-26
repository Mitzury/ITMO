#include "os_select.h"
#include "win_sockets.h"
#include "sender.cpp"


using namespace std;

int main()
{
	InitializeSockets();
	string a;
	cin >> a;
	
	const char* sendBuffer = a.c_str();
	
	//char *sendBuffer = &a[0];
	

	sender(sendBuffer);
}