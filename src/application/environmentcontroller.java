package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.event.ChangeListener;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.PreparedStatement;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRStyledText.Run;
import net.sf.jasperreports.view.JasperViewer;

public class environmentcontroller implements Initializable {

	// All Tab In Main Layout
	@FXML
	public TabPane testfeetab = new TabPane();
	@FXML
	public TabPane soundtab = new TabPane();
	@FXML
	public TabPane airtab = new TabPane();
	@FXML
	public TabPane watertab = new TabPane();
	@FXML
	public TabPane sweagetab = new TabPane();
	@FXML
	public Button waterbutton = new Button();
	@FXML
	public Button airbutton = new Button();
	@FXML
	public Button sweagebutton = new Button();
	@FXML
	public Button soundbutton = new Button();
	
	// Common Water Report Monitoring For All Items
	@FXML
	public RadioButton watermonitoringstandlimitfalse = new RadioButton();
	@FXML
	public RadioButton watermonitoringstandardlimittrue = new RadioButton();
	@FXML
	public CheckBox monitoringReportPrintingForOrganizationChecker = new CheckBox();
	@FXML
	public Label monitoringreportdatetotext = new Label();
	@FXML
	public Label monitoringreportdatetext = new Label();

	// All elements for Water -> Monitoring -> Deep Tubewell
	@FXML
	public CheckBox waterdeeptubewellmonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringDay = new ComboBox<>();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringTubleName = new ComboBox<>();
	@FXML
	public TextField waterdeeptubewellMonitoringLabCode = new TextField();
	@FXML
	public TextArea waterdeeptubewellMonitoringLocation = new TextArea();
	@FXML
	public TextField waterdeeptubewellMonitoringTemperature = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringPH = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringEC = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringTS = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringTDS = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringSS = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringDO = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringCOD = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringSalinity = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringChloride = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringNTU = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringTotalHardrness = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringOilandGrease = new TextField();
	@FXML
	public TextField waterdeeptubewellMonitoringBOD = new TextField();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> waterdeeptubewellMonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label waterdeeptubewellMonitoringseriallabel = new Label();

	// All elements for Water -> Monitoring -> Pond
	@FXML
	public CheckBox waterpondmonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> waterPondMonitoringDay = new ComboBox<>();
	@FXML
	public ComboBox<String> waterPondMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> waterPondMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> waterPondMonitoringPondName = new ComboBox<>();
	@FXML
	public TextField waterPondMonitoringLabCode = new TextField();
	@FXML
	public TextArea waterPondMonitoringPondLocation = new TextArea();
	@FXML
	public TextField waterPondMonitoringTemperature = new TextField();
	@FXML
	public TextField waterPondMonitoringPH = new TextField();
	@FXML
	public TextField waterPondMonitoringEC = new TextField();
	@FXML
	public TextField waterPondMonitoringTS = new TextField();
	@FXML
	public TextField waterPondMonitoringTDS = new TextField();
	@FXML
	public TextField waterPondMonitoringSS = new TextField();
	@FXML
	public TextField waterPondMonitoringDO = new TextField();
	@FXML
	public TextField waterPondMonitoringCOD = new TextField();
	@FXML
	public TextField waterPondMonitoringSalinity = new TextField();
	@FXML
	public TextField waterPondMonitoringChloride = new TextField();
	@FXML
	public TextField waterPondMonitoringNTU = new TextField();
	@FXML
	public TextField waterPondMonitoringTotalHardness = new TextField();
	@FXML
	public TextField waterPondMonitoringOilandGrease = new TextField();
	@FXML
	public TextField waterPondMonitoringBOD = new TextField();
	@FXML
	public ComboBox<String> waterPondMonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> waterPondMonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label waterPondMonitoringseriallabel = new Label();

	// All elements for Water -> Monitoring -> Sea
	@FXML
	public CheckBox waterseamonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> waterSeaMonitoringDay = new ComboBox<>();
	@FXML
	public ComboBox<String> waterSeaMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> waterSeaMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> waterSeaMonitoringSeaName = new ComboBox<>();
	@FXML
	public TextField waterSeaMonitoringLabCode = new TextField();
	@FXML
	public TextArea waterSeaMonitoringSeaLocation = new TextArea();
	@FXML
	public TextField waterSeaMonitoringTemperature = new TextField();
	@FXML
	public TextField waterSeaMonitoringPH = new TextField();
	@FXML
	public TextField waterSeaMonitoringEC = new TextField();
	@FXML
	public TextField waterSeaMonitoringTS = new TextField();
	@FXML
	public TextField waterSeaMonitoringTDS = new TextField();
	@FXML
	public TextField waterSeaMonitoringSS = new TextField();
	@FXML
	public TextField waterSeaMonitoringDO = new TextField();
	@FXML
	public TextField waterSeaMonitoringCOD = new TextField();
	@FXML
	public TextField waterSeaMonitoringSalinity = new TextField();
	@FXML
	public TextField waterSeaMonitoringChloride = new TextField();
	@FXML
	public TextField waterSeaMonitoringNTU = new TextField();
	@FXML
	public TextField waterSeaMonitoringTotalHardness = new TextField();
	@FXML
	public TextField waterSeaMonitoringOilandGrease = new TextField();
	@FXML
	public TextField waterSeaMonitoringBOD = new TextField();
	@FXML
	public ComboBox<String> waterSeaMonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> waterSeaMonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label waterSeaMonitoringseriallabel = new Label();

	// All elements for Water -> Monitoring -> River
	@FXML
	public CheckBox waterrivermonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> waterRiverMonitoringDay = new ComboBox<>();
	@FXML
	public ComboBox<String> waterRiverMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> waterRiverMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> waterRiverMonitoringRiverName = new ComboBox<>();
	@FXML
	public ComboBox<String> waterRiverMonitoringRiverWaterType = new ComboBox<>();
	@FXML
	public TextField waterRiverMonitoringLabCode = new TextField();
	@FXML
	public TextArea waterRiverMonitoringLocation = new TextArea();
	@FXML
	public TextField waterRiverMonitoringTemperature = new TextField();
	@FXML
	public TextField waterRiverMonitoringSS = new TextField();
	@FXML
	public TextField waterRiverMonitoringTS = new TextField();
	@FXML
	public TextField waterRiverMonitoringPH = new TextField();
	@FXML
	public TextField waterRiverMonitoringEC = new TextField();
	@FXML
	public TextField waterRiverMonitoringTDS = new TextField();
	@FXML
	public TextField waterRiverMonitoringDO = new TextField();
	@FXML
	public TextField waterRiverMonitoringCOD = new TextField();
	@FXML
	public TextField waterRiverMonitoringSalinity = new TextField();
	@FXML
	public TextField waterRiverMonitoringChloride = new TextField();
	@FXML
	public TextField waterRiverMonitoringNTU = new TextField();
	@FXML
	public TextField waterRiverMonitoringTotalHardness = new TextField();
	@FXML
	public TextField waterRiverMonitoringOilandGrease = new TextField();
	@FXML
	public TextField waterRiverMonitoringBOD = new TextField();
	@FXML
	public ComboBox<String> waterRiverMonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> waterRiverMonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label waterRiverMonitoringseriallabel = new Label();

	// All elements for Water -> Industry -> Report
	@FXML
	public Label reportdatetext = new Label();
	@FXML
	public Label reportdatetotext = new Label();
	@FXML
	public RadioButton waterindustrystandlimitfalse = new RadioButton();
	@FXML
	public RadioButton waterindustrystandardlimittrue = new RadioButton();
	@FXML
	public CheckBox ReportPrintingForOrganizationChecker = new CheckBox();
	

	@FXML
	public ComboBox<String> waterindustryreportindustryname;
	@FXML
	public ComboBox<String> waterindustryreportdatefrom;
	@FXML
	public ComboBox<String> waterindustryreportmonthfrom;
	@FXML
	public ComboBox<String> waterindustryreportyearfrom;
	@FXML
	public ComboBox<String> waterindustryreportdateto;
	@FXML
	public ComboBox<String> waterindustryreportmonthto;
	@FXML
	public ComboBox<String> waterindustryreportyearto;

	// All elements for Water -> Industry -> Data Input
	@FXML
	public CheckBox waterindustrycheckbox = new CheckBox();
	@FXML
	public ComboBox<String> waterIndustryDay;
	@FXML
	public ComboBox<String> waterIndustryMonth;
	@FXML
	public ComboBox<String> waterIndustryYear;
	@FXML
	public ComboBox<String> waterIndustryName;
	@FXML
	public ComboBox<String> waterIndsutryWaterType;
	@FXML
	public ComboBox<String> waterIndustryType;
	@FXML
	public TextField waterIndustryLabCode = new TextField();
	@FXML
	public TextField waterIndustryTemperature = new TextField();
	@FXML
	public TextField waterIndustryPh = new TextField();
	@FXML
	public TextField waterIndustryEC = new TextField();
	@FXML
	public TextField waterIndustryTS = new TextField();
	@FXML
	public TextField waterIndustryTDS = new TextField();
	@FXML
	public TextField waterIndustrySS = new TextField();
	@FXML
	public TextField waterIndustryDO = new TextField();
	@FXML
	public TextField waterIndustryCOD = new TextField();
	@FXML
	public TextField waterIndustrySalinity = new TextField();
	@FXML
	public TextField waterIndustryChloride = new TextField();
	@FXML
	public TextField waterIndustryTurbidity = new TextField();
	@FXML
	public TextField waterIndustryTotalHardness = new TextField();
	@FXML
	public TextField waterIndustryOilandGrease = new TextField();
	@FXML
	public TextField waterIndustryBOD = new TextField();
	@FXML
	public ComboBox<String> waterIndustrydatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> waterIndustryserialcombobox = new ComboBox<>();
	@FXML
	public Label waterIndustryseriallabel = new Label();
	@FXML
	public TextArea waterIndustryRemarks = new TextArea();
	@FXML
	public ComboBox<String> waterIndsutrySampleLocation = new ComboBox<>();

	// All elements in Water -> Industry -> Registration
	/*
	 * Embrodery = সেলাই শিল্প Decorator = প্রসাধক , সজ্জাশিল্প Ceramic = মাটির
	 * শিল্প Weaving = বুনন শিল্প
	 */
	@FXML
	public ComboBox<String> industryTypeInRegistration;

	@FXML
	public TextField industryNameInRegistration = new TextField();
	@FXML
	public TextArea industryLocationInRegistration = new TextArea();

	// Water -> Monitoring -> Report
	@FXML
	public ComboBox<String> watermonitoringreporttype;
	@FXML
	public ComboBox<String> watermonitoringreportname;
	@FXML
	public ComboBox<String> watermonitoringreportdatefrom;
	@FXML
	public ComboBox<String> watermonitoringreportmonthfrom;
	@FXML
	public ComboBox<String> watermonitoringreportyearfrom;
	@FXML
	public ComboBox<String> watermonitoringreportdateto;
	@FXML
	public ComboBox<String> watermonitoringreportmonthto;
	@FXML
	public ComboBox<String> watermonitoringreportyearto;

	// All elements In water -> Monitoring -> Registration
	@FXML
	public ComboBox<String> waterMonitoringType;
	@FXML
	public TextField waterMonitoringName = new TextField();
	@FXML
	public TextArea waterMonitoringLocation = new TextArea();

	// Directory
	public String reprotDirectory = "C:\\Govt_Environment\\report";

	// ComboBox Item List water -> Industry
	ObservableList<String> waterindustrynamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> waterindustrynameFilteredlist = new FilteredList<String>(waterindustrynamelist, p -> true);

	ObservableList<String> waterindustrynamelistforreport = FXCollections.observableArrayList("Refresh", "All Data");
	FilteredList<String> waterindustryFilterednamelistforreport = new FilteredList<String>(
			waterindustrynamelistforreport, p -> true);

	ObservableList<String> waterindustrytype = FXCollections.observableArrayList();
	ObservableList<String> indsutrytypelist = FXCollections.observableArrayList("Refresh", "Sugar(Production ≥ 50 Ton)",
			"Sugar(Production< 50 Ton)", "Tannery", "Cement", "Architect", "Fertilizer", "Pulp & Paper", "Distillery",
			"Embrodery", "Decorator", "Ceramic", "Weaving");
	ObservableList<String> day = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31");
	ObservableList<String> month = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12");
	ObservableList<String> year = FXCollections.observableArrayList("2020", "2019", "2018", "2017", "2016", "2015",
			"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002",
			"2001", "2000");
	ObservableList<String> industrywatertype = FXCollections.observableArrayList("ETP");
	ObservableList<String> industrysamplinglocation = FXCollections.observableArrayList("Inlet Water", "Outlet Water");

	// ComboBox Item list water -> Monitoring
	ObservableList<String> monitoringtypelist = FXCollections.observableArrayList("Refresh", "River", "Sea", "Pond",
			"Deep Tubewell");
	ObservableList<String> monitoringreportnamelistforCorrespondingType = FXCollections.observableArrayList();
	FilteredList<String> monitoringreportFilterednamelistforCorrespondingType = new FilteredList<String>(
			monitoringreportnamelistforCorrespondingType, p -> true);

	ObservableList<String> monitoringtypelistreport = FXCollections.observableArrayList("Refresh", "River", "Sea",
			"Pond", "Deep Tubewell");
	ObservableList<String> waterRiverMonitoringWaterType = FXCollections.observableArrayList("With Sault",
			"Without Sault");

	ObservableList<String> waterRiverMonitoringRiverNameList = FXCollections.observableArrayList("Refresh");
	FilteredList<String> waterRiverMonitoringRiverFilteredNameList = new FilteredList<String>(
			waterRiverMonitoringRiverNameList, p -> true);

	ObservableList<String> waterSeaMonitoringSeaNameList = FXCollections.observableArrayList("Refresh");
	FilteredList<String> waterSeaMonitoringSeaFilteredNameList = new FilteredList<String>(waterSeaMonitoringSeaNameList,
			p -> true);

	ObservableList<String> waterPondMonitoringPondNameList = FXCollections.observableArrayList("Refresh");
	FilteredList<String> waterPondMonitoringPondFilteredNameList = new FilteredList<String>(
			waterPondMonitoringPondNameList, p -> true);

	ObservableList<String> waterdeeptubewellMonitoringDeepNameList = FXCollections.observableArrayList("Refresh");
	FilteredList<String> waterdeeptubewellMonitoringDeepFilteredNameList = new FilteredList<String>(
			waterdeeptubewellMonitoringDeepNameList, p -> true);

	ObservableList<String> waterindustrydatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<String> waterindustrydatainputidlist = FXCollections.observableArrayList();

