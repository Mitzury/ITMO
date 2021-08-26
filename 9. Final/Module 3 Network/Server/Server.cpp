// макрос в случае работы с сетью
#define WIN32_LEAN_AND_MEAN

#include <Windows.h>
#include <WinSock2.h>
#include <WS2tcpip.h>
#include <iostream>

//ѕодключаем библиотеку работы с соектами (Windows)
#pragma comment (lib, "Ws2_32.lib")

using namespace std;

int main()
{
	WSADATA wsaData;
	ADDRINFO hints;
	ADDRINFO* addrResult = NULL;
	SOCKET ClientSocket = INVALID_SOCKET;
	SOCKET ListenSocket = INVALID_SOCKET;

	const char* sendBuffer = "Hello i'm server";
	char recvBuffer[512];

	int result;

	result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (result != 0) {
		cout << "WSA start fail, result = " << result << endl;
		return 1;
	}

	ZeroMemory(&hints, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;
	hints.ai_flags = AI_PASSIVE;


	result = getaddrinfo(NULL, "22081", &hints, &addrResult);
	if (result != 0) {
		cout << "gettaddinfo failed" << endl;
		WSACleanup();
		return 1;
	}
	ListenSocket = socket(addrResult->ai_family, addrResult->ai_socktype, addrResult->ai_protocol);
	if (ListenSocket == INVALID_SOCKET) {
		cout << "Socket Creation Fail" << endl;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}


	result = bind(ListenSocket, addrResult->ai_addr, (int)addrResult->ai_addrlen);
	if (result == SOCKET_ERROR) {
		cout << "Binding socket failed" << result << endl;
		closesocket(ListenSocket);
		ListenSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}
	result = listen(ListenSocket, SOMAXCONN);
	if (result == SOCKET_ERROR) {
		cout << "Listening Fail" << endl;
		closesocket(ListenSocket);
		ListenSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}

	ClientSocket = accept(ListenSocket, NULL, NULL);
	if (ClientSocket == INVALID_SOCKET) {
		cout << "Accepting Fail" << endl;
		closesocket(ListenSocket);
		ListenSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}
	closesocket(ListenSocket);

	do
	{
		ZeroMemory(recvBuffer, 512);
		result = recv(ClientSocket, recvBuffer, 512, 0);
		if (result > 0) {
			cout << "Received " << result << endl;
			cout << "Received " << recvBuffer << endl;

			result = send(ClientSocket, sendBuffer, (int)strlen(sendBuffer),0);
			if (result == SOCKET_ERROR) {
				cout << "failed to send" << endl;
				closesocket(ClientSocket);
				ClientSocket = INVALID_SOCKET;
				freeaddrinfo(addrResult);
				WSACleanup();
				return 1;
			}

		}
		else if (result == 0) {
			cout << "conn closed";
		}
		else
			cout << "recv failed" << endl;

		closesocket(ClientSocket);
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	} while (result > 0);

	result == shutdown(ClientSocket, SD_SEND);
	if (result == SOCKET_ERROR) {
		cout << "shutdown cliuent socket failed" << endl;
		closesocket(ClientSocket);
		freeaddrinfo(addrResult);
		WSACleanup();
		return 1;
	}

	closesocket(ClientSocket);
	freeaddrinfo(addrResult);
	WSACleanup();
	return 0;
}