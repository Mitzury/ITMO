#include "os_select.h"
#include "win_sockets.h"
using namespace std;

int recvtest(string& buff)
{
    WSAData wsa;
    SOCKET sock;
    SOCKADDR_IN server;
    WSAStartup(MAKEWORD(2, 2), &wsa);
    server.sin_family = AF_INET;
    server.sin_addr.s_addr = INADDR_ANY;
    server.sin_port = htons(22080); 
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock == INVALID_SOCKET)
    {
        return 0;
    }
    if (bind(sock, (SOCKADDR*)&server, sizeof(server)) != 0)
    {
        return -1;
    }
    if (listen(sock,SOMAXCONN) != 0)
    {
        return -2;
    }
    SOCKET client;
    SOCKADDR_IN FromAddr;
    int len = sizeof(SOCKADDR_IN);
    client = accept(list_sock, (SOCKADDR*)&FromAddr, &len);
    char* ip_client = new char[128];
    if (client != INVALID_SOCKET)
    {
		sprintf(ip_client, "%3u.%3u.%3u.%3u", FromAddr.sin_addr.S_un.S_un_b.s_b1,
		FromAddr.sin_addr.S_un.S_un_b.s_b2,
		FromAddr.sin_addr.S_un.S_un_b.s_b3,
		FromAddr.sin_addr.S_un.S_un_b.s_b4);
   }
   else
   {
	   printf("accept failed: %d\n", WSAGetLastError());
           closesocket(sock);
           WSACleanup();
	   return -3;
   }
   return string(ip_clint);
}

int sender()
{

	char recvBuffer[512];
	int result;
	string ip;
        recvtest(ip);
	result = getaddrinfo(ip.c_str(), "22081", &hints, &addrResult);
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
