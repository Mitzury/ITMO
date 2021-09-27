#define WIN32_LEAN_AND_MEAN

#include <iostream>
#include <Windows.h>
#include <WinSock2.h>
#include <WS2tcpip.h>


#pragma comment (lib, "Ws2_32.lib")

using namespace std;

int main(int argc, char const* argv[]) {

	int result;

	// const char* sendBuffer = "Hello server";
	char recvBuffer[512];

	WSADATA wsaData;
	ADDRINFO hints;
	ADDRINFO* addrResult = NULL;

	SOCKET ClientSocket = INVALID_SOCKET;
	SOCKET ListenSocket = INVALID_SOCKET;

	std::cout << "Server Starting" << std::endl;

	result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (result != 0)
	{
		std::cout << "WSAStartup fail = " << result << std::endl;
		return 1;
	}
	else
	{
		std::cout << "WSAStartup succesful" << std::endl;
	}
		
	

	ZeroMemory(&hints, sizeof(hints));

	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;
	hints.ai_flags = AI_PASSIVE;


	result = getaddrinfo(NULL, "22081", &hints, &addrResult);
	if (result != 0)
	{
		std::cout << "GetAddrInfo" << result << std::endl;
		WSACleanup;
		return 1;
	}
	else
	{
		std::cout << "GetAddrInfo succesful" << std::endl;
	}

	ListenSocket = socket(addrResult->ai_family, addrResult->ai_socktype, addrResult->ai_protocol);
	if (ListenSocket == INVALID_SOCKET) {
		cout << "Socket creation failed" << endl;
		freeaddrinfo(addrResult);
		WSACleanup;
		return 1;
	}
	else
	{
		std::cout << "Listen Socket Creation Succesful" << std::endl;
	}

	result = bind(ListenSocket, addrResult->ai_addr, (int)addrResult->ai_addrlen);
	if (result == SOCKET_ERROR)
	{
		std::cout << "binding failed" << result << std::endl;
		closesocket(ListenSocket);
		ListenSocket = INVALID_SOCKET;
		freeaddrinfo(addrResult);
		WSACleanup;
		return 1;
	}

	result = listen(ListenSocket, SOMAXCONN);
	if (result == SOCKET_ERROR)
	{
		std::cout << "Listening failed" << result << std::endl;
		closesocket(ListenSocket);
		freeaddrinfo(addrResult);
		WSACleanup;
		return 1;
	}
	while (1) {
		sockaddr_in cs_addr;
		socklen_t cs_addrsize = sizeof(cs_addr);
		char buffer[INET_ADDRSTRLEN];

		ClientSocket = accept(ListenSocket, (struct sockaddr*)&cs_addr, &cs_addrsize);
		if (ClientSocket == INVALID_SOCKET)
		{
			std::cout << "Accepting failed" << result << std::endl;
			closesocket(ListenSocket);
			freeaddrinfo(addrResult);
			WSACleanup;
			return 1;
		}
		do
		{

			ZeroMemory(recvBuffer, sizeof(recvBuffer));
			result = recv(ClientSocket, recvBuffer, 512, 0);
			string client_ip = inet_ntop(AF_INET, &cs_addr.sin_addr, buffer, sizeof(buffer));

			if (result > 0)
			{
				cout << "Reveived bytes: " << result << " from: " << client_ip << endl;
				cout << recvBuffer << endl;

				if (recvBuffer == "0")
				{
					result = send(ClientSocket, "false", (int)strlen("false"), 0);
				}
				else {
					result = send(ClientSocket, "true", (int)strlen("true"), 0);

				}
				if (result == SOCKET_ERROR) {
					cout << "Failed to send data back" << endl;
					closesocket(ClientSocket);
					freeaddrinfo(addrResult);
					WSACleanup;
					return 1;
				}

			}
			else if (result == 0)
			{
				cout << "connection closed" << endl;
			}
			else {
				cout << "Connect failed" << endl;
				closesocket(ClientSocket);
				freeaddrinfo(addrResult);
				WSACleanup;
				return 1;
			}
		} while (result > 0);

	}

	//closesocket(ListenSocket);

	result = shutdown(ClientSocket, SD_SEND);
	if (result == SOCKET_ERROR) {
		cout << "Failed to send data back" << endl;
		closesocket(ClientSocket);
		freeaddrinfo(addrResult);
		WSACleanup;
		return 1;
	}

	closesocket(ClientSocket);
	freeaddrinfo(addrResult);
	WSACleanup;
	return 0;
}