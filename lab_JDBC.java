package lab_JDBC;

public class lab_JDBC {

    public static void main(String[] args) {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("warehouse", "inf132217");
        connectionProps.put("password", "inf132217");
        try {
            conn = DriverManager.getConnection("
                    jdbc:oracle:
            thin:
            @admlab2.cs.put.poznan.pl:1521 / "+
            "dblab02_students.cs.put.poznan.pl", connectionProps);
            System.out.println("Połączono z bazą danych");
        } catch (SQLException ex) {
            Logger.getLogger(Lab_JDBC.class.getName()).log(Level.SEVERE,
                    "nie udało się połączyć z bazą danych", ex);
            System.exit(-1);
        }
    }

}