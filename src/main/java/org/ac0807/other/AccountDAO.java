package org.ac0807.other;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDAO extends DAO0807{
        public List<AccountDTO> selectAll() {
            try {

                String sql = "select * from account";

                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);

                List<AccountDTO> list = new ArrayList<>();

                while (rs.next()) {
                    AccountDTO row = new AccountDTO();

                    row.setIdx(rs.getInt("idx"));
                    row.setEmail(rs.getString("email"));
                    row.setNick(rs.getString("nick"));
                    row.setUserid(rs.getString("userid"));
                    row.setUserPw(rs.getString("userPw"));
                    row.setJoin_date(rs.getDate("join_date"));

                    list.add(row);

                }

                return list;

            } catch (SQLException e) {
                System.err.println("select 예외 : "+ e.getMessage());
            }finally {
                close();

            }
            return null;
        }

//        public List<AccountDTO> insert() {
//
//        }



}
