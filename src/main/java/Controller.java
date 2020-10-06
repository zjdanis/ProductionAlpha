import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    @FXML
    private Label lblOutput;

    @FXML
    private ChoiceBox<String> itemType1;

    @FXML
    private ChoiceBox<String> itemType2;

    @FXML
    private Label productName1;

    @FXML
    private ComboBox<String> cmbQuantity;

    @FXML
    private Label recordedProduct;

    public void initialize() {
        for (int i = 1; i <= 10; i++) {
            cmbQuantity.getItems().add(String.valueOf(i));
        }
    }

    public void productName1(){
        String itemType [];
    }

    public void addProduct() {
        lblOutput.setText("Product Added");
        connectDatabase();
    }

    public void recordProd() {
        recordedProduct.setText("Product Recorded");
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"DMI_EMPTY_DB_PASSWORD", "OBL_UNSATISFIED_OBLIGATION"})
    private void connectDatabase() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/HR";

        final String USER = "";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            String sql = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";

            stmt.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
