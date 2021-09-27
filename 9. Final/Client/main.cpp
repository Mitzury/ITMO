#define WIN32_LEAN_AND_MEAN


#ifdef _WIN32 // Windows NT
#include <WinSock2.h>
#include <iostream>
#include <Windows.h>
#include <WinSock2.h>
#include <WS2tcpip.h>
#pragma comment (lib, "Ws2_32.lib")
#include "com.h"
#else // *nix
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#endif
#include <vector>


using namespace std;

// Фцнкция инициализации слежубной структуры для хранения информации
// о реализации Windows Sockets
int WSAStart() {
	int WSAStart;
	WSADATA wsaData;
	WSAStart = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (WSAStart != 0)
	{
		std::cout << "WSAStartup fail = " << WSAStart << std::endl;
		
		return 1;
	}
}

int main(int argc, char const* argv[]) {

	int result;
	char recvBuffer[512];


	ADDRINFO hints;
	ADDRINFO* addrResult = NULL;
	SOCKET ConnectSocket = INVALID_SOCKET;
	#ifdef _WIN32
		WSAStart();
	#endif
	ZeroMemory(&hints, sizeof(hints));

	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;

	

	while (1) {
		char chars = ReadCOM();
		//str = "JGUYR*%^!@#RIK:";
		cout << "I'm sent: " << chars << endl;
		const char* sendBuffer = chars;


		result = getaddrinfo("127.0.0.1", "22081", &hints, &addrResult);
		if (result != 0)
		{
			std::cout << "GetAddrInfo" << result << std::endl;
			WSACleanup;
			return 1;
		}

		ConnectSocket = socket(addrResult->ai_family, addrResult->ai_socktype, addrResult->ai_protocol);
		if (ConnectSocket == INVALID_SOCKET) {
			cout << "Socket creation failed" << endl;
			freeaddrinfo(addrResult);
			WSACleanup;
			return 1;
		}

		result = connect(ConnectSocket, addrResult->ai_addr, (int)addrResult->ai_addrlen);
		if (result == SOCKET_ERROR)
		{
			std::cout << "Can't Connect to server" << result << std::endl;
			closesocket(ConnectSocket);
			ConnectSocket = INVALID_SOCKET;
			freeaddrinfo(addrResult);
			WSACleanup;
			return 1;
		}

		result = send(ConnectSocket, sendBuffer, (int)strlen(sendBuffer), 0);
		if (result == SOCKET_ERROR)
		{
			std::cout << "Send failed" << result << std::endl;
			closesocket(ConnectSocket);
			ConnectSocket = INVALID_SOCKET;
			freeaddrinfo(addrResult);
			WSACleanup;
			return 1;
		}

		cout << "Sent bytes: " << result << endl;

		result = shutdown(ConnectSocket, SD_SEND);
		if (result == SOCKET_ERROR)
		{
			std::cout << "ShutDown failed" << result << std::endl;
			closesocket(ConnectSocket);
			ConnectSocket = INVALID_SOCKET;
			freeaddrinfo(addrResult);
			WSACleanup;
			return 1;
		}

		ZeroMemory(recvBuffer, sizeof(recvBuffer));
		result = recv(ConnectSocket, recvBuffer, 512, 0);
		if (result > 0)
		{
			cout << "Reveived bytes: " << result << endl;
			cout << recvBuffer << endl;
		}
		else if (result == 0)
		{
			cout << "connection closed" << endl;
		}
		else {
			cout << "Connect failed" << endl;
		}

	}


	closesocket(ConnectSocket);
	ConnectSocket = INVALID_SOCKET;
	freeaddrinfo(addrResult);
	WSACleanup;
	return 0;
}