package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class airindustrystandardlimitcontroller implements Initializable {
	@FXML
	public DatePicker idealdate = new DatePicker();
	@FXML
	public TextField idealsubject = new TextField();
	@FXML
	public TextField idealreference = new TextField();
	@FXML
	public TextField signaturetemplate = new TextField();
	@FXML
    public TextField idealspm = new TextField();
	@FXML
    public TextField idealsox = new TextField();
	@FXML
    public TextField idealnox = new TextField();
	@FXML
    public TextField idealcox = new TextField();
	@FXML
	public TextArea idealremarks = new TextArea();
	@FXML
	public TextField idealdescription = new TextField();

	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;

	public airindustrystandardlimitcontroller() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
			// "root", "");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		actionrefresh(null);

	}

	public void actionrefresh(ActionEvent event) {

		String DAY = "";
		String remarks = "-";
		String subject = "-";
		String refrence = "-";
		String samplecollector = "-";
		String description = "-";
		String spm = "-";
		String sox = "-";
		String nox = "-";
		String cox = "-";
		


		String query = "select * from airindustrystandarddatasave";
		try {
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				DAY = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				refrence = rSet.getString("reference");
				samplecollector = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				spm = rSet.getString("idealspm");
				sox = rSet.getString("idealsox");
				cox = rSet.getString("idealcox");
				nox = rSet.getString("idealnox");
				remarks = rSet.getString("remarks");

			}

		} catch (SQLException e) {

		}
		try {
			idealsubject.setText(subject);
			idealreference.setText(refrence);
			idealdescription.setText(description);
			signaturetemplate.setText(samplecollector);
			idealspm.setText(spm);
			idealsox.setText(sox);
			idealnox.setText(nox);
			idealcox.setText(cox);
			idealremarks.setText(remarks);
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	public void actionidealsave(ActionEvent event) throws SQLException {
		String date = "-";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.US);
			date = idealdate.getValue().format(formatter);
		} catch (Exception exception) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please Select The Date. Thank You!");
			alert.showAndWait();
		}
		String subject = idealsubject.getText();
		String reference = idealreference.getText();
		String samplecolector = signaturetemplate.getText();
		String description = idealdescription.getText();
		String spm = idealspm.getText();
		String sox = idealsox.getText();
		String nox = idealnox.getText();
		String cox = idealcox.getText();
		String remarks = idealremarks.getText();

		String deleteQuery = "delete from airindustrystandarddatasave";
		stat.execute(deleteQuery);

		// //Adding into database
		String insertquery = "INSERT INTO airindustrystandarddatasave (sampledate, subject, reference, signaturetemplate, description, idealspm,idealsox,idealnox,idealcox, remarks)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
		preparedStatement.setString(1, date);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, reference);
		preparedStatement.setString(4, samplecolector);
		preparedStatement.setString(5, description);
		preparedStatement.setString(6, spm);
		preparedStatement.setString(7, sox);
		preparedStatement.setString(8, nox);
		preparedStatement.setString(9, cox);
		preparedStatement.setString(10, remarks);

		preparedStatement.execute();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information Message");
		alert.setHeaderText("Access Granted !!");
		alert.setContentText("Your data has been successfully saved.");
		alert.showAndWait();

	}

}
