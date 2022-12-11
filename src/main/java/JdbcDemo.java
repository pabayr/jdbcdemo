import java.sql.*;

public class JdbcDemo {
    public static void main (String[] args) {
        System.out.println("JdbcDemo");
        selectAllDemo();
       updateStudentDemo();
       selectAllDemo();
       deleteStudentDemo(3);
       selectAllDemo();
       findAllByNameLike("ba");

    }

    public static void findAllByNameLike(String sname)
    {
        System.out.println("Select DEMO mit JDBC");
        String connectionURL="jdbc:mysql://localhost:3306/jdbcdemo";
        String user= "root";
        String pwd="";
        try(Connection conn = DriverManager.getConnection(connectionURL,user,pwd)){
            System.out.println("Verbindung zur DB hergestellt");

            PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM `student` WHERE `student`.`name` LIKE ?");
            preparedStatement.setString(1,"%"+sname+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email= rs.getString("email");
                System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
            }
        }catch(SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }


    }
    public static void deleteStudentDemo(int studentID) //Hier geben wir den Parameter gleich mit anstatt sie zu hardcoden
    {
        System.out.println("Delete DEMO");
        String connectionURL="jdbc:mysql://localhost:3306/jdbcdemo";
        String user= "root";
        String pwd="";
        try(Connection conn = DriverManager.getConnection(connectionURL,user,pwd)){
            System.out.println("Verbindung zur DB hergestellt");

            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM `student` where `student`.`id` = ?;");
            try {
                preparedStatement.setInt(1,studentID);
                int affectedRows=preparedStatement.executeUpdate();
                System.out.println("Anzahl der gelöschten Datensätze: " + affectedRows);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-DELETE Statement" + ex.getMessage());
            }
        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }


    }
    public static void updateStudentDemo()
    {
        System.out.println("Update DEMO");
        String connectionURL="jdbc:mysql://localhost:3306/jdbcdemo";
        String user= "root";
        String pwd="";
        try(Connection conn = DriverManager.getConnection(connectionURL,user,pwd)){
            System.out.println("Verbindung zur DB hergestellt");

            PreparedStatement preparedStatement= conn.prepareStatement("UPDATE `student` set `name` = ? where `student`.`id` = 3;");
            try {
                preparedStatement.setString(1,"Hans Zimmer");
                int affectedRows=preparedStatement.executeUpdate();
                System.out.println("Anzahl der aktualisierten Datensätze: " + affectedRows);
            } catch (SQLException ex)
            {
                System.out.println("Fehler im SQL-INSERT Statement" + ex.getMessage());
            }
        } catch (SQLException e)
        {
            System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
        }

    }



        public static void selectAllDemo()
        {
            System.out.println("Select DEMO mit JDBC");
            String sqlSelectAllPersons = "SELECT * FROM `student`";
            String connectionURL="jdbc:mysql://localhost:3306/jdbcdemo";
            String user= "root";
            String pwd="";
            try(Connection conn = DriverManager.getConnection(connectionURL,user,pwd)){
                System.out.println("Verbindung zur DB hergestellt");

                PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM `student`");
                ResultSet rs = preparedStatement.executeQuery();
                while(rs.next())
                {
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String email= rs.getString("email");
                    System.out.println("Student aus der DB: [ID] " + id + " [NAME] " + name + " [EMAIL] " + email);
                }
            }catch(SQLException e)
            {
                System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
            }

        }
        public static void insertStudentDemo()
        {
            System.out.println("Insert DEMO mit JDBC");
            String connectionURL="jdbc:mysql://localhost:3306/jdbcdemo";
            String user= "root";
            String pwd="";
            try(Connection conn = DriverManager.getConnection(connectionURL,user,pwd)){
                System.out.println("Verbindung zur DB hergestellt");

                PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL,?,?)");
                try
                {
                preparedStatement.setString(1,"Peter Zeck");
                preparedStatement.setString(2,"p.zeck@idk.com");
                int rowaffected= preparedStatement.executeUpdate();
                    System.out.println(rowaffected +" Datensätze eingefügt");
                } catch (SQLException ex)
                {
                    System.out.println("Fehler im SQL-INSERT Statement" + ex.getMessage());
                }
            } catch (SQLException e)
            {
                System.out.println("Fehler beim Aufbau der Verbindung zur DB: " + e.getMessage());
            }

        }

    }



