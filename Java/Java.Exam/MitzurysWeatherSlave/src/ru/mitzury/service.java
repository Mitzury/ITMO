package ru.mitzury;

import java.sql.*;

public class service {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String usr = "root";
    private static final String password = "220819891";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public static Object getUserLoc (String chatId, String uName, String uSecondName, String uNick, double lat, double lon) {
        try {
            String select = "SELECT count(uChatId) FROM weatherbotdata.new_table where uChatId = " + chatId + "";
            conn = DriverManager.getConnection(url, usr, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(select);
            rs.next();
            int count = rs.getInt(1);


            if (count == 0) {
                String insert = "INSERT INTO `weatherbotdata`.`new_table` (`uName`,`uSecondName`,`uNick`,`uChatId`, `lon`, `lat`, `LastDate`) " +
                                          "VALUES ('" + uName + "','" + uSecondName + "','" + uNick + "','" + chatId + "'," + lon + "," + lat +", now());";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(insert);

                return weather.parseWeather(lat,lon,"");
            } else {
                String update = "UPDATE weatherbotdata.new_table SET lon =" + lon + ", lat =" + lat + " where uChatId =" + chatId + ";";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(update);

                return weather.parseWeather(lat,lon,"");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ce) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    try {
                        rs.close();
                    } catch (SQLException re) {
                    }
                }
            }

        }
        return null;
    }
    public static Object subscribe (String chatId, String uName, String uSecondName, String uNick, double lat, double lon) {
        try {
            String select = "SELECT count(uChatId) FROM weatherbotdata.new_table where uChatId = " + chatId + "";
            conn = DriverManager.getConnection(url, usr, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(select);
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                String insert = "INSERT INTO `weatherbotdata`.`new_table` (`uName`,`uSecondName`,`uNick`,`uChatId`, `Subscribe`, `lon`, `lat`, `LastDate`) " +
                        "VALUES ('" + uName + "','" + uSecondName + "','" + uNick + "','" + chatId + "', 1," + lon + "," + lat +", now());";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(insert);

                return "Вы успешно подписались на обновления2";
            } else {
                String update = "UPDATE weatherbotdata.new_table SET Subscribe = 1 where uchatId =" + chatId + "";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(update);

                return "Вы успешно подписались на обновления";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ce) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    try {
                        rs.close();
                    } catch (SQLException re) {
                    }
                }
            }

        }
        return null;
    }
    public static Object unsubscribe (String chatId, String uName, String uSecondName, String uNick, double lat, double lon) {
        try {
            String select = "SELECT count(uChatId) FROM weatherbotdata.new_table where uChatId = " + chatId + "";
            conn = DriverManager.getConnection(url, usr, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(select);
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {
                String insert = "INSERT INTO `weatherbotdata`.`new_table` (`uName`,`uSecondName`,`uNick`,`uChatId`, `Subscribe`, `lon`, `lat`, `LastDate`) " +
                        "VALUES ('" + uName + "','" + uSecondName + "','" + uNick + "','" + chatId + "', 0," + lon + "," + lat +", now());";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(insert);

                return "Вы успешно отподписались на обновления2";
            } else {
                String update = "UPDATE weatherbotdata.new_table SET Subscribe = 0 where uchatId =" + chatId + "";
                conn = DriverManager.getConnection(url, usr, password);
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(update);

                return "Вы успешно отподписались на обновления";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ce) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    try {
                        rs.close();
                    } catch (SQLException re) {
                    }
                }
            }

        }
        return null;
    }
    public static String sending () {
        try {
            String select = "SELECT * FROM weatherbotdata.new_table";
            conn = DriverManager.getConnection(url, usr, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(select);

            while (rs.next()) {
                int id = rs.getInt(1);
                String uName = rs.getString(2);
                String uSecondName = rs.getString(3);
                String uNick = rs.getString(4);
                String uChatId = rs.getString(5);
                int Subscribe = rs.getInt(6);
                Double lon = rs.getDouble(7);
                Double lat = rs.getDouble(8);
                if (Subscribe == 1) {
                   return uChatId;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public static String MySqlConn(String chatId, String uName, String uSecondName, String uNick) {

        try {
            String select = "SELECT count(uChatId) FROM weatherbotdata.new_table where uChatId = " + chatId + "";
            conn = DriverManager.getConnection(url, usr, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(select);
            rs.next();
            int count = rs.getInt(1);

                if (count > 0) {
                    return "Вы уже подписаны";
                } else {

                    String insert = "INSERT INTO `weatherbotdata`.`new_table` (`uName`,`uSecondName`,`uNick`,`uChatId`,`LastDate`) " +
                            "VALUES ('" + uName + "','" + uSecondName + "','" + uNick + "','" + chatId + "', now());";
                    conn = DriverManager.getConnection(url, usr, password);
                    stmt = conn.createStatement();
                    int rs = stmt.executeUpdate(insert);
                    return "Спасибо за подписку";
                }
            } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ce) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                    try {
                        rs.close();
                    } catch (SQLException re) {
                    }
                }
            }

        }
        return null;
    }
}