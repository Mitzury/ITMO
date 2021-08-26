#include "Server.h"

#define recv_s(Socket,DataPtr,Size,Other) recv( (Socket), (char *)(DataPtr), (Size), (Other))
#define send_s(Socket,DataPtr,Size,Other) send( (Socket), (char *)(DataPtr), (Size), (Other))

DWORD WINAPI receive_cmds(LPVOID lpParam)
{
	SOCKET current_client = (SOCKET)lpParam;
  bool data; //сюда будешь true/false присваивать
	int res;
	char buff[4096];
  while (res != -1)
  {
     res = recv(current_client, buff, 4096, 0);
     string s(buff, buff + res);
     //Здесь поместишь логику уже работы с 1C и т.д
     res = send_s(current_client,&data,sizeof(data),0);
  }
	closesocket(current_client);
}

int Server::Init()
{
   int result;
   result = WSAStartup(MAKEWORD(2, 2), &wsaData);
	 if (result != 0) {
		 cout << "WSA start fail, result = " << result << endl;
		 return 1;
	 }
}

int Server::Create()
{
   ZeroMemory(&hints, sizeof(hints));
	 hints.ai_family = AF_INET;
	 hints.ai_socktype = SOCK_STREAM;
	 hints.ai_protocol = IPPROTO_TCP;
	 hints.ai_flags = AI_PASSIVE;
   result = getaddrinfo(NULL, "22081", &hints, &addrResult);
	 if (result != 0) {
		 cout << "gettaddinfo failed" << endl;
		 WSACleanup();
		 return 0;
	 }
	 ListenSocket = socket(addrResult->ai_family, addrResult->ai_socktype, addrResult->ai_protocol);
	 if (ListenSocket == INVALID_SOCKET) {
	   cout << "Socket Creation Fail" << endl;
		 freeaddrinfo(addrResult);
		 WSACleanup();
		 return -1;
	 }
	 result = bind(ListenSocket, addrResult->ai_addr, (int)addrResult->ai_addrlen);
	 if (result == SOCKET_ERROR) {
		 cout << "Binding socket failed" << result << endl;
		 closesocket(ListenSocket);
		 ListenSocket = INVALID_SOCKET;
		 freeaddrinfo(addrResult);
	 	 WSACleanup();
		 return -2;
	 }
	 result = listen(ListenSocket, SOMAXCONN);
	 if (result == SOCKET_ERROR) {
		 cout << "Listening Fail" << endl;
		 closesocket(ListenSocket);
		 ListenSocket = INVALID_SOCKET;
		 freeaddrinfo(addrResult);
		 WSACleanup();
		 return -3;
	 }
   SOCKET client;
   SOCKADDR_IN from;
   int fromlen = sizeof(from);
   while (1)
   {
       client = accept(sock,(struct SOCKADDR*)&from,&fromlen);
       CreateThread(NULL, 0,receive_cmds,(LPVOID)client, 0, &thread);
   }
   closesocket(ClientSocket);
	 freeaddrinfo(addrResult);
   WSACleanup();
   return 1;
}
