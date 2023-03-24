import java.sql.*;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn;
        String url = "jdbc:postgresql://localhost:5432/meu_db"; 
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "1234");
        props.setProperty("ssl", "false");
        conn = DriverManager.getConnection(url, props);

        System.out.println("Conectado");
        
        Statement sttt = conn.createStatement();

        /*String mySqlCode = "CREATE TABLE clients " +
                    "(" +
                        "username CHAR(20) PRIMARY KEY NOT NULL, " +
                        "fullname TEXT NOT NULL, " +
                        "email CHAR(50) NOT NULL, " +
                        "phone CHAR(15) NOT NULL, " +
                        "age INT NOT NULL " +
                    ")";
                    sttt.executeUpdate(mySqlCode);
                    System.out.println("Tabela Criada");
                    sttt.close();
                    conn.close();  */           
        // String mySqlCode = "INSERT INTO clients VALUES ('go97', 'Daniele Zanoni', 'email@gmail.com', '985463218', 26)";
        // sttt.executeUpdate(mySqlCode);
        // System.out.println("Linha inserida");

        String mySqlString = "SELECT * FROM clients";
        ResultSet tableResult = sttt.executeQuery(mySqlString);
        System.out.println("Query executada");
        
        while(tableResult.next()){
            String username = tableResult.getString("username");
            System.out.println("Nome de usuario: " + username);
        }

        sttt.close();
        conn.close();
    }
}
