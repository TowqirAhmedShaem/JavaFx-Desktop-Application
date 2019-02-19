package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.application.Platform;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class airIndustryController implements Initializable{
	
	
	//Air ->Industry -> Report
	// All elements for air -> Industry -> Report
	@FXML
	public Label reportdatetext = new Label();
	@FXML
	public Button airindustrysettings= new Button();
	@FXML
	public Label reportdatetotext = new Label();
	@FXML
	public RadioButton airindustrystandlimitfalse = new RadioButton();
	@FXML
	public RadioButton airindustrystandardlimittrue = new RadioButton();
	@FXML
	public CheckBox ReportPrintingForOrganizationChecker = new CheckBox();
	
	@FXML
	public ComboBox<String> airindustryreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> airindustryreportindustryname = new ComboBox<>();
	

	// All elements for Air -> Industry -> Registration
	@FXML
	public ComboBox<String> airIndustryRegistrationType = new ComboBox<>();
	@FXML
	public TextArea airIndustryRegistrationLocation = new TextArea();
	@FXML
	public TextField airIndustryRegistrationName = new TextField();

	
	// All elements for Air -> Industry -> Data Input
	@FXML
	public CheckBox airindustrycheckbox = new CheckBox();
	@FXML
	public CheckBox airmonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> airIndustryDataInputDay = new ComboBox<>();
	@FXML
	public ComboBox<String> airIndustryDataInputMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> airIndustryDataInputYear = new ComboBox<>();
	@FXML
	public ComboBox<String> airIndustryDataInputType = new ComboBox<>();
	@FXML
	public ComboBox<String> airIndustryDataInputName = new ComboBox<>();
	@FXML
	public TextArea airIndustryDataInputLocation = new TextArea();
	@FXML
	public TextField airIndustryDataInputLabCode = new TextField();
	@FXML
	public TextField airIndustryDataInputSPM = new TextField();
	@FXML
	public TextField airIndustryDataInputSOx = new TextField();
	@FXML
	public TextField airIndustryDataInputNOx = new TextField();
	@FXML
	public TextField airIndustryDataInputCox = new TextField();
	@FXML
	public ComboBox<String> airindustrydatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<Integer> airindustryserialcombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> airIndustryDataInputSampleLocation = new ComboBox<>();
	@FXML
	public Label airindustryseriallabel ;
	@FXML
	public TextArea airIndustryDataInputRemarks = new TextArea();
	
	
	
	//Air ->Monitoring -> Report
	@FXML
	public Label monitoringreportdatetext = new Label();
	@FXML
	public Button airmonitoringsettings= new Button();
	@FXML
	public Label monitoringreportdatetotext = new Label();
	@FXML
	public RadioButton airmonitoringstandardlimitfalse = new RadioButton();
	@FXML
	public RadioButton airmonitoringstandardlimittrue = new RadioButton();
	@FXML
	public CheckBox monitoringReportPrintingForOrganizationChecker = new CheckBox();
	
	@FXML
	public ComboBox<String> airmonitoringreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> airmonitoringreportindustryname = new ComboBox<>();
	
	
	// All elements for air -> Monitoring -> Registration
	@FXML
	public ComboBox<String> airMonitoringRegistrationType = new ComboBox<>();
	@FXML
	public TextArea airMonitoringRegistrationLocation = new TextArea();
	@FXML
	public TextField airMonitoringRegistrationName = new TextField();

	
	// All elements for Air -> Monitoring -> Data Input
	@FXML
	public ComboBox<String> airDataInputMonitoringDAY = new ComboBox<>();
	@FXML
	public ComboBox<String> airDataInputMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> airDataInputMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> airDataInputMonitoringType = new ComboBox<>();
	@FXML
	public ComboBox<String> airDataInputMonitoringName = new ComboBox<>();
	@FXML
	public TextArea airDataInputMonitoringLocation = new TextArea();
	@FXML
	public TextField airDataInputMonitoringLabCode = new TextField();
	@FXML
	public TextField airDataInputMonitoringspm = new TextField();
	@FXML
	public TextField airDataInputMonitoringcox = new TextField();
	@FXML
	public TextField airDataInputMonitoringnox = new TextField();
	@FXML
	public TextField airDataInputMonitoringsox = new TextField();
	@FXML
	public ComboBox<String> airmonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<Integer> airmonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label airmonitoringseriallabel ;
	
	// Directory
	public String reprotDirectory = "C:\\Govt_Environment\\report";
	
	
	// All list for combobox
	ObservableList<String> airindustrynamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> airindustrynameFilteredlistforreport = new FilteredList<String>(airindustrynamelistforreport, p -> true);
	
	ObservableList<String> airindustrysamplelocationlist = FXCollections.observableArrayList("South side of factory", "North side of factory", "East side of factory", "West side of factory");
	ObservableList<String> airmonitoringnamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> airmonitoringnamefilteredlistforreport = new FilteredList<String>(airmonitoringnamelistforreport, p -> true);
	
	ObservableList<String> AirIndsutryRegistrationTypelist = FXCollections.observableArrayList("Refresh", "Sugar(Production ≥ 50 Ton)", "Sugar(Production< 50 Ton)", "Tannery", "Cement",
			"Architect", "Fertilizer", "Pulp & Paper", "Distillery", "Embrodery", "Decorator", "Ceramic", "Weaving");
	
	ObservableList<String> airindustrynamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> airindustrynameFilteredlist = new FilteredList<String>(airindustrynamelist, p -> true);
	
	ObservableList<String> airindustrytypelist = FXCollections.observableArrayList();
	ObservableList<String> day = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31");
	ObservableList<String> month = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12");
	ObservableList<String> year = FXCollections.observableArrayList("2020", "2019", "2018", "2017", "2016", "2015",
			"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002",
			"2001", "2000");
	
	ObservableList<String> airmonitoringtypelist = FXCollections.observableArrayList("Refresh", "Market", "Institution");
	ObservableList<String> airmonitoringdatainputnamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> airmonitoringdatainputfilterednamelist = new FilteredList<String>(airmonitoringdatainputnamelist, p -> true);
	
	ObservableList<String> airmonitoringdatainputtypelist = FXCollections.observableArrayList();
	
	ObservableList<String> airindustrydatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> airindustrydatainputidlist = FXCollections.observableArrayList();
	ObservableList<String> airmonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> airmonitoringdatainputidlist = FXCollections.observableArrayList();
	
	
	
	// All Variables
	public String AirIndustryFullData = "Shaem";
	public String AirMonitoringFullData = "Shaem";
	public String airIndustryDataConvertingType = "";
	public String airMonitoringDataConvertingType = "";
	
	public String reportfullData = "null";
	public String monitoringreportfullData = "null";
	
	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;
	
	
	public airIndustryController() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/environementoffice", "root", "");
			con = DriverManager.getConnection("jdbc:mysql://192.168.0.215:3306/environementoffice", "office", "ajmstt");
			stat = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		airIndustryRegistrationType.setItems(AirIndsutryRegistrationTypelist);
		airIndustryDataInputDay.setItems(day);
		airIndustryDataInputMonth.setItems(month);
		airIndustryDataInputYear.setItems(year);
		airIndustryDataInputType.setItems(airindustrytypelist);
		airIndustryDataInputSampleLocation.setItems(airindustrysamplelocationlist);
		
		airMonitoringRegistrationType.setItems(airmonitoringtypelist);
		airDataInputMonitoringDAY.setItems(day);
		airDataInputMonitoringMonth.setItems(month);
		airDataInputMonitoringYear.setItems(year);
		
		airindustrydatacombobox.setItems(airindustrydatacovertingtype);
		airindustrydatacombobox.setValue("Add");
		airindustryserialcombobox.setDisable(true);
		airindustryserialcombobox.setOpacity(0);

		airmonitoringdatacombobox.setItems(airmonitoringdatacovertingtype);
		airmonitoringdatacombobox.setValue("Add");
		airmonitoringserialcombobox.setDisable(true);
		airmonitoringserialcombobox.setOpacity(0);
		
		airindustryreportdatefrom.setItems(day);
		airindustryreportmonthfrom.setItems(month);
		airindustryreportyearfrom.setItems(year);
		airindustryreportdateto.setItems(day);
		airindustryreportmonthto.setItems(month);
		airindustryreportyearto.setItems(year);
		
		airmonitoringreportdatefrom.setItems(day);
		airmonitoringreportmonthfrom.setItems(month);
		airmonitoringreportyearfrom.setItems(year);
		airmonitoringreportdateto.setItems(day);
		airmonitoringreportmonthto.setItems(month);
		airmonitoringreportyearto.setItems(year);
		
		
		
		actionAirIndustryReportIndustryNameCombobox(null);
		airindustryreportindustryname.setItems(airindustrynamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // air -> Report -> Industryname
	    airindustryreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionAirIndustryReportIndustryNameCombobox(null, newValue));
	    
		
		actionAirMonitoringReportIndustryNameCombobox(null);
		airmonitoringreportindustryname.setItems(airmonitoringnamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // air -> Report -> Monitoring name
		airmonitoringreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionAirMonitoringReportIndustryNameCombobox(null, newValue));
		
		// Air -> Industry -> Registration for adding items in initialize
		actionAirIndustryRegistrationIndustryTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In Air -> Industry -> Registration 
		airIndustryRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionAirIndustryRegistrationIndustryTypeComboboxForInitialize());
		
		//Air -> Industry -> Data Input for adding Industry Names in initialize
		actionAirIndustryDataInputIndustryNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In Air -> Industry -> Data Input 
		airIndustryDataInputName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionAirIndustryDataInputIndustryNameCombobox(null, newValue));
		
		// Air -> Monitoring -> Registration -> Industry Type for Initialize
		actionAirMonitoringRegistrationTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In Air -> Monitoring -> Registration 
		airMonitoringRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionAirMonitoringRegistrationTypeComboboxForInitialize());
		
		//Air -> Monitoring -> Data Input for adding Industry Names in initialize
		AirMonitoringDataInputNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In air -> Monitoring -> Data Input 
		airDataInputMonitoringName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		AirMonitoringDataInputNameCombobox(null, newValue));
		
		//Listener for Data converting type Air -> Industry -> Data Input -> Data converting combobox
	    airindustrydatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
	    AirIndustryDataInputConverting(null, newValue));
	    
		//Listener for Serial No Air -> Industry -> Data Input -> Data converting combobox
		airindustryserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		AirIndustryDataLoadingforcorrespondingserialno(null, newValue));
		
		//Listener for Data converting type Air -> Monitoring -> Data Input -> Data converting combobox
	    airmonitoringdatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
	    AirMonitoringDataInputConverting(null, newValue));
	    
		//Listener for Serial No Air -> Monitoring -> Data Input -> Data converting combobox
		airmonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		AirMonitoringDataLoadingforcorrespondingserialno(null, newValue));
		
		//Searching or Filtering
		
		airIndustryDataInputName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = airIndustryDataInputName.getEditor();
            final String selected = airIndustryDataInputName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	airindustrynameFilteredlist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		airIndustryDataInputName.setItems(airindustrynameFilteredlist);
		
		airDataInputMonitoringName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = airDataInputMonitoringName.getEditor();
            final String selected = airDataInputMonitoringName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	airmonitoringdatainputfilterednamelist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		airDataInputMonitoringName.setItems(airmonitoringdatainputfilterednamelist);
		
		
		airindustryreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = airindustryreportindustryname.getEditor();
            final String selected = airindustryreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	airindustrynameFilteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		airindustryreportindustryname.setItems(airindustrynameFilteredlistforreport);
		
		airmonitoringreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = airmonitoringreportindustryname.getEditor();
            final String selected = airmonitoringreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	airmonitoringnamefilteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		airmonitoringreportindustryname.setItems(airmonitoringnamefilteredlistforreport);
		
		// Industry report radio button setup
		airindustrystandlimitfalse.setVisible(false);
		airindustrystandlimitfalse.setOpacity(0);
		airindustrystandardlimittrue.setVisible(false);
		airindustrystandardlimittrue.setOpacity(0);
		airindustrysettings.setVisible(false);
		airindustrysettings.setOpacity(0);
		
		
		// Monitoring report radio button setup
		airmonitoringstandardlimitfalse.setVisible(false);
		airmonitoringstandardlimitfalse.setOpacity(0);
		airmonitoringstandardlimittrue.setVisible(false);
		airmonitoringstandardlimittrue.setOpacity(0);
		airmonitoringsettings.setVisible(false);
		airmonitoringsettings.setOpacity(0);
		
		
		
		
	}
	
	
	
	public void actionAirIndustryReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from airindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					airindustrynamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionAirMonitoringReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from airmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					airmonitoringnamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	
	public void actionAirIndustryReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from airindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					airindustrynamelistforreport.add(item);
					airindustryreportindustryname.setItems(airindustrynamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}

	public void actionAirMonitoringReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from airmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					airmonitoringnamelistforreport.add(item);
					airmonitoringreportindustryname.setItems(airmonitoringnamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}

	
	//********Industry Registration( Starts )*******//
	
	// Air -> Industry -> Registration -> Industry Type for Initialize
	public void actionAirIndustryRegistrationIndustryTypeComboboxForInitialize() {
		try {
			String query = "select * from airindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (AirIndsutryRegistrationTypelist.contains(item)) {
				} 
				else {
					AirIndsutryRegistrationTypelist.add(item);
				}
			}
			airIndustryRegistrationType.setItems(AirIndsutryRegistrationTypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	@FXML
	public void actionAirIndustryRegistrationSaveButton(ActionEvent event) throws SQLException{
		String Industrytype = airIndustryRegistrationType.getValue();
		String IndustryName = airIndustryRegistrationName.getText();
		String IndsutryLocation = airIndustryRegistrationLocation.getText();

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
			String query = "INSERT INTO airindustryregistration (industrytype, industryname, industrylocation)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, Industrytype);
			preparedStatement.setString(2, IndustryName);
			preparedStatement.setString(3, IndsutryLocation);
			preparedStatement.execute();

			airIndustryRegistrationType.setValue(null);
			airIndustryRegistrationName.setText(null);
			airIndustryRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}

	}
	
	//********Industry Registration( ENDS )*******//
	//********Industry Data Input( Starts )*******//
	
	public void actionAirIndustryDataInputIndustryNameCombobox() {
		try {
			String query = "select * from airindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (AirIndustryFullData.contains(item)) {
				} else {
					AirIndustryFullData += item;
					airindustrynamelist.add(item);
				}
			}
			airIndustryDataInputName.setItems(airindustrynamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionAirIndustryDataInputIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from airindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (AirIndustryFullData.contains(item)) {
				} else {
					AirIndustryFullData += item;
					airindustrynamelist.add(item);
					airIndustryDataInputName.setItems(airindustrynamelist);
				}
			}
			airindustrytypelist.clear();
			query = "select * from airindustryregistration where " + "industryname like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				String item2 = rSet.getString("industrylocation");
				airindustrytypelist.add(item);
				airIndustryDataInputType.setItems(airindustrytypelist);
				airIndustryDataInputLocation.setText(item2);
			}
			
			String dataconvertingtype = airindustrydatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				airindustrydatainputidlist.clear();
				query = "select id from airindustrydatainput where " + "indsutryname like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					airindustrydatainputidlist.add(item);
					airindustryserialcombobox.setItems(airindustrydatainputidlist);
				}
			}

			

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	

	// air -> Industry -> Data Input -> Loading for corresponding serial no to edit.
	public void AirIndustryDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = airindustrydatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from airindustrydatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					//day, month, year, indsutryname, location, labcode, indsutrtype, airlevel, remarks
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String indsutryname = rSet.getString("indsutryname");
					String location = rSet.getString("location");
					String samplelocation = rSet.getString("samplelocation");
					String labcode = rSet.getString("labcode");
					String indsutrytype = rSet.getString("indsutrtype");
					String sox = rSet.getString("sox");
					String spm = rSet.getString("spm");
					String nox = rSet.getString("nox");
					String cox = rSet.getString("cox");
					String remarks = rSet.getString("remarks");				
					
					airIndustryDataInputDay.setValue(day);
					airIndustryDataInputMonth.setValue(month);
					airIndustryDataInputYear.setValue(year);
					airIndustryDataInputType.setValue(indsutrytype);
					airIndustryDataInputLabCode.setText(labcode);
					airIndustryDataInputLocation.setText(location);
					airIndustryDataInputSampleLocation.setValue(samplelocation);
					airIndustryDataInputSOx.setText(sox);
					airIndustryDataInputSPM.setText(spm);
					airIndustryDataInputNOx.setText(nox);
					airIndustryDataInputCox.setText(cox);
					airIndustryDataInputRemarks.setText(remarks);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
	}

	
	@FXML
	public void actionAirIndustryDataInputSaveButton(ActionEvent event){
		boolean checkbox = airindustrycheckbox.isSelected();
		
		String day = airIndustryDataInputDay.getValue();
		String Month = airIndustryDataInputMonth.getValue();
		String Year = airIndustryDataInputYear.getValue();
		String IndustryName = airIndustryDataInputName.getValue();
		String Labcode = airIndustryDataInputLabCode.getText();
		String Location = airIndustryDataInputLocation.getText();
		String samplelocation = airIndustryDataInputSampleLocation.getValue();
		String IndustryType = airIndustryDataInputType.getValue();
		String spm = airIndustryDataInputSPM.getText();
		String sox = airIndustryDataInputSOx.getText();
		String nox = airIndustryDataInputNOx.getText();
		String cox = airIndustryDataInputCox.getText();
		String Remarks = airIndustryDataInputRemarks.getText();
		

		String AirIndustryDataConvertingType = airindustrydatacombobox.getValue();

		if (IndustryName != "Refresh" && IndustryName.length() > 1 && AirIndustryDataConvertingType == "Add") {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO airindustrydatainput (day, month, year, indsutryname, location, labcode, indsutrtype, spm, sox, nox, cox, remarks, samplelocation)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, IndustryType);
				preparedStatement.setString(8, spm);
				preparedStatement.setString(9, sox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, cox);
				preparedStatement.setString(12, Remarks);
				preparedStatement.setString(13, samplelocation);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				
				if(checkbox){
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
				}
				else{
					//Clearing all items after data Editiing
					airIndustryDataInputDay.setValue(null);
					airIndustryDataInputMonth.setValue(null);
					airIndustryDataInputYear.setValue(null);
					airIndustryDataInputType.setValue(null);
					airIndustryDataInputName.setValue(null);
					airIndustryDataInputLocation.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
					airIndustryDataInputLabCode.setText(null);
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
				}

				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}

		
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && AirIndustryDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = airindustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update airindustrydatainput set day=?,month=?,year=?,indsutryname=?,indsutrtype=?,location=?,labcode=?,spm=?,sox=?,nox=?,cox=?,remarks=?,samplelocation=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, IndustryType);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, spm);
				preparedStatement.setString(9, sox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, cox);
				preparedStatement.setString(12, Remarks);
				preparedStatement.setString(13, samplelocation);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					airIndustryDataInputDay.setValue(null);
					airIndustryDataInputMonth.setValue(null);
					airIndustryDataInputYear.setValue(null);
					airIndustryDataInputType.setValue(null);
					airIndustryDataInputLocation.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
					airIndustryDataInputLabCode.setText(null);
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
				}
				else{
					//Clearing all items after data Editiing
					airIndustryDataInputDay.setValue(null);
					airIndustryDataInputMonth.setValue(null);
					airIndustryDataInputYear.setValue(null);
					airIndustryDataInputType.setValue(null);
					airIndustryDataInputName.setValue(null);
					airIndustryDataInputLocation.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
					airIndustryDataInputLabCode.setText(null);
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && AirIndustryDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = airindustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from airindustrydatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data Deleting
				if(checkbox){
					airIndustryDataInputDay.setValue(null);
					airIndustryDataInputMonth.setValue(null);
					airIndustryDataInputYear.setValue(null);
					airIndustryDataInputType.setValue(null);
					airIndustryDataInputLocation.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
					airIndustryDataInputLabCode.setText(null);
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
				}
				else{
					//Clearing all items after data Editiing
					airIndustryDataInputDay.setValue(null);
					airIndustryDataInputMonth.setValue(null);
					airIndustryDataInputYear.setValue(null);
					airIndustryDataInputType.setValue(null);
					airIndustryDataInputName.setValue(null);
					airIndustryDataInputLocation.setText(null);
					airIndustryDataInputSampleLocation.setValue(null);
					airIndustryDataInputLabCode.setText(null);
					airindustryserialcombobox.setValue(null);
					airIndustryDataInputSPM.setText(null);
					airIndustryDataInputSOx.setText(null);
					airIndustryDataInputNOx.setText(null);
					airIndustryDataInputCox.setText(null);
					airIndustryDataInputRemarks.setText(null);
				}
				
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Texfields. Thank You!");
			alert.showAndWait();
		}
	}
	// Air -> Industry -> Data Input -> Data Converting Comboobox
	public void AirIndustryDataInputConverting(ActionEvent event, String value) {
    
		airIndustryDataConvertingType = airindustrydatacombobox.getValue();
		if(airIndustryDataConvertingType == "Add"){
			airindustryserialcombobox.setDisable(true);
			airindustryserialcombobox.setOpacity(0);
			airindustryseriallabel.setDisable(true);
			airindustryseriallabel.setOpacity(0);
		}
		if(airIndustryDataConvertingType ==  "Edit"){
			airindustryserialcombobox.setDisable(false);
			airindustryserialcombobox.setOpacity(1);
			airindustryseriallabel.setDisable(false);
			airindustryseriallabel.setOpacity(1);
		}
		if(airIndustryDataConvertingType == "Delete"){
			airindustryserialcombobox.setDisable(false);
			airindustryserialcombobox.setOpacity(1);
			airindustryseriallabel.setDisable(false);
			airindustryseriallabel.setOpacity(1);
		}

	}
	
	//********Industry Data Input( ENDS )*******//
	
	//********Monitoring Registration( Starts )*******//
	// Air -> Monitoring -> Registration -> Industry Type for Initialize
	public void actionAirMonitoringRegistrationTypeComboboxForInitialize() {
		try {
			String query = "select * from airmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("type");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (airmonitoringtypelist.contains(item)) {
				} 
				else {
					airmonitoringtypelist.add(item);
				}
			}
			airMonitoringRegistrationType.setItems(airmonitoringtypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	@FXML
	public void actionairMonitoringRegistrationSave(ActionEvent event) throws SQLException{
		String type = airMonitoringRegistrationType.getValue();
		String Name = airMonitoringRegistrationName.getText();
		String Location = airMonitoringRegistrationLocation.getText();

		// checking whether all textbox are fill up or not
		if (type == null || Name == null || Location == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setHeaderText("You have an error !!");
			alert.setContentText("Please fill up all Textbox. Thank You!");
			alert.showAndWait();
		}
		// Database storing
		else {
			String query = "INSERT INTO airmonitoringregistration (type, name, location)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, type);
			preparedStatement.setString(2, Name);
			preparedStatement.setString(3, Location);
			preparedStatement.execute();

			airMonitoringRegistrationType.setValue(null);
			airMonitoringRegistrationName.setText(null);
			airMonitoringRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}
	}
	//********Monitoring Registration( ENDS )*******//
	
	//********Monitoring Data Input( Starts )*******//
	public void AirMonitoringDataInputNameCombobox() {
		try {
			String query = "select * from airmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (AirMonitoringFullData.contains(item)) {
				} else {
					AirMonitoringFullData += item;
					airmonitoringdatainputnamelist.add(item);
				}
			}
			airDataInputMonitoringName.setItems(airmonitoringdatainputnamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}
	}
	
	public void AirMonitoringDataInputNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from airmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (AirMonitoringFullData.contains(item)) {
				} else {
					AirMonitoringFullData += item;
					airmonitoringdatainputnamelist.add(item);
					airDataInputMonitoringName.setItems(airmonitoringdatainputnamelist);
				}
			}
			query = "select * from airmonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			airmonitoringdatainputtypelist.clear();
			while (rSet.next()) {
				String item = rSet.getString("type");
				String item2 = rSet.getString("location");
				airmonitoringdatainputtypelist.add(item);
				airDataInputMonitoringType.setItems(airmonitoringdatainputtypelist);
				airDataInputMonitoringLocation.setText(item2);
			}
			
			String dataconvertingtype = airmonitoringdatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				airmonitoringdatainputidlist.clear();
				query = "select id from airmonitoringdatainput where " + "name like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					airmonitoringdatainputidlist.add(item);
					airmonitoringserialcombobox.setItems(airmonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	

	// air -> Monitoring -> Data Input -> Loading for corresponding serial no to edit.
	public void AirMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = airmonitoringdatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from airmonitoringdatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				System.out.println(rSet);
				while (rSet.next()) {
					//day, month, year, indsutryname, location, labcode, indsutrtype, airlevel, remarks
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String name = rSet.getString("name");
					String location = rSet.getString("location");
					String labcode = rSet.getString("labcode");
					String type = rSet.getString("type");
					String sox = rSet.getString("sox");
					String spm = rSet.getString("spm");
					String nox = rSet.getString("nox");
					String cox = rSet.getString("cox");
								
					System.out.println(day);
					airDataInputMonitoringDAY.setValue(day);
					airDataInputMonitoringMonth.setValue(month);
					airDataInputMonitoringYear.setValue(year);
					airDataInputMonitoringType.setValue(type);
					airDataInputMonitoringLabCode.setText(labcode);
					airDataInputMonitoringLocation.setText(location);
					airDataInputMonitoringsox.setText(sox);
					airDataInputMonitoringspm.setText(spm);
					airDataInputMonitoringnox.setText(nox);
					airDataInputMonitoringcox.setText(cox);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
	}
	
	
	@FXML
	public void actionairDataInputMonitoringSave(ActionEvent event){
		boolean checkbox = airmonitoringcheckbox.isSelected();
		
		System.out.println("Monitoring Save");
		String AirMonitoringDataConvertingType = airmonitoringdatacombobox.getValue();
		System.out.println(AirMonitoringDataConvertingType);
		
		String day = airDataInputMonitoringDAY.getValue();
		String Month = airDataInputMonitoringMonth.getValue();
		String Year = airDataInputMonitoringYear.getValue();
		String Name = airDataInputMonitoringName.getValue();
		String Labcode = airDataInputMonitoringLabCode.getText();
		String Location = airDataInputMonitoringLocation.getText();
		String Type = airDataInputMonitoringType.getValue();
		String spm = airDataInputMonitoringspm.getText();
		String sox = airDataInputMonitoringsox.getText();
		String nox = airDataInputMonitoringnox.getText();
		String cox = airDataInputMonitoringcox.getText();
		if (Name != "Refresh" && Name.length() > 1 && AirMonitoringDataConvertingType == "Add") {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO airmonitoringdatainput (day, month, year, name, location, labcode, type, spm, sox, nox, cox)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Type);
				preparedStatement.setString(8, spm);
				preparedStatement.setString(9, sox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, cox);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				else{
					airDataInputMonitoringDAY.setValue(null);
					airDataInputMonitoringMonth.setValue(null);
					airDataInputMonitoringYear.setValue(null);
					airDataInputMonitoringType.setValue(null);
					airDataInputMonitoringName.setValue(null);
					airDataInputMonitoringLocation.setText(null);
					airDataInputMonitoringLabCode.setText(null);
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} 
		else if (Name != "Refresh" && Name.length() > 1 && AirMonitoringDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = airmonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update airmonitoringdatainput set day=?,month=?,year=?,name=?,type=?,location=?,labcode=?,spm=?,sox=?,nox=?,cox=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Type);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, spm);
				preparedStatement.setString(9, sox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, cox);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					airDataInputMonitoringDAY.setValue(null);
					airDataInputMonitoringMonth.setValue(null);
					airDataInputMonitoringYear.setValue(null);
					airDataInputMonitoringType.setValue(null);
					airDataInputMonitoringLocation.setText(null);
					airDataInputMonitoringLabCode.setText(null);
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				else{
					airDataInputMonitoringDAY.setValue(null);
					airDataInputMonitoringMonth.setValue(null);
					airDataInputMonitoringYear.setValue(null);
					airDataInputMonitoringType.setValue(null);
					airDataInputMonitoringName.setValue(null);
					airDataInputMonitoringLocation.setText(null);
					airDataInputMonitoringLabCode.setText(null);
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (Name != "Refresh" && Name.length() > 1 && AirMonitoringDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = airmonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from airmonitoringdatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					airDataInputMonitoringDAY.setValue(null);
					airDataInputMonitoringMonth.setValue(null);
					airDataInputMonitoringYear.setValue(null);
					airDataInputMonitoringType.setValue(null);
					airDataInputMonitoringLocation.setText(null);
					airDataInputMonitoringLabCode.setText(null);
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				else{
					airDataInputMonitoringDAY.setValue(null);
					airDataInputMonitoringMonth.setValue(null);
					airDataInputMonitoringYear.setValue(null);
					airDataInputMonitoringType.setValue(null);
					airDataInputMonitoringName.setValue(null);
					airDataInputMonitoringLocation.setText(null);
					airDataInputMonitoringLabCode.setText(null);
					airmonitoringserialcombobox.setValue(null);
					airDataInputMonitoringspm.setText(null);
					airDataInputMonitoringsox.setText(null);
					airDataInputMonitoringnox.setText(null);
					airDataInputMonitoringcox.setText(null);
				}
				
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Information Message");
			alert.setContentText("Please fill up all Texfields. Thank You!");
			alert.showAndWait();
		}

	}
	
	// Air -> Monitoring -> Data Input -> Data Converting Comboobox
	public void AirMonitoringDataInputConverting(ActionEvent event, String value) {
    
		airMonitoringDataConvertingType = airmonitoringdatacombobox.getValue();
		if(airMonitoringDataConvertingType == "Add"){
			airmonitoringserialcombobox.setDisable(true);
			airmonitoringserialcombobox.setOpacity(0);
			airmonitoringseriallabel.setDisable(true);
			airmonitoringseriallabel.setOpacity(0);
		}
		if(airMonitoringDataConvertingType ==  "Edit"){
			airmonitoringserialcombobox.setDisable(false);
			airmonitoringserialcombobox.setOpacity(1);
			airmonitoringseriallabel.setDisable(false);
			airmonitoringseriallabel.setOpacity(1);
		}
		if(airMonitoringDataConvertingType == "Delete"){
			airmonitoringserialcombobox.setDisable(false);
			airmonitoringserialcombobox.setOpacity(1);
			airmonitoringseriallabel.setDisable(false);
			airmonitoringseriallabel.setOpacity(1);
		}

	}
	
	
	//********Monitoring Data Input( ENDS )*******//
	
	// Air -> Industry -> Report
	@FXML 
	public void actionAirIndustryReport(ActionEvent event) throws JRException, SQLException{
		boolean reportPrintingForOrganization = ReportPrintingForOrganizationChecker.isSelected();
		
		String industryquery;
		String datefrom = airindustryreportdatefrom.getValue();
		String monthfrom = airindustryreportmonthfrom.getValue();
		String yearfrom = airindustryreportyearfrom.getValue();
		String dateto = airindustryreportdateto.getValue();
		String monthto = airindustryreportmonthto.getValue();
		String yearto = airindustryreportyearto.getValue();
		String IndustryName = airindustryreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from airindustryreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from airindustrydatainput";
			rSet = stat.executeQuery(allDataQuery);
			
			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("indsutryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("indsutrtype");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO airindustryreport (date, indsutryname, indsutrtype,  labcode,  spm, sox, nox , cox, remarks, location, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, remarks);
				preparedStatement.setString(10, indsutrylocation);
				preparedStatement.setString(11, samplelocation);
				preparedStatement.setString(12, serial);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
        }
        else if ( (datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
				|| yearto == null )&& IndustryName == null) {
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

			String deleteQuery = "delete from airindustryindividualreport";
			stat.execute(deleteQuery);

			String idealspm = "-";
			String idealsox = "-";
			String idealnox = "-";
			String idealcox = "-";
			String sampledate = "-";
			String subject ="-";
			String reference = "-";
			String signaturetemplate = "-";
			String description = "-";
			String remarks = "-";

			String query = "select * from airindustrystandarddatasave";

			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				sampledate = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				reference = rSet.getString("reference");
				signaturetemplate = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				idealspm = rSet.getString("idealspm");
				idealsox = rSet.getString("idealsox");
				idealnox = rSet.getString("idealnox");
				idealcox = rSet.getString("idealcox");
				remarks = rSet.getString("remarks");
			}
			
			subject = "Subject : "+ subject;
			reference = "Reference : "+ reference;
			sampledate = "Date : "+sampledate;
			remarks = "*Remarks : "+remarks;

			if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null) {
				industryquery = "select * from airindustrydatainput where " + "indsutryname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			} else {
				industryquery = "select * from airindustrydatainput where " + "year like " + "'" + Yearfrom
						+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
						+ "' and indsutryname like " + "'" + IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			}

			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("indsutryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("indsutrtype");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				String id = rSet.getString("id");

				String fulldate;
				if(indsutrylocation == null){
					indsutrylocation = "-";
				}
				if(samplelocation == null){
					samplelocation = "-";
				}
				indsutrylocation = " "+indsutrylocation;
				samplelocation = " "+ samplelocation;
				
				samplelocation = samplelocation.replaceAll("\n", " ");
				samplelocation = samplelocation.replaceAll("\r", " ");
				
				indsutrylocation = indsutrylocation.replaceAll("\n", " ");
				indsutrylocation = indsutrylocation.replaceAll("\r", " ");
				if (indsutrylocation.length() > 2) {
					indsutryname = "Name and Address of Applicant/Organization : "+IndustryName + " ( " + indsutrylocation + " ).";
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
				if(spm == null || spm == "")
					spm = "-";
				if(sox == null || sox == "")
					sox = "-";
				if(nox == null || nox == "")
					nox = "-";
				if(cox == null || cox == "")
					cox = "-";
				if(remarks == null || remarks == "")
					remarks = "-";

				fulldate = "Sample Collection Date : "+fulldate;
				id = "Memo No : "+ id;

				// //Adding into database
				String insertquery = "INSERT INTO airindustryindividualreport (date, industryname, industrytype,  labcode, spm, sox ,nox, cox , remarks, location, samplelocation,  idealspm, idealsox, idealnox, idealcox, memono,sampledate,subject,reference,signaturetemplate,description)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, remarks);
				preparedStatement.setString(10, indsutrylocation);
				preparedStatement.setString(11, samplelocation);
				preparedStatement.setString(12, idealspm);
				preparedStatement.setString(13, idealsox);
				preparedStatement.setString(14, idealnox);
				preparedStatement.setString(15, idealcox);
				preparedStatement.setString(16, id);
				preparedStatement.setString(17, sampledate);
				preparedStatement.setString(18, subject);
				preparedStatement.setString(19, reference);
				preparedStatement.setString(20, signaturetemplate);
				preparedStatement.setString(21, description);

				preparedStatement.execute();

			}
			if(airindustrystandlimitfalse.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\airindustryindividualreportwithoutstandardlimt.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}
			if(airindustrystandardlimittrue.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\airindustryindividualreport.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

		}
		// Just for Showing not printing.
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from airindustryreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from airindustrydatainput where " +  "indsutryname like " + "'" + IndustryName + "'";
			rSet = stat.executeQuery(industryquery);
			
			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("indsutryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String samplelocation = rSet.getString("samplelocation");
				String indsutrytype = rSet.getString("indsutrtype");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO airindustryreport (date, indsutryname, indsutrtype,  labcode,  spm, sox, nox , cox, remarks, location, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, remarks);
				preparedStatement.setString(10, indsutrylocation);
				preparedStatement.setString(11, samplelocation);
				preparedStatement.setString(12, serial);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
		}
		else {

			int	Datefrom = Integer.parseInt(datefrom);
			int	Monthfrom = Integer.parseInt(monthfrom);
			int	Yearfrom = Integer.parseInt(yearfrom);
			int	Dateto = Integer.parseInt(dateto);
			int	Monthto = Integer.parseInt(monthto);
			int	Yearto = Integer.parseInt(yearto);

			
			
			String deleteQuery = "delete from airindustryreport";
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
			
						if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null && monthto != null
								&& yearto != null && IndustryName != null && IndustryName != "Refresh" && IndustryName != "All Data") {
							query = "select * from airindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and indsutryname like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from airindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
						}
						

			
						rSet = stat.executeQuery(query);
						
						while (rSet.next()) {
							String serial = rSet.getString("id");
							String DAY = rSet.getString("day");
							String MONTH = rSet.getString("month");
							String YEAR = rSet.getString("year");
							String indsutryname = rSet.getString("indsutryname");
							String labcode = rSet.getString("labcode");
							String indsutrylocation = rSet.getString("location");
							String samplelocation = rSet.getString("samplelocation");
							String indsutrytype = rSet.getString("indsutrtype");
							String spm = rSet.getString("spm");
							String sox = rSet.getString("sox");
							String nox = rSet.getString("nox");
							String cox = rSet.getString("cox");
							String remarks = rSet.getString("remarks");

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							

							// //Adding into database
							String insertquery = "INSERT INTO airindustryreport (date, indsutryname, indsutrtype,  labcode,  spm, sox, nox , cox, remarks, location, samplelocation, serial)"
									+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, spm);
							preparedStatement.setString(6, sox);
							preparedStatement.setString(7, nox);
							preparedStatement.setString(8, cox);
							preparedStatement.setString(9, remarks);
							preparedStatement.setString(10, indsutrylocation);
							preparedStatement.setString(11, samplelocation);
							preparedStatement.setString(12, serial);

							preparedStatement.execute();

						}
						
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
	
		
        
	}
	
	// Air -> Monitoring -> Report
	@FXML
	public void actionAirMonitoringDataInputSaveButton(ActionEvent event) throws JRException, SQLException
	{
		boolean reportPrintingForOrganization = monitoringReportPrintingForOrganizationChecker.isSelected();
		
		String industryquery;
		String datefrom = airmonitoringreportdatefrom.getValue();
		String monthfrom = airmonitoringreportmonthfrom.getValue();
		String yearfrom = airmonitoringreportyearfrom.getValue();
		String dateto = airmonitoringreportdateto.getValue();
		String monthto = airmonitoringreportmonthto.getValue();
		String yearto = airmonitoringreportyearto.getValue();
		String IndustryName = airmonitoringreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from airmonitoringreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from airmonitoringdatainput";
			rSet = stat.executeQuery(allDataQuery);
			
			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("name");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("type");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO airmonitoringreport (date, name,type,  labcode,  spm, sox, nox , cox, location, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, indsutrylocation);
				preparedStatement.setString(10, serial);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airmonitoringreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
        }
        else if ( (datefrom == null || monthfrom == null || yearfrom == null || dateto == null || monthto == null
				|| yearto == null )&& IndustryName == null) {
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

			String deleteQuery = "delete from airmonitoringindividualreport";
			stat.execute(deleteQuery);

			String idealspm = "-";
			String idealsox = "-";
			String idealnox = "-";
			String idealcox = "-";
			String sampledate = "-";
			String subject ="-";
			String reference = "-";
			String signaturetemplate = "-";
			String description = "-";
			String remarks = "-";

			String query = "select * from airmonitoringstandarddatasave";

			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				sampledate = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				reference = rSet.getString("reference");
				signaturetemplate = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				idealspm = rSet.getString("idealspm");
				idealsox = rSet.getString("idealsox");
				idealnox = rSet.getString("idealnox");
				idealcox = rSet.getString("idealcox");
				remarks = rSet.getString("remarks");
			}
			
			subject = "Subject : "+ subject;
			reference = "Reference : "+ reference;
			sampledate = "Date : "+sampledate;
			remarks = "*Remarks : "+remarks;
			
			String indsutrylocation = "";
			query = "select location from airmonitoringregistration where name like "+"'"+ IndustryName +"'";
			rSet = stat.executeQuery(query);
			while(rSet.next()){
				indsutrylocation = rSet.getString("location");
			}
			if(indsutrylocation == null){
				indsutrylocation = "-";
			}
			
			indsutrylocation = " "+indsutrylocation;
			indsutrylocation = indsutrylocation.replaceAll("\n", " ");
			indsutrylocation = indsutrylocation.replaceAll("\r", " ");

			if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null) {
				industryquery = "select * from airmonitoringdatainput where " + "name like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			} else {
				industryquery = "select * from airmonitoringdatainput where " + "year like " + "'" + Yearfrom
						+ "' and month like " + "'" + Monthfrom + "' and day like " + "'" + Datefrom
						+ "' and name like " + "'" + IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			}

			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("name");
				String labcode = rSet.getString("labcode");
				String samplelocation = rSet.getString("location");
				String indsutrytype = rSet.getString("type");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				String id = rSet.getString("id");

				String fulldate;


				if(samplelocation == null){
					samplelocation = "-";
				}
				samplelocation = " "+ samplelocation;
				samplelocation = samplelocation.replaceAll("\n", " ");
				samplelocation = samplelocation.replaceAll("\r", " ");

				if (indsutrylocation.length() > 2) {
					indsutryname = "Name and Address of Sample : "+IndustryName + " ( " + indsutrylocation + " ).";
				}
				else{
					indsutryname = "Name and Address of Sample : "+IndustryName;
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
				if(spm == null || spm == "")
					spm = "-";
				if(sox == null || sox == "")
					sox = "-";
				if(nox == null || nox == "")
					nox = "-";
				if(cox == null || cox == "")
					cox = "-";
				if(remarks == null || remarks == "")
					remarks = "-";

				fulldate = "Sample Collection Date : "+fulldate;
				id = "Memo No : "+ id;

				// //Adding into database
				String insertquery = "INSERT INTO airmonitoringindividualreport (date, name, type,  labcode, spm, sox ,nox, cox , remarks, location, samplelocation,  idealspm, idealsox, idealnox, idealcox, memono,sampledate,subject,reference,signaturetemplate,description)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, remarks);
				preparedStatement.setString(10, indsutrylocation);
				preparedStatement.setString(11, samplelocation);
				preparedStatement.setString(12, idealspm);
				preparedStatement.setString(13, idealsox);
				preparedStatement.setString(14, idealnox);
				preparedStatement.setString(15, idealcox);
				preparedStatement.setString(16, id);
				preparedStatement.setString(17, sampledate);
				preparedStatement.setString(18, subject);
				preparedStatement.setString(19, reference);
				preparedStatement.setString(20, signaturetemplate);
				preparedStatement.setString(21, description);

				preparedStatement.execute();

			}
			if(airmonitoringstandardlimitfalse.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\airmonitoringindividualreportwithoutstandardlimt.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}
			if(airmonitoringstandardlimittrue.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\airmonitoringindividualreport.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

		}
		// Just for Showing not printing.
        
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from airmonitoringreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from airmonitoringdatainput where " +  "name like " + "'" + IndustryName + "'";
			rSet = stat.executeQuery(industryquery);
			
			while (rSet.next()) {
				String serial = rSet.getString("id");
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("name");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("type");
				String spm = rSet.getString("spm");
				String sox = rSet.getString("sox");
				String nox = rSet.getString("nox");
				String cox = rSet.getString("cox");
				

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO airmonitoringreport (date, name,type,  labcode,  spm, sox, nox , cox, location, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, spm);
				preparedStatement.setString(6, sox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, cox);
				preparedStatement.setString(9, indsutrylocation);
				preparedStatement.setString(10, serial);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airmonitoringreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);
		}
		else {

			int	Datefrom = Integer.parseInt(datefrom);
			int	Monthfrom = Integer.parseInt(monthfrom);
			int	Yearfrom = Integer.parseInt(yearfrom);
			int	Dateto = Integer.parseInt(dateto);
			int	Monthto = Integer.parseInt(monthto);
			int	Yearto = Integer.parseInt(yearto);

			
			
			String deleteQuery = "delete from airmonitoringreport";
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
			
						if (datefrom != null && monthfrom != null && yearfrom != null && dateto != null && monthto != null
								&& yearto != null && IndustryName != null && IndustryName != "Refresh" && IndustryName != "All Data") {
							query = "select * from airmonitoringdatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and name like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from airmonitoringdatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
						}
						

			
						rSet = stat.executeQuery(query);
						while (rSet.next()) {
							String serial = rSet.getString("id");
							String DAY = rSet.getString("day");
							String MONTH = rSet.getString("month");
							String YEAR = rSet.getString("year");
							String indsutryname = rSet.getString("name");
							String labcode = rSet.getString("labcode");
							String indsutrylocation = rSet.getString("location");
							String indsutrytype = rSet.getString("type");
							String spm = rSet.getString("spm");
							String sox = rSet.getString("sox");
							String nox = rSet.getString("nox");
							String cox = rSet.getString("cox");
							

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							

							// //Adding into database
							String insertquery = "INSERT INTO airmonitoringreport (date, name,type,  labcode,  spm, sox, nox , cox, location, serial)"
									+ " VALUES (?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, spm);
							preparedStatement.setString(6, sox);
							preparedStatement.setString(7, nox);
							preparedStatement.setString(8, cox);
							preparedStatement.setString(9, indsutrylocation);
							preparedStatement.setString(10, serial);


							preparedStatement.execute();

						}
						
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\airmonitoringreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
	
		
	}
	
	public void actioncleardateairindustry(ActionEvent event){
		airindustryreportdatefrom.setValue(null);
		airindustryreportmonthfrom.setValue(null);
		airindustryreportyearfrom.setValue(null);
		airindustryreportdateto.setValue(null);
		airindustryreportmonthto.setValue(null);
		airindustryreportyearto.setValue(null);
	}
	public void actioncleardateairmonitoring(ActionEvent event){
		airmonitoringreportdatefrom.setValue(null);
		airmonitoringreportmonthfrom.setValue(null);
		airmonitoringreportyearfrom.setValue(null);
		airmonitoringreportdateto.setValue(null);
		airmonitoringreportmonthto.setValue(null);
		airmonitoringreportyearto.setValue(null);
	}
	public void actionairindustrystandardlimit(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/airidealvalues.fxml"));
		Scene scene2 = new Scene(root2, 531, 679);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Standard Limit Setting For Industrial Air");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}
	
	public void actionairmonitoringstandardlimit(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/airmonitoringidealvalues.fxml"));
		Scene scene2 = new Scene(root2, 531, 679);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Standard Limit Setting For Routine Monitoring of Air");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}
	
	public void actionairindustrycheckbox(ActionEvent event) {
		boolean check = ReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			reportdatetext.setText("Date From :");
			reportdatetotext.setVisible(true);
			reportdatetotext.setOpacity(1);
			airindustryreportdateto.setVisible(true);
			airindustryreportdateto.setOpacity(1);
			airindustryreportmonthto.setVisible(true);
			airindustryreportmonthto.setOpacity(1);
			airindustryreportyearto.setVisible(true);
			airindustryreportyearto.setOpacity(1);

			airindustrystandlimitfalse.setVisible(false);
			airindustrystandlimitfalse.setOpacity(0);
			airindustrystandardlimittrue.setVisible(false);
			airindustrystandardlimittrue.setOpacity(0);
			airindustrysettings.setVisible(false);
			airindustrysettings.setOpacity(0);

		} else if (check) {
			reportdatetext.setText("Report For :");
			reportdatetotext.setVisible(false);
			reportdatetotext.setOpacity(0);
			airindustryreportdateto.setVisible(false);
			airindustryreportdateto.setOpacity(0);
			airindustryreportmonthto.setVisible(false);
			airindustryreportmonthto.setOpacity(0);
			airindustryreportyearto.setVisible(false);
			airindustryreportyearto.setOpacity(0);

			airindustrystandardlimittrue.setSelected(true);
			airindustrystandlimitfalse.setVisible(true);
			airindustrystandlimitfalse.setOpacity(1);
			airindustrystandardlimittrue.setVisible(true);
            airindustrystandardlimittrue.setOpacity(1);
    		airindustrysettings.setVisible(true);
    		airindustrysettings.setOpacity(1);
		}
	}
	
	public void actionairmonitoringcheckbox(ActionEvent event) {
		boolean check = monitoringReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			monitoringreportdatetext.setText("Date From :");
			monitoringreportdatetotext.setVisible(true);
			monitoringreportdatetotext.setOpacity(1);
			airmonitoringreportdateto.setVisible(true);
			airmonitoringreportdateto.setOpacity(1);
			airmonitoringreportmonthto.setVisible(true);
			airmonitoringreportmonthto.setOpacity(1);
			airmonitoringreportyearto.setVisible(true);
			airmonitoringreportyearto.setOpacity(1);

			airmonitoringstandardlimitfalse.setVisible(false);
			airmonitoringstandardlimitfalse.setOpacity(0);
			airmonitoringstandardlimittrue.setVisible(false);
			airmonitoringstandardlimittrue.setOpacity(0);
			airmonitoringsettings.setVisible(false);
			airmonitoringsettings.setOpacity(0);

		} else if (check) {
			monitoringreportdatetext.setText("Report For :");
			monitoringreportdatetotext.setVisible(false);
			monitoringreportdatetotext.setOpacity(0);
			airmonitoringreportdateto.setVisible(false);
			airmonitoringreportdateto.setOpacity(0);
			airmonitoringreportmonthto.setVisible(false);
			airmonitoringreportmonthto.setOpacity(0);
			airmonitoringreportyearto.setVisible(false);
			airmonitoringreportyearto.setOpacity(0);

			airmonitoringstandardlimittrue.setSelected(true);
			airmonitoringstandardlimitfalse.setVisible(true);
			airmonitoringstandardlimitfalse.setOpacity(1);
			airmonitoringstandardlimittrue.setVisible(true);
            airmonitoringstandardlimittrue.setOpacity(1);
    		airmonitoringsettings.setVisible(true);
    		airmonitoringsettings.setOpacity(1);
		}
	}
	

}
