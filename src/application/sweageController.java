package application;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class sweageController implements Initializable{


	
	
	//sweage ->Industry -> Report
	@FXML
	public ComboBox<String> sweageindustryreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageindustryreportindustryname = new ComboBox<>();
	
	
	// All elements for sweage -> Industry -> Registration
	@FXML
	public ComboBox<String> sweageIndustryRegistrationType = new ComboBox<>();
	@FXML
	public TextArea sweageIndustryRegistrationLocation = new TextArea();
	@FXML
	public TextField sweageIndustryRegistrationName = new TextField();

	
	// All elements for sweage -> Industry -> Data Input
	@FXML
	public CheckBox sweageindustrycheckbox = new CheckBox();
	@FXML
	public CheckBox sweagemonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> sweageIndustryDataInputDay = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageIndustryDataInputMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageIndustryDataInputYear = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageIndustryDataInputType = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageIndustryDataInputName = new ComboBox<>();
	@FXML
	public TextArea sweageIndustryDataInputLocation = new TextArea();
	@FXML
	public TextField sweageIndustryDataInputLabCode = new TextField();
	@FXML
	public TextField sweageIndustryDataInputbod = new TextField();
	@FXML
	public TextField sweageIndustryDataInputpox = new TextField();
	@FXML
	public TextField sweageIndustryDataInputnox = new TextField();
	@FXML
	public TextField sweageIndustryDataInputcoliform = new TextField();
	@FXML
	public TextField sweageIndustryDataInputss = new TextField();
	@FXML
	public TextField sweageIndustryDataInputtemperature = new TextField();
	@FXML
	public ComboBox<String> sweageIndustrydatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<Integer> sweageIndustryserialcombobox = new ComboBox<>();
	@FXML
	public Label sweageIndustryseriallabel ;
	@FXML
	public TextArea sweageIndustryDataInput = new TextArea();
	
	
	//sweage ->Monitoring -> Report
	@FXML
	public ComboBox<String> sweagemonitoringreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> sweagemonitoringreportindustryname = new ComboBox<>();
	
	
	// All elements for sweage -> Monitoring -> Registration
	@FXML
	public ComboBox<String> sweageMonitoringRegistrationType = new ComboBox<>();
	@FXML
	public TextArea sweageMonitoringRegistrationLocation = new TextArea();
	@FXML
	public TextField sweageMonitoringRegistrationName = new TextField();

	
	// All elements for sweage -> Monitoring -> Data Input
	@FXML
	public ComboBox<String> sweageDataInputMonitoringDAY = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageDataInputMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageDataInputMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageDataInputMonitoringType = new ComboBox<>();
	@FXML
	public ComboBox<String> sweageDataInputMonitoringName = new ComboBox<>();
	@FXML
	public TextArea sweageDataInputMonitoringLocation = new TextArea();
	@FXML
	public TextField sweageDataInputMonitoringLabCode = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringbod = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringpox = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringnox = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringss = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringcoliform = new TextField();
	@FXML
	public TextField sweageDataInputMonitoringtemperature = new TextField();
	@FXML
	public ComboBox<String> sweageDataInputMonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<Integer> sweageDataInputMonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label sweageDataInputMonitoringseriallabel ;

	// Directory
	public String reprotDirectory = "C:\\Govt_Environment\\report";
	
	
	// All list for combobox
	
	// All list for combobox
	ObservableList<String> sweageindustrynamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> sweageindustrynameFilteredlistforreport = new FilteredList<String>(sweageindustrynamelistforreport, p -> true);
	
	ObservableList<String> sweagemonitoringnamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> sweagemonitoringnameFlteredlistforreport = new FilteredList<String>(sweagemonitoringnamelistforreport, p -> true);
	
	ObservableList<String> sweageIndsutryRegistrationTypelist = FXCollections.observableArrayList("Refresh", "Sugar(Production ≥ 50 Ton)", "Sugar(Production< 50 Ton)", "Tannery", "Cement",
			"Architect", "Fertilizer", "Pulp & Paper", "Distillery", "Embrodery", "Decorator", "Ceramic", "Weaving");
	ObservableList<String> sweageindustrynamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> sweageindustrynameFilteredlist = new FilteredList<String>(sweageindustrynamelist, p -> true);
	
	ObservableList<String> sweageindustrytypelist = FXCollections.observableArrayList();
	ObservableList<String> day = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31");
	ObservableList<String> month = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12");
	ObservableList<String> year = FXCollections.observableArrayList("2020", "2019", "2018", "2017", "2016", "2015",
			"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002",
			"2001", "2000");
	
	ObservableList<String> sweagemonitoringtypelist = FXCollections.observableArrayList("Refresh", "Market", "Institution");
	ObservableList<String> sweagemonitoringdatainputnamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> sweagemonitoringdatainputFilterednamelist = new FilteredList<String>(sweagemonitoringdatainputnamelist, p -> true);
	
	ObservableList<String> sweagemonitoringdatainputtypelist = FXCollections.observableArrayList();
	
	ObservableList<String> sweageIndustrydatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> sweageIndustrydatainputidlist = FXCollections.observableArrayList();
	
	ObservableList<String> sweageDataInputMonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> sweageDataInputMonitoringdatainputidlist = FXCollections.observableArrayList();
	
	
	
	// All Variables
	public String sweageIndustryFullData = "Shaem";
	public String sweageMonitoringFullData = "Shaem";
	public String sweageIndustryDataConvertingType = "";
	public String sweageDataInputMonitoringDataConvertingType = "";
	public String reportfullData = "null";
	public String monitoringreportfullData = "null";
	
	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;
	
	
	public sweageController() {
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
		sweageIndustryRegistrationType.setItems(sweageIndsutryRegistrationTypelist);
		sweageIndustryDataInputDay.setItems(day);
		sweageIndustryDataInputMonth.setItems(month);
		sweageIndustryDataInputYear.setItems(year);
		sweageIndustryDataInputType.setItems(sweageindustrytypelist);
		
		sweageMonitoringRegistrationType.setItems(sweagemonitoringtypelist);
		sweageDataInputMonitoringDAY.setItems(day);
		sweageDataInputMonitoringMonth.setItems(month);
		sweageDataInputMonitoringYear.setItems(year);
		
		sweageIndustrydatacombobox.setItems(sweageIndustrydatacovertingtype);
		sweageIndustrydatacombobox.setValue("Add");
		sweageIndustryserialcombobox.setDisable(true);
		sweageIndustryserialcombobox.setOpacity(0);
		
		sweageDataInputMonitoringdatacombobox.setItems(sweageDataInputMonitoringdatacovertingtype);
		sweageDataInputMonitoringdatacombobox.setValue("Add");
		sweageDataInputMonitoringserialcombobox.setDisable(true);
		sweageDataInputMonitoringserialcombobox.setOpacity(0);
		
		sweageindustryreportdatefrom.setItems(day);
		sweageindustryreportmonthfrom.setItems(month);
		sweageindustryreportyearfrom.setItems(year);
		sweageindustryreportdateto.setItems(day);
		sweageindustryreportmonthto.setItems(month);
		sweageindustryreportyearto.setItems(year);
		
		sweagemonitoringreportdatefrom.setItems(day);
		sweagemonitoringreportmonthfrom.setItems(month);
		sweagemonitoringreportyearfrom.setItems(year);
		sweagemonitoringreportdateto.setItems(day);
		sweagemonitoringreportmonthto.setItems(month);
		sweagemonitoringreportyearto.setItems(year);
		
		
		actionSweageIndustryReportIndustryNameCombobox(null);
		sweageindustryreportindustryname.setItems(sweageindustrynamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // sweage -> Report -> Industryname
	    sweageindustryreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionSweageIndustryReportIndustryNameCombobox(null, newValue));
	    
		actionSweageMonitoringReportIndustryNameCombobox(null);
		sweagemonitoringreportindustryname.setItems(sweagemonitoringnamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // sweage -> Report -> Industryname
		sweagemonitoringreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionSweageMonitoringReportIndustryNameCombobox(null, newValue));
	    
		// sweage -> Industry -> Registration for adding items in initialize
		actionsweageIndustryRegistrationIndustryTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In sweage -> Industry -> Registration 
		sweageIndustryRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionsweageIndustryRegistrationIndustryTypeComboboxForInitialize());
		
		//sweage -> Industry -> Data Input for adding Industry Names in initialize
		actionsweageIndustryDataInputIndustryNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In sweage -> Industry -> Data Input 
		sweageIndustryDataInputName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionsweageIndustryDataInputIndustryNameCombobox(null, newValue));
		
		// sweage -> Monitoring -> Registration -> Industry Type for Initialize
		actionsweageMonitoringRegistrationTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In sweage -> Monitoring -> Registration 
		sweageMonitoringRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionsweageMonitoringRegistrationTypeComboboxForInitialize());
		
		//sweage -> Monitoring -> Data Input for adding Industry Names in initialize
		sweageMonitoringDataInputNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In Sound -> Monitoring -> Data Input 
		sweageDataInputMonitoringName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		sweageMonitoringDataInputNameCombobox(null, newValue));
		
		//Listener for Data converting type Sweage -> Industry -> Data Input -> Data converting combobox
	    sweageIndustrydatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
	    sweageIndustryDataInputConverting(null, newValue));
	    
		//Listener for Serial No Sweage -> Industry -> Data Input -> Data converting combobox
		sweageIndustryserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		sweageIndustryDataLoadingforcorrespondingserialno(null, newValue));
		
		//Listener for Data converting type Sweage -> Monitoring -> Data Input -> Data converting combobox
		sweageDataInputMonitoringdatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		sweageDataInputMonitoringDataInputConverting(null, newValue));
		
		//Listener for Serial No Sweage -> Monitoring -> Data Input -> Data converting combobox
		sweageDataInputMonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		sweageDataInputMonitoringDataLoadingforcorrespondingserialno(null, newValue));
		
		//Searching or Filtering
		
		sweageIndustryDataInputName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = sweageIndustryDataInputName.getEditor();
            final String selected = sweageIndustryDataInputName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	sweageindustrynameFilteredlist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		sweageIndustryDataInputName.setItems(sweageindustrynameFilteredlist);
		
		
		sweageindustryreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = sweageindustryreportindustryname.getEditor();
            final String selected = sweageindustryreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	sweageindustrynameFilteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		sweageindustryreportindustryname.setItems(sweageindustrynameFilteredlistforreport);
		
		
		
		sweageDataInputMonitoringName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = sweageDataInputMonitoringName.getEditor();
            final String selected = sweageDataInputMonitoringName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	sweagemonitoringdatainputFilterednamelist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		sweageDataInputMonitoringName.setItems(sweagemonitoringdatainputFilterednamelist);
		
		sweagemonitoringreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = sweagemonitoringreportindustryname.getEditor();
            final String selected = sweagemonitoringreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	sweagemonitoringnameFlteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		sweagemonitoringreportindustryname.setItems(sweagemonitoringnameFlteredlistforreport);
		
	}
	
	
	
	public void actionSweageIndustryReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from sweageindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					sweageindustrynamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionSweageMonitoringReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from sweagemonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					sweagemonitoringnamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	
	
	public void actionSweageIndustryReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from sweageindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					sweageindustrynamelistforreport.add(item);
					sweageindustryreportindustryname.setItems(sweageindustrynamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}
	
	public void actionSweageMonitoringReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from sweagemonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					sweagemonitoringnamelistforreport.add(item);
					sweagemonitoringreportindustryname.setItems(sweagemonitoringnamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}
	
	//********Industry Registration( Starts )*******//
	
	// sweage -> Industry -> Registration -> Industry Type for Initialize
	public void actionsweageIndustryRegistrationIndustryTypeComboboxForInitialize() {
		try {
			String query = "select * from sweageindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (sweageIndsutryRegistrationTypelist.contains(item)) {
				} 
				else {
					sweageIndsutryRegistrationTypelist.add(item);
				}
			}
			sweageIndustryRegistrationType.setItems(sweageIndsutryRegistrationTypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	

	// Sweage -> Industry -> Data Input -> Loading for corresponding serial no to edit.
	public void sweageIndustryDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = sweageIndustrydatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from sweageindustrydatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					//day, month, year, indsutryname, location, labcode, indsutrtype, bod, pox, nox, ss, temperature, coliform, remarks
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String indsutryname = rSet.getString("indsutryname");
					String location = rSet.getString("location");
					String labcode = rSet.getString("labcode");
					String indsutrytype = rSet.getString("indsutrtype");
					String bod = rSet.getString("bod");
					String pox = rSet.getString("pox");
					String nox = rSet.getString("nox");
					String ss = rSet.getString("ss");
					String temperature = rSet.getString("temperature");
					String coliform = rSet.getString("coliform");
					String remarks = rSet.getString("remarks");				
					
					sweageIndustryDataInputDay.setValue(day);
					sweageIndustryDataInputMonth.setValue(month);
					sweageIndustryDataInputYear.setValue(year);
					sweageIndustryDataInputType.setValue(indsutrytype);
					sweageIndustryDataInputLabCode.setText(labcode);
					sweageIndustryDataInputLocation.setText(location);
					sweageIndustryDataInputbod.setText(bod);
					sweageIndustryDataInputpox.setText(pox);
					sweageIndustryDataInputnox.setText(nox);
					sweageIndustryDataInputss.setText(ss);
					sweageIndustryDataInputtemperature.setText(temperature);
					sweageIndustryDataInputcoliform.setText(coliform);
					sweageIndustryDataInput.setText(remarks);
					
				}
			} catch (SQLException e) {
				System.out.println(e);
			}	
		}
	}

	// Sweage -> Monitoring -> Data Input -> Loading for corresponding serial no to edit.
	public void sweageDataInputMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = sweageDataInputMonitoringdatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from sweagemonitoringdatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					//day, month, year, indsutryname, location, labcode, indsutrtype, bod, pox, nox, ss, temperature, coliform, remarks
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String indsutryname = rSet.getString("name");
					String location = rSet.getString("location");
					String labcode = rSet.getString("labcode");
					String indsutrytype = rSet.getString("type");
					String bod = rSet.getString("bod");
					String pox = rSet.getString("pox");
					String nox = rSet.getString("nox");
					String ss = rSet.getString("ss");
					String temperature = rSet.getString("temperature");
					String coliform = rSet.getString("coliform");			
					
					sweageDataInputMonitoringDAY.setValue(day);
					sweageDataInputMonitoringMonth.setValue(month);
					sweageDataInputMonitoringYear.setValue(year);
					sweageDataInputMonitoringType.setValue(indsutrytype);
					sweageDataInputMonitoringLabCode.setText(labcode);
					sweageDataInputMonitoringLocation.setText(location);
					sweageDataInputMonitoringbod.setText(bod);
					sweageDataInputMonitoringpox.setText(pox);
					sweageDataInputMonitoringnox.setText(nox);
					sweageDataInputMonitoringss.setText(ss);
					sweageDataInputMonitoringtemperature.setText(temperature);
					sweageDataInputMonitoringcoliform.setText(coliform);
					
				}
			} catch (SQLException e) {
				System.out.println(e);
			}	
		}
	}
	
	// Sweage -> Industry -> Data Input -> Data Converting Comboobox
	public void sweageIndustryDataInputConverting(ActionEvent event, String value) {
    
		sweageIndustryDataConvertingType = sweageIndustrydatacombobox.getValue();
		if(sweageIndustryDataConvertingType == "Add"){
			sweageIndustryserialcombobox.setDisable(true);
			sweageIndustryserialcombobox.setOpacity(0);
			sweageIndustryseriallabel.setDisable(true);
			sweageIndustryseriallabel.setOpacity(0);
		}
		if(sweageIndustryDataConvertingType ==  "Edit"){
			sweageIndustryserialcombobox.setDisable(false);
			sweageIndustryserialcombobox.setOpacity(1);
			sweageIndustryseriallabel.setDisable(false);
			sweageIndustryseriallabel.setOpacity(1);
		}
		if(sweageIndustryDataConvertingType == "Delete"){
			sweageIndustryserialcombobox.setDisable(false);
			sweageIndustryserialcombobox.setOpacity(1);
			sweageIndustryseriallabel.setDisable(false);
			sweageIndustryseriallabel.setOpacity(1);
		}

	}
	
	// Sweage -> Monitoring -> Data Input -> Data Converting Comboobox
	public void sweageDataInputMonitoringDataInputConverting(ActionEvent event, String value) {
    
		sweageDataInputMonitoringDataConvertingType = sweageDataInputMonitoringdatacombobox.getValue();
		if(sweageDataInputMonitoringDataConvertingType == "Add"){
			sweageDataInputMonitoringserialcombobox.setDisable(true);
			sweageDataInputMonitoringserialcombobox.setOpacity(0);
			sweageDataInputMonitoringseriallabel.setDisable(true);
			sweageDataInputMonitoringseriallabel.setOpacity(0);
		}
		if(sweageDataInputMonitoringDataConvertingType ==  "Edit"){
			sweageDataInputMonitoringserialcombobox.setDisable(false);
			sweageDataInputMonitoringserialcombobox.setOpacity(1);
			sweageDataInputMonitoringseriallabel.setDisable(false);
			sweageDataInputMonitoringseriallabel.setOpacity(1);
		}
		if(sweageDataInputMonitoringDataConvertingType == "Delete"){
			sweageDataInputMonitoringserialcombobox.setDisable(false);
			sweageDataInputMonitoringserialcombobox.setOpacity(1);
			sweageDataInputMonitoringseriallabel.setDisable(false);
			sweageDataInputMonitoringseriallabel.setOpacity(1);
		}

	}
	
	@FXML
	public void actionSweageIndustryRegistrationSaveButton(ActionEvent event) throws SQLException{
		String Industrytype = sweageIndustryRegistrationType.getValue();
		String IndustryName = sweageIndustryRegistrationName.getText();
		String IndsutryLocation = sweageIndustryRegistrationLocation.getText();

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
			String query = "INSERT INTO sweageindustryregistration (industrytype, industryname, industrylocation)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, Industrytype);
			preparedStatement.setString(2, IndustryName);
			preparedStatement.setString(3, IndsutryLocation);
			preparedStatement.execute();

			sweageIndustryRegistrationType.setValue(null);
			sweageIndustryRegistrationName.setText(null);
			sweageIndustryRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}

	}
	
	//********Industry Registration( ENDS )*******//
	//********Industry Data Input( Starts )*******//
	
	public void actionsweageIndustryDataInputIndustryNameCombobox() {
		try {
			String query = "select * from sweageindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (sweageIndustryFullData.contains(item)) {
				} else {
					sweageIndustryFullData += item;
					sweageindustrynamelist.add(item);
				}
			}
			sweageIndustryDataInputName.setItems(sweageindustrynamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionsweageIndustryDataInputIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from sweageindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (sweageIndustryFullData.contains(item)) {
				} else {
					sweageIndustryFullData += item;
					sweageindustrynamelist.add(item);
					sweageIndustryDataInputName.setItems(sweageindustrynamelist);
				}
			}
			sweageindustrytypelist.clear();
			query = "select * from sweageindustryregistration where " + "industryname like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				String item2 = rSet.getString("industrylocation");
				sweageindustrytypelist.add(item);
				sweageIndustryDataInputType.setItems(sweageindustrytypelist);
				sweageIndustryDataInputLocation.setText(item2);
			}
			
			String dataconvertingtype = sweageIndustrydatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				sweageIndustrydatainputidlist.clear();
				query = "select id from sweageindustrydatainput where " + "indsutryname like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					sweageIndustrydatainputidlist.add(item);
					sweageIndustryserialcombobox.setItems(sweageIndustrydatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	@FXML
	public void actionSweageIndustryDataInputSaveButton(ActionEvent event){
		boolean checkbox= sweageindustrycheckbox.isSelected();
		
		String day = sweageIndustryDataInputDay.getValue();
		String Month = sweageIndustryDataInputMonth.getValue();
		String Year = sweageIndustryDataInputYear.getValue();
		String IndustryName = sweageIndustryDataInputName.getValue();
		String Labcode = sweageIndustryDataInputLabCode.getText();
		String Location = sweageIndustryDataInputLocation.getText();
		String IndustryType = sweageIndustryDataInputType.getValue();
		String bod = sweageIndustryDataInputbod.getText();
		String pox = sweageIndustryDataInputpox.getText();
		String nox = sweageIndustryDataInputnox.getText();
		String ss = sweageIndustryDataInputss.getText();
		String coliform = sweageIndustryDataInputcoliform.getText();
		String temperature = sweageIndustryDataInputtemperature.getText();
		String Remarks = sweageIndustryDataInput.getText();
		
		String sweageIndustryDataConvertingType = sweageIndustrydatacombobox.getValue();
		if (IndustryName != "Refresh" && IndustryName.length() > 1 && sweageIndustryDataConvertingType == "Add") {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO sweageindustrydatainput (day, month, year, indsutryname, location, labcode, indsutrtype, bod, pox, nox, ss, temperature, coliform, remarks)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, IndustryType);
				preparedStatement.setString(8, bod);
				preparedStatement.setString(9, pox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, temperature);
				preparedStatement.setString(13, coliform);
				preparedStatement.setString(14, Remarks);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
				}else{
					sweageIndustryDataInputDay.setValue(null);
					sweageIndustryDataInputMonth.setValue(null);
					sweageIndustryDataInputYear.setValue(null);
					sweageIndustryDataInputType.setValue(null);
					sweageIndustryDataInputName.setValue(null);
					sweageIndustryDataInputLocation.setText(null);
					sweageIndustryDataInputLabCode.setText(null);
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
					sweageIndustryDataInput.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} 

		
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && sweageIndustryDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = sweageIndustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update sweageindustrydatainput set day=?,month=?,year=?,indsutryname=?,indsutrtype=?,location=?,labcode=?,bod=?,pox=?,nox=?,ss=?,temperature=?,coliform=?,remarks=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, IndustryType);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, bod);
				preparedStatement.setString(9, pox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, temperature);
				preparedStatement.setString(13, coliform);
				preparedStatement.setString(14, Remarks);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				if(checkbox){
					sweageIndustryDataInputDay.setValue(null);
					sweageIndustryDataInputMonth.setValue(null);
					sweageIndustryDataInputYear.setValue(null);
					sweageIndustryDataInputType.setValue(null);
					sweageIndustryDataInputLocation.setText(null);
					sweageIndustryDataInputLabCode.setText(null);
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
					sweageIndustryDataInput.setText(null);
				}else{
					sweageIndustryDataInputDay.setValue(null);
					sweageIndustryDataInputMonth.setValue(null);
					sweageIndustryDataInputYear.setValue(null);
					sweageIndustryDataInputType.setValue(null);
					sweageIndustryDataInputName.setValue(null);
					sweageIndustryDataInputLocation.setText(null);
					sweageIndustryDataInputLabCode.setText(null);
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
					sweageIndustryDataInput.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && sweageIndustryDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = sweageIndustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from sweageindustrydatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					sweageIndustryDataInputDay.setValue(null);
					sweageIndustryDataInputMonth.setValue(null);
					sweageIndustryDataInputYear.setValue(null);
					sweageIndustryDataInputType.setValue(null);
					sweageIndustryDataInputLocation.setText(null);
					sweageIndustryDataInputLabCode.setText(null);
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
					sweageIndustryDataInput.setText(null);
				}else{
					sweageIndustryDataInputDay.setValue(null);
					sweageIndustryDataInputMonth.setValue(null);
					sweageIndustryDataInputYear.setValue(null);
					sweageIndustryDataInputType.setValue(null);
					sweageIndustryDataInputName.setValue(null);
					sweageIndustryDataInputLocation.setText(null);
					sweageIndustryDataInputLabCode.setText(null);
					sweageIndustryserialcombobox.setValue(null);
					sweageIndustryDataInputbod.setText(null);
					sweageIndustryDataInputpox.setText(null);
					sweageIndustryDataInputnox.setText(null);
					sweageIndustryDataInputss.setText(null);
					sweageIndustryDataInputtemperature.setText(null);
					sweageIndustryDataInputcoliform.setText(null);
					sweageIndustryDataInput.setText(null);
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
	//********Industry Data Input( ENDS )*******//
	
	//********Monitoring Registration( Starts )*******//
	// sweage -> Monitoring -> Registration -> Industry Type for Initialize
	public void actionsweageMonitoringRegistrationTypeComboboxForInitialize() {
		try {
			String query = "select * from sweagemonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("type");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (sweagemonitoringtypelist.contains(item)) {
				} 
				else {
					sweagemonitoringtypelist.add(item);
				}
			}
			sweageMonitoringRegistrationType.setItems(sweagemonitoringtypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	@FXML
	public void actionsweageMonitoringRegistrationSave(ActionEvent event) throws SQLException{
		String type = sweageMonitoringRegistrationType.getValue();
		String Name = sweageMonitoringRegistrationName.getText();
		String Location = sweageMonitoringRegistrationLocation.getText();

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
			String query = "INSERT INTO sweagemonitoringregistration (type, name, location)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, type);
			preparedStatement.setString(2, Name);
			preparedStatement.setString(3, Location);
			preparedStatement.execute();

			sweageMonitoringRegistrationType.setValue(null);
			sweageMonitoringRegistrationName.setText(null);
			sweageMonitoringRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}
	}
	//********Monitoring Registration( ENDS )*******//
	
	//********Monitoring Data Input( Starts )*******//
	public void sweageMonitoringDataInputNameCombobox() {
		try {
			String query = "select * from sweagemonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (sweageMonitoringFullData.contains(item)) {
				} else {
					sweageMonitoringFullData += item;
					sweagemonitoringdatainputnamelist.add(item);
				}
			}
			sweageDataInputMonitoringName.setItems(sweagemonitoringdatainputnamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}
	}
	
	public void sweageMonitoringDataInputNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from sweagemonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (sweageMonitoringFullData.contains(item)) {
				} else {
					sweageMonitoringFullData += item;
					sweagemonitoringdatainputnamelist.add(item);
					sweageDataInputMonitoringName.setItems(sweagemonitoringdatainputnamelist);
				}
			}
			query = "select * from sweagemonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			sweagemonitoringdatainputtypelist.clear();
			while (rSet.next()) {
				String item = rSet.getString("type");
				String item2 = rSet.getString("location");
				sweagemonitoringdatainputtypelist.add(item);
				sweageDataInputMonitoringType.setItems(sweagemonitoringdatainputtypelist);
				sweageDataInputMonitoringLocation.setText(item2);
			}
			
			String dataconvertingtype = sweageDataInputMonitoringdatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				sweageDataInputMonitoringdatainputidlist.clear();
				query = "select id from sweagemonitoringdatainput where " + "name like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					sweageDataInputMonitoringdatainputidlist.add(item);
					sweageDataInputMonitoringserialcombobox.setItems(sweageDataInputMonitoringdatainputidlist);
				}
			}
			

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	@FXML
	public void actionsweageDataInputMonitoringSave(ActionEvent event){
		boolean checkbox = sweagemonitoringcheckbox.isSelected();
		
		String day = sweageDataInputMonitoringDAY.getValue();
		String Month = sweageDataInputMonitoringMonth.getValue();
		String Year = sweageDataInputMonitoringYear.getValue();
		String Name = sweageDataInputMonitoringName.getValue();
		String Labcode = sweageDataInputMonitoringLabCode.getText();
		String Location = sweageDataInputMonitoringLocation.getText();
		String Type = sweageDataInputMonitoringType.getValue();
		String bod = sweageDataInputMonitoringbod.getText();
		String pox = sweageDataInputMonitoringpox.getText();
		String nox = sweageDataInputMonitoringnox.getText();
		String ss = sweageDataInputMonitoringss.getText();
		String temperature = sweageDataInputMonitoringtemperature.getText();
		String coliform = sweageDataInputMonitoringcoliform.getText();
		
		String sweageDataInputMonitoringDataConvertingType = sweageDataInputMonitoringdatacombobox.getValue();
		if (Name != "Refresh" && Name.length() > 1  && sweageDataInputMonitoringDataConvertingType == "Add" ) {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO sweagemonitoringdatainput (day, month, year, name, location, labcode, type, bod, pox, nox, ss, temperature, coliform)" + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Type);
				preparedStatement.setString(8, bod);
				preparedStatement.setString(9, pox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, temperature);
				preparedStatement.setString(13, coliform);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
				}else
				{
					sweageDataInputMonitoringDAY.setValue(null);
					sweageDataInputMonitoringMonth.setValue(null);
					sweageDataInputMonitoringYear.setValue(null);
					sweageDataInputMonitoringType.setValue(null);
					sweageDataInputMonitoringName.setValue(null);
					sweageDataInputMonitoringLocation.setText(null);
					sweageDataInputMonitoringLabCode.setText(null);
					sweageDataInputMonitoringserialcombobox.setValue(null);
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
				}

			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} 		

		
		else if (Name != "Refresh" && Name.length() > 1 && sweageDataInputMonitoringDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = sweageDataInputMonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update sweagemonitoringdatainput set day=?,month=?,year=?,name=?,type=?,location=?,labcode=?,bod=?,pox=?,nox=?,ss=?,temperature=?,coliform=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Type);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, bod);
				preparedStatement.setString(9, pox);
				preparedStatement.setString(10, nox);
				preparedStatement.setString(11, ss);
				preparedStatement.setString(12, temperature);
				preparedStatement.setString(13, coliform);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					sweageDataInputMonitoringDAY.setValue(null);
					sweageDataInputMonitoringMonth.setValue(null);
					sweageDataInputMonitoringYear.setValue(null);
					sweageDataInputMonitoringType.setValue(null);
					sweageDataInputMonitoringLocation.setText(null);
					sweageDataInputMonitoringLabCode.setText(null);
					sweageDataInputMonitoringserialcombobox.setValue(null);
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
				}else
				{
					sweageDataInputMonitoringDAY.setValue(null);
					sweageDataInputMonitoringMonth.setValue(null);
					sweageDataInputMonitoringYear.setValue(null);
					sweageDataInputMonitoringType.setValue(null);
					sweageDataInputMonitoringName.setValue(null);
					sweageDataInputMonitoringLocation.setText(null);
					sweageDataInputMonitoringLabCode.setText(null);
					sweageDataInputMonitoringserialcombobox.setValue(null);
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (Name != "Refresh" && Name.length() > 1 && sweageDataInputMonitoringDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = sweageDataInputMonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from sweagemonitoringdatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data Editiing
				if(checkbox){
					sweageDataInputMonitoringDAY.setValue(null);
					sweageDataInputMonitoringMonth.setValue(null);
					sweageDataInputMonitoringYear.setValue(null);
					sweageDataInputMonitoringType.setValue(null);
					sweageDataInputMonitoringLocation.setText(null);
					sweageDataInputMonitoringLabCode.setText(null);
					sweageDataInputMonitoringserialcombobox.setValue(null);
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
				}else
				{
					sweageDataInputMonitoringDAY.setValue(null);
					sweageDataInputMonitoringMonth.setValue(null);
					sweageDataInputMonitoringYear.setValue(null);
					sweageDataInputMonitoringType.setValue(null);
					sweageDataInputMonitoringName.setValue(null);
					sweageDataInputMonitoringLocation.setText(null);
					sweageDataInputMonitoringLabCode.setText(null);
					sweageDataInputMonitoringserialcombobox.setValue(null);
					sweageDataInputMonitoringbod.setText(null);
					sweageDataInputMonitoringpox.setText(null);
					sweageDataInputMonitoringnox.setText(null);
					sweageDataInputMonitoringss.setText(null);
					sweageDataInputMonitoringtemperature.setText(null);
					sweageDataInputMonitoringcoliform.setText(null);
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
	
	//********Monitoring Data Input( ENDS )*******//
	
	// Sweage -> Industry -> Report
	@FXML
	public void actionsweageIndustryReport(ActionEvent event) throws JRException, SQLException{
//		JasperReport jr= JasperCompileManager.compileReport("F:\\Ict\\JAVA\\Environment\\src\\application\\sweageindustryreport.jrxml");
//		JasperPrint jp= JasperFillManager.fillReport(jr, null,con);
//		JasperViewer.viewReport(jp, false);
		
		String industryquery;
		String datefrom = sweageindustryreportdatefrom.getValue();
		String monthfrom = sweageindustryreportmonthfrom.getValue();
		String yearfrom = sweageindustryreportyearfrom.getValue();
		String dateto = sweageindustryreportdateto.getValue();
		String monthto = sweageindustryreportmonthto.getValue();
		String yearto = sweageindustryreportyearto.getValue();
		String IndustryName = sweageindustryreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from sweageindustryreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from sweageindustrydatainput";
			rSet = stat.executeQuery(allDataQuery);
			
			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("indsutryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("indsutrtype");
				String bod = rSet.getString("bod");
				String pox = rSet.getString("pox");
				String nox = rSet.getString("nox");
				String ss = rSet.getString("ss");
				String temperature = rSet.getString("temperature");
				String coliform = rSet.getString("coliform");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO sweageindustryreport (date, indsutryname, indsutrtype,  labcode,  bod, pox, nox , ss, temperature, coliform, remarks, location)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, bod);
				preparedStatement.setString(6, pox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, ss);
				preparedStatement.setString(9, temperature);
				preparedStatement.setString(10, coliform);
				preparedStatement.setString(11, remarks);
				preparedStatement.setString(12, indsutrylocation);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweageindustryreport.jrxml");
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
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from sweageindustryreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from sweageindustrydatainput where " +  "indsutryname like " + "'" + IndustryName + "'";
			rSet = stat.executeQuery(industryquery);
			
			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("indsutryname");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("indsutrtype");
				String bod = rSet.getString("bod");
				String pox = rSet.getString("pox");
				String nox = rSet.getString("nox");
				String ss = rSet.getString("ss");
				String temperature = rSet.getString("temperature");
				String coliform = rSet.getString("coliform");
				String remarks = rSet.getString("remarks");

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO sweageindustryreport (date, indsutryname, indsutrtype,  labcode,  bod, pox, nox , ss, temperature, coliform, remarks, location)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, bod);
				preparedStatement.setString(6, pox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, ss);
				preparedStatement.setString(9, temperature);
				preparedStatement.setString(10, coliform);
				preparedStatement.setString(11, remarks);
				preparedStatement.setString(12, indsutrylocation);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweageindustryreport.jrxml");
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

			
			
			String deleteQuery = "delete from sweageindustryreport";
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
							query = "select * from sweageindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and indsutryname like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from sweageindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
						}
						

			
						rSet = stat.executeQuery(query);
						
						while (rSet.next()) {
							String DAY = rSet.getString("day");
							String MONTH = rSet.getString("month");
							String YEAR = rSet.getString("year");
							String indsutryname = rSet.getString("indsutryname");
							String labcode = rSet.getString("labcode");
							String indsutrylocation = rSet.getString("location");
							String indsutrytype = rSet.getString("indsutrtype");
							String bod = rSet.getString("bod");
							String pox = rSet.getString("pox");
							String nox = rSet.getString("nox");
							String ss = rSet.getString("ss");
							String temperature = rSet.getString("temperature");
							String coliform = rSet.getString("coliform");
							String remarks = rSet.getString("remarks");

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							

							// //Adding into database
							String insertquery = "INSERT INTO sweageindustryreport (date, indsutryname, indsutrtype,  labcode,  bod, pox, nox , ss, temperature, coliform, remarks, location)"
									+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, bod);
							preparedStatement.setString(6, pox);
							preparedStatement.setString(7, nox);
							preparedStatement.setString(8, ss);
							preparedStatement.setString(9, temperature);
							preparedStatement.setString(10, coliform);
							preparedStatement.setString(11, remarks);
							preparedStatement.setString(12, indsutrylocation);


							preparedStatement.execute();

						}
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweageindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
	
		
		
		
	}
	
	
	@FXML
	public void actionsweagereportmonitoring(ActionEvent event) throws JRException, SQLException{
//		JasperReport jr= JasperCompileManager.compileReport("F:\\Ict\\JAVA\\Environment\\src\\application\\sweagemonitoringreport.jrxml");
//		JasperPrint jp= JasperFillManager.fillReport(jr, null,con);
//		JasperViewer.viewReport(jp, false);
		
		String industryquery;
		String datefrom = sweagemonitoringreportdatefrom.getValue();
		String monthfrom = sweagemonitoringreportmonthfrom.getValue();
		String yearfrom = sweagemonitoringreportyearfrom.getValue();
		String dateto = sweagemonitoringreportdateto.getValue();
		String monthto = sweagemonitoringreportmonthto.getValue();
		String yearto = sweagemonitoringreportyearto.getValue();
		String IndustryName = sweagemonitoringreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from sweagemonitoringreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from sweagemonitoringdatainput";
			rSet = stat.executeQuery(allDataQuery);
			
			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("name");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("type");
				String bod = rSet.getString("bod");
				String pox = rSet.getString("pox");
				String nox = rSet.getString("nox");
				String ss = rSet.getString("ss");
				String temperature = rSet.getString("temperature");
				String coliform = rSet.getString("coliform");
				

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO sweagemonitoringreport (date, name, type,  labcode,  bod, pox, nox , ss, temperature, coliform,  location)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, bod);
				preparedStatement.setString(6, pox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, ss);
				preparedStatement.setString(9, temperature);
				preparedStatement.setString(10, coliform);
				preparedStatement.setString(11, indsutrylocation);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweagemonitoringreport.jrxml");
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
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from sweagemonitoringreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from sweagemonitoringdatainput where " +  "name like " + "'" + IndustryName + "'";
			rSet = stat.executeQuery(industryquery);
			while (rSet.next()) {
				String DAY = rSet.getString("day");
				String MONTH = rSet.getString("month");
				String YEAR = rSet.getString("year");
				String indsutryname = rSet.getString("name");
				String labcode = rSet.getString("labcode");
				String indsutrylocation = rSet.getString("location");
				String indsutrytype = rSet.getString("type");
				String bod = rSet.getString("bod");
				String pox = rSet.getString("pox");
				String nox = rSet.getString("nox");
				String ss = rSet.getString("ss");
				String temperature = rSet.getString("temperature");
				String coliform = rSet.getString("coliform");
				

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				

				// //Adding into database
				String insertquery = "INSERT INTO sweagemonitoringreport (date, name, type,  labcode,  bod, pox, nox , ss, temperature, coliform,  location)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, bod);
				preparedStatement.setString(6, pox);
				preparedStatement.setString(7, nox);
				preparedStatement.setString(8, ss);
				preparedStatement.setString(9, temperature);
				preparedStatement.setString(10, coliform);
				preparedStatement.setString(11, indsutrylocation);


				preparedStatement.execute();

			}
			
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweagemonitoringreport.jrxml");
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

			
			
			String deleteQuery = "delete from sweagemonitoringreport";
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
							query = "select * from sweagemonitoringdatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and name like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from sweagemonitoringdatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date + "'";
						}
						

			
						rSet = stat.executeQuery(query);
						while (rSet.next()) {
							String DAY = rSet.getString("day");
							String MONTH = rSet.getString("month");
							String YEAR = rSet.getString("year");
							String indsutryname = rSet.getString("name");
							String labcode = rSet.getString("labcode");
							String indsutrylocation = rSet.getString("location");
							String indsutrytype = rSet.getString("type");
							String bod = rSet.getString("bod");
							String pox = rSet.getString("pox");
							String nox = rSet.getString("nox");
							String ss = rSet.getString("ss");
							String temperature = rSet.getString("temperature");
							String coliform = rSet.getString("coliform");
							

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							

							// //Adding into database
							String insertquery = "INSERT INTO sweagemonitoringreport (date, name, type,  labcode,  bod, pox, nox , ss, temperature, coliform,  location)"
									+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, bod);
							preparedStatement.setString(6, pox);
							preparedStatement.setString(7, nox);
							preparedStatement.setString(8, ss);
							preparedStatement.setString(9, temperature);
							preparedStatement.setString(10, coliform);
							preparedStatement.setString(11, indsutrylocation);


							preparedStatement.execute();

						}
						
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\sweagemonitoringreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
		
		
	}

	public void actioncleardatesweageindustry(ActionEvent event){
		sweageindustryreportdatefrom.setValue(null);
		sweageindustryreportmonthfrom.setValue(null);
		sweageindustryreportyearfrom.setValue(null);
		sweageindustryreportdateto.setValue(null);
		sweageindustryreportmonthto.setValue(null);
		sweageindustryreportyearto.setValue(null);
	}
	public void actioncleardatesweagemonitoring(ActionEvent event){
		sweagemonitoringreportdatefrom.setValue(null);
		sweagemonitoringreportmonthfrom.setValue(null);
		sweagemonitoringreportyearfrom.setValue(null);
		sweagemonitoringreportdateto.setValue(null);
		sweagemonitoringreportmonthto.setValue(null);
		sweagemonitoringreportyearto.setValue(null);
	}
}
