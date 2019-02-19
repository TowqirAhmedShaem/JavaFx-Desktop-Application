package application;

import java.awt.Desktop.Action;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.apache.tools.ant.taskdefs.condition.And;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class testfeecontroller implements Initializable {
	@FXML
	public ListView<String> mainitems = new ListView<>();
	@FXML
	public ListView<String> calculateitem = new ListView<>();
	@FXML
	public ListView<String> calculatemoney = new ListView<>();
	@FXML
	public Label itemnamelevel = new Label();
	@FXML
	public Label costlevel = new Label();
	@FXML
	public Label printingdatetext = new Label();
	@FXML
	public DatePicker printingdate = new DatePicker();
	@FXML
	public Button savebutton = new Button();
	@FXML
	public TextField itemnamefield = new TextField();
	@FXML
	public TextField costfield = new TextField();

	// Variable
	public String selecteditem = "";
	String namedata = "";
	String moneydata = "";
	String itemNameSymbol = "————————————————————————";
	String moneyNameSysmbol = "————————";
	String TotalCost = "";
	String vat = "";
	String grandcost = "";
	String subtotal = "Sub Total : ";
	String vatDescription = "15% vat : ";
	String grandtotal = "Grand Total : ";
	double previousCost = 0.0;

	public boolean addData;
	public boolean editData;
	public boolean deleteData;

	ObservableList<String> selectedItemList = FXCollections.observableArrayList();
	ObservableList<String> selectedItemMoneyList = FXCollections.observableArrayList();
	ObservableList<String> feenamelist = FXCollections.observableArrayList();

	// Directory
	public String reprotDirectory = "C:\\Govt_Environment\\report";

	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;

	public testfeecontroller() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice",
			// "root", "");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		itemnamefield.setVisible(false);
		itemnamefield.setOpacity(0);
		itemnamelevel.setVisible(false);
		itemnamelevel.setOpacity(0);
		costfield.setVisible(false);
		costlevel.setOpacity(0);
		savebutton.setVisible(false);
		savebutton.setOpacity(0);

		printingdate.setVisible(true);
		printingdate.setOpacity(1);
		printingdatetext.setVisible(true);
		printingdatetext.setOpacity(1);

		try {
			getListdata();
		} catch (SQLException e) {
			System.out.println(e);
		}

		mainitems.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> ListitemListener(null, newValue));

	}

	public void getListdata() throws SQLException {
		String query = "select * from testfee";
		rSet = stat.executeQuery(query);

		while (rSet.next()) {
			String itemname = rSet.getString("name");
			String money = rSet.getString("money");
			int itemNameLength = itemname.length();
			String customSpace = " — ";
			String moneyfromet = " Tk";
			String data = itemname + customSpace + money + moneyfromet;

			feenamelist.add(data);
			mainitems.setItems(feenamelist);

		}
	}

	public void ListitemListener(ActionEvent event, String value) {
		boolean nameflag = true;
		char[] str = new char[30];
		str = value.toCharArray();
		int length = value.length();
		namedata = "";
		moneydata = "";
		for (int i = 0; i < length - 3; i++) {
			if (str[i] == ' ') {
				if (str[i + 1] == '—') {
					nameflag = false;

				}
			}
			if (nameflag) {
				namedata += str[i];
			} else {

				if (str[i + 2] == ' ' || str[i + 2] == 'T' || str[i + 2] == 'k') {

				} else {
					moneydata += str[i + 2];
				}
			}

		}

		if (editData) {
			itemnamefield.setText(namedata);
			costfield.setText(moneydata);
		}

	}

	public void actiontestfeeaddinorderlist(ActionEvent event) {
		itemnamefield.setVisible(false);
		itemnamefield.setOpacity(0);
		itemnamelevel.setVisible(false);
		itemnamelevel.setOpacity(0);
		costfield.setVisible(false);
		costlevel.setOpacity(0);
		savebutton.setVisible(false);
		savebutton.setOpacity(0);

		printingdate.setVisible(true);
		printingdate.setOpacity(1);
		printingdatetext.setVisible(true);
		printingdatetext.setOpacity(1);

		// Removing line Sysmbol
		selectedItemList.remove(subtotal);
		selectedItemMoneyList.remove(TotalCost);
		selectedItemList.remove(vatDescription);
		selectedItemMoneyList.remove(vat);
		selectedItemList.remove(grandtotal);
		selectedItemMoneyList.remove(grandcost);
		selectedItemList.remove(itemNameSymbol);
		selectedItemMoneyList.remove(moneyNameSysmbol);

		previousCost += Double.parseDouble(moneydata);
		TotalCost = "" + previousCost + " Tk";
		vat = "" + (.15) * previousCost + " Tk";
		double grandtotalcost = previousCost + previousCost * .15;
		grandcost = "" + grandtotalcost + " Tk";

		namedata += "";
		moneydata += "";

		selectedItemList.add(namedata);
		selectedItemMoneyList.add(moneydata);

		selectedItemList.add(itemNameSymbol);
		selectedItemMoneyList.add(moneyNameSysmbol);

		selectedItemList.add(subtotal);
		selectedItemMoneyList.add(TotalCost);

		selectedItemList.add(vatDescription);
		selectedItemMoneyList.add(vat);

		selectedItemList.add(grandtotal);
		selectedItemMoneyList.add(grandcost);

		calculateitem.setItems(selectedItemList);
		calculatemoney.setItems(selectedItemMoneyList);

	}

	public void actiontestfeeremovefromorderlist(ActionEvent event) {

		itemnamefield.setVisible(false);
		itemnamefield.setOpacity(0);
		itemnamelevel.setVisible(false);
		itemnamelevel.setOpacity(0);
		costfield.setVisible(false);
		costlevel.setOpacity(0);
		savebutton.setVisible(false);
		savebutton.setOpacity(0);

		printingdate.setVisible(true);
		printingdate.setOpacity(1);
		printingdatetext.setVisible(true);
		printingdatetext.setOpacity(1);

		int index = calculateitem.getSelectionModel().getSelectedIndex();

		String string = selectedItemMoneyList.get(index);

		char[] characterdata = new char[string.length()];
		String characternewdata = "";

		characterdata = string.toCharArray();

		for (int i = 0; i <= string.length() - 1; i++) {
			characternewdata += characterdata[i];
		}
		double presenstmoney = Double.parseDouble(characternewdata);
		previousCost -= presenstmoney;

		selectedItemList.remove(index);
		selectedItemMoneyList.remove(index);
		selectedItemList.remove(subtotal);
		selectedItemMoneyList.remove(TotalCost);
		selectedItemList.remove(vatDescription);
		selectedItemMoneyList.remove(vat);
		selectedItemList.remove(grandtotal);
		selectedItemMoneyList.remove(grandcost);

		TotalCost = "" + previousCost + " Tk";
		vat = "" + (.15) * previousCost + " Tk";
		double grandtotalcost = previousCost + previousCost * .15;
		grandcost = "" + grandtotalcost + " Tk";

		selectedItemList.add(subtotal);
		selectedItemMoneyList.add(TotalCost);

		selectedItemList.add(vatDescription);
		selectedItemMoneyList.add(vat);

		selectedItemList.add(grandtotal);
		selectedItemMoneyList.add(grandcost);

		calculateitem.setItems(selectedItemList);
		calculatemoney.setItems(selectedItemMoneyList);
	}

	public void actionclean(ActionEvent event) {
		previousCost = 0.0;
		namedata = "";
		moneydata = "";
		TotalCost = "";

		selectedItemList.clear();
		selectedItemMoneyList.clear();
		calculateitem.setItems(selectedItemList);
		calculatemoney.setItems(selectedItemMoneyList);

	}

	public void actionprint(ActionEvent event) throws JRException, SQLException {

		String sql = "Delete from testfeeorder";
		stat.executeUpdate(sql);

		int datasize = selectedItemList.size();
		System.out.println(datasize);

		String date = "";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.US);
			date =  printingdate.getValue().format(formatter);
		} catch (Exception e) {

		}
		date = " Date : " + date;
		for (int i = 0; i < datasize - 4; i++) {
			int Serial = i + 1;
			String serial = "" + Serial;

			String query = "INSERT INTO testfeeorder (id,name, money,subtotal,vat,grantotal,date)"
					+ " VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			String TotalMoney = "" + previousCost;
			String VAT = " 15% VAT :        " + vat;
			String GRANDTOTAL = "GRANDTOTAL :        " + grandcost;

			preparedStatement.setString(1, serial);
			preparedStatement.setString(2, selectedItemList.get(i));
			preparedStatement.setString(3, selectedItemMoneyList.get(i));
			preparedStatement.setString(4, TotalMoney);
			preparedStatement.setString(5, VAT);
			preparedStatement.setString(6, GRANDTOTAL);
			preparedStatement.setString(7, date);
			preparedStatement.execute();
		}

		JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\testfeeslip.jrxml");
		// JasperReport jr =
		// JasperCompileManager.compileReport("D:\\java\\Environment\\src\\application\\testfee.jrxml");
		// JasperReport jr =
		// JasperCompileManager.compileReport(reprotDirectory+"\\watermonitoringreportpond.jrxml");
		JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
		JasperViewer.viewReport(jp, false);
	}

	public void actionaddbutton(ActionEvent event) {

		itemnamefield.setVisible(true);
		itemnamefield.setOpacity(1);
		itemnamelevel.setVisible(true);
		itemnamelevel.setOpacity(1);
		costfield.setVisible(true);
		costlevel.setOpacity(1);
		savebutton.setVisible(true);
		savebutton.setOpacity(1);

		printingdate.setVisible(false);
		printingdate.setOpacity(0);
		printingdatetext.setVisible(false);
		printingdatetext.setOpacity(0);

		addData = true;
		editData = false;
		deleteData = false;

		itemnamefield.setText(null);
		costfield.setText(null);

	}

	public void actioneditbutton(ActionEvent event) {
		itemnamefield.setVisible(true);
		itemnamefield.setOpacity(1);
		itemnamelevel.setVisible(true);
		itemnamelevel.setOpacity(1);
		costfield.setVisible(true);
		costlevel.setOpacity(1);
		savebutton.setVisible(true);
		savebutton.setOpacity(1);

		printingdate.setVisible(false);
		printingdate.setOpacity(0);
		printingdatetext.setVisible(false);
		printingdatetext.setOpacity(0);

		addData = false;
		editData = true;
		deleteData = false;

	}

	public void actionremovebutton(ActionEvent event) throws SQLException {

		itemnamefield.setVisible(false);
		itemnamefield.setOpacity(0);
		itemnamelevel.setVisible(false);
		itemnamelevel.setOpacity(0);
		costfield.setVisible(false);
		costlevel.setOpacity(0);
		savebutton.setVisible(false);
		savebutton.setOpacity(0);

		printingdate.setVisible(true);
		printingdate.setOpacity(1);
		printingdatetext.setVisible(true);
		printingdatetext.setOpacity(1);

		addData = false;
		editData = false;

		int id = mainitems.getSelectionModel().getSelectedIndex() + 1;

		String sql = "Delete from testfee where name = " + "'" + namedata + "' and money = " + "'" + moneydata + "'";
		stat.executeUpdate(sql);

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information Message");
		alert.setHeaderText("Access Granted !!");
		alert.setContentText("Your data has been successfully removed.");
		alert.showAndWait();

		itemnamefield.setText(null);
		costfield.setText(null);
		feenamelist.clear();
		getListdata();

	}

	public void actionsavebuton(ActionEvent event) throws SQLException {

		// For Add Data
		if (addData) {
			String itemname = itemnamefield.getText();
			String cost = costfield.getText();
			double intcost;
			try {
				if (cost != null && itemname != null && itemname.length() > 1) {
					intcost = Double.parseDouble(cost);

					String query = "INSERT INTO testfee (name, money)" + " VALUES (?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

					preparedStatement.setString(1, itemname);
					preparedStatement.setString(2, cost);
					preparedStatement.execute();

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText("Access Granted !!");
					alert.setContentText("Your data has been successfully saved.");
					alert.showAndWait();

					itemnamefield.setText(null);
					costfield.setText(null);
					feenamelist.clear();
					getListdata();

				} else {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Information Message");
					alert.setContentText("Please fill up all Textbox. Thank You!");
					alert.showAndWait();

				}
			} catch (Exception e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please fill up all Textbox. Thank You!");
				alert.showAndWait();

			}
		}

		// For Edit Data
		if (editData) {
			String itemname = itemnamefield.getText();
			String cost = costfield.getText();
			double intcost;
			try {
				if (cost != null && itemname != null && itemname.length() > 1) {
					intcost = Double.parseDouble(cost);
					int id = mainitems.getSelectionModel().getSelectedIndex() + 1;
					String sql = "Update testfee set name=?,money=? where  name like " + "'" + namedata
							+ "' and money like " + "'" + moneydata + "'";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
					preparedStatement.setString(1, itemname);
					preparedStatement.setString(2, cost);
					preparedStatement.execute();

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText("Access Granted !!");
					alert.setContentText("Your data has been successfully saved.");
					alert.showAndWait();

					itemnamefield.setText(null);
					costfield.setText(null);
					feenamelist.clear();
					getListdata();

				} else {

					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Information Message");
					alert.setContentText("Please fill up all Textbox. Thank You!");
					alert.showAndWait();

				}
			} catch (Exception e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please fill up all Textbox. Thank You!");
				alert.showAndWait();

			}
		}

	}

}
