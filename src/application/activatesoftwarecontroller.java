package application;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class activatesoftwarecontroller implements Initializable {
	@FXML
	public Label activatestatuslabel = new Label();

	@FXML
	public Button activatebutton = new Button();
	
	
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;


	public activatesoftwarecontroller() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
			String query = "CREATE DATABASE environementoffice";
			stat.executeUpdate(query);
			
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
		System.out.println("Activate Software Construction first");
	}

	@FXML
	public void actionbuttonactivatesoftware(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		activatestatuslabel.setText("Software Is Not Activated");
		
		String strDirectoy = "C:\\Govt_Environment";
		boolean success = (new File(strDirectoy)).mkdir();
		System.out.println("Success in creating a directory : " + success);
		if (success) {
			System.out.println("Directory: " + strDirectoy + " created");

		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice", "root", "");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
			activatestatuslabel.setText("Software Is Activated !");
			String sql = "";
			
			//Creating a colimn for Sweage -> Monitoring -> Data Input
			sql = "CREATE TABLE testfeeorder" + " "+
					"(id LONGTEXT, " +
                    " name LONGTEXT, " +
                    " money LONGTEXT, " + 
                    " subtotal LONGTEXT, " + 
                    " vat LONGTEXT, " +
                    " grantotal LONGTEXT, " +
                    " date LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Indsutry -> Report
			sql = "CREATE TABLE airmonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " name LONGTEXT, " +
                    " type LONGTEXT, " +
                    " location LONGTEXT, " +  
                    " samplelocation LONGTEXT, " +  
                    " labcode LONGTEXT, " + 
                    " spm LONGTEXT, " +
                    " sox LONGTEXT, " +
                    " nox LONGTEXT, " +
                    " cox LONGTEXT, " +
                    " idealspm LONGTEXT, " +
                    " idealsox LONGTEXT, " +
                    " idealnox LONGTEXT, " +
                    " idealcox LONGTEXT, " +
                    " memono LONGTEXT, " +
					" sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a column for Air -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE airmonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealspm LONGTEXT, " +
                    " idealsox LONGTEXT, " +
                    " idealnox LONGTEXT, " +
                    " idealcox LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Indsutry -> Report
			sql = "CREATE TABLE airindustryindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " industryname LONGTEXT, " +
                    " industrytype LONGTEXT, " +
                    " location LONGTEXT, " +  
                    " samplelocation LONGTEXT, " +  
                    " labcode LONGTEXT, " + 
                    " spm LONGTEXT, " +
                    " sox LONGTEXT, " +
                    " nox LONGTEXT, " +
                    " cox LONGTEXT, " +
                    " idealspm LONGTEXT, " +
                    " idealsox LONGTEXT, " +
                    " idealnox LONGTEXT, " +
                    " idealcox LONGTEXT, " +
                    " memono LONGTEXT, " +
					" sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a column for Air -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE airindustrystandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealspm LONGTEXT, " +
                    " idealsox LONGTEXT, " +
                    " idealnox LONGTEXT, " +
                    " idealcox LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a column for Sound -> Industry -> Individual Report
			sql = "CREATE TABLE soundmonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " industryname LONGTEXT, " +
                    " industrytype LONGTEXT, " +
                    " location LONGTEXT, " +  
                    " samplelocation LONGTEXT, " +  
                    " labcode LONGTEXT, " + 
                    " soundlevel LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " idealsoundlevel LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a column for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE soundmonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealsoundlevel LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a column for Sound -> Industry -> Individual Report
			sql = "CREATE TABLE soundindustryindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " industryname LONGTEXT, " +
                    " industrytype LONGTEXT, " +
                    " location LONGTEXT, " +  
                    " samplelocation LONGTEXT, " +  
                    " labcode LONGTEXT, " + 
                    " soundlevel LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " idealsoundlevel LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a column for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE soundindustrystandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealsoundlevel LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a column for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE watertubewellmonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Individual Report Generate -> River
			sql = "CREATE TABLE watertubewellmonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " name LONGTEXT, " +
                    " location LONGTEXT, " + 
                    " watertype LONGTEXT, " + 
                    " labcode LONGTEXT, " + 
                    " temperature LONGTEXT, " +
                    " ph LONGTEXT, " +
                    " ec LONGTEXT, " + 
                    " ts LONGTEXT, " +
                    " tds LONGTEXT, " +
                    " ss LONGTEXT, " +
                    " do LONGTEXT, " + 
                    " cod LONGTEXT, " +
                    " salinity LONGTEXT, " +
                    " chloride LONGTEXT, " +
                    " turbidity LONGTEXT, " + 
                    " totalhardness LONGTEXT, " +
                    " oilandgrease LONGTEXT, " +
                    " bod LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a column for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE waterpondmonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Individual Report Generate -> River
			sql = "CREATE TABLE waterpondmonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " name LONGTEXT, " +
                    " location LONGTEXT, " + 
                    " watertype LONGTEXT, " + 
                    " labcode LONGTEXT, " + 
                    " temperature LONGTEXT, " +
                    " ph LONGTEXT, " +
                    " ec LONGTEXT, " + 
                    " ts LONGTEXT, " +
                    " tds LONGTEXT, " +
                    " ss LONGTEXT, " +
                    " do LONGTEXT, " + 
                    " cod LONGTEXT, " +
                    " salinity LONGTEXT, " +
                    " chloride LONGTEXT, " +
                    " turbidity LONGTEXT, " + 
                    " totalhardness LONGTEXT, " +
                    " oilandgrease LONGTEXT, " +
                    " bod LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a column for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE waterseamonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Individual Report Generate -> River
			sql = "CREATE TABLE waterseamonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " name LONGTEXT, " +
                    " location LONGTEXT, " + 
                    " watertype LONGTEXT, " + 
                    " labcode LONGTEXT, " + 
                    " temperature LONGTEXT, " +
                    " ph LONGTEXT, " +
                    " ec LONGTEXT, " + 
                    " ts LONGTEXT, " +
                    " tds LONGTEXT, " +
                    " ss LONGTEXT, " +
                    " do LONGTEXT, " + 
                    " cod LONGTEXT, " +
                    " salinity LONGTEXT, " +
                    " chloride LONGTEXT, " +
                    " turbidity LONGTEXT, " + 
                    " totalhardness LONGTEXT, " +
                    " oilandgrease LONGTEXT, " +
                    " bod LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			
			//Creating a colimn for water -> Monitoring ->  Standard Report Data Save
			sql = "CREATE TABLE waterrivermonitoringstandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Individual Report Generate -> River
			sql = "CREATE TABLE waterrivermonitoringindividualreport" + " "+
                    "(date LONGTEXT, " +
                    " name LONGTEXT, " +
                    " location LONGTEXT, " + 
                    " watertype LONGTEXT, " + 
                    " labcode LONGTEXT, " + 
                    " temperature LONGTEXT, " +
                    " ph LONGTEXT, " +
                    " ec LONGTEXT, " + 
                    " ts LONGTEXT, " +
                    " tds LONGTEXT, " +
                    " ss LONGTEXT, " +
                    " do LONGTEXT, " + 
                    " cod LONGTEXT, " +
                    " salinity LONGTEXT, " +
                    " chloride LONGTEXT, " +
                    " turbidity LONGTEXT, " + 
                    " totalhardness LONGTEXT, " +
                    " oilandgrease LONGTEXT, " +
                    " bod LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Industry ->  Standard Report Data Save
			sql = "CREATE TABLE waterindustrystandarddatasave" + " "+
					"( sampledate LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a colimn for water -> Industry ->  Individual Report
			sql = "CREATE TABLE waterindustryindividualreport" + " "+
                    "( date LONGTEXT, " +
                    " industryname LONGTEXT, " +
                    " industrytype LONGTEXT, "+ 
                    " industrylocation LONGTEXT, " + 
                    " samplelocation LONGTEXT, " + 
                    " watertype LONGTEXT, " + 
                    " labcode LONGTEXT, " + 
                    " temperature LONGTEXT, " +
                    " ph LONGTEXT, " +
                    " ec LONGTEXT, " + 
                    " ts LONGTEXT, " +
                    " tds LONGTEXT, " +
                    " ss LONGTEXT, " +
                    " do LONGTEXT, " + 
                    " cod LONGTEXT, " +
                    " salinity LONGTEXT, " +
                    " chloride LONGTEXT, " +
                    " turbidity LONGTEXT, " + 
                    " totalhardness LONGTEXT, " +
                    " oilandgrease LONGTEXT, " +
                    " bod LONGTEXT, " +
                    " idealtemperature LONGTEXT, " +
                    " idealph LONGTEXT, " +
                    " idealec LONGTEXT, " + 
                    " idealts LONGTEXT, " +
                    " idealtds LONGTEXT, " +
                    " idealss LONGTEXT, " +
                    " idealdo LONGTEXT, " + 
                    " idealcod LONGTEXT, " +
                    " idealsalinity LONGTEXT, " +
                    " idealchloride LONGTEXT, " +
                    " idealturbidity LONGTEXT, " + 
                    " idealtotalhardness LONGTEXT, " +
                    " idealoilandgrease LONGTEXT, " +
                    " idealbod LONGTEXT, " +
                    " memono LONGTEXT, " +
                    " sampledate LONGTEXT, " +
                    " subject LONGTEXT, " +
                    " reference LONGTEXT, " +
                    " signaturetemplate LONGTEXT, " +
                    " description LONGTEXT, " +
                    " remarks LONGTEXT " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			
			
			//Creating a colimn for Sweage -> Monitoring -> Data Input
			sql = "CREATE TABLE testfee" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " name VARCHAR(30), " +
                    " money VARCHAR(5), " + 
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a colimn for Sweage -> Monitoring -> Data Input
			sql = "CREATE TABLE sweagemonitoringdatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " bod VARCHAR(10), " +
                    " pox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " temperature VARCHAR(10), " +
                    " coliform VARCHAR(10), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sweage -> Indsutry -> Data Input
			sql = "CREATE TABLE sweageindustrydatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " bod VARCHAR(10), " +
                    " pox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " temperature VARCHAR(10), " +
                    " coliform VARCHAR(10), " +
                    " remarks VARCHAR(300), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Deep Tuble Data Input
			sql = "CREATE TABLE watermonitoringdeeptubledatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " deeptublename VARCHAR(100), " + 
                    " deeptublelocation VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);	
			
			//Creating a colimn for water -> Monitoring -> Pond Data Input
			sql = "CREATE TABLE watermonitoringponddatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " pondname VARCHAR(100), " + 
                    " pondlocation VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Sea Data Input
			sql = "CREATE TABLE watermonitoringseadatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " seaname VARCHAR(100), " + 
                    " sealocation VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a colimn for water -> Monitoring -> River Data Input
			sql = "CREATE TABLE watermonitoringriverdatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " rivername VARCHAR(100), " +
                    " riverwatertype VARCHAR(30), "+ 
                    " riverlocation VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Industry -> Data Input
			sql = "CREATE TABLE waterindustrydatainput" + " "+
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    " day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " industryname VARCHAR(100), " +
                    " industrytype VARCHAR(30), "+ 
                    " industrylocation VARCHAR(300), " + 
                    " samplelocation VARCHAR(50), " + 
                    " watertype VARCHAR(30), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " remarks VARCHAR(300), " +
                    " PRIMARY KEY (id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Monitoring -> Data Input
			sql = "CREATE TABLE airmonitoringdatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
					" day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " spm VARCHAR(10), " +
                    " sox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " cox VARCHAR(10), " +
                    " primary key(id) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Indsutry -> Data Input
			sql = "CREATE TABLE airindustrydatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
					" day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " samplelocation VARCHAR(50), " +  
                    " labcode VARCHAR(10), " + 
                    " spm VARCHAR(10), " +
                    " sox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " cox VARCHAR(10), " +
                    " remarks VARCHAR(300), " +
                    " primary key (id) " + 
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sound -> Monitoring -> Data Input
			sql = "CREATE TABLE soundmonitoringdatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
					" day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " soundlevel VARCHAR(10), " +
                    " primary key (id)" + 
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sound -> Indsutry -> Data Input
			sql = "CREATE TABLE soundindustrydatainput" + " "+
					"(id INT NOT NULL AUTO_INCREMENT, " +
					" day VARCHAR(2), " +
                    " month VARCHAR(2), " + 
                    " year VARCHAR(4), " + 
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " samplelocation VARCHAR(50), " +  
                    " labcode VARCHAR(10), " + 
                    " soundlevel VARCHAR(10), " +
                    " remarks VARCHAR(300), " +
                    " primary key (id)" + 
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a colimn for water -> Industry -> Report Generate
			sql = "CREATE TABLE waterindustryreport" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " industryname VARCHAR(100), " +
                    " industrytype VARCHAR(30), "+ 
                    " industrylocation VARCHAR(300), " + 
                    " samplelocation VARCHAR(50), " + 
                    " watertype VARCHAR(30), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10), " +
                    " remarks VARCHAR(300) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			
			//Creating a colimn for Water -> Industry -> Report Show
			sql = "CREATE TABLE waterindustryreportshow" + " "+
                    "(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sweage -> Indsutry -> Report
			sql = "CREATE TABLE sweageindustryreport" + " "+
                    "(date VARCHAR(10), " +
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " bod VARCHAR(10), " +
                    " pox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " temperature VARCHAR(10), " +
                    " coliform VARCHAR(10), " +
                    " remarks VARCHAR(300) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sweage -> Monitoring -> Report
			sql = "CREATE TABLE sweagemonitoringreport" + " "+
                    "(date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " bod VARCHAR(10), " +
                    " pox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " temperature VARCHAR(10), " +
                    " coliform VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Sound -> Monitoring -> Report
			sql = "CREATE TABLE soundmonitoringreport" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " soundlevel VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);

			
			//Creating a colimn for Sound -> Indsutry -> Report
			sql = "CREATE TABLE soundindustryreport" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " samplelocation VARCHAR(50), " +  
                    " labcode VARCHAR(10), " + 
                    " soundlevel VARCHAR(10), " +
                    " remarks VARCHAR(300) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Monitoring -> Report
			sql = "CREATE TABLE airmonitoringreport" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " labcode VARCHAR(10), " + 
                    " spm VARCHAR(10), " +
                    " sox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " cox VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for Air -> Indsutry -> Report
			sql = "CREATE TABLE airindustryreport" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " indsutryname VARCHAR(100), " +
                    " indsutrtype VARCHAR(30), " +
                    " location VARCHAR(300), " +  
                    " samplelocation VARCHAR(50), " +  
                    " labcode VARCHAR(10), " + 
                    " spm VARCHAR(10), " +
                    " sox VARCHAR(10), " +
                    " nox VARCHAR(10), " +
                    " cox VARCHAR(10), " +
                    " remarks VARCHAR(300) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Report Generate -> Pond
			sql = "CREATE TABLE watermonitoringreportpond" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), "+ 
                    " location VARCHAR(300), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Report Generate -> Sea
			sql = "CREATE TABLE watermonitoringreportsea" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), "+ 
                    " location VARCHAR(300), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);
			//Creating a colimn for water -> Monitoring -> Report Generate -> Deep Tuble
			sql = "CREATE TABLE watermonitoringreporttuble" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), "+ 
                    " location VARCHAR(300), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);
			
			//Creating a colimn for water -> Monitoring -> Report Generate -> River
			sql = "CREATE TABLE watermonitoringreportriver" + " "+
					"(serial VARCHAR(10), " +
                    " date VARCHAR(10), " +
                    " name VARCHAR(100), " +
                    " type VARCHAR(30), "+ 
                    " location VARCHAR(300), " + 
                    " watertype VARCHAR(30), " + 
                    " labcode VARCHAR(10), " + 
                    " temperature VARCHAR(5), " +
                    " ph VARCHAR(5), " +
                    " ec VARCHAR(10), " + 
                    " ts VARCHAR(10), " +
                    " tds VARCHAR(10), " +
                    " ss VARCHAR(10), " +
                    " do VARCHAR(10), " + 
                    " cod VARCHAR(10), " +
                    " salinity VARCHAR(10), " +
                    " chloride VARCHAR(10), " +
                    " turbidity VARCHAR(10), " + 
                    " totalhardness VARCHAR(10), " +
                    " oilandgrease VARCHAR(10), " +
                    " bod VARCHAR(10) " +
                    ")"; 
			stat.executeUpdate(sql);

			
			// creating a column for Sweage -> Indsutry -> registration
			sql = "CREATE TABLE sweageindustryregistration" + " " + 
					"(industrytype VARCHAR(30), "+ 
					" industryname VARCHAR(100), " + 
					" industrylocation VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for Sweage -> Monitoring -> Registration
			sql = "CREATE TABLE sweagemonitoringregistration" + " " + 
					"(type VARCHAR(30), "+ 
					" name VARCHAR(100), " + 
					" location VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for Air -> Monitoring -> Registration
			sql = "CREATE TABLE airmonitoringregistration" + " " + 
					"(type VARCHAR(30), "+ 
					" name VARCHAR(100), " + 
					" location VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for Air -> Indsutry -> registration
			sql = "CREATE TABLE airindustryregistration" + " " + 
					"(industrytype VARCHAR(30), "+ 
					" industryname VARCHAR(100), " + 
					" industrylocation VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for Sound -> Indsutry -> registration
			sql = "CREATE TABLE soundindustryregistration" + " " + 
					"(industrytype VARCHAR(30), "+ 
					" industryname VARCHAR(100), " + 
					" industrylocation VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for Sound -> Monitoring -> Registration
			sql = "CREATE TABLE soundmonitoringregistration" + " " + 
					"(type VARCHAR(30), "+ 
					" name VARCHAR(100), " + 
					" location VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);		
			
			
			//Creating a coumn for ideal values
			String query = "CREATE TABLE IndustryIdealValues" + " " + 
					"(industrytype VARCHAR(30), "+ 
					" ph VARCHAR(10), " + 
					" bod VARCHAR(10), " + 
					" oilandgrease VARCHAR(10), " + 
					" totalhardness VARCHAR(10) " + 
					")";
			stat.executeUpdate(query);
			
			// creating a column for water -> Indsutry -> registration
			sql = "CREATE TABLE waterindustryregistration" + " " + 
					"(industrytype VARCHAR(30), "+ 
					" industryname VARCHAR(100), " + 
					" industrylocation VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			
			// creating a column for water -> Monitoring -> Registration
			sql = "CREATE TABLE watermonitoringregistration" + " " + 
					"(type VARCHAR(30), "+ 
					" name VARCHAR(100), " + 
					" location VARCHAR(300) " + 
					")";
			stat.executeUpdate(sql);
			
			

		} catch (SQLException e) {
			System.out.println(e);
			activatestatuslabel.setText("Software Is Not Activated !");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			activatestatuslabel.setText("Software Is Not Activated !");
		}

	}

}