	ObservableList<String> waterRiverMonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit",
			"Delete");
	ObservableList<String> waterRiverMonitoringdatainputidlist = FXCollections.observableArrayList();

	ObservableList<String> waterSeaMonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit",
			"Delete");
	ObservableList<String> waterSeaMonitoringdatainputidlist = FXCollections.observableArrayList();

	ObservableList<String> waterPondMonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit",
			"Delete");
	ObservableList<String> waterPondMonitoringdatainputidlist = FXCollections.observableArrayList();

	ObservableList<String> waterdeeptubewellMonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit",
			"Delete");
	ObservableList<String> waterdeeptubewellMonitoringdatainputidlist = FXCollections.observableArrayList();

	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;

	// Variable
	public String fullData = "null";
	public String reportfullData = "null";
	public String monitoringreportfullData = "null";

	public String registrationIndustryTypeData = "null";
	public String rivernameFulldata = "Nothing";
	public String seanameFulldata = "Nothing";
	public String pondnameFulldata = "Nothing";
	public String deeptubewellnameFulldata = "Nothing";

	public String waterIndustryDataConvertingType = "";
	public String waterRiverMonitoringDataConvertingType = "";
	public String waterSeaMonitoringDataConvertingType = "";
	public String waterPondMonitoringDataConvertingType = "";
	public String waterdeeptubewellMonitoringDataConvertingType = "";

	public environmentcontroller() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice",
			// "root", "");
			// con =
			// DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/environementoffice",
			// "root", "");
			// con =
			// DriverManager.getConnection("jdbc:mysql://192.168.0.110:3306/environementoffice",
			// "office", "ajmstt");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		industryTypeInRegistration.setItems(indsutrytypelist);
		waterIndustryDay.setItems(day);
		waterIndustryMonth.setItems(month);
		waterIndustryYear.setItems(year);
		waterIndsutryWaterType.setItems(industrywatertype);
		waterIndsutrySampleLocation.setItems(industrysamplinglocation);

		waterRiverMonitoringDay.setItems(day);
		waterRiverMonitoringMonth.setItems(month);
		waterRiverMonitoringYear.setItems(year);
		waterRiverMonitoringRiverWaterType.setItems(waterRiverMonitoringWaterType);
		waterRiverMonitoringRiverName.setItems(waterRiverMonitoringRiverNameList);

		waterSeaMonitoringDay.setItems(day);
		waterSeaMonitoringMonth.setItems(month);
		waterSeaMonitoringYear.setItems(year);
		waterSeaMonitoringSeaName.setItems(waterSeaMonitoringSeaNameList);

		waterPondMonitoringDay.setItems(day);
		waterPondMonitoringMonth.setItems(month);
		waterPondMonitoringYear.setItems(year);
		waterPondMonitoringPondName.setItems(waterPondMonitoringPondNameList);

		waterdeeptubewellMonitoringDay.setItems(day);
		waterdeeptubewellMonitoringMonth.setItems(month);
		waterdeeptubewellMonitoringYear.setItems(year);
		waterdeeptubewellMonitoringTubleName.setItems(waterdeeptubewellMonitoringDeepNameList);

		waterIndustrydatacombobox.setItems(waterindustrydatacovertingtype);
		waterIndustrydatacombobox.setValue("Add");
		waterIndustryserialcombobox.setDisable(true);
		waterIndustryserialcombobox.setOpacity(0);

		waterRiverMonitoringdatacombobox.setItems(waterRiverMonitoringdatacovertingtype);
		waterRiverMonitoringdatacombobox.setValue("Add");
		waterRiverMonitoringserialcombobox.setDisable(true);
		waterRiverMonitoringserialcombobox.setOpacity(0);

		waterSeaMonitoringdatacombobox.setItems(waterSeaMonitoringdatacovertingtype);
		waterSeaMonitoringdatacombobox.setValue("Add");
		waterSeaMonitoringserialcombobox.setDisable(true);
		waterSeaMonitoringserialcombobox.setOpacity(0);

		waterPondMonitoringdatacombobox.setItems(waterPondMonitoringdatacovertingtype);
		waterPondMonitoringdatacombobox.setValue("Add");
		waterPondMonitoringserialcombobox.setDisable(true);
		waterPondMonitoringserialcombobox.setOpacity(0);

		waterdeeptubewellMonitoringdatacombobox.setItems(waterdeeptubewellMonitoringdatacovertingtype);
		waterdeeptubewellMonitoringdatacombobox.setValue("Add");
		waterdeeptubewellMonitoringserialcombobox.setDisable(true);
		waterdeeptubewellMonitoringserialcombobox.setOpacity(0);

		// water -> Monitoring
		waterMonitoringType.setItems(monitoringtypelist);
		watermonitoringreporttype.setItems(monitoringtypelistreport);

		// water -> Report
		waterindustryreportdatefrom.setItems(day);
		waterindustryreportmonthfrom.setItems(month);
		waterindustryreportyearfrom.setItems(year);
		waterindustryreportdateto.setItems(day);
		waterindustryreportmonthto.setItems(month);
		waterindustryreportyearto.setItems(year);

		// water Monitoring -> Report
		watermonitoringreportdatefrom.setItems(day);
		watermonitoringreportmonthfrom.setItems(month);
		watermonitoringreportyearfrom.setItems(year);
		watermonitoringreportdateto.setItems(day);
		watermonitoringreportmonthto.setItems(month);
		watermonitoringreportyearto.setItems(year);

		airtab.setDisable(true);
		airtab.setOpacity(0);
		sweagetab.setDisable(true);
		sweagetab.setOpacity(0);
		soundtab.setDisable(true);
		soundtab.setOpacity(0);
		testfeetab.setDisable(true);
		testfeetab.setOpacity(0);

		// Industry report radio button setup
		waterindustrystandlimitfalse.setVisible(false);
		waterindustrystandlimitfalse.setOpacity(0);
		waterindustrystandardlimittrue.setVisible(false);
		waterindustrystandardlimittrue.setOpacity(0);
		
		// Monitoing report radio button setup
		watermonitoringstandlimitfalse.setVisible(false);
		watermonitoringstandlimitfalse.setOpacity(0);
		watermonitoringstandardlimittrue.setVisible(false);
		watermonitoringstandardlimittrue.setOpacity(0);

		actionWaterIndustryReportIndustryNameCombobox(null);
		waterindustryreportindustryname.setItems(waterindustrynamelistforreport);

		// Listener for Adding Industry Type of Corresponding Industry Name In
		// Water -> Report -> Industryname
		waterindustryreportindustryname.getSelectionModel().selectedItemProperty().addListener(
				(options, oldValue, newValue) -> actionWaterIndustryReportIndustryNameCombobox(null, newValue));

		// Water Monitoring -> Report -> Type
		watermonitoringreporttype.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterMonitoringReportNameCombobox(null, newValue));

		// Adding Item In water -> Industry -> Data Input -> Industry Name
		actionWaterIndustryDataInputIndustryNameCombobox(null);
		waterIndustryName.setItems(waterindustrynamelist);

		// Listener for Adding Industry Type of Corresponding Industry Name In
		// Water -> Industry -> Data Input
		waterIndustryName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		// Function Where New Industry Name will be Included With Corresponding
		// Industry Type
		actionWaterIndustryDataInputIndustryNameCombobox(null, newValue));

		// Listener for Adding New Industry Type In Water -> Industry ->
		// Registration
		industryTypeInRegistration.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterIndustryRegistrationIndustryTypeCombobox());

		// Water -> Industry -> Registration for Initialize
		actionWaterIndustryRegistrationIndustryTypeComboboxForInitialize();

		// Listener for Adding New Industry Type In Water -> Monitoring ->
		// Registration
		waterMonitoringType.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterMonitoringRegistrationIndustryTypeCombobox());

		// Water -> Monitoring -> Registration For Initialize
		actionWaterMonitoringRegistrationTypeComboboxForInitialize();

		// Water -> Monitoring -> River -> Automatic River Location for
		// Corrsponding River Name
		waterRiverMonitoringRiverName.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterMonitoringRiverNameCombobox(null, newValue));
		// Water -> Monitoring -> River ( Loading River name in Initialize)
		actionWaterMonitoringRiverNameCombobox();

		// Water -> Monitoring -> Sea -> Automatic Sea Location for Corrsponding
		// Sea Name
		waterSeaMonitoringSeaName.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterMonitoringSeaNameCombobox(null, newValue));
		// Water -> Monitoring -> Sea ( Loading Sea name in Initialize)
		actionWaterMonitoringSeaNameCombobox();

		// Water -> Monitoring -> Pond -> Automatic Sea Location for
		// Corrsponding Sea Name
		waterPondMonitoringPondName.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> actionWaterMonitoringPondNameCombobox(null, newValue));
		// Water -> Monitoring -> Pond ( Loading Sea name in Initialize)
		actionWaterMonitoringPondNameCombobox();

		// Water -> Monitoring -> Deep Tubewell -> Automatic Sea Location for
		// Corrsponding Deep Tubewell Name
		waterdeeptubewellMonitoringTubleName.getSelectionModel().selectedItemProperty().addListener(
				(options, oldValue, newValue) -> actionWaterMonitoringdeeptubewellNameCombobox(null, newValue));
		// Water -> Monitoring -> Deep Tubewell ( Loading Deep Tubewell name in
		// Initialize)
		actionWaterMonitoringdeeptubewellNameCombobox();

		// Listener for Data converting type Water -> Industry -> Data Input ->
		// Data converting combobox
		waterIndustrydatacombobox.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> WaterIndustryDataInputConverting(null, newValue));

		// Listener for Serial No Water -> Industry -> Data Input -> Data
		// converting combobox
		waterIndustryserialcombobox.getSelectionModel().selectedItemProperty().addListener(
				(options, oldValue, newValue) -> WaterIndustryDataLoadingforcorrespondingserialno(null, newValue));

		// Listener for Data converting type Water -> Monitoring -> River Data
		// Input -> Data converting combobox
		waterRiverMonitoringdatacombobox.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> WaterRiverMonitoringDataInputConverting(null, newValue));

		// Listener for Serial No Water -> Industry -> River Data Input -> Data
		// converting combobox
		waterRiverMonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue,
				newValue) -> WaterRiverMonitoringDataLoadingforcorrespondingserialno(null, newValue));

		// Listener for Data converting type Water -> Monitoring -> Sea Data
		// Input -> Data converting combobox
		waterSeaMonitoringdatacombobox.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> WaterSeaMonitoringDataInputConverting(null, newValue));

		// Listener for Serial No Water -> Industry -> Sea Data Input -> Data
		// converting combobox
		waterSeaMonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener(
				(options, oldValue, newValue) -> WaterSeaMonitoringDataLoadingforcorrespondingserialno(null, newValue));

		// Listener for Data converting type Water -> Monitoring -> Pond Data
		// Input -> Data converting combobox
		waterPondMonitoringdatacombobox.getSelectionModel().selectedItemProperty()
				.addListener((options, oldValue, newValue) -> WaterPondMonitoringDataInputConverting(null, newValue));

		// Listener for Serial No Water -> Industry -> Sea Data Input -> Data
		// converting combobox
		waterPondMonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue,
				newValue) -> WaterPondMonitoringDataLoadingforcorrespondingserialno(null, newValue));

		// Listener for Data converting type Water -> Monitoring -> deeptubewell
		// Data Input -> Data converting combobox
		waterdeeptubewellMonitoringdatacombobox.getSelectionModel().selectedItemProperty().addListener(
				(options, oldValue, newValue) -> WaterdeeptubewellMonitoringDataInputConverting(null, newValue));

		// Listener for Serial No Water -> Industry -> Sea Data Input -> Data
		// converting combobox
		waterdeeptubewellMonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options,
				oldValue, newValue) -> WaterdeeptubewellMonitoringDataLoadingforcorrespondingserialno(null, newValue));

		// Searching or Filtering In Combobox

		waterIndustryName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {

			final TextField editor = waterIndustryName.getEditor();
			final String selected = waterIndustryName.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterindustrynameFilteredlist.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});

		});
		waterIndustryName.setItems(waterindustrynameFilteredlist);
		// new ComboBoxAutoComplete<String>(waterIndustryName);

		waterindustryreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			final TextField editor = waterindustryreportindustryname.getEditor();
			final String selected = waterindustryreportindustryname.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterindustryFilterednamelistforreport.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});
		});
		waterindustryreportindustryname.setItems(waterindustryFilterednamelistforreport);
		
		new ComboBoxAutoComplete<String>(watermonitoringreportname);

		waterRiverMonitoringRiverName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			final TextField editor = waterRiverMonitoringRiverName.getEditor();
			final String selected = waterRiverMonitoringRiverName.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterRiverMonitoringRiverFilteredNameList.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});
		});
		waterRiverMonitoringRiverName.setItems(waterRiverMonitoringRiverFilteredNameList);

		waterSeaMonitoringSeaName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			final TextField editor = waterSeaMonitoringSeaName.getEditor();
			final String selected = waterSeaMonitoringSeaName.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterSeaMonitoringSeaFilteredNameList.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});
		});
		waterSeaMonitoringSeaName.setItems(waterSeaMonitoringSeaFilteredNameList);

		waterPondMonitoringPondName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			final TextField editor = waterPondMonitoringPondName.getEditor();
			final String selected = waterPondMonitoringPondName.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterPondMonitoringPondFilteredNameList.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});
		});
		waterPondMonitoringPondName.setItems(waterPondMonitoringPondFilteredNameList);

		waterdeeptubewellMonitoringTubleName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			final TextField editor = waterdeeptubewellMonitoringTubleName.getEditor();
			final String selected = waterdeeptubewellMonitoringTubleName.getSelectionModel().getSelectedItem();

			Platform.runLater(() -> {
				if (selected == null || !selected.equals(editor.getText())) {
					waterdeeptubewellMonitoringDeepFilteredNameList.setPredicate(item -> {
						if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
							return true;
						} else {
							return false;
						}
					});
				}
			});
		});
		waterdeeptubewellMonitoringTubleName.setItems(waterdeeptubewellMonitoringDeepFilteredNameList);

	}

	public void actionWaterIndustryDataInputIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (fullData.contains(item)) {
				} else {
					fullData += item;
					waterindustrynamelist.add(item);
					waterIndustryName.setItems(waterindustrynamelist);
				}
			}
			waterindustrytype.clear();
			query = "select * from waterindustryregistration where " + "industryname like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				waterindustrytype.add(item);
				waterIndustryType.setItems(waterindustrytype);
			}

			String dataconvertingtype = waterIndustrydatacombobox.getValue();
			if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
				waterindustrydatainputidlist.clear();
				query = "select id from waterindustrydatainput where " + "industryname like " + "'" + value + "'"
						+ " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					String item2 = "" + item;
					waterindustrydatainputidlist.add(item2);
					waterIndustryserialcombobox.setItems(waterindustrydatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Industry -> Data Input -> Loading for corresponding serial no to
	// edit.
	public void WaterIndustryDataLoadingforcorrespondingserialno(ActionEvent event, String serialno) {
		String Serialno = "" + serialno;
		String dataconvertingtype = waterIndustrydatacombobox.getValue();
		if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
			String query = "select * from waterindustrydatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {

					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String indsutryname = rSet.getString("industryname");
					String samplelocation = rSet.getString("samplelocation");
					String labcode = rSet.getString("labcode");
					String indsutrytype = rSet.getString("industrytype");
					String watertype = rSet.getString("watertype");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");
					String industrylocation = rSet.getString("industrylocation");
					String remarks = rSet.getString("remarks");

					waterIndustryDay.setValue(day);
					waterIndustryMonth.setValue(month);
					waterIndustryYear.setValue(year);
					waterIndustryType.setValue(indsutrytype);
					waterIndsutrySampleLocation.setValue(samplelocation);
					waterIndustryLabCode.setText(labcode);
					waterIndsutryWaterType.setValue(watertype);
					waterIndustryType.setValue(indsutrytype);
					waterIndustryTemperature.setText(temperature);
					waterIndustryPh.setText(ph);
					waterIndustryEC.setText(ec);
					waterIndustryTS.setText(ts);
					waterIndustryTDS.setText(tds);
					waterIndustrySS.setText(ss);
					waterIndustryDO.setText(Do);
					waterIndustryCOD.setText(cod);

					waterIndustrySalinity.setText(salinity);
					waterIndustryChloride.setText(chloride);
					waterIndustryTurbidity.setText(turbidity);
					waterIndustryTotalHardness.setText(totalhardness);
					waterIndustryOilandGrease.setText(oilandgrease);
					waterIndustryBOD.setText(bod);
					waterIndustryRemarks.setText(remarks);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		}

	}

	// Water -> Monitoring -> River Data Input -> Loading for corresponding
	// serial no to edit.
	public void WaterRiverMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, String serialno) {
		String Serialno = "" + serialno;
		String dataconvertingtype = waterRiverMonitoringdatacombobox.getValue();
		if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
			String query = "select * from watermonitoringriverdatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {

					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String rivername = rSet.getString("rivername");
					String labcode = rSet.getString("labcode");
					String watertype = rSet.getString("riverwatertype");
					String riverlocation = rSet.getString("riverlocation");

					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");
					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					waterRiverMonitoringDay.setValue(day);
					waterRiverMonitoringMonth.setValue(month);
					waterRiverMonitoringYear.setValue(year);
					waterRiverMonitoringRiverWaterType.setValue(watertype);
					waterRiverMonitoringLabCode.setText(labcode);
					waterIndsutryWaterType.setValue(watertype);
					waterRiverMonitoringTemperature.setText(temperature);
					waterRiverMonitoringLocation.setText(riverlocation);
					waterRiverMonitoringPH.setText(ph);
					waterRiverMonitoringEC.setText(ec);
					waterRiverMonitoringTS.setText(ts);
					waterRiverMonitoringTDS.setText(tds);
					waterRiverMonitoringSS.setText(ss);
					waterRiverMonitoringDO.setText(Do);
					waterRiverMonitoringCOD.setText(cod);

					waterRiverMonitoringSalinity.setText(salinity);
					waterRiverMonitoringChloride.setText(chloride);
					waterRiverMonitoringNTU.setText(turbidity);
					waterRiverMonitoringTotalHardness.setText(totalhardness);
					waterRiverMonitoringOilandGrease.setText(oilandgrease);
					waterRiverMonitoringBOD.setText(bod);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	// Water -> Monitoring -> Sea Data Input -> Loading for corresponding serial
	// no to edit.
	public void WaterSeaMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, String serialno) {
		String Serialno = "" + serialno;
		String dataconvertingtype = waterSeaMonitoringdatacombobox.getValue();
		if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
			String query = "select * from watermonitoringseadatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {

					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String Seaname = rSet.getString("seaname");
					String labcode = rSet.getString("labcode");
					String Sealocation = rSet.getString("sealocation");

					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");
					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					waterSeaMonitoringDay.setValue(day);
					waterSeaMonitoringMonth.setValue(month);
					waterSeaMonitoringYear.setValue(year);
					waterSeaMonitoringLabCode.setText(labcode);
					waterSeaMonitoringTemperature.setText(temperature);
					waterSeaMonitoringSeaLocation.setText(Sealocation);
					waterSeaMonitoringPH.setText(ph);
					waterSeaMonitoringEC.setText(ec);
					waterSeaMonitoringTS.setText(ts);
					waterSeaMonitoringTDS.setText(tds);
					waterSeaMonitoringSS.setText(ss);
					waterSeaMonitoringDO.setText(Do);
					waterSeaMonitoringCOD.setText(cod);

					waterSeaMonitoringSalinity.setText(salinity);
					waterSeaMonitoringChloride.setText(chloride);
					waterSeaMonitoringNTU.setText(turbidity);
					waterSeaMonitoringTotalHardness.setText(totalhardness);
					waterSeaMonitoringOilandGrease.setText(oilandgrease);
					waterSeaMonitoringBOD.setText(bod);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		}

	}

	// Water -> Monitoring -> Pond Data Input -> Loading for corresponding
	// serial no to edit.
	public void WaterPondMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, String serialno) {
		String Serialno = "" + serialno;
		String dataconvertingtype = waterPondMonitoringdatacombobox.getValue();
		if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
			String query = "select * from watermonitoringponddatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {

					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String Pondname = rSet.getString("pondname");
					String labcode = rSet.getString("labcode");
					String Pondlocation = rSet.getString("pondlocation");

					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");
					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					waterPondMonitoringDay.setValue(day);
					waterPondMonitoringMonth.setValue(month);
					waterPondMonitoringYear.setValue(year);
					waterPondMonitoringLabCode.setText(labcode);
					waterPondMonitoringTemperature.setText(temperature);
					waterPondMonitoringPondLocation.setText(Pondlocation);
					waterPondMonitoringPH.setText(ph);
					waterPondMonitoringEC.setText(ec);
					waterPondMonitoringTS.setText(ts);
					waterPondMonitoringTDS.setText(tds);
					waterPondMonitoringSS.setText(ss);
					waterPondMonitoringDO.setText(Do);
					waterPondMonitoringCOD.setText(cod);

					waterPondMonitoringSalinity.setText(salinity);
					waterPondMonitoringChloride.setText(chloride);
					waterPondMonitoringNTU.setText(turbidity);
					waterPondMonitoringTotalHardness.setText(totalhardness);
					waterPondMonitoringOilandGrease.setText(oilandgrease);
					waterPondMonitoringBOD.setText(bod);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		}

	}

	// Water -> Monitoring -> deeptubewell Data Input -> Loading for corresponding
	// serial no to edit.
	public void WaterdeeptubewellMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, String serialno) {
		String Serialno = "" + serialno;
		String dataconvertingtype = waterdeeptubewellMonitoringdatacombobox.getValue();
		if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
			String query = "select * from watermonitoringdeeptubledatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {

					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String deeptubewellname = rSet.getString("deeptubewellname");
					String labcode = rSet.getString("labcode");
					String deeptubewelllocation = rSet.getString("deeptubewelllocation");

					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");
					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					waterdeeptubewellMonitoringDay.setValue(day);
					waterdeeptubewellMonitoringMonth.setValue(month);
					waterdeeptubewellMonitoringYear.setValue(year);
					waterdeeptubewellMonitoringLabCode.setText(labcode);
					waterdeeptubewellMonitoringTemperature.setText(temperature);
					waterdeeptubewellMonitoringLocation.setText(deeptubewelllocation);
					waterdeeptubewellMonitoringPH.setText(ph);
					waterdeeptubewellMonitoringEC.setText(ec);
					waterdeeptubewellMonitoringTS.setText(ts);
					waterdeeptubewellMonitoringTDS.setText(tds);
					waterdeeptubewellMonitoringSS.setText(ss);
					waterdeeptubewellMonitoringDO.setText(Do);
					waterdeeptubewellMonitoringCOD.setText(cod);

					waterdeeptubewellMonitoringSalinity.setText(salinity);
					waterdeeptubewellMonitoringChloride.setText(chloride);
					waterdeeptubewellMonitoringNTU.setText(turbidity);
					waterdeeptubewellMonitoringTotalHardrness.setText(totalhardness);
					waterdeeptubewellMonitoringOilandGrease.setText(oilandgrease);
					waterdeeptubewellMonitoringBOD.setText(bod);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}

		}

	}

	public void actionWaterIndustryDataInputIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (fullData.contains(item)) {
				} else {
					fullData += item;
					waterindustrynamelist.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Industry -> Registration -> Industry Type
	public void actionWaterIndustryRegistrationIndustryTypeCombobox() {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (indsutrytypelist.contains(item)) {
				} else {
					// indsutrytypelist += item;
					indsutrytypelist.add(item);
				}
			}
			industryTypeInRegistration.setItems(indsutrytypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Industry -> Registration -> Industry Type for Initialize
	public void actionWaterIndustryRegistrationIndustryTypeComboboxForInitialize() {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (indsutrytypelist.contains(item)) {
				} else {
					// indsutrytypelist += item;
					indsutrytypelist.add(item);
				}
			}
			industryTypeInRegistration.setItems(indsutrytypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Industry -> Registration
	@FXML
	public void actionWaterIndustryRegistrationSave(ActionEvent event) throws SQLException {
		String Industrytype = industryTypeInRegistration.getValue();
		String IndustryName = industryNameInRegistration.getText();
		String IndsutryLocation = industryLocationInRegistration.getText();

		// checking whether all textbox are fill up or not
		if (Industrytype == null || IndustryName == null || IndsutryLocation == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setHeaderText("You have an error !!");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
		// Database storing
		else {
			String query = "INSERT INTO waterindustryregistration (industrytype, industryname, industrylocation)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, Industrytype);
			preparedStatement.setString(2, IndustryName);
			preparedStatement.setString(3, IndsutryLocation);
			preparedStatement.execute();

			industryTypeInRegistration.setValue(null);
			industryLocationInRegistration.setText(null);
			industryNameInRegistration.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}

	}

	// Water -> Industry -> Data Input -> Data Converting Comboobox
	public void WaterIndustryDataInputConverting(ActionEvent event, String value) {
		waterIndustryDataConvertingType = waterIndustrydatacombobox.getValue();

		if (waterIndustryDataConvertingType == "Add") {
			waterIndustryserialcombobox.setDisable(true);
			waterIndustryserialcombobox.setOpacity(0);
			waterIndustryseriallabel.setDisable(true);
			waterIndustryseriallabel.setOpacity(0);
		}
		if (waterIndustryDataConvertingType == "Edit") {
			waterIndustryserialcombobox.setDisable(false);
			waterIndustryserialcombobox.setOpacity(1);
			waterIndustryseriallabel.setDisable(false);
			waterIndustryseriallabel.setOpacity(1);
		}
		if (waterIndustryDataConvertingType == "Delete") {
			waterIndustryserialcombobox.setDisable(false);
			waterIndustryserialcombobox.setOpacity(1);
			waterIndustryseriallabel.setDisable(false);
			waterIndustryseriallabel.setOpacity(1);
		}

	}

	// Water -> Monitoring -> River Data Input -> Data Converting Comboobox
	public void WaterRiverMonitoringDataInputConverting(ActionEvent event, String value) {
		waterRiverMonitoringDataConvertingType = waterRiverMonitoringdatacombobox.getValue();

		if (waterRiverMonitoringDataConvertingType == "Add") {
			waterRiverMonitoringserialcombobox.setDisable(true);
			waterRiverMonitoringserialcombobox.setOpacity(0);
			waterRiverMonitoringseriallabel.setDisable(true);
			waterRiverMonitoringseriallabel.setOpacity(0);
		}
		if (waterRiverMonitoringDataConvertingType == "Edit") {
			waterRiverMonitoringserialcombobox.setDisable(false);
			waterRiverMonitoringserialcombobox.setOpacity(1);
			waterRiverMonitoringseriallabel.setDisable(false);
			waterRiverMonitoringseriallabel.setOpacity(1);
		}
		if (waterRiverMonitoringDataConvertingType == "Delete") {
			waterRiverMonitoringserialcombobox.setDisable(false);
			waterRiverMonitoringserialcombobox.setOpacity(1);
			waterRiverMonitoringseriallabel.setDisable(false);
			waterRiverMonitoringseriallabel.setOpacity(1);
		}

	}

	// Water -> Monitoring -> Sea Data Input -> Data Converting Comboobox
	public void WaterSeaMonitoringDataInputConverting(ActionEvent event, String value) {
		waterSeaMonitoringDataConvertingType = waterSeaMonitoringdatacombobox.getValue();

		if (waterSeaMonitoringDataConvertingType == "Add") {
			waterSeaMonitoringserialcombobox.setDisable(true);
			waterSeaMonitoringserialcombobox.setOpacity(0);
			waterSeaMonitoringseriallabel.setDisable(true);
			waterSeaMonitoringseriallabel.setOpacity(0);
		}
		if (waterSeaMonitoringDataConvertingType == "Edit") {
			waterSeaMonitoringserialcombobox.setDisable(false);
			waterSeaMonitoringserialcombobox.setOpacity(1);
			waterSeaMonitoringseriallabel.setDisable(false);
			waterSeaMonitoringseriallabel.setOpacity(1);
		}
		if (waterSeaMonitoringDataConvertingType == "Delete") {
			waterSeaMonitoringserialcombobox.setDisable(false);
			waterSeaMonitoringserialcombobox.setOpacity(1);
			waterSeaMonitoringseriallabel.setDisable(false);
			waterSeaMonitoringseriallabel.setOpacity(1);
		}

	}

	// Water -> Monitoring -> Pond Data Input -> Data Converting Comboobox
	public void WaterPondMonitoringDataInputConverting(ActionEvent event, String value) {
		waterPondMonitoringDataConvertingType = waterPondMonitoringdatacombobox.getValue();

		if (waterPondMonitoringDataConvertingType == "Add") {
			waterPondMonitoringserialcombobox.setDisable(true);
			waterPondMonitoringserialcombobox.setOpacity(0);
			waterPondMonitoringseriallabel.setDisable(true);
			waterPondMonitoringseriallabel.setOpacity(0);
		}
		if (waterPondMonitoringDataConvertingType == "Edit") {
			waterPondMonitoringserialcombobox.setDisable(false);
			waterPondMonitoringserialcombobox.setOpacity(1);
			waterPondMonitoringseriallabel.setDisable(false);
			waterPondMonitoringseriallabel.setOpacity(1);
		}
		if (waterPondMonitoringDataConvertingType == "Delete") {
			waterPondMonitoringserialcombobox.setDisable(false);
			waterPondMonitoringserialcombobox.setOpacity(1);
			waterPondMonitoringseriallabel.setDisable(false);
			waterPondMonitoringseriallabel.setOpacity(1);
		}

	}

	// Water -> Monitoring -> deeptubewell Data Input -> Data Converting Comboobox
	public void WaterdeeptubewellMonitoringDataInputConverting(ActionEvent event, String value) {
		waterdeeptubewellMonitoringDataConvertingType = waterdeeptubewellMonitoringdatacombobox.getValue();

		if (waterdeeptubewellMonitoringDataConvertingType == "Add") {
			waterdeeptubewellMonitoringserialcombobox.setDisable(true);
			waterdeeptubewellMonitoringserialcombobox.setOpacity(0);
			waterdeeptubewellMonitoringseriallabel.setDisable(true);
			waterdeeptubewellMonitoringseriallabel.setOpacity(0);
		}
		if (waterdeeptubewellMonitoringDataConvertingType == "Edit") {
			waterdeeptubewellMonitoringserialcombobox.setDisable(false);
			waterdeeptubewellMonitoringserialcombobox.setOpacity(1);
			waterdeeptubewellMonitoringseriallabel.setDisable(false);
			waterdeeptubewellMonitoringseriallabel.setOpacity(1);
		}
		if (waterdeeptubewellMonitoringDataConvertingType == "Delete") {
			waterdeeptubewellMonitoringserialcombobox.setDisable(false);
			waterdeeptubewellMonitoringserialcombobox.setOpacity(1);
			waterdeeptubewellMonitoringseriallabel.setDisable(false);
			waterdeeptubewellMonitoringseriallabel.setOpacity(1);
		}

	}

	// Water -> Monitoring -> Registration -> Type
	public void actionWaterMonitoringRegistrationIndustryTypeCombobox() {
		try {
			String query = "select * from watermonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("type");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringtypelist.contains(item)) {
				} else {
					monitoringtypelist.add(item);
				}
			}
			waterMonitoringType.setItems(monitoringtypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Registration -> Type for Initialize
	public void actionWaterMonitoringRegistrationTypeComboboxForInitialize() {
		try {
			String query = "select * from watermonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("type");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringtypelist.contains(item)) {
				} else {
					monitoringtypelist.add(item);
				}
			}
			waterMonitoringType.setItems(monitoringtypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Registration
	@FXML
	public void actionwaterMonitorinfSave(ActionEvent event) throws SQLException {
		String Monitoringtype = waterMonitoringType.getValue();
		String MonitoringName = waterMonitoringName.getText();
		String MonitoringLocation = waterMonitoringLocation.getText();

		// checking whether all textbox are fill up or not
		if (Monitoringtype == null || MonitoringName == null || MonitoringLocation == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setHeaderText("You have an error !!");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
		// Database storing
		else {
			String query = "INSERT INTO watermonitoringregistration (type, name, location)" + " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, Monitoringtype);
			preparedStatement.setString(2, MonitoringName);
			preparedStatement.setString(3, MonitoringLocation);
			preparedStatement.execute();

			waterMonitoringType.setValue(null);
			waterMonitoringLocation.setText(null);
			waterMonitoringName.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}

	}

	@FXML
	public void actionwaterindustrydataInputButton(ActionEvent event) {
		boolean checkbox = waterindustrycheckbox.isSelected();

		String day = waterIndustryDay.getValue();
		String Month = waterIndustryMonth.getValue();
		String Year = waterIndustryYear.getValue();
		String IndustryName = waterIndustryName.getValue();
		String IndustryType = waterIndustryType.getValue();
		String WaterType = waterIndsutryWaterType.getValue();
		String samplelocation = waterIndsutrySampleLocation.getValue();
		String Labcode = waterIndustryLabCode.getText();
		String Temp = waterIndustryTemperature.getText();
		String ph = waterIndustryPh.getText();
		String ec = waterIndustryEC.getText();
		String ts = waterIndustryTS.getText();
		String tds = waterIndustryTDS.getText();
		String ss = waterIndustrySS.getText();
		String Do = waterIndustryDO.getText();
		String cod = waterIndustryCOD.getText();
		String salinity = waterIndustrySalinity.getText();
		String chloride = waterIndustryChloride.getText();
		String turbidity = waterIndustryTurbidity.getText();
		String totalhardness = waterIndustryTotalHardness.getText();
		String oilandgrease = waterIndustryOilandGrease.getText();
		String bod = waterIndustryBOD.getText();
		String industryLocation = "Not Included";
		String Remarks = waterIndustryRemarks.getText();

		waterIndustryDataConvertingType = waterIndustrydatacombobox.getValue();

		if (IndustryName != "Refresh" && IndustryName.length() > 1 && IndustryType.length() > 2
				&& waterIndustryDataConvertingType == "Add") {
			System.out.println("Ok");
			try {
				String query = "select * from waterindustryregistration where " + "industryname like " + "'"
						+ IndustryName + "' and industrytype like " + "'" + IndustryType + "'";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					String item = rSet.getString("industrylocation");
					industryLocation = item;
				}

				query = "INSERT INTO waterindustrydatainput (day, month, year, industryname, industrytype, watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, industrylocation, samplelocation)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, IndustryType);
				preparedStatement.setString(6, WaterType);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, Temp);
				preparedStatement.setString(9, ph);
				preparedStatement.setString(10, ec);
				preparedStatement.setString(11, ts);
				preparedStatement.setString(12, tds);
				preparedStatement.setString(13, ss);
				preparedStatement.setString(14, Do);
				preparedStatement.setString(15, cod);
				preparedStatement.setString(16, salinity);
				preparedStatement.setString(17, chloride);
				preparedStatement.setString(18, turbidity);
				preparedStatement.setString(19, totalhardness);
				preparedStatement.setString(20, oilandgrease);
				preparedStatement.setString(21, bod);
				preparedStatement.setString(22, Remarks);
				preparedStatement.setString(23, industryLocation);
				preparedStatement.setString(24, samplelocation);

				preparedStatement.execute();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterIndsutrySampleLocation.setValue(null);
					waterIndustryTemperature.setText(null);
					waterIndustryPh.setText(null);
					waterIndustryEC.setText(null);
					waterIndustryTS.setText(null);
					waterIndustryTDS.setText(null);
					waterIndustrySS.setText(null);
					waterIndustryDO.setText(null);
					waterIndustryCOD.setText(null);

					waterIndustrySalinity.setText(null);
					waterIndustryChloride.setText(null);
					waterIndustryTurbidity.setText(null);
					waterIndustryTotalHardness.setText(null);
					waterIndustryOilandGrease.setText(null);
					waterIndustryBOD.setText(null);
					waterIndustryRemarks.setText(null);
				} else {
					waterIndustryDay.setValue(null);
					waterIndustryMonth.setValue(null);
					waterIndustryYear.setValue(null);
					waterIndustryType.setValue(null);
					waterIndustryLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterIndustryType.setValue(null);
					waterIndsutrySampleLocation.setValue(null);
					waterIndustryTemperature.setText(null);
					waterIndustryPh.setText(null);
					waterIndustryEC.setText(null);
					waterIndustryTS.setText(null);
					waterIndustryTDS.setText(null);
					waterIndustrySS.setText(null);
					waterIndustryDO.setText(null);
					waterIndustryCOD.setText(null);

					waterIndustrySalinity.setText(null);
					waterIndustryChloride.setText(null);
					waterIndustryTurbidity.setText(null);
					waterIndustryTotalHardness.setText(null);
					waterIndustryOilandGrease.setText(null);
					waterIndustryBOD.setText(null);
					waterIndustryRemarks.setText(null);

				}

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && IndustryType.length() > 2
				&& waterIndustryDataConvertingType == "Edit") {
			System.out.println("Ok");
			try {
				String id = waterIndustryserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Update waterindustrydatainput set day=?,month=?,year=?,industryname=?,industrytype=?,watertype=?,labcode=?,temperature=?,ph=?,ec=?,ts=?,tds=?,ss=?,do=?,cod=?,salinity=?,chloride=?,turbidity=?,totalhardness=?,oilandgrease=?,bod=?,remarks=?, samplelocation=? where id like "
						+ "'" + id + "'";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, IndustryType);
				preparedStatement.setString(6, WaterType);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, Temp);
				preparedStatement.setString(9, ph);
				preparedStatement.setString(10, ec);
				preparedStatement.setString(11, ts);

				preparedStatement.setString(12, tds);
				preparedStatement.setString(13, ss);
				preparedStatement.setString(14, Do);
				preparedStatement.setString(15, cod);
				preparedStatement.setString(16, salinity);

				preparedStatement.setString(17, chloride);
				preparedStatement.setString(18, turbidity);
				preparedStatement.setString(19, totalhardness);
				preparedStatement.setString(20, oilandgrease);
				preparedStatement.setString(21, bod);
				preparedStatement.setString(22, Remarks);
				preparedStatement.setString(23, samplelocation);
				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterIndustryDay.setValue(null);
					waterIndustryMonth.setValue(null);
					waterIndustryYear.setValue(null);
					waterIndustryType.setValue(null);
					waterIndustryLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterIndustryType.setValue(null);
					waterIndsutrySampleLocation.setValue(null);
					waterIndustryTemperature.setText(null);
					waterIndustryPh.setText(null);
					waterIndustryEC.setText(null);
					waterIndustryTS.setText(null);
					waterIndustryTDS.setText(null);
					waterIndustrySS.setText(null);
					waterIndustryDO.setText(null);
					waterIndustryCOD.setText(null);

					waterIndustrySalinity.setText(null);
					waterIndustryChloride.setText(null);
					waterIndustryTurbidity.setText(null);
					waterIndustryTotalHardness.setText(null);
					waterIndustryOilandGrease.setText(null);
					waterIndustryBOD.setText(null);
					waterIndustryRemarks.setText(null);
				} else {
					waterIndustryDay.setValue(null);
					waterIndustryMonth.setValue(null);
					waterIndustryYear.setValue(null);
					waterIndustryType.setValue(null);
					waterIndustryLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterIndustryType.setValue(null);
					waterIndsutrySampleLocation.setValue(null);
					waterIndustryTemperature.setText(null);
					waterIndustryPh.setText(null);
					waterIndustryEC.setText(null);
					waterIndustryTS.setText(null);
					waterIndustryTDS.setText(null);
					waterIndustrySS.setText(null);
					waterIndustryDO.setText(null);
					waterIndustryCOD.setText(null);

					waterIndustrySalinity.setText(null);
					waterIndustryChloride.setText(null);
					waterIndustryTurbidity.setText(null);
					waterIndustryTotalHardness.setText(null);
					waterIndustryOilandGrease.setText(null);
					waterIndustryBOD.setText(null);
					waterIndustryRemarks.setText(null);

				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && IndustryType.length() > 2
				&& waterIndustryDataConvertingType == "Delete") {
			System.out.println("Ok");
			try {
				String id = waterIndustryserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Delete from waterindustrydatainput where id = " + "'" + id + "'";
				stat.executeUpdate(sql);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				waterIndustryDay.setValue(null);
				waterIndustryMonth.setValue(null);
				waterIndustryYear.setValue(null);
				waterIndustryType.setValue(null);
				waterIndustryLabCode.setText(null);
				waterIndsutryWaterType.setValue(null);
				waterIndustryType.setValue(null);
				waterIndsutrySampleLocation.setValue(null);
				waterIndustryTemperature.setText(null);
				waterIndustryPh.setText(null);
				waterIndustryEC.setText(null);
				waterIndustryTS.setText(null);
				waterIndustryTDS.setText(null);
				waterIndustrySS.setText(null);
				waterIndustryDO.setText(null);
				waterIndustryCOD.setText(null);

				waterIndustrySalinity.setText(null);
				waterIndustryChloride.setText(null);
				waterIndustryTurbidity.setText(null);
				waterIndustryTotalHardness.setText(null);
				waterIndustryOilandGrease.setText(null);
				waterIndustryBOD.setText(null);
				waterIndustryRemarks.setText(null);

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
	}

	// Water -> Monitoring -> River( Automatic Location set up for corresponding
	// River Name )
	public void actionWaterMonitoringRiverNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from watermonitoringregistration where type like 'River'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (rivernameFulldata.contains(item)) {
				} else {
					rivernameFulldata += item;
					waterRiverMonitoringRiverNameList.add(item);
					waterRiverMonitoringRiverName.setItems(waterRiverMonitoringRiverNameList);
				}
			}
			waterRiverMonitoringLocation.setText(null);
			query = "select * from watermonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("location");
				waterRiverMonitoringLocation.setText(item);
			}

			String dataconvertingtype = waterRiverMonitoringdatacombobox.getValue();
			if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
				waterRiverMonitoringdatainputidlist.clear();
				query = "select id from watermonitoringriverdatainput where " + "rivername like " + "'" + value + "'"
						+ " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					String item2 = "" + item;
					waterRiverMonitoringdatainputidlist.add(item2);
					waterRiverMonitoringserialcombobox.setItems(waterRiverMonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> River (Loading River Name in Initialize)
	public void actionWaterMonitoringRiverNameCombobox() {
		try {
			String query = "select * from watermonitoringregistration where type like 'River'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (rivernameFulldata.contains(item)) {
				} else {
					rivernameFulldata += item;
					waterRiverMonitoringRiverNameList.add(item);
					waterRiverMonitoringRiverName.setItems(waterRiverMonitoringRiverNameList);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Sea( Automatic Location set up for corresponding
	// Sea Name )
	public void actionWaterMonitoringSeaNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from watermonitoringregistration where type like 'Sea'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (seanameFulldata.contains(item)) {
				} else {
					seanameFulldata += item;
					waterSeaMonitoringSeaNameList.add(item);
					waterSeaMonitoringSeaName.setItems(waterSeaMonitoringSeaNameList);
				}
			}
			waterSeaMonitoringSeaLocation.setText(null);
			query = "select * from watermonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("location");
				waterSeaMonitoringSeaLocation.setText(item);
			}

			String dataconvertingtype = waterSeaMonitoringdatacombobox.getValue();
			if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
				waterSeaMonitoringdatainputidlist.clear();
				query = "select id from watermonitoringseadatainput where " + "seaname like " + "'" + value + "'"
						+ " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					String item2 = "" + item;
					waterSeaMonitoringdatainputidlist.add(item2);
					waterSeaMonitoringserialcombobox.setItems(waterSeaMonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Sea (Loading Sea Name in Initialize)
	public void actionWaterMonitoringSeaNameCombobox() {
		try {
			String query = "select * from watermonitoringregistration where type like 'Sea'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (seanameFulldata.contains(item)) {
				} else {
					seanameFulldata += item;
					waterSeaMonitoringSeaNameList.add(item);
					waterSeaMonitoringSeaName.setItems(waterSeaMonitoringSeaNameList);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Pond( Automatic Location set up for corresponding
	// pond Name )
	public void actionWaterMonitoringPondNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from watermonitoringregistration where type like 'Pond'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (pondnameFulldata.contains(item)) {
				} else {
					pondnameFulldata += item;
					waterPondMonitoringPondNameList.add(item);
					waterPondMonitoringPondName.setItems(waterPondMonitoringPondNameList);
				}
			}
			waterPondMonitoringPondLocation.setText(null);
			query = "select * from watermonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("location");
				waterPondMonitoringPondLocation.setText(item);
			}

			String dataconvertingtype = waterPondMonitoringdatacombobox.getValue();
			if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
				waterPondMonitoringdatainputidlist.clear();
				query = "select id from watermonitoringponddatainput where " + "pondname like " + "'" + value + "'"
						+ " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					String item2 = "" + item;
					waterPondMonitoringdatainputidlist.add(item2);
					waterPondMonitoringserialcombobox.setItems(waterPondMonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Pond (Loading Pond Name in Initialize)
	public void actionWaterMonitoringPondNameCombobox() {
		try {
			String query = "select * from watermonitoringregistration where type like 'Pond'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (pondnameFulldata.contains(item)) {
				} else {
					pondnameFulldata += item;
					waterPondMonitoringPondNameList.add(item);
					waterPondMonitoringPondName.setItems(waterPondMonitoringPondNameList);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Deep Tubewell( Automatic Location set up for
	// corresponding Deep Tubewell Name )
	public void actionWaterMonitoringdeeptubewellNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from watermonitoringregistration where type like 'Deep Tubewell'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (deeptubewellnameFulldata.contains(item)) {
				} else {
					deeptubewellnameFulldata += item;
					waterdeeptubewellMonitoringDeepNameList.add(item);
					waterdeeptubewellMonitoringTubleName.setItems(waterdeeptubewellMonitoringDeepNameList);
				}
			}
			waterdeeptubewellMonitoringLocation.setText(null);
			query = "select * from watermonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("location");
				waterdeeptubewellMonitoringLocation.setText(item);
			}

			String dataconvertingtype = waterdeeptubewellMonitoringdatacombobox.getValue();
			if (dataconvertingtype == "Edit" || dataconvertingtype == "Delete") {
				waterdeeptubewellMonitoringdatainputidlist.clear();
				query = "select id from watermonitoringdeeptubledatainput where " + "deeptubewellname like " + "'" + value
						+ "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					String item2 = "" + item;
					waterdeeptubewellMonitoringdatainputidlist.add(item2);
					waterdeeptubewellMonitoringserialcombobox.setItems(waterdeeptubewellMonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> Deep Tubewell (Loading Deep Tubewell Name in Initialize)
	public void actionWaterMonitoringdeeptubewellNameCombobox() {
		try {
			String query = "select * from watermonitoringregistration where type like 'Deep Tubewell'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (deeptubewellnameFulldata.contains(item)) {
				} else {
					deeptubewellnameFulldata += item;
					waterdeeptubewellMonitoringDeepNameList.add(item);
					waterdeeptubewellMonitoringTubleName.setItems(waterdeeptubewellMonitoringDeepNameList);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Water -> Monitoring -> River's Data Input
	@FXML
	public void actionrivermonitoringsavebutton(ActionEvent event) {
		boolean checkbox = waterrivermonitoringcheckbox.isSelected();

		String day = waterRiverMonitoringDay.getValue();
		String Month = waterRiverMonitoringMonth.getValue();
		String Year = waterRiverMonitoringYear.getValue();
		String RiverName = waterRiverMonitoringRiverName.getValue();
		String RiverWaterType = waterRiverMonitoringRiverWaterType.getValue();
		String Labcode = waterRiverMonitoringLabCode.getText();
		String Location = waterRiverMonitoringLocation.getText();
		String Temp = waterRiverMonitoringTemperature.getText();
		String ph = waterRiverMonitoringPH.getText();
		String ec = waterRiverMonitoringEC.getText();
		String ts = waterRiverMonitoringTS.getText();
		String tds = waterRiverMonitoringTDS.getText();
		String ss = waterRiverMonitoringSS.getText();
		String Do = waterRiverMonitoringDO.getText();
		String cod = waterRiverMonitoringCOD.getText();
		String salinity = waterRiverMonitoringSalinity.getText();
		String chloride = waterRiverMonitoringChloride.getText();
		String turbidity = waterRiverMonitoringNTU.getText();
		String totalhardness = waterRiverMonitoringTotalHardness.getText();
		String oilandgrease = waterRiverMonitoringOilandGrease.getText();
		String bod = waterRiverMonitoringBOD.getText();

		waterRiverMonitoringDataConvertingType = waterRiverMonitoringdatacombobox.getValue();
		if (RiverName != "Refresh" && RiverName.length() > 1 && waterRiverMonitoringDataConvertingType == "Add") {
			System.out.println("Ok");
			try {

				String query = "INSERT INTO watermonitoringriverdatainput (day, month, year, rivername, riverwatertype, riverlocation, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, RiverName);
				preparedStatement.setString(5, RiverWaterType);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, Temp);
				preparedStatement.setString(9, ph);
				preparedStatement.setString(10, ec);
				preparedStatement.setString(11, ts);
				preparedStatement.setString(12, tds);
				preparedStatement.setString(13, ss);
				preparedStatement.setString(14, Do);
				preparedStatement.setString(15, cod);
				preparedStatement.setString(16, salinity);
				preparedStatement.setString(17, chloride);
				preparedStatement.setString(18, turbidity);
				preparedStatement.setString(19, totalhardness);
				preparedStatement.setString(20, oilandgrease);
				preparedStatement.setString(21, bod);

				preparedStatement.execute();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();

				// Clearing data
				if (checkbox) {
					waterRiverMonitoringTemperature.setText(null);
					waterRiverMonitoringPH.setText(null);
					waterRiverMonitoringEC.setText(null);
					waterRiverMonitoringTS.setText(null);
					waterRiverMonitoringTDS.setText(null);
					waterRiverMonitoringSS.setText(null);
					waterRiverMonitoringDO.setText(null);
					waterRiverMonitoringCOD.setText(null);

					waterRiverMonitoringSalinity.setText(null);
					waterRiverMonitoringChloride.setText(null);
					waterRiverMonitoringNTU.setText(null);
					waterRiverMonitoringTotalHardness.setText(null);
					waterRiverMonitoringOilandGrease.setText(null);
					waterRiverMonitoringBOD.setText(null);
				} else {
					waterRiverMonitoringDay.setValue(null);
					waterRiverMonitoringMonth.setValue(null);
					waterRiverMonitoringYear.setValue(null);
					waterRiverMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterRiverMonitoringLocation.setText(null);
					waterRiverMonitoringTemperature.setText(null);
					waterRiverMonitoringPH.setText(null);
					waterRiverMonitoringEC.setText(null);
					waterRiverMonitoringTS.setText(null);
					waterRiverMonitoringTDS.setText(null);
					waterRiverMonitoringSS.setText(null);
					waterRiverMonitoringDO.setText(null);
					waterRiverMonitoringCOD.setText(null);

					waterRiverMonitoringSalinity.setText(null);
					waterRiverMonitoringChloride.setText(null);
					waterRiverMonitoringNTU.setText(null);
					waterRiverMonitoringTotalHardness.setText(null);
					waterRiverMonitoringOilandGrease.setText(null);
					waterRiverMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (RiverName != "Refresh" && RiverName.length() > 1 && waterRiverMonitoringDataConvertingType == "Edit") {
			System.out.println("Ok");
			try {
				String id = waterRiverMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);
				// (day, month, year, industryname, industrytype, watertype,
				// labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity,
				// chloride, turbidity, totalhardness, oilandgrease, bod,
				// remarks, industrylocation
				String sql = "Update watermonitoringriverdatainput set day=?,month=?,year=?,rivername=?,riverlocation=?,riverwatertype=?,labcode=?,temperature=?,ph=?,ec=?,ts=?,tds=?,ss=?,do=?,cod=?,salinity=?,chloride=?,turbidity=?,totalhardness=?,oilandgrease=?,bod=? where id like "
						+ "'" + id + "'";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, RiverName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, RiverWaterType);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, Temp);
				preparedStatement.setString(9, ph);
				preparedStatement.setString(10, ec);
				preparedStatement.setString(11, ts);

				preparedStatement.setString(12, tds);
				preparedStatement.setString(13, ss);
				preparedStatement.setString(14, Do);
				preparedStatement.setString(15, cod);
				preparedStatement.setString(16, salinity);

				preparedStatement.setString(17, chloride);
				preparedStatement.setString(18, turbidity);
				preparedStatement.setString(19, totalhardness);
				preparedStatement.setString(20, oilandgrease);
				preparedStatement.setString(21, bod);
				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterRiverMonitoringDay.setValue(null);
					waterRiverMonitoringMonth.setValue(null);
					waterRiverMonitoringYear.setValue(null);
					waterRiverMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterRiverMonitoringLocation.setText(null);
					waterRiverMonitoringTemperature.setText(null);
					waterRiverMonitoringPH.setText(null);
					waterRiverMonitoringEC.setText(null);
					waterRiverMonitoringTS.setText(null);
					waterRiverMonitoringTDS.setText(null);
					waterRiverMonitoringSS.setText(null);
					waterRiverMonitoringDO.setText(null);
					waterRiverMonitoringCOD.setText(null);

					waterRiverMonitoringSalinity.setText(null);
					waterRiverMonitoringChloride.setText(null);
					waterRiverMonitoringNTU.setText(null);
					waterRiverMonitoringTotalHardness.setText(null);
					waterRiverMonitoringOilandGrease.setText(null);
					waterRiverMonitoringBOD.setText(null);
				} else {
					waterRiverMonitoringDay.setValue(null);
					waterRiverMonitoringMonth.setValue(null);
					waterRiverMonitoringYear.setValue(null);
					waterRiverMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterRiverMonitoringLocation.setText(null);
					waterRiverMonitoringTemperature.setText(null);
					waterRiverMonitoringPH.setText(null);
					waterRiverMonitoringEC.setText(null);
					waterRiverMonitoringTS.setText(null);
					waterRiverMonitoringTDS.setText(null);
					waterRiverMonitoringSS.setText(null);
					waterRiverMonitoringDO.setText(null);
					waterRiverMonitoringCOD.setText(null);

					waterRiverMonitoringSalinity.setText(null);
					waterRiverMonitoringChloride.setText(null);
					waterRiverMonitoringNTU.setText(null);
					waterRiverMonitoringTotalHardness.setText(null);
					waterRiverMonitoringOilandGrease.setText(null);
					waterRiverMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (RiverName != "Refresh" && RiverName.length() > 1
				&& waterRiverMonitoringDataConvertingType == "Delete") {
			System.out.println("Ok");
			try {
				String id = waterRiverMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Delete from watermonitoringriverdatainput where id = " + "'" + id + "'";
				stat.executeUpdate(sql);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				waterRiverMonitoringDay.setValue(null);
				waterRiverMonitoringMonth.setValue(null);
				waterRiverMonitoringYear.setValue(null);
				waterRiverMonitoringLabCode.setText(null);
				waterIndsutryWaterType.setValue(null);
				waterRiverMonitoringLocation.setText(null);
				waterRiverMonitoringTemperature.setText(null);
				waterRiverMonitoringPH.setText(null);
				waterRiverMonitoringEC.setText(null);
				waterRiverMonitoringTS.setText(null);
				waterRiverMonitoringTDS.setText(null);
				waterRiverMonitoringSS.setText(null);
				waterRiverMonitoringDO.setText(null);
				waterRiverMonitoringCOD.setText(null);

				waterRiverMonitoringSalinity.setText(null);
				waterRiverMonitoringChloride.setText(null);
				waterRiverMonitoringNTU.setText(null);
				waterRiverMonitoringTotalHardness.setText(null);
				waterRiverMonitoringOilandGrease.setText(null);
				waterRiverMonitoringBOD.setText(null);

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
	}

	@FXML
	public void actionWaterMonitoringdeeptubewellSaveButton(ActionEvent event) {
		boolean checkbox = waterdeeptubewellmonitoringcheckbox.isSelected();

		String day = waterdeeptubewellMonitoringDay.getValue();
		String Month = waterdeeptubewellMonitoringMonth.getValue();
		String Year = waterdeeptubewellMonitoringYear.getValue();
		String deeptubewellName = waterdeeptubewellMonitoringTubleName.getValue();
		String Labcode = waterdeeptubewellMonitoringLabCode.getText();
		String Location = waterdeeptubewellMonitoringLocation.getText();
		String Temp = waterdeeptubewellMonitoringTemperature.getText();
		String ph = waterdeeptubewellMonitoringPH.getText();
		String ec = waterdeeptubewellMonitoringEC.getText();
		String ts = waterdeeptubewellMonitoringTS.getText();
		String tds = waterdeeptubewellMonitoringTDS.getText();
		String ss = waterdeeptubewellMonitoringSS.getText();
		String Do = waterdeeptubewellMonitoringDO.getText();
		String cod = waterdeeptubewellMonitoringCOD.getText();
		String salinity = waterdeeptubewellMonitoringSalinity.getText();
		String chloride = waterdeeptubewellMonitoringChloride.getText();
		String turbidity = waterdeeptubewellMonitoringNTU.getText();
		String totalhardness = waterdeeptubewellMonitoringTotalHardrness.getText();
		String oilandgrease = waterdeeptubewellMonitoringOilandGrease.getText();
		String bod = waterdeeptubewellMonitoringBOD.getText();

		waterdeeptubewellMonitoringDataConvertingType = waterdeeptubewellMonitoringdatacombobox.getValue();
		if (deeptubewellName != "Refresh" && deeptubewellName.length() > 1
				&& waterdeeptubewellMonitoringDataConvertingType == "Add") {
			System.out.println("Ok");
			try {

				String query = "INSERT INTO watermonitoringdeeptubledatainput (day, month, year, deeptubewellname, deeptubewelllocation, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, deeptubewellName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);
				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);
				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);

				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				if (checkbox) {
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				} else {
					waterdeeptubewellMonitoringDay.setValue(null);
					waterdeeptubewellMonitoringMonth.setValue(null);
					waterdeeptubewellMonitoringYear.setValue(null);
					waterdeeptubewellMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (deeptubewellName != "Refresh" && deeptubewellName.length() > 1
				&& waterdeeptubewellMonitoringDataConvertingType == "Edit") {
			System.out.println("Ok");
			try {
				String id = waterdeeptubewellMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);
				String sql = "Update watermonitoringdeeptubledatainput set day=?,month=?,year=?,deeptubewellname=?,deeptubewelllocation=?,labcode=?,temperature=?,ph=?,ec=?,ts=?,tds=?,ss=?,do=?,cod=?,salinity=?,chloride=?,turbidity=?,totalhardness=?,oilandgrease=?,bod=? where id like "
						+ "'" + id + "'";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, deeptubewellName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);

				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);

				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);
				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterdeeptubewellMonitoringDay.setValue(null);
					waterdeeptubewellMonitoringMonth.setValue(null);
					waterdeeptubewellMonitoringYear.setValue(null);
					waterdeeptubewellMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				} else {
					waterdeeptubewellMonitoringDay.setValue(null);
					waterdeeptubewellMonitoringMonth.setValue(null);
					waterdeeptubewellMonitoringYear.setValue(null);
					waterdeeptubewellMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (deeptubewellName != "Refresh" && deeptubewellName.length() > 1
				&& waterdeeptubewellMonitoringDataConvertingType == "Delete") {
			System.out.println("Ok");
			try {
				String id = waterdeeptubewellMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Delete from watermonitoringdeeptubledatainput where id = " + "'" + id + "'";
				stat.executeUpdate(sql);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();

				// Clearing all items after data Deleting

				if (checkbox) {
					waterdeeptubewellMonitoringDay.setValue(null);
					waterdeeptubewellMonitoringMonth.setValue(null);
					waterdeeptubewellMonitoringYear.setValue(null);
					waterdeeptubewellMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				} else {
					waterdeeptubewellMonitoringDay.setValue(null);
					waterdeeptubewellMonitoringMonth.setValue(null);
					waterdeeptubewellMonitoringYear.setValue(null);
					waterdeeptubewellMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterdeeptubewellMonitoringTemperature.setText(null);
					waterdeeptubewellMonitoringPH.setText(null);
					waterdeeptubewellMonitoringEC.setText(null);
					waterdeeptubewellMonitoringTS.setText(null);
					waterdeeptubewellMonitoringTDS.setText(null);
					waterdeeptubewellMonitoringSS.setText(null);
					waterdeeptubewellMonitoringDO.setText(null);
					waterdeeptubewellMonitoringCOD.setText(null);

					waterdeeptubewellMonitoringSalinity.setText(null);
					waterdeeptubewellMonitoringChloride.setText(null);
					waterdeeptubewellMonitoringNTU.setText(null);
					waterdeeptubewellMonitoringTotalHardrness.setText(null);
					waterdeeptubewellMonitoringOilandGrease.setText(null);
					waterdeeptubewellMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}

	}

	@FXML
	public void actionWaterMonitoringPondSaveButton(ActionEvent event) {
		boolean checkbox = waterpondmonitoringcheckbox.isSelected();

		String day = waterPondMonitoringDay.getValue();
		String Month = waterPondMonitoringMonth.getValue();
		String Year = waterPondMonitoringYear.getValue();
		String PondName = waterPondMonitoringPondName.getValue();
		String Labcode = waterPondMonitoringLabCode.getText();
		String Location = waterPondMonitoringPondLocation.getText();
		String Temp = waterPondMonitoringTemperature.getText();
		String ph = waterPondMonitoringPH.getText();
		String ec = waterPondMonitoringEC.getText();
		String ts = waterPondMonitoringTS.getText();
		String tds = waterPondMonitoringTDS.getText();
		String ss = waterPondMonitoringSS.getText();
		String Do = waterPondMonitoringDO.getText();
		String cod = waterPondMonitoringCOD.getText();
		String salinity = waterPondMonitoringSalinity.getText();
		String chloride = waterPondMonitoringChloride.getText();
		String turbidity = waterPondMonitoringNTU.getText();
		String totalhardness = waterPondMonitoringTotalHardness.getText();
		String oilandgrease = waterPondMonitoringOilandGrease.getText();
		String bod = waterPondMonitoringBOD.getText();

		waterPondMonitoringDataConvertingType = waterPondMonitoringdatacombobox.getValue();
		if (PondName != "Refresh" && PondName.length() > 1 && waterPondMonitoringDataConvertingType == "Add") {
			System.out.println("Ok");
			try {

				String query = "INSERT INTO watermonitoringponddatainput (day, month, year, pondname, pondlocation, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, PondName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);
				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);
				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);

				preparedStatement.execute();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				} else {
					waterPondMonitoringDay.setValue(null);
					waterPondMonitoringMonth.setValue(null);
					waterPondMonitoringYear.setValue(null);
					waterPondMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (PondName != "Refresh" && PondName.length() > 1 && waterPondMonitoringDataConvertingType == "Edit") {
			System.out.println("Ok");
			try {
				String id = waterPondMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Update watermonitoringponddatainput set day=?,month=?,year=?,pondname=?,pondlocation=?,labcode=?,temperature=?,ph=?,ec=?,ts=?,tds=?,ss=?,do=?,cod=?,salinity=?,chloride=?,turbidity=?,totalhardness=?,oilandgrease=?,bod=? where id like "
						+ "'" + id + "'";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, PondName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);

				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);

				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);
				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				if (checkbox) {
					waterPondMonitoringDay.setValue(null);
					waterPondMonitoringMonth.setValue(null);
					waterPondMonitoringYear.setValue(null);
					waterPondMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				} else {
					waterPondMonitoringDay.setValue(null);
					waterPondMonitoringMonth.setValue(null);
					waterPondMonitoringYear.setValue(null);
					waterPondMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (PondName != "Refresh" && PondName.length() > 1 && waterPondMonitoringDataConvertingType == "Delete") {
			System.out.println("Ok");
			try {
				String id = waterPondMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Delete from watermonitoringponddatainput where id = " + "'" + id + "'";
				stat.executeUpdate(sql);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				if (checkbox) {
					waterPondMonitoringDay.setValue(null);
					waterPondMonitoringMonth.setValue(null);
					waterPondMonitoringYear.setValue(null);
					waterPondMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				} else {
					waterPondMonitoringDay.setValue(null);
					waterPondMonitoringMonth.setValue(null);
					waterPondMonitoringYear.setValue(null);
					waterPondMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterPondMonitoringTemperature.setText(null);
					waterPondMonitoringPH.setText(null);
					waterPondMonitoringEC.setText(null);
					waterPondMonitoringTS.setText(null);
					waterPondMonitoringTDS.setText(null);
					waterPondMonitoringSS.setText(null);
					waterPondMonitoringDO.setText(null);
					waterPondMonitoringCOD.setText(null);

					waterPondMonitoringSalinity.setText(null);
					waterPondMonitoringChloride.setText(null);
					waterPondMonitoringNTU.setText(null);
					waterPondMonitoringTotalHardness.setText(null);
					waterPondMonitoringOilandGrease.setText(null);
					waterPondMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
	}

	@FXML
	public void actionWaterMonitoringSeaSaveButton(ActionEvent event) {
		boolean checkbox = waterseamonitoringcheckbox.isSelected();

		String day = waterSeaMonitoringDay.getValue();
		String Month = waterSeaMonitoringMonth.getValue();
		String Year = waterSeaMonitoringYear.getValue();
		String SeaName = waterSeaMonitoringSeaName.getValue();
		String Labcode = waterSeaMonitoringLabCode.getText();
		String Location = waterSeaMonitoringSeaLocation.getText();
		String Temp = waterSeaMonitoringTemperature.getText();
		String ph = waterSeaMonitoringPH.getText();
		String ec = waterSeaMonitoringEC.getText();
		String ts = waterSeaMonitoringTS.getText();
		String tds = waterSeaMonitoringTDS.getText();
		String ss = waterSeaMonitoringSS.getText();
		String Do = waterSeaMonitoringDO.getText();
		String cod = waterSeaMonitoringCOD.getText();
		String salinity = waterSeaMonitoringSalinity.getText();
		String chloride = waterSeaMonitoringChloride.getText();
		String turbidity = waterSeaMonitoringNTU.getText();
		String totalhardness = waterSeaMonitoringTotalHardness.getText();
		String oilandgrease = waterSeaMonitoringOilandGrease.getText();
		String bod = waterSeaMonitoringBOD.getText();

		waterSeaMonitoringDataConvertingType = waterSeaMonitoringdatacombobox.getValue();

		if (SeaName != "Refresh" && SeaName.length() > 1 && waterSeaMonitoringDataConvertingType == "Add") {
			System.out.println("Ok");
			try {

				String query = "INSERT INTO watermonitoringseadatainput (day, month, year, seaname, sealocation, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, SeaName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);
				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);
				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);

				preparedStatement.execute();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				if (checkbox) {
					waterSeaMonitoringTemperature.setText(null);
					waterSeaMonitoringPH.setText(null);
					waterSeaMonitoringEC.setText(null);
					waterSeaMonitoringTS.setText(null);
					waterSeaMonitoringTDS.setText(null);
					waterSeaMonitoringSS.setText(null);
					waterSeaMonitoringDO.setText(null);
					waterSeaMonitoringCOD.setText(null);

					waterSeaMonitoringSalinity.setText(null);
					waterSeaMonitoringChloride.setText(null);
					waterSeaMonitoringNTU.setText(null);
					waterSeaMonitoringTotalHardness.setText(null);
					waterSeaMonitoringOilandGrease.setText(null);
					waterSeaMonitoringBOD.setText(null);
				} else {
					waterSeaMonitoringDay.setValue(null);
					waterSeaMonitoringMonth.setValue(null);
					waterSeaMonitoringYear.setValue(null);
					waterSeaMonitoringLabCode.setText(null);
					waterIndsutryWaterType.setValue(null);
					waterSeaMonitoringTemperature.setText(null);
					waterSeaMonitoringPH.setText(null);
					waterSeaMonitoringEC.setText(null);
					waterSeaMonitoringTS.setText(null);
					waterSeaMonitoringTDS.setText(null);
					waterSeaMonitoringSS.setText(null);
					waterSeaMonitoringDO.setText(null);
					waterSeaMonitoringCOD.setText(null);

					waterSeaMonitoringSalinity.setText(null);
					waterSeaMonitoringChloride.setText(null);
					waterSeaMonitoringNTU.setText(null);
					waterSeaMonitoringTotalHardness.setText(null);
					waterSeaMonitoringOilandGrease.setText(null);
					waterSeaMonitoringBOD.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (SeaName != "Refresh" && SeaName.length() > 1 && waterSeaMonitoringDataConvertingType == "Edit") {
			System.out.println("Ok");
			try {
				String id = waterSeaMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);
				// (day, month, year, industryname, industrytype, watertype,
				// labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity,
				// chloride, turbidity, totalhardness, oilandgrease, bod,
				// remarks, industrylocation
				String sql = "Update watermonitoringseadatainput set day=?,month=?,year=?,seaname=?,sealocation=?,labcode=?,temperature=?,ph=?,ec=?,ts=?,tds=?,ss=?,do=?,cod=?,salinity=?,chloride=?,turbidity=?,totalhardness=?,oilandgrease=?,bod=? where id like "
						+ "'" + id + "'";

				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, SeaName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Temp);
				preparedStatement.setString(8, ph);
				preparedStatement.setString(9, ec);
				preparedStatement.setString(10, ts);

				preparedStatement.setString(11, tds);
				preparedStatement.setString(12, ss);
				preparedStatement.setString(13, Do);
				preparedStatement.setString(14, cod);
				preparedStatement.setString(15, salinity);

				preparedStatement.setString(16, chloride);
				preparedStatement.setString(17, turbidity);
				preparedStatement.setString(18, totalhardness);
				preparedStatement.setString(19, oilandgrease);
				preparedStatement.setString(20, bod);
				preparedStatement.execute();

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();

				// Clearing all items after data Editiing
				waterSeaMonitoringDay.setValue(null);
				waterSeaMonitoringMonth.setValue(null);
				waterSeaMonitoringYear.setValue(null);
				waterSeaMonitoringLabCode.setText(null);
				waterIndsutryWaterType.setValue(null);
				waterSeaMonitoringTemperature.setText(null);
				waterSeaMonitoringPH.setText(null);
				waterSeaMonitoringEC.setText(null);
				waterSeaMonitoringTS.setText(null);
				waterSeaMonitoringTDS.setText(null);
				waterSeaMonitoringSS.setText(null);
				waterSeaMonitoringDO.setText(null);
				waterSeaMonitoringCOD.setText(null);

				waterSeaMonitoringSalinity.setText(null);
				waterSeaMonitoringChloride.setText(null);
				waterSeaMonitoringNTU.setText(null);
				waterSeaMonitoringTotalHardness.setText(null);
				waterSeaMonitoringOilandGrease.setText(null);
				waterSeaMonitoringBOD.setText(null);

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		else if (SeaName != "Refresh" && SeaName.length() > 1 && waterSeaMonitoringDataConvertingType == "Delete") {
			System.out.println("Ok");
			try {
				String id = waterSeaMonitoringserialcombobox.getValue();
				System.out.println("ID : " + id);

				String sql = "Delete from watermonitoringseadatainput where id = " + "'" + id + "'";
				stat.executeUpdate(sql);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();

				// Clearing all items after data Deleting
				waterSeaMonitoringDay.setValue(null);
				waterSeaMonitoringMonth.setValue(null);
				waterSeaMonitoringYear.setValue(null);
				waterSeaMonitoringLabCode.setText(null);
				waterIndsutryWaterType.setValue(null);
				waterSeaMonitoringTemperature.setText(null);
				waterSeaMonitoringPH.setText(null);
				waterSeaMonitoringEC.setText(null);
				waterSeaMonitoringTS.setText(null);
				waterSeaMonitoringTDS.setText(null);
				waterSeaMonitoringSS.setText(null);
				waterSeaMonitoringDO.setText(null);
				waterSeaMonitoringCOD.setText(null);

				waterSeaMonitoringSalinity.setText(null);
				waterSeaMonitoringChloride.setText(null);
				waterSeaMonitoringNTU.setText(null);
				waterSeaMonitoringTotalHardness.setText(null);
				waterSeaMonitoringOilandGrease.setText(null);
				waterSeaMonitoringBOD.setText(null);

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
	}

	public void actionWaterIndustryReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					waterindustrynamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	public void actionWaterMonitoringReportNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from watermonitoringregistration where type like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			monitoringreportnamelistforCorrespondingType.clear();
			monitoringreportnamelistforCorrespondingType.add("Refresh");
			monitoringreportnamelistforCorrespondingType.add("All Data");
			while (rSet.next()) {
				String item = rSet.getString("name");
				monitoringreportnamelistforCorrespondingType.add(item);
			}
			watermonitoringreportname.setItems(monitoringreportnamelistforCorrespondingType);
		} catch (Exception e) {
		}
	}

	public void actionWaterIndustryReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from waterindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					waterindustrynamelistforreport.add(item);
					waterindustryreportindustryname.setItems(waterindustrynamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}

	// Report of Water -> Industry
	@FXML
	public void actionWaterIndustryReportGenerate(ActionEvent event) throws JRException, IOException, SQLException {
		boolean reportPrintingForOrganization = ReportPrintingForOrganizationChecker.isSelected();

		String industryquery;
		String datefrom = waterindustryreportdatefrom.getValue();
		String monthfrom = waterindustryreportmonthfrom.getValue();
		String yearfrom = waterindustryreportyearfrom.getValue();
		String dateto = waterindustryreportdateto.getValue();
		String monthto = waterindustryreportmonthto.getValue();
		String yearto = waterindustryreportyearto.getValue();
		String IndustryName = waterindustryreportindustryname.getValue();
		if (IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null
				&& monthto == null && yearto == null) {

			String deleteQuery = "delete from waterindustryreport";
			stat.execute(deleteQuery);

			String allDataQuery = "select * from waterindustrydatainput";
			rSet = stat.executeQuery(allDataQuery);

			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("industryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("industrylocation");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("industrytype");
				String watertype = rSet.getString("watertype");
				String temperature = rSet.getString("temperature");
				String ph = rSet.getString("ph");
				String ec = rSet.getString("ec");
				String ts = rSet.getString("ts");
				String tds = rSet.getString("tds");
				String ss = rSet.getString("ss");
				String Do = rSet.getString("do");
				String cod = rSet.getString("cod");

				String salinity = rSet.getString("salinity");
				String chloride = rSet.getString("chloride");
				String turbidity = rSet.getString("turbidity");
				String totalhardness = rSet.getString("totalhardness");
				String oilandgrease = rSet.getString("oilandgrease");
				String bod = rSet.getString("bod");
				String industrylocation = rSet.getString("industrylocation");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				
				if(labcode == null || labcode == "")
					labcode = "-";
				if(samplelocation == null || samplelocation == "")
					samplelocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(watertype == null || watertype == "")
					watertype = "-";
				if(ph == null || ph == "")
					ph = "-";
				if(ec == null || ec == "")
					ec = "-";
				if(ts == null || ts == "")
					ts = "-";
				if(tds == null || tds == "")
					tds = "-";
				if(ss == null || ss == "")
					ss = "-";
				if(Do == null || Do == "")
					Do = "-";
				if(cod == null || cod == "")
					cod = "-";
				if(salinity == null || salinity == "")
					salinity = "-";
				if(chloride == null || chloride == "")
					chloride = "-";
				if(turbidity == null || turbidity == "")
					turbidity = "-";
				if(totalhardness == null || totalhardness == "")
					totalhardness = "-";
				if(oilandgrease == null || oilandgrease == "")
					oilandgrease = "-";
				if(bod == null || bod == "")
					bod = "-";
				if(remarks == null || remarks == "" || remarks == " ")
					remarks = "-";

				
				// //Adding into database
				String insertquery = "INSERT INTO waterindustryreport (date, industryname, industrytype, watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, industrylocation, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, watertype);
				preparedStatement.setString(5, labcode);
				preparedStatement.setString(6, temperature);
				preparedStatement.setString(7, ph);
				preparedStatement.setString(8, ec);
				preparedStatement.setString(9, ts);
				preparedStatement.setString(10, tds);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, Do);
				preparedStatement.setString(13, cod);
				preparedStatement.setString(14, salinity);
				preparedStatement.setString(15, chloride);
				preparedStatement.setString(16, turbidity);
				preparedStatement.setString(17, totalhardness);
				preparedStatement.setString(18, oilandgrease);
				preparedStatement.setString(19, bod);
				preparedStatement.setString(20, remarks);
				preparedStatement.setString(21, indsutrylocation);
				preparedStatement.setString(22, samplelocation);
				preparedStatement.setString(23, serial);

				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\waterindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
		} else if ((datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
				|| yearto == null) && IndustryName == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please Select All Time Options. Thank You!");
			alert.showAndWait();
		}
		// For Report Printing
		else if (IndustryName != "Refresh" && reportPrintingForOrganization == true) {
			int Datefrom = 0;
			int Monthfrom = 0;
			int Yearfrom = 0;
			try {
				Datefrom = Integer.parseInt(datefrom);
				Monthfrom = Integer.parseInt(monthfrom);
				Yearfrom = Integer.parseInt(yearfrom);
			} catch (Exception e) {

			}

			String deleteQuery = "delete from waterindustryindividualreport";
			stat.execute(deleteQuery);

			String idealtemperature = "itemp";
			String idealph = "iph";
			String idealec = "iec";
			String idealts = "its";
			String idealtds = "itds";
			String idealss = "iss";
			String idealDo = "ido";
			String idealcod = "icod";
			String idealsalinity = "isalinity";
			String idealchloride = "ichloride";
			String idealturbidity = "iturbiduty";
			String idealtotalhardness = "itotal";
			String idealoilandgrease = "ioil";
			String idealbod = "ibod";
			String sampledate = "manual date";
			String subject = "subject";
			String reference = "reference";
			String signaturetemplate = "signaturetemplate";
			String description = "description";
			String remarks = "remarks";

			String query = "select * from waterindustrystandarddatasave";

			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				sampledate = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				reference = rSet.getString("reference");
				signaturetemplate = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				idealtemperature = rSet.getString("idealtemperature");
				idealph = rSet.getString("idealph");
				idealec = rSet.getString("idealec");
				idealts = rSet.getString("idealts");
				idealtds = rSet.getString("idealtds");
				idealss = rSet.getString("idealss");
				idealDo = rSet.getString("idealdo");
				idealcod = rSet.getString("idealcod");
				idealsalinity = rSet.getString("idealsalinity");
				idealchloride = rSet.getString("idealchloride");
				idealturbidity = rSet.getString("idealturbidity");
				idealtotalhardness = rSet.getString("idealtotalhardness");
				idealoilandgrease = rSet.getString("idealoilandgrease");
				idealbod = rSet.getString("idealbod");
				remarks = rSet.getString("remarks");
			}
			subject = "Subject : "+ subject;
			reference = "Reference : "+ reference;
			sampledate = "Date : "+sampledate;
			remarks = "*Remarks : "+remarks;

			if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null) {
				industryquery = "select * from waterindustrydatainput where " + "industryname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			} else {
				industryquery = "select * from waterindustrydatainput where " + "year like " + "'" + Yearfrom
						+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
						+ "' and industryname like " + "'" + IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			}

			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("industryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("industrylocation");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("industrytype");
				String watertype = rSet.getString("watertype");
				String temperature = rSet.getString("temperature");
				String ph = rSet.getString("ph");
				String ec = rSet.getString("ec");
				String ts = rSet.getString("ts");
				String tds = rSet.getString("tds");
				String ss = rSet.getString("ss");
				String Do = rSet.getString("do");
				String cod = rSet.getString("cod");

				String salinity = rSet.getString("salinity");
				String chloride = rSet.getString("chloride");
				String turbidity = rSet.getString("turbidity");
				String totalhardness = rSet.getString("totalhardness");
				String oilandgrease = rSet.getString("oilandgrease");
				String bod = rSet.getString("bod");
				String industrylocation = rSet.getString("industrylocation");
				String id = rSet.getString("id");

				String fulldate;
				if(industrylocation == null){
					industrylocation = "-";
				}
				if(samplelocation == null){
					samplelocation = "-";
				}
				indsutrylocation = " "+industrylocation;
				samplelocation = " "+ samplelocation;
				
				samplelocation = samplelocation.replaceAll("\n", " ");
				samplelocation = samplelocation.replaceAll("\r", " ");
				
				industrylocation = industrylocation.replaceAll("\n", " ");
				industrylocation = industrylocation.replaceAll("\r", " ");
				if (industrylocation.length() > 2) {
					indsutryname = "Name and Address of Applicant/Organization : "+IndustryName + " ( " + industrylocation + " ).";
				}
				else{
					indsutryname = "Name and Address of Applicant/Organization : "+IndustryName;
				}
				

				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}

				if(labcode == null || labcode == "")
					labcode = "-";
				if(samplelocation == null || samplelocation == "")
					samplelocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(watertype == null || watertype == "")
					watertype = "-";
				if(ph == null || ph == "")
					ph = "-";
				if(ec == null || ec == "")
					ec = "-";
				if(ts == null || ts == "")
					ts = "-";
				if(tds == null || tds == "")
					tds = "-";
				if(ss == null || ss == "")
					ss = "-";
				if(Do == null || Do == "")
					Do = "-";
				if(cod == null || cod == "")
					cod = "-";
				if(salinity == null || salinity == "")
					salinity = "-";
				if(chloride == null || chloride == "")
					chloride = "-";
				if(turbidity == null || turbidity == "")
					turbidity = "-";
				if(totalhardness == null || totalhardness == "")
					totalhardness = "-";
				if(oilandgrease == null || oilandgrease == "")
					oilandgrease = "-";
				if(bod == null || bod == "")
					bod = "-";
				if(remarks == null || remarks == "" || remarks == " ")
					remarks = "-";
				
				fulldate = "Sample Collection Date : "+fulldate;
				id = "Memo No : "+ id;

				// //Adding into database
				String insertquery = "INSERT INTO waterindustryindividualreport (date, industryname, industrytype, watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, industrylocation, samplelocation,  idealtemperature, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity, idealchloride,  idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,memono,sampledate,subject,reference,signaturetemplate,description)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, watertype);
				preparedStatement.setString(5, labcode);
				preparedStatement.setString(6, temperature);
				preparedStatement.setString(7, ph);
				preparedStatement.setString(8, ec);
				preparedStatement.setString(9, ts);
				preparedStatement.setString(10, tds);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, Do);
				preparedStatement.setString(13, cod);
				preparedStatement.setString(14, salinity);
				preparedStatement.setString(15, chloride);
				preparedStatement.setString(16, turbidity);
				preparedStatement.setString(17, totalhardness);
				preparedStatement.setString(18, oilandgrease);
				preparedStatement.setString(19, bod);
				preparedStatement.setString(20, remarks);
				preparedStatement.setString(21, indsutrylocation);
				preparedStatement.setString(22, samplelocation);
				preparedStatement.setString(23, idealtemperature);
				preparedStatement.setString(24, idealph);
				preparedStatement.setString(25, idealec);
				preparedStatement.setString(26, idealts);
				preparedStatement.setString(27, idealtds);
				preparedStatement.setString(28, idealss);
				preparedStatement.setString(29, idealDo);
				preparedStatement.setString(30, idealcod);
				preparedStatement.setString(31, idealsalinity);
				preparedStatement.setString(32, idealchloride);
				preparedStatement.setString(33, idealturbidity);
				preparedStatement.setString(34, idealtotalhardness);
				preparedStatement.setString(35, idealoilandgrease);
				preparedStatement.setString(36, idealbod);
				preparedStatement.setString(37, id);
				preparedStatement.setString(38, sampledate);
				preparedStatement.setString(39, subject);
				preparedStatement.setString(40, reference);
				preparedStatement.setString(41, signaturetemplate);
				preparedStatement.setString(42, description);

				preparedStatement.execute();

			}
			if(waterindustrystandlimitfalse.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\waterindustryindividualreportwithoutstandardlimit.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}
			if(waterindustrystandardlimittrue.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\waterindustryindividualreport.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

		}
		// Just for Showing not printing.
		else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh") {

			String deleteQuery = "delete from waterindustryreport";
			stat.execute(deleteQuery);

			industryquery = "select * from waterindustrydatainput where " + "industryname like " + "'" + IndustryName
					+ "'";
			rSet = stat.executeQuery(industryquery);

			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("industryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("industrylocation");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("industrytype");
				String watertype = rSet.getString("watertype");
				String temperature = rSet.getString("temperature");
				String ph = rSet.getString("ph");
				String ec = rSet.getString("ec");
				String ts = rSet.getString("ts");
				String tds = rSet.getString("tds");
				String ss = rSet.getString("ss");
				String Do = rSet.getString("do");
				String cod = rSet.getString("cod");

				String salinity = rSet.getString("salinity");
				String chloride = rSet.getString("chloride");
				String turbidity = rSet.getString("turbidity");
				String totalhardness = rSet.getString("totalhardness");
				String oilandgrease = rSet.getString("oilandgrease");
				String bod = rSet.getString("bod");
				String industrylocation = rSet.getString("industrylocation");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				if(labcode == null || labcode == "")
					labcode = "-";
				if(samplelocation == null || samplelocation == "")
					samplelocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(watertype == null || watertype == "")
					watertype = "-";
				if(ph == null || ph == "")
					ph = "-";
				if(ec == null || ec == "")
					ec = "-";
				if(ts == null || ts == "")
					ts = "-";
				if(tds == null || tds == "")
					tds = "-";
				if(ss == null || ss == "")
					ss = "-";
				if(Do == null || Do == "")
					Do = "-";
				if(cod == null || cod == "")
					cod = "-";
				if(salinity == null || salinity == "")
					salinity = "-";
				if(chloride == null || chloride == "")
					chloride = "-";
				if(turbidity == null || turbidity == "")
					turbidity = "-";
				if(totalhardness == null || totalhardness == "")
					totalhardness = "-";
				if(oilandgrease == null || oilandgrease == "")
					oilandgrease = "-";
				if(bod == null || bod == "")
					bod = "-";
				if(remarks == null || remarks == "" || remarks == " ")
					remarks = "-";

				// //Adding into database
				String insertquery = "INSERT INTO waterindustryreport (date, industryname, industrytype, watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, industrylocation, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, watertype);
				preparedStatement.setString(5, labcode);
				preparedStatement.setString(6, temperature);
				preparedStatement.setString(7, ph);
				preparedStatement.setString(8, ec);
				preparedStatement.setString(9, ts);
				preparedStatement.setString(10, tds);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, Do);
				preparedStatement.setString(13, cod);
				preparedStatement.setString(14, salinity);
				preparedStatement.setString(15, chloride);
				preparedStatement.setString(16, turbidity);
				preparedStatement.setString(17, totalhardness);
				preparedStatement.setString(18, oilandgrease);
				preparedStatement.setString(19, bod);
				preparedStatement.setString(20, remarks);
				preparedStatement.setString(21, indsutrylocation);
				preparedStatement.setString(22, samplelocation);
				preparedStatement.setString(23, serial);

				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\waterindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
		} else {

			int Datefrom = Integer.parseInt(datefrom);
			int Monthfrom = Integer.parseInt(monthfrom);
			int Yearfrom = Integer.parseInt(yearfrom);
			int Dateto = Integer.parseInt(dateto);
			int Monthto = Integer.parseInt(monthto);
			int Yearto = Integer.parseInt(yearto);

			String deleteQuery = "delete from waterindustryreport";
			stat.execute(deleteQuery);

			for (int year = Yearfrom; year <= Yearto; year++) {

				for (int month = Monthfrom; month <= 12; month++) {

					for (int date = Datefrom; date <= 31; date++) {

						if (year == Yearto) {

							if (month > Monthto) {
								break;
							}
							if (month == Monthto) {
								if (date > Dateto) {
									break;
								}
							}
						}

						String query;

						if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null
								&& monthto != null && yearto != null && IndustryName != null
								&& IndustryName != "Refresh" && IndustryName != "All Data") {
							query = "select * from waterindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and industryname like " + "'" + IndustryName + "'";
						} else {
							query = "select * from waterindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
						}

						rSet = stat.executeQuery(query);
						while (rSet.next()) {
							String serial = rSet.getString("id");
							String DAY = rSet.getString("day");
							String MONTH = rSet.getString("month");
							String YEAR = rSet.getString("year");
							String indsutryname = rSet.getString("industryname");
							String labcode = rSet.getString("labcode");
							String indsutrylocation = rSet.getString("industrylocation");
							String sampelocation = rSet.getString("samplelocation");
							String indsutrytype = rSet.getString("industrytype");
							String watertype = rSet.getString("watertype");
							String temperature = rSet.getString("temperature");
							String ph = rSet.getString("ph");
							String ec = rSet.getString("ec");
							String ts = rSet.getString("ts");
							String tds = rSet.getString("tds");
							String ss = rSet.getString("ss");
							String Do = rSet.getString("do");
							String cod = rSet.getString("cod");

							String salinity = rSet.getString("salinity");
							String chloride = rSet.getString("chloride");
							String turbidity = rSet.getString("turbidity");
							String totalhardness = rSet.getString("totalhardness");
							String oilandgrease = rSet.getString("oilandgrease");
							String bod = rSet.getString("bod");
							String industrylocation = rSet.getString("industrylocation");
							String remarks = rSet.getString("remarks");

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							System.out.println("fulldata : " + fulldate);

							if(labcode == null || labcode == "")
								labcode = "-";
							if(sampelocation == null || sampelocation == "")
								sampelocation = "-";
							if(indsutrytype == null || indsutrytype == "")
								indsutrytype = "-";
							if(watertype == null || watertype == "")
								watertype = "-";
							if(ph == null || ph == "")
								ph = "-";
							if(ec == null || ec == "")
								ec = "-";
							if(ts == null || ts == "")
								ts = "-";
							if(tds == null || tds == "")
								tds = "-";
							if(ss == null || ss == "")
								ss = "-";
							if(Do == null || Do == "")
								Do = "-";
							if(cod == null || cod == "")
								cod = "-";
							if(salinity == null || salinity == "")
								salinity = "-";
							if(chloride == null || chloride == "")
								chloride = "-";
							if(turbidity == null || turbidity == "")
								turbidity = "-";
							if(totalhardness == null || totalhardness == "")
								totalhardness = "-";
							if(oilandgrease == null || oilandgrease == "")
								oilandgrease = "-";
							if(bod == null || bod == "")
								bod = "-";
							if(remarks == null || remarks == "" || remarks == " ")
								remarks = "-";
							
							// //Adding into database
							String insertquery = "INSERT INTO waterindustryreport (date, industryname, industrytype, watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, industrylocation, samplelocation, serial)"
									+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, watertype);
							preparedStatement.setString(5, labcode);
							preparedStatement.setString(6, temperature);
							preparedStatement.setString(7, ph);
							preparedStatement.setString(8, ec);
							preparedStatement.setString(9, ts);
							preparedStatement.setString(10, tds);
							preparedStatement.setString(11, ss);
							preparedStatement.setString(12, Do);
							preparedStatement.setString(13, cod);
							preparedStatement.setString(14, salinity);
							preparedStatement.setString(15, chloride);
							preparedStatement.setString(16, turbidity);
							preparedStatement.setString(17, totalhardness);
							preparedStatement.setString(18, oilandgrease);
							preparedStatement.setString(19, bod);
							preparedStatement.setString(20, remarks);
							preparedStatement.setString(21, indsutrylocation);
							preparedStatement.setString(22, sampelocation);
							preparedStatement.setString(23, serial);

							preparedStatement.execute();

						}
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\waterindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}

	}

	// Report of Water -> Monitoring
	@FXML
	public void actionwatermonitoringreport(ActionEvent event) throws JRException, SQLException {
		String value = watermonitoringreporttype.getValue();
		boolean reportPrintingForOrganization = monitoringReportPrintingForOrganizationChecker.isSelected();
		if (value == "River") {

			String industryquery;
			String datefrom = watermonitoringreportdatefrom.getValue();
			String monthfrom = watermonitoringreportmonthfrom.getValue();
			String yearfrom = watermonitoringreportyearfrom.getValue();
			String dateto = watermonitoringreportdateto.getValue();
			String monthto = watermonitoringreportmonthto.getValue();
			String yearto = watermonitoringreportyearto.getValue();
			String IndustryName = watermonitoringreportname.getValue();
			if (IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null
					&& dateto == null && monthto == null && yearto == null) {

				String deleteQuery = "delete from watermonitoringreportriver";
				stat.execute(deleteQuery);

				String allDataQuery = "select * from watermonitoringriverdatainput";
				rSet = stat.executeQuery(allDataQuery);

				while (rSet.next()) {
				
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("rivername");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("riverlocation");
					String id = rSet.getString("id");
					String watertype = rSet.getString("riverwatertype");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(watertype == null || watertype == "")
						watertype = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";

					
					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportriver (date, name,  watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, watertype);
					preparedStatement.setString(4, labcode);
					preparedStatement.setString(5, temperature);
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
					preparedStatement.setString(19, riverlocation);
					preparedStatement.setString(20, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportriver.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

			else if ((datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
					|| yearto == null) && IndustryName == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please Select All Time Options. Thank You!");
				alert.showAndWait();
			} 
			// For Report Printing
			else if (IndustryName != "Refresh" && reportPrintingForOrganization == true) {
				int Datefrom = 0;
				int Monthfrom = 0;
				int Yearfrom = 0;
				try {
					Datefrom = Integer.parseInt(datefrom);
					Monthfrom = Integer.parseInt(monthfrom);
					Yearfrom = Integer.parseInt(yearfrom);
				} catch (Exception e) {

				}

				String deleteQuery = "delete from waterrivermonitoringindividualreport";
				stat.execute(deleteQuery);

				String idealtemperature = "itemp";
				String idealph = "iph";
				String idealec = "iec";
				String idealts = "its";
				String idealtds = "itds";
				String idealss = "iss";
				String idealDo = "ido";
				String idealcod = "icod";
				String idealsalinity = "isalinity";
				String idealchloride = "ichloride";
				String idealturbidity = "iturbiduty";
				String idealtotalhardness = "itotal";
				String idealoilandgrease = "ioil";
				String idealbod = "ibod";
				String sampledate = "manual date";
				String subject = "subject";
				String reference = "reference";
				String signaturetemplate = "signaturetemplate";
				String description = "description";
				String remarks = "remarks";

				String query = "select * from waterrivermonitoringstandarddatasave";

				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					sampledate = rSet.getString("sampledate");
					subject = rSet.getString("subject");
					reference = rSet.getString("reference");
					signaturetemplate = rSet.getString("signaturetemplate");
					description = rSet.getString("description");
					idealtemperature = rSet.getString("idealtemperature");
					idealph = rSet.getString("idealph");
					idealec = rSet.getString("idealec");
					idealts = rSet.getString("idealts");
					idealtds = rSet.getString("idealtds");
					idealss = rSet.getString("idealss");
					idealDo = rSet.getString("idealdo");
					idealcod = rSet.getString("idealcod");
					idealsalinity = rSet.getString("idealsalinity");
					idealchloride = rSet.getString("idealchloride");
					idealturbidity = rSet.getString("idealturbidity");
					idealtotalhardness = rSet.getString("idealtotalhardness");
					idealoilandgrease = rSet.getString("idealoilandgrease");
					idealbod = rSet.getString("idealbod");
					remarks = rSet.getString("remarks");
				}
				subject = "Subject : "+ subject;
				reference = "Reference : "+ reference;
				sampledate = "Date : "+sampledate;
				remarks = "*Remarks : "+remarks;
				
				String orginallocation = "";
				query = "select location from watermonitoringregistration where type like 'River' and name like "+"'"+ IndustryName +"'";
				rSet = stat.executeQuery(query);
				while(rSet.next()){
					orginallocation = rSet.getString("location");
				}
				if(orginallocation == null){
					orginallocation = "-";
				}
				orginallocation = " "+orginallocation;
				orginallocation = orginallocation.replaceAll("\n", " ");
				orginallocation = orginallocation.replaceAll("\r", " ");
				if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
						&& yearto == null) {
					industryquery = "select * from watermonitoringriverdatainput where " + "rivername like " + "'"
							+ IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				} else {
					industryquery = "select * from watermonitoringriverdatainput where " + "year like " + "'" + Yearfrom
							+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
							+ "' and rivername like " + "'" + IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				}
                
                
				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String rivername = rSet.getString("rivername");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("riverlocation");
					String watertype = rSet.getString("riverwatertype");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");
					String id = rSet.getString("id");

					String fulldate;
					// char [] locationcharacter = industrylocation.toCharArray();
                    if(riverlocation == null){
                    	riverlocation = "-";
                    }
                    riverlocation = " "+riverlocation;
					riverlocation = riverlocation.replaceAll("\n", " ");
					riverlocation = riverlocation.replaceAll("\r", " ");
					if (orginallocation.length() > 2) {
						rivername = "Name and Address of River : "+rivername + " ( " + orginallocation + " ).";
					}
					else{
						rivername = "Name and Address of River : "+rivername;
					}
					
					

					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					fulldate = "Sample Collection Date : "+fulldate;
					id = "Memo No : "+ id;

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(watertype == null || watertype == "")
						watertype = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					// //Adding into database
					String insertquery = "INSERT INTO waterrivermonitoringindividualreport (date, name,  watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, location,  idealtemperature, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity, idealchloride,  idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,memono,sampledate,subject,reference,signaturetemplate,description)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, rivername);
					preparedStatement.setString(3, watertype);
					preparedStatement.setString(4, labcode);
					preparedStatement.setString(5, temperature);
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
					preparedStatement.setString(19, remarks);
					preparedStatement.setString(20, riverlocation);
					preparedStatement.setString(21, idealtemperature);
					preparedStatement.setString(22, idealph);
					preparedStatement.setString(23, idealec);
					preparedStatement.setString(24, idealts);
					preparedStatement.setString(25, idealtds);
					preparedStatement.setString(26, idealss);
					preparedStatement.setString(27, idealDo);
					preparedStatement.setString(28, idealcod);
					preparedStatement.setString(29, idealsalinity);
					preparedStatement.setString(30, idealchloride);
					preparedStatement.setString(31, idealturbidity);
					preparedStatement.setString(32, idealtotalhardness);
					preparedStatement.setString(33, idealoilandgrease);
					preparedStatement.setString(34, idealbod);
					preparedStatement.setString(35, id);
					preparedStatement.setString(36, sampledate);
					preparedStatement.setString(37, subject);
					preparedStatement.setString(38, reference);
					preparedStatement.setString(39, signaturetemplate);
					preparedStatement.setString(40, description);

					preparedStatement.execute();

				}
				if(watermonitoringstandlimitfalse.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterrivermonitoringindividualreportwithoutstandardlimit.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}
				if(watermonitoringstandardlimittrue.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterrivermonitoringindividualreport.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}

			}
			// Just for Showing not printing.
           else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null && IndustryName != null && IndustryName != "Refresh") {

				String deleteQuery = "delete from watermonitoringreportriver";
				stat.execute(deleteQuery);

				industryquery = "select * from watermonitoringriverdatainput where " + "rivername like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("rivername");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("riverlocation");
					String id = rSet.getString("id");
					String watertype = rSet.getString("riverwatertype");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(watertype == null || watertype == "")
						watertype = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportriver (date, name,  watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, watertype);
					preparedStatement.setString(4, labcode);
					preparedStatement.setString(5, temperature);
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
					preparedStatement.setString(19, riverlocation);
					preparedStatement.setString(20, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportriver.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			} else {

				int Datefrom = Integer.parseInt(datefrom);
				int Monthfrom = Integer.parseInt(monthfrom);
				int Yearfrom = Integer.parseInt(yearfrom);
				int Dateto = Integer.parseInt(dateto);
				int Monthto = Integer.parseInt(monthto);
				int Yearto = Integer.parseInt(yearto);

				String deleteQuery = "delete from watermonitoringreportriver";
				stat.execute(deleteQuery);

				for (int year = Yearfrom; year <= Yearto; year++) {

					for (int month = Monthfrom; month <= 12; month++) {

						for (int date = Datefrom; date <= 31; date++) {

							if (year == Yearto) {

								if (month > Monthto) {
									break;
								}
								if (month == Monthto) {
									if (date > Dateto) {
										break;
									}
								}
							}

							String query;

							if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null
									&& monthto != null && yearto != null && IndustryName != null
									&& IndustryName != "Refresh" && IndustryName != "All Data") {
								query = "select * from watermonitoringriverdatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date
										+ "' and rivername like " + "'" + IndustryName + "'";
							} else {
								query = "select * from watermonitoringriverdatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
							}

							rSet = stat.executeQuery(query);

							while (rSet.next()) {
								String DAY = rSet.getString("day");
								String MONTH = rSet.getString("month");
								String YEAR = rSet.getString("year");
								String indsutryname = rSet.getString("rivername");
								String labcode = rSet.getString("labcode");
								String riverlocation = rSet.getString("riverlocation");
								String id = rSet.getString("id");
								String watertype = rSet.getString("riverwatertype");
								String temperature = rSet.getString("temperature");
								String ph = rSet.getString("ph");
								String ec = rSet.getString("ec");
								String ts = rSet.getString("ts");
								String tds = rSet.getString("tds");
								String ss = rSet.getString("ss");
								String Do = rSet.getString("do");
								String cod = rSet.getString("cod");

								String salinity = rSet.getString("salinity");
								String chloride = rSet.getString("chloride");
								String turbidity = rSet.getString("turbidity");
								String totalhardness = rSet.getString("totalhardness");
								String oilandgrease = rSet.getString("oilandgrease");
								String bod = rSet.getString("bod");

								String fulldate;
								if (DAY == null || MONTH == null || YEAR == null) {
									fulldate = " ";
								} else {
									fulldate = DAY + "." + MONTH + "." + YEAR;
								}
								if(labcode == null || labcode == "")
									labcode = "-";
								if(riverlocation == null || riverlocation == "")
									riverlocation = "-";
								if(watertype == null || watertype == "")
									watertype = "-";
								if(ph == null || ph == "")
									ph = "-";
								if(ec == null || ec == "")
									ec = "-";
								if(ts == null || ts == "")
									ts = "-";
								if(tds == null || tds == "")
									tds = "-";
								if(ss == null || ss == "")
									ss = "-";
								if(Do == null || Do == "")
									Do = "-";
								if(cod == null || cod == "")
									cod = "-";
								if(salinity == null || salinity == "")
									salinity = "-";
								if(chloride == null || chloride == "")
									chloride = "-";
								if(turbidity == null || turbidity == "")
									turbidity = "-";
								if(totalhardness == null || totalhardness == "")
									totalhardness = "-";
								if(oilandgrease == null || oilandgrease == "")
									oilandgrease = "-";
								if(bod == null || bod == "")
									bod = "-";
								

								// //Adding into database
								String insertquery = "INSERT INTO watermonitoringreportriver (date, name,  watertype, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
										+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement preparedStatement = (PreparedStatement) con
										.prepareStatement(insertquery);
								preparedStatement.setString(1, fulldate);
								preparedStatement.setString(2, indsutryname);
								preparedStatement.setString(3, watertype);
								preparedStatement.setString(4, labcode);
								preparedStatement.setString(5, temperature);
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
								preparedStatement.setString(19, riverlocation);
								preparedStatement.setString(20, id);

								preparedStatement.execute();

							}
						}
						Datefrom = 1;

					}
					Monthfrom = 1;

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportriver.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);

			}

		}

		if (value == "Sea") {

			String industryquery;
			String datefrom = watermonitoringreportdatefrom.getValue();
			String monthfrom = watermonitoringreportmonthfrom.getValue();
			String yearfrom = watermonitoringreportyearfrom.getValue();
			String dateto = watermonitoringreportdateto.getValue();
			String monthto = watermonitoringreportmonthto.getValue();
			String yearto = watermonitoringreportyearto.getValue();
			String IndustryName = watermonitoringreportname.getValue();
			if (IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null
					&& dateto == null && monthto == null && yearto == null) {

				String deleteQuery = "delete from watermonitoringreportsea";
				stat.execute(deleteQuery);

				String allDataQuery = "select * from watermonitoringseadatainput";
				rSet = stat.executeQuery(allDataQuery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("seaname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("sealocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportsea (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportsea.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

			else if ((datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
					|| yearto == null) && IndustryName == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please Select All Time Options. Thank You!");
				alert.showAndWait();
			}
			// For Report Printing
			else if (IndustryName != "Refresh" && reportPrintingForOrganization == true) {
				int Datefrom = 0;
				int Monthfrom = 0;
				int Yearfrom = 0;
				try {
					Datefrom = Integer.parseInt(datefrom);
					Monthfrom = Integer.parseInt(monthfrom);
					Yearfrom = Integer.parseInt(yearfrom);
				} catch (Exception e) {

				}

				String deleteQuery = "delete from waterseamonitoringindividualreport";
				stat.execute(deleteQuery);

				String idealtemperature = "itemp";
				String idealph = "iph";
				String idealec = "iec";
				String idealts = "its";
				String idealtds = "itds";
				String idealss = "iss";
				String idealDo = "ido";
				String idealcod = "icod";
				String idealsalinity = "isalinity";
				String idealchloride = "ichloride";
				String idealturbidity = "iturbiduty";
				String idealtotalhardness = "itotal";
				String idealoilandgrease = "ioil";
				String idealbod = "ibod";
				String sampledate = "manual date";
				String subject = "subject";
				String reference = "reference";
				String signaturetemplate = "signaturetemplate";
				String description = "description";
				String remarks = "remarks";

				String query = "select * from waterseamonitoringstandarddatasave";

				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					sampledate = rSet.getString("sampledate");
					subject = rSet.getString("subject");
					reference = rSet.getString("reference");
					signaturetemplate = rSet.getString("signaturetemplate");
					description = rSet.getString("description");
					idealtemperature = rSet.getString("idealtemperature");
					idealph = rSet.getString("idealph");
					idealec = rSet.getString("idealec");
					idealts = rSet.getString("idealts");
					idealtds = rSet.getString("idealtds");
					idealss = rSet.getString("idealss");
					idealDo = rSet.getString("idealdo");
					idealcod = rSet.getString("idealcod");
					idealsalinity = rSet.getString("idealsalinity");
					idealchloride = rSet.getString("idealchloride");
					idealturbidity = rSet.getString("idealturbidity");
					idealtotalhardness = rSet.getString("idealtotalhardness");
					idealoilandgrease = rSet.getString("idealoilandgrease");
					idealbod = rSet.getString("idealbod");
					remarks = rSet.getString("remarks");
				}
				subject = "Subject : "+ subject;
				reference = "Reference : "+ reference;
				sampledate = "Date : "+sampledate;
				remarks = "*Remarks : "+remarks;
				
				String orginallocation = "";
				query = "select location from watermonitoringregistration where type like 'Sea' and name like "+"'"+ IndustryName +"'";
				rSet = stat.executeQuery(query);
				while(rSet.next()){
					orginallocation = rSet.getString("location");
				}
				if(orginallocation == null){
					orginallocation = "-";
				}
				orginallocation = " "+orginallocation;
				orginallocation = orginallocation.replaceAll("\n", " ");
				orginallocation = orginallocation.replaceAll("\r", " ");
				if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
						&& yearto == null) {
					industryquery = "select * from watermonitoringseadatainput where " + "seaname like " + "'"
							+ IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				} else {
					industryquery = "select * from watermonitoringseadatainput where " + "year like " + "'" + Yearfrom
							+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
							+ "' and seaname like " + "'" + IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				}
                
                
				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String seaname = rSet.getString("seaname");
					String labcode = rSet.getString("labcode");
					String sealocation = rSet.getString("sealocation");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");
					String id = rSet.getString("id");

					String fulldate;
                    if(sealocation == null){
                    	sealocation = "-";
                    }
                    sealocation = " "+sealocation;
					sealocation = sealocation.replaceAll("\n", " ");
					sealocation = sealocation.replaceAll("\r", " ");
					if (orginallocation.length() > 2) {
						seaname = "Name and Address of Sea : "+seaname + " ( " + orginallocation + " ).";
					}
					else{
						seaname = "Name and Address of Sea : "+seaname;
					}
					
					

					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(sealocation == null || sealocation == "")
						sealocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					fulldate = "Sample Collection Date : "+fulldate;
					id = "Memo No : "+ id;

					// //Adding into database
					String insertquery = "INSERT INTO waterseamonitoringindividualreport (date, name,  labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, location,  idealtemperature, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity, idealchloride,  idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,memono,sampledate,subject,reference,signaturetemplate,description)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, seaname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, remarks);
					preparedStatement.setString(19, sealocation);
					preparedStatement.setString(20, idealtemperature);
					preparedStatement.setString(21, idealph);
					preparedStatement.setString(22, idealec);
					preparedStatement.setString(23, idealts);
					preparedStatement.setString(24, idealtds);
					preparedStatement.setString(25, idealss);
					preparedStatement.setString(26, idealDo);
					preparedStatement.setString(27, idealcod);
					preparedStatement.setString(28, idealsalinity);
					preparedStatement.setString(29, idealchloride);
					preparedStatement.setString(30, idealturbidity);
					preparedStatement.setString(31, idealtotalhardness);
					preparedStatement.setString(32, idealoilandgrease);
					preparedStatement.setString(33, idealbod);
					preparedStatement.setString(34, id);
					preparedStatement.setString(35, sampledate);
					preparedStatement.setString(36, subject);
					preparedStatement.setString(37, reference);
					preparedStatement.setString(38, signaturetemplate);
					preparedStatement.setString(39, description);

					preparedStatement.execute();

				}
				if(watermonitoringstandlimitfalse.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterseamonitoringindividualreportwithoutstandardlimit.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}
				if(watermonitoringstandardlimittrue.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterseamonitoringindividualreport.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}

			}
			// Just for Showing not printing.
			else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null && IndustryName != null && IndustryName != "Refresh") {

				String deleteQuery = "delete from watermonitoringreportsea";
				stat.execute(deleteQuery);

				industryquery = "select * from watermonitoringseadatainput where " + "seaname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("seaname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("sealocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportsea (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportsea.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			} else {

				int Datefrom = Integer.parseInt(datefrom);
				int Monthfrom = Integer.parseInt(monthfrom);
				int Yearfrom = Integer.parseInt(yearfrom);
				int Dateto = Integer.parseInt(dateto);
				int Monthto = Integer.parseInt(monthto);
				int Yearto = Integer.parseInt(yearto);

				String deleteQuery = "delete from watermonitoringreportsea";
				stat.execute(deleteQuery);

				for (int year = Yearfrom; year <= Yearto; year++) {

					for (int month = Monthfrom; month <= 12; month++) {

						for (int date = Datefrom; date <= 31; date++) {

							if (year == Yearto) {

								if (month > Monthto) {
									break;
								}
								if (month == Monthto) {
									if (date > Dateto) {
										break;
									}
								}
							}

							String query;

							if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null
									&& monthto != null && yearto != null && IndustryName != null
									&& IndustryName != "Refresh" && IndustryName != "All Data") {
								query = "select * from watermonitoringseadatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date
										+ "' and seaname like " + "'" + IndustryName + "'";
							} else {
								query = "select * from watermonitoringseadatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
							}

							rSet = stat.executeQuery(query);

							while (rSet.next()) {
								String DAY = rSet.getString("day");
								String MONTH = rSet.getString("month");
								String YEAR = rSet.getString("year");
								String indsutryname = rSet.getString("seaname");
								String labcode = rSet.getString("labcode");
								String riverlocation = rSet.getString("sealocation");
								String id = rSet.getString("id");
								String temperature = rSet.getString("temperature");
								String ph = rSet.getString("ph");
								String ec = rSet.getString("ec");
								String ts = rSet.getString("ts");
								String tds = rSet.getString("tds");
								String ss = rSet.getString("ss");
								String Do = rSet.getString("do");
								String cod = rSet.getString("cod");

								String salinity = rSet.getString("salinity");
								String chloride = rSet.getString("chloride");
								String turbidity = rSet.getString("turbidity");
								String totalhardness = rSet.getString("totalhardness");
								String oilandgrease = rSet.getString("oilandgrease");
								String bod = rSet.getString("bod");

								String fulldate;
								if (DAY == null || MONTH == null || YEAR == null) {
									fulldate = " ";
								} else {
									fulldate = DAY + "." + MONTH + "." + YEAR;
								}
								if(labcode == null || labcode == "")
									labcode = "-";
								if(riverlocation == null || riverlocation == "")
									riverlocation = "-";
								if(ph == null || ph == "")
									ph = "-";
								if(ec == null || ec == "")
									ec = "-";
								if(ts == null || ts == "")
									ts = "-";
								if(tds == null || tds == "")
									tds = "-";
								if(ss == null || ss == "")
									ss = "-";
								if(Do == null || Do == "")
									Do = "-";
								if(cod == null || cod == "")
									cod = "-";
								if(salinity == null || salinity == "")
									salinity = "-";
								if(chloride == null || chloride == "")
									chloride = "-";
								if(turbidity == null || turbidity == "")
									turbidity = "-";
								if(totalhardness == null || totalhardness == "")
									totalhardness = "-";
								if(oilandgrease == null || oilandgrease == "")
									oilandgrease = "-";
								if(bod == null || bod == "")
									bod = "-";
								

								// //Adding into database
								String insertquery = "INSERT INTO watermonitoringreportsea (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
										+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement preparedStatement = (PreparedStatement) con
										.prepareStatement(insertquery);
								preparedStatement.setString(1, fulldate);
								preparedStatement.setString(2, indsutryname);
								preparedStatement.setString(3, labcode);
								preparedStatement.setString(4, temperature);
								preparedStatement.setString(5, ph);
								preparedStatement.setString(6, ec);
								preparedStatement.setString(7, ts);
								preparedStatement.setString(8, tds);
								preparedStatement.setString(9, ss);
								preparedStatement.setString(10, Do);
								preparedStatement.setString(11, cod);
								preparedStatement.setString(12, salinity);
								preparedStatement.setString(13, chloride);
								preparedStatement.setString(14, turbidity);
								preparedStatement.setString(15, totalhardness);
								preparedStatement.setString(16, oilandgrease);
								preparedStatement.setString(17, bod);
								preparedStatement.setString(18, riverlocation);
								preparedStatement.setString(19, id);

								preparedStatement.execute();

							}
						}
						Datefrom = 1;

					}
					Monthfrom = 1;

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportsea.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);

			}

		}

		if (value == "Pond") {
			// JasperReport jr = JasperCompileManager
			// .compileReport(reprotDirectory+"\\watermonitoringreportpond.jrxml");
			// JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			// JasperViewer.viewReport(jp,false);

			String industryquery;
			String datefrom = watermonitoringreportdatefrom.getValue();
			String monthfrom = watermonitoringreportmonthfrom.getValue();
			String yearfrom = watermonitoringreportyearfrom.getValue();
			String dateto = watermonitoringreportdateto.getValue();
			String monthto = watermonitoringreportmonthto.getValue();
			String yearto = watermonitoringreportyearto.getValue();
			String IndustryName = watermonitoringreportname.getValue();
			if (IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null
					&& dateto == null && monthto == null && yearto == null) {

				String deleteQuery = "delete from watermonitoringreportpond";
				stat.execute(deleteQuery);

				String allDataQuery = "select * from watermonitoringponddatainput";
				rSet = stat.executeQuery(allDataQuery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("pondname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("pondlocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportpond (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportpond.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

			else if ((datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
					|| yearto == null) && IndustryName == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please Select All Time Options. Thank You!");
				alert.showAndWait();
			}
			// For Report Printing
			else if (IndustryName != "Refresh" && reportPrintingForOrganization == true) {
				int Datefrom = 0;
				int Monthfrom = 0;
				int Yearfrom = 0;
				try {
					Datefrom = Integer.parseInt(datefrom);
					Monthfrom = Integer.parseInt(monthfrom);
					Yearfrom = Integer.parseInt(yearfrom);
				} catch (Exception e) {

				}

				String deleteQuery = "delete from waterpondmonitoringindividualreport";
				stat.execute(deleteQuery);

				String idealtemperature = "itemp";
				String idealph = "iph";
				String idealec = "iec";
				String idealts = "its";
				String idealtds = "itds";
				String idealss = "iss";
				String idealDo = "ido";
				String idealcod = "icod";
				String idealsalinity = "isalinity";
				String idealchloride = "ichloride";
				String idealturbidity = "iturbiduty";
				String idealtotalhardness = "itotal";
				String idealoilandgrease = "ioil";
				String idealbod = "ibod";
				String sampledate = "manual date";
				String subject = "subject";
				String reference = "reference";
				String signaturetemplate = "signaturetemplate";
				String description = "description";
				String remarks = "remarks";

				String query = "select * from waterpondmonitoringstandarddatasave";

				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					sampledate = rSet.getString("sampledate");
					subject = rSet.getString("subject");
					reference = rSet.getString("reference");
					signaturetemplate = rSet.getString("signaturetemplate");
					description = rSet.getString("description");
					idealtemperature = rSet.getString("idealtemperature");
					idealph = rSet.getString("idealph");
					idealec = rSet.getString("idealec");
					idealts = rSet.getString("idealts");
					idealtds = rSet.getString("idealtds");
					idealss = rSet.getString("idealss");
					idealDo = rSet.getString("idealdo");
					idealcod = rSet.getString("idealcod");
					idealsalinity = rSet.getString("idealsalinity");
					idealchloride = rSet.getString("idealchloride");
					idealturbidity = rSet.getString("idealturbidity");
					idealtotalhardness = rSet.getString("idealtotalhardness");
					idealoilandgrease = rSet.getString("idealoilandgrease");
					idealbod = rSet.getString("idealbod");
					remarks = rSet.getString("remarks");
				}
				subject = "Subject : "+ subject;
				reference = "Reference : "+ reference;
				sampledate = "Date : "+sampledate;
				remarks = "*Remarks : "+remarks;
				
				String orginallocation = "";
				query = "select location from watermonitoringregistration where type like 'Pond' and name like "+"'"+ IndustryName +"'";
				rSet = stat.executeQuery(query);
				while(rSet.next()){
					orginallocation = rSet.getString("location");
				}
				if(orginallocation == null){
					orginallocation = "-";
				}
				orginallocation = " "+orginallocation;
				orginallocation = orginallocation.replaceAll("\n", " ");
				orginallocation = orginallocation.replaceAll("\r", " ");
				if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
						&& yearto == null) {
					industryquery = "select * from watermonitoringponddatainput where " + "pondname like " + "'"
							+ IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				} else {
					industryquery = "select * from watermonitoringponddatainput where " + "year like " + "'" + Yearfrom
							+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
							+ "' and pondname like " + "'" + IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				}
                
                
				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String pondname = rSet.getString("pondname");
					String labcode = rSet.getString("labcode");
					String pondlocation = rSet.getString("pondlocation");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");
					String id = rSet.getString("id");

					String fulldate;
                    if(pondlocation == null){
                    	pondlocation = "-";
                    }
                    pondlocation = " "+pondlocation;
					pondlocation = pondlocation.replaceAll("\n", " ");
					pondlocation = pondlocation.replaceAll("\r", " ");
					if (orginallocation.length() > 2) {
						pondname = "Name and Address of Pond : "+pondname + " ( " + orginallocation + " ).";
					}
					else{
						pondname = "Name and Address of Pond : "+pondname;
					}
					
					

					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}

					if(labcode == null || labcode == "")
						labcode = "-";
					if(pondlocation == null || pondlocation == "")
						pondlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					
					fulldate = "Sample Collection Date : "+fulldate;
					id = "Memo No : "+ id;

					// //Adding into database
					String insertquery = "INSERT INTO waterpondmonitoringindividualreport (date, name,  labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, location,  idealtemperature, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity, idealchloride,  idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,memono,sampledate,subject,reference,signaturetemplate,description)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, pondname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, remarks);
					preparedStatement.setString(19, pondlocation);
					preparedStatement.setString(20, idealtemperature);
					preparedStatement.setString(21, idealph);
					preparedStatement.setString(22, idealec);
					preparedStatement.setString(23, idealts);
					preparedStatement.setString(24, idealtds);
					preparedStatement.setString(25, idealss);
					preparedStatement.setString(26, idealDo);
					preparedStatement.setString(27, idealcod);
					preparedStatement.setString(28, idealsalinity);
					preparedStatement.setString(29, idealchloride);
					preparedStatement.setString(30, idealturbidity);
					preparedStatement.setString(31, idealtotalhardness);
					preparedStatement.setString(32, idealoilandgrease);
					preparedStatement.setString(33, idealbod);
					preparedStatement.setString(34, id);
					preparedStatement.setString(35, sampledate);
					preparedStatement.setString(36, subject);
					preparedStatement.setString(37, reference);
					preparedStatement.setString(38, signaturetemplate);
					preparedStatement.setString(39, description);

					preparedStatement.execute();

				}
				if(watermonitoringstandlimitfalse.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterpondmonitoringindividualreportwithoutstandardlimit.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}
				if(watermonitoringstandardlimittrue.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\waterpondmonitoringindividualreport.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}

			}
			// Just for Showing not printing.
			
			else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null && IndustryName != null && IndustryName != "Refresh") {

				String deleteQuery = "delete from watermonitoringreportpond";
				stat.execute(deleteQuery);

				industryquery = "select * from watermonitoringponddatainput where " + "pondname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("pondname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("pondlocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}
					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					

					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreportpond (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportpond.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			} else {

				int Datefrom = Integer.parseInt(datefrom);
				int Monthfrom = Integer.parseInt(monthfrom);
				int Yearfrom = Integer.parseInt(yearfrom);
				int Dateto = Integer.parseInt(dateto);
				int Monthto = Integer.parseInt(monthto);
				int Yearto = Integer.parseInt(yearto);

				String deleteQuery = "delete from watermonitoringreportpond";
				stat.execute(deleteQuery);

				for (int year = Yearfrom; year <= Yearto; year++) {

					for (int month = Monthfrom; month <= 12; month++) {

						for (int date = Datefrom; date <= 31; date++) {

							if (year == Yearto) {

								if (month > Monthto) {
									break;
								}
								if (month == Monthto) {
									if (date > Dateto) {
										break;
									}
								}
							}

							String query;

							if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null
									&& monthto != null && yearto != null && IndustryName != null
									&& IndustryName != "Refresh" && IndustryName != "All Data") {
								query = "select * from watermonitoringponddatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date
										+ "' and pondname like " + "'" + IndustryName + "'";
							} else {
								query = "select * from watermonitoringponddatainput where " + "year like " + "'" + year
										+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
							}

							rSet = stat.executeQuery(query);

							while (rSet.next()) {
								String DAY = rSet.getString("day");
								String MONTH = rSet.getString("month");
								String YEAR = rSet.getString("year");
								String indsutryname = rSet.getString("pondname");
								String labcode = rSet.getString("labcode");
								String riverlocation = rSet.getString("pondlocation");
								String id = rSet.getString("id");
								String temperature = rSet.getString("temperature");
								String ph = rSet.getString("ph");
								String ec = rSet.getString("ec");
								String ts = rSet.getString("ts");
								String tds = rSet.getString("tds");
								String ss = rSet.getString("ss");
								String Do = rSet.getString("do");
								String cod = rSet.getString("cod");

								String salinity = rSet.getString("salinity");
								String chloride = rSet.getString("chloride");
								String turbidity = rSet.getString("turbidity");
								String totalhardness = rSet.getString("totalhardness");
								String oilandgrease = rSet.getString("oilandgrease");
								String bod = rSet.getString("bod");

								String fulldate;
								if (DAY == null || MONTH == null || YEAR == null) {
									fulldate = " ";
								} else {
									fulldate = DAY + "." + MONTH + "." + YEAR;
								}

								if(labcode == null || labcode == "")
									labcode = "-";
								if(riverlocation == null || riverlocation == "")
									riverlocation = "-";
								if(ph == null || ph == "")
									ph = "-";
								if(ec == null || ec == "")
									ec = "-";
								if(ts == null || ts == "")
									ts = "-";
								if(tds == null || tds == "")
									tds = "-";
								if(ss == null || ss == "")
									ss = "-";
								if(Do == null || Do == "")
									Do = "-";
								if(cod == null || cod == "")
									cod = "-";
								if(salinity == null || salinity == "")
									salinity = "-";
								if(chloride == null || chloride == "")
									chloride = "-";
								if(turbidity == null || turbidity == "")
									turbidity = "-";
								if(totalhardness == null || totalhardness == "")
									totalhardness = "-";
								if(oilandgrease == null || oilandgrease == "")
									oilandgrease = "-";
								if(bod == null || bod == "")
									bod = "-";
								
								// //Adding into database
								String insertquery = "INSERT INTO watermonitoringreportpond (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
										+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement preparedStatement = (PreparedStatement) con
										.prepareStatement(insertquery);
								preparedStatement.setString(1, fulldate);
								preparedStatement.setString(2, indsutryname);
								preparedStatement.setString(3, labcode);
								preparedStatement.setString(4, temperature);
								preparedStatement.setString(5, ph);
								preparedStatement.setString(6, ec);
								preparedStatement.setString(7, ts);
								preparedStatement.setString(8, tds);
								preparedStatement.setString(9, ss);
								preparedStatement.setString(10, Do);
								preparedStatement.setString(11, cod);
								preparedStatement.setString(12, salinity);
								preparedStatement.setString(13, chloride);
								preparedStatement.setString(14, turbidity);
								preparedStatement.setString(15, totalhardness);
								preparedStatement.setString(16, oilandgrease);
								preparedStatement.setString(17, bod);
								preparedStatement.setString(18, riverlocation);
								preparedStatement.setString(19, id);

								preparedStatement.execute();

							}
						}
						Datefrom = 1;

					}
					Monthfrom = 1;

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreportpond.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);

			}

		}

		if (value == "Deep Tubewell") {
			String industryquery;
			String datefrom = watermonitoringreportdatefrom.getValue();
			String monthfrom = watermonitoringreportmonthfrom.getValue();
			String yearfrom = watermonitoringreportyearfrom.getValue();
			String dateto = watermonitoringreportdateto.getValue();
			String monthto = watermonitoringreportmonthto.getValue();
			String yearto = watermonitoringreportyearto.getValue();
			String IndustryName = watermonitoringreportname.getValue();

			if (IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null
					&& dateto == null && monthto == null && yearto == null) {

				String deleteQuery = "delete from watermonitoringreporttuble";
				stat.execute(deleteQuery);

				String allDataQuery = "select * from watermonitoringdeeptubledatainput";
				rSet = stat.executeQuery(allDataQuery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("deeptubewellname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("deeptubewelllocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}
					
					
					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					

					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreporttuble (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreporttuble.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

			else if ((datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
					|| yearto == null) && IndustryName == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setContentText("Please Select All Time Options. Thank You!");
				alert.showAndWait();
			} 
			// For Report Printing
			else if (IndustryName != "Refresh" && reportPrintingForOrganization == true) {
				int Datefrom = 0;
				int Monthfrom = 0;
				int Yearfrom = 0;
				try {
					Datefrom = Integer.parseInt(datefrom);
					Monthfrom = Integer.parseInt(monthfrom);
					Yearfrom = Integer.parseInt(yearfrom);
				} catch (Exception e) {

				}

				String deleteQuery = "delete from watertubewellmonitoringindividualreport";
				stat.execute(deleteQuery);

				String idealtemperature = "itemp";
				String idealph = "iph";
				String idealec = "iec";
				String idealts = "its";
				String idealtds = "itds";
				String idealss = "iss";
				String idealDo = "ido";
				String idealcod = "icod";
				String idealsalinity = "isalinity";
				String idealchloride = "ichloride";
				String idealturbidity = "iturbiduty";
				String idealtotalhardness = "itotal";
				String idealoilandgrease = "ioil";
				String idealbod = "ibod";
				String sampledate = "manual date";
				String subject = "subject";
				String reference = "reference";
				String signaturetemplate = "signaturetemplate";
				String description = "description";
				String remarks = "remarks";

				String query = "select * from watertubewellmonitoringstandarddatasave";

				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					sampledate = rSet.getString("sampledate");
					subject = rSet.getString("subject");
					reference = rSet.getString("reference");
					signaturetemplate = rSet.getString("signaturetemplate");
					description = rSet.getString("description");
					idealtemperature = rSet.getString("idealtemperature");
					idealph = rSet.getString("idealph");
					idealec = rSet.getString("idealec");
					idealts = rSet.getString("idealts");
					idealtds = rSet.getString("idealtds");
					idealss = rSet.getString("idealss");
					idealDo = rSet.getString("idealdo");
					idealcod = rSet.getString("idealcod");
					idealsalinity = rSet.getString("idealsalinity");
					idealchloride = rSet.getString("idealchloride");
					idealturbidity = rSet.getString("idealturbidity");
					idealtotalhardness = rSet.getString("idealtotalhardness");
					idealoilandgrease = rSet.getString("idealoilandgrease");
					idealbod = rSet.getString("idealbod");
					remarks = rSet.getString("remarks");
				}
				subject = "Subject : "+ subject;
				reference = "Reference : "+ reference;
				sampledate = "Date : "+sampledate;
				remarks = "*Remarks : "+remarks;
				
				String orginallocation = "";
				query = "select location from watermonitoringregistration where type like 'Deep Tubewell' and name like "+"'"+ IndustryName +"'";
				rSet = stat.executeQuery(query);
				while(rSet.next()){
					orginallocation = rSet.getString("location");
				}
				if(orginallocation == null){
					orginallocation = "-";
				}
				orginallocation = " "+orginallocation;
				orginallocation = orginallocation.replaceAll("\n", " ");
				orginallocation = orginallocation.replaceAll("\r", " ");
				if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
						&& yearto == null) {
					industryquery = "select * from watermonitoringdeeptubledatainput where " + "deeptubewellname like " + "'"
							+ IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				} else {
					industryquery = "select * from watermonitoringdeeptubledatainput where " + "year like " + "'" + Yearfrom
							+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
							+ "' and deeptubewellname like " + "'" + IndustryName + "'";
					rSet = stat.executeQuery(industryquery);
				}
                
                
				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String tubewellname = rSet.getString("deeptubewellname");
					String labcode = rSet.getString("labcode");
					String tubewelllocation = rSet.getString("deeptubewelllocation");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");
					String id = rSet.getString("id");

					String fulldate;
                    if(tubewelllocation == null){
                    	tubewelllocation = "-";
                    }
                    tubewelllocation = " "+tubewelllocation;
					tubewelllocation = tubewelllocation.replaceAll("\n", " ");
					tubewelllocation = tubewelllocation.replaceAll("\r", " ");
					if (orginallocation.length() > 2) {
						tubewellname = "Name and Address of Deep Tubewell : "+tubewellname + " ( " + orginallocation + " ).";
					}
					else{
						tubewellname = "Name and Address of Deep Tubewell : "+tubewellname;
					}
					
					

					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}
					
					if(labcode == null || labcode == "")
						labcode = "-";
					if(tubewelllocation == null || tubewelllocation == "")
						tubewelllocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";

					fulldate = "Sample Collection Date : "+fulldate;
					id = "Memo No : "+ id;

					// //Adding into database
					String insertquery = "INSERT INTO watertubewellmonitoringindividualreport (date, name,  labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, remarks, location,  idealtemperature, idealph, idealec, idealts, idealtds, idealss, idealdo, idealcod, idealsalinity, idealchloride,  idealturbidity, idealtotalhardness, idealoilandgrease, idealbod,memono,sampledate,subject,reference,signaturetemplate,description)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, tubewellname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, remarks);
					preparedStatement.setString(19, tubewelllocation);
					preparedStatement.setString(20, idealtemperature);
					preparedStatement.setString(21, idealph);
					preparedStatement.setString(22, idealec);
					preparedStatement.setString(23, idealts);
					preparedStatement.setString(24, idealtds);
					preparedStatement.setString(25, idealss);
					preparedStatement.setString(26, idealDo);
					preparedStatement.setString(27, idealcod);
					preparedStatement.setString(28, idealsalinity);
					preparedStatement.setString(29, idealchloride);
					preparedStatement.setString(30, idealturbidity);
					preparedStatement.setString(31, idealtotalhardness);
					preparedStatement.setString(32, idealoilandgrease);
					preparedStatement.setString(33, idealbod);
					preparedStatement.setString(34, id);
					preparedStatement.setString(35, sampledate);
					preparedStatement.setString(36, subject);
					preparedStatement.setString(37, reference);
					preparedStatement.setString(38, signaturetemplate);
					preparedStatement.setString(39, description);

					preparedStatement.execute();

				}
				if(watermonitoringstandlimitfalse.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\watertubewellmonitoringindividualreportwithoutstandardlimit.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}
				if(watermonitoringstandardlimittrue.isSelected()){
					System.out.println("With Limit");
					JasperReport jr = JasperCompileManager
							.compileReport(reprotDirectory + "\\watertubewellmonitoringindividualreport.jrxml");
					JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
					JasperViewer.viewReport(jp, false);
				}

			}
			// Just for Showing not printing.
			else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null && IndustryName != null && IndustryName != "Refresh") {

				String deleteQuery = "delete from watermonitoringreporttuble";
				stat.execute(deleteQuery);

				industryquery = "select * from watermonitoringdeeptubledatainput where " + "deeptubewellname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);

				while (rSet.next()) {
					String DAY = rSet.getString("day");
					String MONTH = rSet.getString("month");
					String YEAR = rSet.getString("year");
					String indsutryname = rSet.getString("deeptubewellname");
					String labcode = rSet.getString("labcode");
					String riverlocation = rSet.getString("deeptubewelllocation");
					String id = rSet.getString("id");
					String temperature = rSet.getString("temperature");
					String ph = rSet.getString("ph");
					String ec = rSet.getString("ec");
					String ts = rSet.getString("ts");
					String tds = rSet.getString("tds");
					String ss = rSet.getString("ss");
					String Do = rSet.getString("do");
					String cod = rSet.getString("cod");

					String salinity = rSet.getString("salinity");
					String chloride = rSet.getString("chloride");
					String turbidity = rSet.getString("turbidity");
					String totalhardness = rSet.getString("totalhardness");
					String oilandgrease = rSet.getString("oilandgrease");
					String bod = rSet.getString("bod");

					String fulldate;
					if (DAY == null || MONTH == null || YEAR == null) {
						fulldate = " ";
					} else {
						fulldate = DAY + "." + MONTH + "." + YEAR;
					}
					
					if(labcode == null || labcode == "")
						labcode = "-";
					if(riverlocation == null || riverlocation == "")
						riverlocation = "-";
					if(ph == null || ph == "")
						ph = "-";
					if(ec == null || ec == "")
						ec = "-";
					if(ts == null || ts == "")
						ts = "-";
					if(tds == null || tds == "")
						tds = "-";
					if(ss == null || ss == "")
						ss = "-";
					if(Do == null || Do == "")
						Do = "-";
					if(cod == null || cod == "")
						cod = "-";
					if(salinity == null || salinity == "")
						salinity = "-";
					if(chloride == null || chloride == "")
						chloride = "-";
					if(turbidity == null || turbidity == "")
						turbidity = "-";
					if(totalhardness == null || totalhardness == "")
						totalhardness = "-";
					if(oilandgrease == null || oilandgrease == "")
						oilandgrease = "-";
					if(bod == null || bod == "")
						bod = "-";
					

					// //Adding into database
					String insertquery = "INSERT INTO watermonitoringreporttuble (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
					preparedStatement.setString(1, fulldate);
					preparedStatement.setString(2, indsutryname);
					preparedStatement.setString(3, labcode);
					preparedStatement.setString(4, temperature);
					preparedStatement.setString(5, ph);
					preparedStatement.setString(6, ec);
					preparedStatement.setString(7, ts);
					preparedStatement.setString(8, tds);
					preparedStatement.setString(9, ss);
					preparedStatement.setString(10, Do);
					preparedStatement.setString(11, cod);
					preparedStatement.setString(12, salinity);
					preparedStatement.setString(13, chloride);
					preparedStatement.setString(14, turbidity);
					preparedStatement.setString(15, totalhardness);
					preparedStatement.setString(16, oilandgrease);
					preparedStatement.setString(17, bod);
					preparedStatement.setString(18, riverlocation);
					preparedStatement.setString(19, id);

					preparedStatement.execute();

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreporttuble.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			} else {

				int Datefrom = Integer.parseInt(datefrom);
				int Monthfrom = Integer.parseInt(monthfrom);
				int Yearfrom = Integer.parseInt(yearfrom);
				int Dateto = Integer.parseInt(dateto);
				int Monthto = Integer.parseInt(monthto);
				int Yearto = Integer.parseInt(yearto);

				String deleteQuery = "delete from watermonitoringreporttuble";
				stat.execute(deleteQuery);

				for (int year = Yearfrom; year <= Yearto; year++) {

					for (int month = Monthfrom; month <= 12; month++) {

						for (int date = Datefrom; date <= 31; date++) {

							if (year == Yearto) {

								if (month > Monthto) {
									break;
								}
								if (month == Monthto) {
									if (date > Dateto) {
										break;
									}
								}
							}

							String query;

							if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null
									&& monthto != null && yearto != null && IndustryName != null
									&& IndustryName != "Refresh" && IndustryName != "All Data") {
								query = "select * from watermonitoringdeeptubledatainput where " + "year like " + "'"
										+ year + "' and month like " + "'" + month + "' and day like " + "'" + date
										+ "' and deeptubewellname like " + "'" + IndustryName + "'";
							} else {
								query = "select * from watermonitoringdeeptubledatainput where " + "year like " + "'"
										+ year + "' and month like " + "'" + month + "' and day like " + "'" + date
										+ "'";
							}

							rSet = stat.executeQuery(query);

							while (rSet.next()) {
								String DAY = rSet.getString("day");
								String MONTH = rSet.getString("month");
								String YEAR = rSet.getString("year");
								String indsutryname = rSet.getString("deeptubewellname");
								String labcode = rSet.getString("labcode");
								String riverlocation = rSet.getString("deeptubewelllocation");
								String id = rSet.getString("id");
								String temperature = rSet.getString("temperature");
								String ph = rSet.getString("ph");
								String ec = rSet.getString("ec");
								String ts = rSet.getString("ts");
								String tds = rSet.getString("tds");
								String ss = rSet.getString("ss");
								String Do = rSet.getString("do");
								String cod = rSet.getString("cod");

								String salinity = rSet.getString("salinity");
								String chloride = rSet.getString("chloride");
								String turbidity = rSet.getString("turbidity");
								String totalhardness = rSet.getString("totalhardness");
								String oilandgrease = rSet.getString("oilandgrease");
								String bod = rSet.getString("bod");

								String fulldate;
								if (DAY == null || MONTH == null || YEAR == null) {
									fulldate = " ";
								} else {
									fulldate = DAY + "." + MONTH + "." + YEAR;
								}

								if(labcode == null || labcode == "")
									labcode = "-";
								if(riverlocation == null || riverlocation == "")
									riverlocation = "-";
								if(ph == null || ph == "")
									ph = "-";
								if(ec == null || ec == "")
									ec = "-";
								if(ts == null || ts == "")
									ts = "-";
								if(tds == null || tds == "")
									tds = "-";
								if(ss == null || ss == "")
									ss = "-";
								if(Do == null || Do == "")
									Do = "-";
								if(cod == null || cod == "")
									cod = "-";
								if(salinity == null || salinity == "")
									salinity = "-";
								if(chloride == null || chloride == "")
									chloride = "-";
								if(turbidity == null || turbidity == "")
									turbidity = "-";
								if(totalhardness == null || totalhardness == "")
									totalhardness = "-";
								if(oilandgrease == null || oilandgrease == "")
									oilandgrease = "-";
								if(bod == null || bod == "")
									bod = "-";
								
								// //Adding into database
								String insertquery = "INSERT INTO watermonitoringreporttuble (date, name, labcode, temperature, ph, ec, ts, tds, ss, do, cod, salinity, chloride,  turbidity, totalhardness, oilandgrease, bod, location, serial)"
										+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								PreparedStatement preparedStatement = (PreparedStatement) con
										.prepareStatement(insertquery);
								preparedStatement.setString(1, fulldate);
								preparedStatement.setString(2, indsutryname);
								preparedStatement.setString(3, labcode);
								preparedStatement.setString(4, temperature);
								preparedStatement.setString(5, ph);
								preparedStatement.setString(6, ec);
								preparedStatement.setString(7, ts);
								preparedStatement.setString(8, tds);
								preparedStatement.setString(9, ss);
								preparedStatement.setString(10, Do);
								preparedStatement.setString(11, cod);
								preparedStatement.setString(12, salinity);
								preparedStatement.setString(13, chloride);
								preparedStatement.setString(14, turbidity);
								preparedStatement.setString(15, totalhardness);
								preparedStatement.setString(16, oilandgrease);
								preparedStatement.setString(17, bod);
								preparedStatement.setString(18, riverlocation);
								preparedStatement.setString(19, id);

								preparedStatement.execute();

							}
						}
						Datefrom = 1;

					}
					Monthfrom = 1;

				}
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\watermonitoringreporttuble.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);

			}

		}

	}

	// Water -> Industry -> Report Show
	@FXML
	public void actionwaterindustryreportshow(ActionEvent event) throws IOException {
		Stage primarysatge3 = new Stage();
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/waterindustryreportshow.fxml"));
		Scene scene3 = new Scene(root3, 1200, 600);
		primarysatge3.setScene(scene3);
		primarysatge3.show();
		primarysatge3.setResizable(false);
	}

	// Setting -> Ideal Values
	@FXML
	public void actionIdealValues(ActionEvent event) throws IOException {
		Stage primarysatge3 = new Stage();
		Parent root3 = FXMLLoader.load(getClass().getResource("/application/idealvalues.fxml"));
		Scene scene3 = new Scene(root3, 435, 478);
		primarysatge3.setScene(scene3);
		primarysatge3.setTitle("Ideal Value's Setting");
		primarysatge3.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarysatge3.setResizable(false);
		primarysatge3.show();
	}

	// Setting -> Activate Software
	@FXML
	public void actionactivatesoftware(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/activatesoftware.fxml"));
		Scene scene2 = new Scene(root2, 300, 100);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Software Activation");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();

	}

	@FXML
	public void actiondevelopedescription(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/developer.fxml"));
		Scene scene2 = new Scene(root2, 598, 267);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Developer's Description");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}

	@FXML
	public void actiontestfee(ActionEvent event) throws IOException {
		airtab.setDisable(true);
		airtab.setOpacity(0);
		watertab.setDisable(true);
		watertab.setOpacity(0);
		sweagetab.setDisable(true);
		sweagetab.setOpacity(0);
		soundtab.setDisable(true);
		soundtab.setOpacity(0);
		testfeetab.setDisable(false);
		testfeetab.setOpacity(1);

	}

	@FXML
	public void actionsound(ActionEvent event) {
		airtab.setDisable(true);
		airtab.setOpacity(0);
		watertab.setDisable(true);
		watertab.setOpacity(0);
		sweagetab.setDisable(true);
		sweagetab.setOpacity(0);
		soundtab.setDisable(false);
		soundtab.setOpacity(1);
		testfeetab.setDisable(true);
		testfeetab.setOpacity(0);
	}

	@FXML
	public void actionair(ActionEvent event) {
		airtab.setDisable(false);
		airtab.setOpacity(1);
		watertab.setDisable(true);
		watertab.setOpacity(0);
		sweagetab.setDisable(true);
		sweagetab.setOpacity(0);
		soundtab.setDisable(true);
		soundtab.setOpacity(0);
		testfeetab.setDisable(true);
		testfeetab.setOpacity(0);
	}

	@FXML
	public void actionwater(ActionEvent event) {
		airtab.setDisable(true);
		airtab.setOpacity(0);
		watertab.setDisable(false);
		watertab.setOpacity(1);
		sweagetab.setDisable(true);
		sweagetab.setOpacity(0);
		soundtab.setDisable(true);
		soundtab.setOpacity(0);
		testfeetab.setDisable(true);
		testfeetab.setOpacity(0);
	}

	@FXML
	public void actionsweage(ActionEvent event) {
		airtab.setDisable(true);
		airtab.setOpacity(0);
		watertab.setDisable(true);
		watertab.setOpacity(0);
		sweagetab.setDisable(false);
		sweagetab.setOpacity(1);
		soundtab.setDisable(true);
		soundtab.setOpacity(0);
		testfeetab.setDisable(true);
		testfeetab.setOpacity(0);
	}

	public void actionHelpAbout(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/About.fxml"));
		Scene scene2 = new Scene(root2, 598, 267);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("About");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}

	public void actioncleardatewaterindustry(ActionEvent event) {
		waterindustryreportdatefrom.setValue(null);
		waterindustryreportmonthfrom.setValue(null);
		waterindustryreportyearfrom.setValue(null);
		waterindustryreportdateto.setValue(null);
		waterindustryreportmonthto.setValue(null);
		waterindustryreportyearto.setValue(null);
	}

	public void actioncleardatewatermonitoring(ActionEvent event) {
		watermonitoringreportdatefrom.setValue(null);
		watermonitoringreportmonthfrom.setValue(null);
		watermonitoringreportyearfrom.setValue(null);
		watermonitoringreportdateto.setValue(null);
		watermonitoringreportmonthto.setValue(null);
		watermonitoringreportyearto.setValue(null);
	}

	public void actionwaterindustrystandardlimit(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/idealvalues.fxml"));
		Scene scene2 = new Scene(root2, 531, 679);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Standard Limit Setting For Industrial Water");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}

	public void actionwatermonitoringstandardlimit(ActionEvent event) throws IOException {
		if(watermonitoringreporttype.getValue() == "River" ){
			Stage primarystage2 = new Stage();
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/waterrivermonitoringidealvalues.fxml"));
			Scene scene2 = new Scene(root2, 531, 679);
			primarystage2.setScene(scene2);
			primarystage2.setTitle("Standard Limit Setting For River Water");
			primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
			primarystage2.setResizable(false);
			primarystage2.show();
		}
		if(watermonitoringreporttype.getValue() == "Sea" ){
			Stage primarystage2 = new Stage();
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/waterseamonitoringidealvalues.fxml"));
			Scene scene2 = new Scene(root2, 531, 679);
			primarystage2.setScene(scene2);
			primarystage2.setTitle("Standard Limit Setting For Sea Water");
			primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
			primarystage2.setResizable(false);
			primarystage2.show();
		}
		if(watermonitoringreporttype.getValue() == "Pond" ){
			Stage primarystage2 = new Stage();
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/waterpondmonitoringidealvalues.fxml"));
			Scene scene2 = new Scene(root2, 531, 679);
			primarystage2.setScene(scene2);
			primarystage2.setTitle("Standard Limit Setting For Pond Water");
			primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
			primarystage2.setResizable(false);
			primarystage2.show();
		}
		if(watermonitoringreporttype.getValue() == "Deep Tubewell" ){
			Stage primarystage2 = new Stage();
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/watertubewellmonitoringidealvalues.fxml"));
			Scene scene2 = new Scene(root2, 531, 679);
			primarystage2.setScene(scene2);
			primarystage2.setTitle("Standard Limit Setting For Tube Well Water");
			primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
			primarystage2.setResizable(false);
			primarystage2.show();
		}
		
	}
	
	public void actionwaterindustrycheckbox(ActionEvent event) {
		boolean check = ReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			reportdatetext.setText("Date From :");
			reportdatetotext.setVisible(true);
			reportdatetotext.setOpacity(1);
			waterindustryreportdateto.setVisible(true);
			waterindustryreportdateto.setOpacity(1);
			waterindustryreportmonthto.setVisible(true);
			waterindustryreportmonthto.setOpacity(1);
			waterindustryreportyearto.setVisible(true);
			waterindustryreportyearto.setOpacity(1);

			waterindustrystandlimitfalse.setVisible(false);
			waterindustrystandlimitfalse.setOpacity(0);
			waterindustrystandardlimittrue.setVisible(false);
			waterindustrystandardlimittrue.setOpacity(0);

		} else if (check) {
			reportdatetext.setText("Report For :");
			reportdatetotext.setVisible(false);
			reportdatetotext.setOpacity(0);
			waterindustryreportdateto.setVisible(false);
			waterindustryreportdateto.setOpacity(0);
			waterindustryreportmonthto.setVisible(false);
			waterindustryreportmonthto.setOpacity(0);
			waterindustryreportyearto.setVisible(false);
			waterindustryreportyearto.setOpacity(0);

			waterindustrystandardlimittrue.setSelected(true);
			waterindustrystandlimitfalse.setVisible(true);
			waterindustrystandlimitfalse.setOpacity(1);
			waterindustrystandardlimittrue.setVisible(true);
			waterindustrystandardlimittrue.setOpacity(1);
		}
	}
	
	public void actionwatermonitoringcheckbox(ActionEvent event) {
		boolean check = monitoringReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			monitoringreportdatetext.setText("Date From :");
			monitoringreportdatetotext.setVisible(true);
			monitoringreportdatetotext.setOpacity(1);
			
			watermonitoringreportdateto.setVisible(true);
			watermonitoringreportdateto.setOpacity(1);
			watermonitoringreportmonthto.setVisible(true);
			watermonitoringreportmonthto.setOpacity(1);
			watermonitoringreportyearto.setVisible(true);
			watermonitoringreportyearto.setOpacity(1);

			watermonitoringstandlimitfalse.setVisible(false);
			watermonitoringstandlimitfalse.setOpacity(0);
			watermonitoringstandardlimittrue.setVisible(false);
			watermonitoringstandardlimittrue.setOpacity(0);

		} else if (check) {
			monitoringreportdatetext.setText("Report For :");
			monitoringreportdatetotext.setVisible(false);
			monitoringreportdatetotext.setOpacity(0);
			
			watermonitoringreportdateto.setVisible(false);
			watermonitoringreportdateto.setOpacity(0);
			watermonitoringreportmonthto.setVisible(false);
			watermonitoringreportmonthto.setOpacity(0);
			watermonitoringreportyearto.setVisible(false);
			watermonitoringreportyearto.setOpacity(0);

			watermonitoringstandardlimittrue.setSelected(true);
			watermonitoringstandlimitfalse.setVisible(true);
			watermonitoringstandlimitfalse.setOpacity(1);
			watermonitoringstandardlimittrue.setVisible(true);
			watermonitoringstandardlimittrue.setOpacity(1);
		}
	}
	
}
