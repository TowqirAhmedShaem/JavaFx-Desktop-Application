package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class waterindustryreportshow implements Initializable {
	
	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;

	
	public waterindustryreportshow() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice", "root", "");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	@FXML
	public TableView<WaterIndustryUser> waterindustrytable = new TableView<WaterIndustryUser>();

	@FXML
	public TableColumn<WaterIndustryUser, String> columnsdate;
	@FXML
	public TableColumn<WaterIndustryUser, String> columnname;
	@FXML
	public TableColumn<WaterIndustryUser, String> columnserial;
	
	public ObservableList<String> data = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columnname.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnsdate.setCellValueFactory(new PropertyValueFactory<>("date"));
		columnserial.setCellValueFactory(new PropertyValueFactory<>("serial"));
		
	      ObservableList<WaterIndustryUser> list = getUserList();
	      waterindustrytable.setItems(list);
	      
		
//		try {
//			String query = "select * from waterindustryreportshow";
//			rSet = stat.executeQuery(query);
//			while (rSet.next()) {
//				data.addAll(rSet.getString("serial"), rSet.getString("date"), rSet.getString("name"));
//				System.out.println(data);
//				waterindustrytable.setUserData(data);
//				waterindustrytable.getColumns().addAll(columnserial,columnname,columnsdate);
//				System.out.println(waterindustrytable);
//			}
//			stat.close();
//			rSet.close();
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		
	}
	  private ObservableList<WaterIndustryUser> getUserList() {
		  
	      WaterIndustryUser user1 = new WaterIndustryUser("1", "Today", "Shaem");
	 
	      ObservableList<WaterIndustryUser> list = FXCollections.observableArrayList(user1);
	      return list;
	  }

}
