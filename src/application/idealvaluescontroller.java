package application;

import java.awt.Desktop.Action;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class idealvaluescontroller implements Initializable{
	
	@FXML
	public ComboBox<String> idealvaluecombobox = new ComboBox<>();
	@FXML
	public TextField industryTypeField = new TextField();
	@FXML
	public TextField PHfield = new TextField();
	@FXML
	public TextField bodfield = new TextField();
	@FXML
	public TextField oilandgreasefield = new TextField();
	@FXML
	public TextField totalfardness = new TextField();
	@FXML
	public AnchorPane anchorpaneForOption = new AnchorPane();
	
	ObservableList<String> indsutrytypelist = FXCollections.observableArrayList("Refresh", "Sugar(Production ≥ 50 Ton)", "Sugar(Production< 50 Ton)", "Tannery", "Cement",
			"Architect", "Fertilizer", "Pulp & Paper", "Distillery", "Embrodery", "Decorator", "Ceramic", "Weaving");
	
	//Database Elements
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;
	
	//Constructor
	public idealvaluescontroller() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice", "root", "");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchorpaneForOption.setDisable(true);
		anchorpaneForOption.setOpacity(0);
		
		idealvaluecombobox.setItems(indsutrytypelist);
		idealvaluecombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionidealValueIndustryTypeCombobox(newValue));
		
	}
	
	@FXML
	public void actionidealvaluessave(ActionEvent event) throws SQLException{
		String value;
		String Industrytype;
		String ph = "Null";
		String bod = "Null";
		String OilandGrease = "Null";
		String TotalHardness = "Null";
		String ph2 = "Null";
		String bod2 = "Null";
		String OilandGrease2 = "Null";
		String TotalHardness2 = "Null";
		value = industryTypeField.getText();
		ph = PHfield.getText();
		bod = bodfield.getText();
		OilandGrease = oilandgreasefield.getText();
		TotalHardness = totalfardness.getText();
		if(value != "Refresh"){
			String query = "select * from IndustryIdealValues where industrytype like "+ "'"+ value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				Industrytype = rSet.getString("industrytype");
				ph2 = rSet.getString("ph");
				bod2 = rSet.getString("bod");
				OilandGrease2 = rSet.getString("oilandgrease");
				TotalHardness2 = rSet.getString("totalhardness");
				if( !(ph.contains(ph2)) || !(bod.contains(bod2)) || !(OilandGrease.contains(OilandGrease2)) || !(TotalHardness.contains(TotalHardness2))){
					//edit
					query = "update IndustryIdealValues set ph = "+ ph + ", bod = " + bod + ", oilandgrease = " + OilandGrease + ", totalhardness = " + TotalHardness +" where industrytype like "+"'"+value+"'";
					PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement(query);
				    preparedStatement.execute();
				    
					System.out.println(ph);
					System.out.println(ph2);
					System.out.println(bod);
					System.out.println(bod2);
					System.out.println(OilandGrease);
					System.out.println(OilandGrease2);
					System.out.println(TotalHardness);
					System.out.println(TotalHardness2);
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Information Message");
					alert.setHeaderText("Access Granted !!");
					alert.setContentText("You Have Changed Data.");
					alert.showAndWait();
				}
			}
			//if (not null add)
			System.out.println(ph.contains(ph2));
			System.out.println(bod.contains(bod2));
			System.out.println(OilandGrease.contains(OilandGrease2));
			System.out.println(TotalHardness.contains(TotalHardness2));
			if(( ph != "Null" || bod != "Null" || OilandGrease != "Null" || TotalHardness != "Null" ) && !(ph.contains(ph2)) && !(bod.contains(bod2)) && !(OilandGrease.contains(OilandGrease2)) && !(TotalHardness.contains(TotalHardness2))){
				System.out.println(ph);
				System.out.println(ph2);
				query = "INSERT INTO IndustryIdealValues (industrytype, ph, bod, oilandgrease, totalhardness)"
						+ " VALUES (?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

				preparedStatement.setString(1, value);
				preparedStatement.setString(2, ph);
				preparedStatement.setString(3, bod);
				preparedStatement.setString(4, OilandGrease);
				preparedStatement.setString(5, TotalHardness);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
			}
			
		}
		
	}
	
	public void actionidealValueIndustryTypeCombobox(String value) {
		anchorpaneForOption.setDisable(false);
		anchorpaneForOption.setOpacity(1);
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				if (indsutrytypelist.contains(item)) {
				} 
				else {
					indsutrytypelist.add(item);
				}
			}
			idealvaluecombobox.setItems(indsutrytypelist);
			
			String Industrytype;
			String ph = "Null";
			String bod = "Null";
			String OilandGrease = "Null";
			String TotalHardness = "Null";
			
			query = "select * from IndustryIdealValues where industrytype like "+ "'"+ value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				Industrytype = rSet.getString("industrytype");
				ph = rSet.getString("ph");
				bod = rSet.getString("bod");
				OilandGrease = rSet.getString("oilandgrease");
				TotalHardness = rSet.getString("totalhardness");
			}
			if(value != "Refresh"){
				industryTypeField.setText(value);
				PHfield.setText(ph);
				bodfield.setText(bod);
				oilandgreasefield.setText(OilandGrease);
				totalfardness.setText(TotalHardness);
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

}
