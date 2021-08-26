#include "os_select.h"
#include "win_sockets.h"
using namespace std;

int sender()
{

	char recvBuffer[512];
	int result;

	result = getaddrinfo("127.0.0.1", "22081", &hints, &addrResult);
	if (result != 0) {
		cout << "gettaddinfo failed" << endl;
		WSACleanup();
		return 1;
	}
	ConnectSocket = socket(addrResult->ai_family, addrResult->ai_socktype, addrResult->ai_protocol);
	if (ConnectSocket == INVALID_SOCKET) {
		cout << "Socket Creation Fail" << endl;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}

	result = connect(ConnectSocket, addrResult->ai_addr, (int)addrResult->ai_addrlen);
	if (result == SOCKET_ERROR) {
		cout << "Ubale connect to server" << result << endl;
		closesocket(ConnectSocket);
		ConnectSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;


	}

	result = send(ConnectSocket, &sendBuffer, (int)strlen(sendBuffer), 0);
	if (result == SOCKET_ERROR) {
		cout << "Send Failes" << result << endl;
		closesocket(ConnectSocket);
		ConnectSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}
	cout << "Sent: " << result << endl;
	result = shutdown(ConnectSocket, SD_SEND);
	if (result == SOCKET_ERROR)
	{
		cout << "Shutdown error" << endl;
		closesocket(ConnectSocket);
		ConnectSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}
	do
	{
		ZeroMemory(recvBuffer, 512);
		result = recv(ConnectSocket, recvBuffer, 512, 0);
		if (result > 0) {
			cout << "Received " << result << endl;
			cout << "Received " << recvBuffer << endl;
		}
		else if (result == 0) {
			cout << "conn closed";
		}
		else
			cout << "recv failed" << endl;
	} while (result > 0);

	closesocket(ConnectSocket);
	ConnectSocket = INVALID_SOCKET;
	freeaddrinfo(addrResult);
	WSACleanup();
	return 0;

}