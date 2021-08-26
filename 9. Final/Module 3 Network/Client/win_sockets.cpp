#include "os_select.h"

WSADATA wsaData;
ADDRINFO hints;
ADDRINFO* addrResult = NULL;
SOCKET ConnectSocket = INVALID_SOCKET;

int InitializeSockets() {
	
	int result;
	result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	if (result != 0) {
		std::cout << "WSA start fail, result = " << result << std::endl;
		return 1;
	}

	ZeroMemory(&hints, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_protocol = IPPROTO_TCP;

}