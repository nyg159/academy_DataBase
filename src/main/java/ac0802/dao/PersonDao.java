package ac0802.dao;


import ac0802.dto.PersonDTO;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends DAO{
    public List<PersonDTO> selectAll() {
        try {
            String sql = "select * from person";

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            List<PersonDTO> list = new ArrayList<PersonDTO>();

            while (rs.next()) {
                PersonDTO row = new PersonDTO();

                row.name = rs.getString("name");
                row.height = rs.getDouble("height");
                row.birth = rs.getDate("birth");

                list.add(row);

            }

            return list;

        } catch (Exception e) {
            System.err.println("selectAll 예외 : " + e.getMessage());
        } finally {

            close();

        }
        return null;
    }
}
