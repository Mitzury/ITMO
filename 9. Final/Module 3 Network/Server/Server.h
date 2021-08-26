#pragma comment
#include <Windows.h>
#include <WinSock2.h>
#include <WS2tcpip.h>
#include <iostream>

//Ïîäêëþ÷àåì áèáëèîòåêó ðàáîòû ñ ñîåêòàìè (Windows)
#pragma comment (lib, "Ws2_32.lib")

using namespace std;

class Server
{
  WSAData wsa;
  ADDRINFO hints;
	ADDRINFO* addrResult = NULL;
	SOCKET ClientSocket = INVALID_SOCKET;
	SOCKET ListenSocket = INVALID_SOCKET;
  
	const char* sendBuffer = "Hello i'm server";
	char recvBuffer[512];
public:
  int Init();
  int Create();
  int Send(const char* msg);
  int Recv();
  int Shutdown();
};
