package Emp;
import java.sql.*;

public class QueryEmp {
    private Object data[][]=new String[10000][4];
    public void Query(String username,String password) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String connectionUrl =
                "jdbc:oracle:thin:@//ns.duan-dky.me:37467/pdborcl";

        try (Connection connection = DriverManager.getConnection(connectionUrl,username, password);) {
            String sql="select empno,ename,job,sal from emp";
            PreparedStatement statement=null;
            statement= connection.prepareStatement(sql);
            ResultSet res = null;
            res = statement.executeQuery();
            int j=0;
            while (res.next()) {
                System.out.println(res.getString(1) + ' ' + res.getString(2) + ' ' + res.getString(3)+' '+res.getString(4));
                for(int i=1;i<=4;i++){
                    data[j][i-1]=res.getString(i);
                }
                j++;
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {
        return data;
    }
}
