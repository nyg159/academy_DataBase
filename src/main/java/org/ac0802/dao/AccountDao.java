package org.ac0802.dao;

import org.ac0802.dto.AccountDTO;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends DAO{
    public List<AccountDTO> selectAll(){
        try {

            String sql = "select * from account";

            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<AccountDTO> list = new ArrayList<AccountDTO>();

            while (rs.next()) {
                AccountDTO row = new AccountDTO();

                row.setIdx(rs.getInt("idx"));
                row.setEmail(rs.getString("email"));
                row.setJoin_Date(rs.getDate("join_Date"));
                row.setNick(rs.getString("nick"));
                row.setUserId(rs.getString("userid"));
                row.setUserPw(rs.getString("userPw"));

                list.add(row);
            }
            return list;

        } catch (Exception e) {
            System.err.println("selectAll 예외 : "+ e.getMessage());
        }finally {
            close();
        }
        return null;


    }
}
