int InitializeSockets();

extern ADDRINFO hints;
extern ADDRINFO* addrResult;
extern SOCKET ConnectSocket;
extern WSADATA wsaData;

extern const char* sendBuffer;