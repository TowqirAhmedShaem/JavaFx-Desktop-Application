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

public class watertubewellmonitoringstandardlimitcontroller implements Initializable {
	@FXML
	public DatePicker idealdate = new DatePicker();
	@FXML
	public TextField idealsubject = new TextField();
	@FXML
	public TextField idealreference = new TextField();
	@FXML
	public TextField signaturetemplate = new TextField();
	@FXML
	public TextField idealph = new TextField();
	@FXML
	public TextField idealchloride = new TextField();
	@FXML
	public TextField idealec = new TextField();
	@FXML
	public TextField idealbod = new TextField();
	@FXML
	public TextField idealoilandgrease = new TextField();
	@FXML
	public TextField idealts = new TextField();
	@FXML
	public TextField idealtds = new TextField();
	@FXML
	public TextField idealdescription = new TextField();
	@FXML
	public TextField idealtotalhardness = new TextField();
	@FXML
	public TextField idealss = new TextField();
	@FXML
	public TextField idealturbidity = new TextField();
	@FXML
	public TextField idealdo = new TextField();
	@FXML
	public TextField idealsalinity = new TextField();
	@FXML
	public TextField idealcod = new TextField();
	@FXML
	public TextField idealtemperature = new TextField();
	@FXML
	public TextArea idealremarks = new TextArea();

	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;

	public watertubewellmonitoringstandardlimitcontroller() throws SQLException {
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
		String temperature = "-";
		String ph = "-";
		String ec = "-";
		String ts = "-";
		String tds = "-";
		String ss = "-";
		String Do = "-";
		String cod = "-";
		String salinity = "-";
		String chloride = "-";
		String turbidity = "-";
		String totalhardness = "-";
		String oilandgrease = "-";
		String bod = "-";

		String query = "select * from watertubewellmonitoringstandarddatasave";
		try {
			rSet = stat.executeQuery(query);
			while (rSet.next()) {

				System.out.println("quesry1");
				DAY = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				refrence = rSet.getString("reference");
				samplecollector = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				temperature = rSet.getString("idealtemperature");
				ph = rSet.getString("idealph");
				ec = rSet.getString("idealec");
				ts = rSet.getString("idealts");
				tds = rSet.getString("idealtds");
				ss = rSet.getString("idealss");
				Do = rSet.getString("idealdo");
				cod = rSet.getString("idealcod");
				salinity = rSet.getString("idealsalinity");
				chloride = rSet.getString("idealchloride");
				turbidity = rSet.getString("idealturbidity");
				totalhardness = rSet.getString("idealtotalhardness");
				oilandgrease = rSet.getString("idealoilandgrease");
				bod = rSet.getString("idealbod");
				remarks = rSet.getString("remarks");

			}

		} catch (SQLException e) {

		}
		try {
			idealsubject.setText(subject);
			idealreference.setText(refrence);
			idealdescription.setText(description);
			signaturetemplate.setText(samplecollector);
			idealtemperature.setText(temperature);
			idealph.setText(ph);
			idealec.setText(ec);
			idealts.setText(ts);
			idealtds.setText(tds);
			idealss.setText(ss);
			idealdo.setText(Do);
			idealcod.setText(cod);
			idealsalinity.setText(salinity);
			idealchloride.setText(chloride);
			idealturbidity.setText(turbidity);
			idealtotalhardness.setText(totalhardness);
			idealoilandgrease.setText(oilandgrease);
			idealbod.setText(bod);
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

		String ph = idealph.getText();
		String chloride = idealchloride.getText();
		String ec = idealec.getText();
		String bod = idealbod.getText();
		String oilandgrease = idealoilandgrease.getText();
		String ts = idealts.getText();
		String tds = idealtds.getText();
		String totalhardness = idealtotalhardness.getText();
		String ss = idealss.getText();
		String turbidity = idealturbidity.getText();
		String Do = idealdo.getText();
		String salinity = idealsalinity.getText();
		String cod = idealcod.getText();
		String temperature = idealtemperature.getText();
		String remarks = idealremarks.getText();

		String deleteQuery = "delete from watertubewellmonitoringstandarddatasave";
		stat.execute(deleteQuery);

		// //Adding into database
		String insertquery = "INSERT INTO watertubewellmonitoringstandarddatasave (sampledate, subject, reference, signaturetemplate, description, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity,  idealchloride, idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,idealtemperature, remarks)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
		preparedStatement.setString(1, date);
		preparedStatement.setString(2, subject);
		preparedStatement.setString(3, reference);
		preparedStatement.setString(4, samplecolector);
		preparedStatement.setString(5, description);
		preparedStatement.setString(6, ph);
		preparedStatement.setString(7, ec);
		preparedStatement.setString(8, ts);
		preparedStatement.setString(9, tds);
		preparedStatement.setString(10, ss);
		preparedStatement.setString(11, Do);
		preparedStatement.setString(12, cod);
		preparedStatement.setString(13, salinity);
		preparedStatement.setString(14, chloride);
		preparedStatement.setString(15, turbidity);
		preparedStatement.setString(16, totalhardness);
		preparedStatement.setString(17, oilandgrease);
		preparedStatement.setString(18, bod);
		preparedStatement.setString(19, temperature);
		preparedStatement.setString(20, remarks);

		preparedStatement.execute();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information Message");
		alert.setHeaderText("Access Granted !!");
		alert.setContentText("Your data has been successfully saved.");
		alert.showAndWait();

	}

}
