public class JdbcDemo {
    public static void main (String[] args) {
        System.out.println("JdbcDemo");

        //INSERT INTO `student` (`id`, `name`, `email`) VALUES (NULL, 'Patrick Bayr', 'pa.bayr@tsn.at'),
        // (NULL, 'Claudio Landerer', 'claudio.landerer@tsn.at');
    }
        public static void selectAllDemo()
        {
            System.out.println("Select DEMO mit JDBC");
            String sqlSelectAllPersons = "SELECT * FROM `student`";
        }

    }



