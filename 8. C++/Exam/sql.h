#pragma once

#include <stdio.h>
#include "sqlite3.h"
#include <string>
#include "sql.h"

void SQLCreate(std::string query);
void SQLRead(std::string query);
void SQLCount(std::string query);