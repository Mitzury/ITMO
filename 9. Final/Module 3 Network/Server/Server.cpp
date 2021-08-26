// ìàêðîñ â ñëó÷àå ðàáîòû ñ ñåòüþ
#define WIN32_LEAN_AND_MEAN

#include "Server.h"

using namespace std;

int main()
{
   Server s;
   s.Init();
   s.Create();
   return 0;
}
