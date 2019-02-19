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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import jxl.read.biff.SharedStringFormulaRecord;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class soundIndustryController implements Initializable {
	
	//Sound ->Industry -> Report
	@FXML
	public Label reportdatetext = new Label();
	@FXML
	public Label reportdatetotext = new Label();
	@FXML
	public RadioButton soundindustrystandlimitfalse = new RadioButton();
	@FXML
	public RadioButton soundindustrystandardlimittrue = new RadioButton();
	@FXML
	public CheckBox ReportPrintingForOrganizationChecker = new CheckBox();
	@FXML
	public ComboBox<String> soundindustryreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundindustryreportindustryname = new ComboBox<>();
	
	// All Elememts for Sound -> Industry -> Registration
	@FXML
	public ComboBox<String> soundIndustryRegistrationType = new ComboBox<>();
	@FXML
	public TextArea soundIndustryRegistrationLocation = new TextArea();
	@FXML
	public TextField soundIndustryRegistrationName = new TextField();
	
	// All elements for Sound -> Industry -> Data Input
	@FXML
	public CheckBox soundindustrycheckbox = new CheckBox();
	@FXML
	public CheckBox soundmonitoringcheckbox = new CheckBox();
	@FXML
	public ComboBox<String> soundIndustryDay = new ComboBox<>();
	@FXML
	public ComboBox<String> soundIndustryMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> soundIndustryYear = new ComboBox<>();
	@FXML
	public ComboBox<String> soundIndustryType = new ComboBox<>();
	@FXML
	public ComboBox<String> soundIndustryName = new ComboBox<>();
	@FXML
	public TextArea soundIndustryLocation = new TextArea();
	@FXML
	public TextField soundIndustryLabCode = new TextField();
	@FXML
	public TextField soundIndustrySoundLevel = new TextField();
	@FXML
	public ComboBox<String> soundindustrydatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<String> soundIndustrySampleLocation = new ComboBox<>();
	@FXML
	public ComboBox<Integer> soundindustryserialcombobox = new ComboBox<>();
	@FXML
	public Label soundindustryseriallabel ;
	@FXML
	public TextArea soundIndustryDataInputRemarks = new TextArea();
	
	
	//Sound ->Monnitoring -> Report
	//Sound ->Industry -> Report
	@FXML
	public Label reportmonitoringdatetext = new Label();
	@FXML
	public Label reportmonitoringdatetotext = new Label();
	@FXML
	public RadioButton soundmonitoringstandlimitfalse = new RadioButton();
	@FXML
	public RadioButton soundmonitoringstandardlimittrue = new RadioButton();
	@FXML
	public CheckBox monitoringReportPrintingForOrganizationChecker = new CheckBox();
	
	@FXML
	public ComboBox<String> soundmonitoringreportdatefrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportmonthfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportyearfrom = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportdateto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportmonthto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportyearto = new ComboBox<>();
	@FXML
	public ComboBox<String> soundmonitoringreportindustryname = new ComboBox<>();
	
	
	// All elements for Sound -> Monitoring -> Registration
	@FXML
	public TextArea soundMonitoringRegistrationLocation = new TextArea();
	@FXML
	public TextField soundMonitoringRegistrationName = new TextField();
	@FXML
	public ComboBox<String> soundMonitoringRegistrationType = new ComboBox<>();
	
	// All elements for Sound -> Monitoring -> Data Input
	@FXML
	public ComboBox<String> soundMonitoringDAY = new ComboBox<>();
	@FXML
	public ComboBox<String> soundMonitoringMonth = new ComboBox<>();
	@FXML
	public ComboBox<String> soundMonitoringYear = new ComboBox<>();
	@FXML
	public ComboBox<String> soundMonitoringName = new ComboBox<>();
	@FXML
	public ComboBox<String> soundMonitoringType = new ComboBox<>();
	@FXML
	public TextArea soundMonitoringLocation = new TextArea();
	@FXML
	public TextField soundMonitoringLabCode = new TextField();
	@FXML
	public TextField soundMonitoringSoundLevel = new TextField();
	@FXML
	public ComboBox<String> soundmonitoringdatacombobox = new ComboBox<>();
	@FXML
	public ComboBox<Integer> soundmonitoringserialcombobox = new ComboBox<>();
	@FXML
	public Label soundmonitoringseriallabel ;
	

	// Directory
	public String reprotDirectory = "C:\\Govt_Environment\\report";
	
	ObservableList<String> soundindustrynamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> soundindustrynameFilteredlist = new FilteredList<String>(soundindustrynamelist, p -> true);
	
	ObservableList<String> soundindustrytypelist = FXCollections.observableArrayList();
	
	ObservableList<String> soundindustrynamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> soundindustrynameFilteredlistforreport = new FilteredList<String>(soundindustrynamelistforreport, p -> true);
	
	ObservableList<String> soundndustrysamplelocationlist = FXCollections.observableArrayList("South side of factory", "North side of factory", "East side of factory", "West side of factory");
	ObservableList<String> soundmonitoringnamelistforreport = FXCollections.observableArrayList("Refresh","All Data");
	FilteredList<String> soundmonitoringnameFilteredlistforreport = new FilteredList<String>(soundmonitoringnamelistforreport, p -> true);
	ObservableList<String> indsutrytypelist = FXCollections.observableArrayList("Refresh", "Sugar(Production ≥ 50 Ton)", "Sugar(Production< 50 Ton)", "Tannery", "Cement",
			"Architect", "Fertilizer", "Pulp & Paper", "Distillery", "Embrodery", "Decorator", "Ceramic", "Weaving");
	ObservableList<String> day = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31");
	ObservableList<String> month = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"11", "12");
	ObservableList<String> year = FXCollections.observableArrayList("2020", "2019", "2018", "2017", "2016", "2015",
			"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002",
			"2001", "2000");
	ObservableList<String> soundmonitoringtypelist = FXCollections.observableArrayList("Refresh", "Market", "Institution");
	
	ObservableList<String> soundmonitoringdatainputnamelist = FXCollections.observableArrayList("Refresh");
	FilteredList<String> soundmonitoringdatainputFilterednamelist = new FilteredList<String>(soundmonitoringdatainputnamelist, p -> true);
	
	ObservableList<String> soundmonitoringdatainputtypelist = FXCollections.observableArrayList();
	ObservableList<String> soundindustrydatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> soundindustrydatainputidlist = FXCollections.observableArrayList();
	ObservableList<String> soundmonitoringdatacovertingtype = FXCollections.observableArrayList("Add", "Edit", "Delete");
	ObservableList<Integer> soundmonitoringdatainputidlist = FXCollections.observableArrayList();
	

	// All elements for database connection
	public Connection con;
	public java.sql.Statement stat;
	public ResultSet rSet;
	
	//Variables
	public String SoundIndustryFullData = "shaem";
	public String SoundMonitoringFullData = "shaem";
	public String SoundIndustryDataConvertingType = "";
	public String SoundMonitoringDataConvertingType = "";
	public String reportfullData = "null";
	public String monitoringreportfullData = "null";
	
	public soundIndustryController() {
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		soundIndustryRegistrationType.setItems(indsutrytypelist);
		soundIndustryDay.setItems(day);
		soundIndustryMonth.setItems(month);
		soundIndustryYear.setItems(year);
		soundIndustryType.setItems(soundindustrytypelist);
		soundindustrydatacombobox.setItems(soundindustrydatacovertingtype);
		soundIndustrySampleLocation.setItems(soundndustrysamplelocationlist);
		
		soundindustrydatacombobox.setValue("Add");
		soundindustryserialcombobox.setDisable(true);
		soundindustryserialcombobox.setOpacity(0);
		soundmonitoringdatacombobox.setItems(soundmonitoringdatacovertingtype);
		soundmonitoringdatacombobox.setValue("Add");
		soundmonitoringserialcombobox.setDisable(true);
		soundmonitoringserialcombobox.setOpacity(0);
		//soundindustryseriallabel.setText("");
		//soundindustryseriallabel.setOpacity(0);
		
		soundMonitoringRegistrationType.setItems(soundmonitoringtypelist);
		soundMonitoringDAY.setItems(day);
		soundMonitoringMonth.setItems(month);
		soundMonitoringYear.setItems(year);
		
		soundindustryreportdatefrom.setItems(day);
		soundindustryreportmonthfrom.setItems(month);
		soundindustryreportyearfrom.setItems(year);
		soundindustryreportdateto.setItems(day);
		soundindustryreportmonthto.setItems(month);
		soundindustryreportyearto.setItems(year);
		
		soundmonitoringreportdatefrom.setItems(day);
		soundmonitoringreportmonthfrom.setItems(month);
		soundmonitoringreportyearfrom.setItems(year);
		soundmonitoringreportdateto.setItems(day);
		soundmonitoringreportmonthto.setItems(month);
		soundmonitoringreportyearto.setItems(year);
		
		
		// Industry report radio button setup
		soundindustrystandlimitfalse.setVisible(false);
		soundindustrystandlimitfalse.setOpacity(0);
		soundindustrystandardlimittrue.setVisible(false);
		soundindustrystandardlimittrue.setOpacity(0);
		
		// Industry report radio button setup
		soundmonitoringstandlimitfalse.setVisible(false);
		soundmonitoringstandlimitfalse.setOpacity(0);
		soundmonitoringstandardlimittrue.setVisible(false);
		soundmonitoringstandardlimittrue.setOpacity(0);
		
		
		actionSoundIndustryReportIndustryNameCombobox(null);
		soundindustryreportindustryname.setItems(soundindustrynamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // Sound -> Report -> Industryname
	    soundindustryreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionSoundIndustryReportIndustryNameCombobox(null, newValue));
	    
	    actionSoundMonitoringReportIndustryNameCombobox(null);
		soundmonitoringreportindustryname.setItems(soundmonitoringnamelistforreport);
		
		// Listener for Adding Industry Type of Corresponding Industry Name In
	    // Sounf -> Report -> Industryname
		soundmonitoringreportindustryname.getSelectionModel().selectedItemProperty().addListener(
		(options, oldValue, newValue) -> actionSoundMonitoringReportIndustryNameCombobox(null, newValue));
				
		
		// Sound -> Industry -> Registration for adding items in initialize
		actionSoundIndustryRegistrationIndustryTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In Sound -> Industry -> Registration 
		soundIndustryRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionSoundIndustryRegistrationIndustryTypeComboboxForInitialize());
		
		//Sound -> Industry -> Data Input for adding Industry Names in initialize
		actionSoundIndustryDataInputIndustryNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In Sound -> Industry -> Data Input 
		soundIndustryName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionSoundIndustryDataInputIndustryNameCombobox(null, newValue));
		
		// Sound -> Monitoring -> Registration -> Industry Type for Initialize
		actionSoundMonitoringRegistrationTypeComboboxForInitialize();
		
		//Listener for Adding New Industry Type  In Sound -> Monitoring -> Registration 
		soundMonitoringRegistrationType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		actionSoundMonitoringRegistrationTypeComboboxForInitialize());
		
		//Sound -> Monitoring -> Data Input for adding Industry Names in initialize
		SoundMonitoringDataInputNameCombobox();
		
		// Listener for Adding Industry Type of Corresponding Industry Name In Sound -> Monitoring -> Data Input 
		soundMonitoringName.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		SoundMonitoringDataInputNameCombobox(null, newValue));
		
		//Listener for Data converting type Sound -> Industry -> Data Input -> Data converting combobox
		soundindustrydatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		SoundIndustryDataInputConverting(null, newValue));
		
		//Listener for Data converting type Sound -> Industry -> Data Input -> Data converting combobox
		soundindustryserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
		SoundIndustryDataLoadingforcorrespondingserialno(null, newValue));
		
		//Listener for Data converting type Sound -> Monitoring -> Data Input -> Data converting combobox
	    soundmonitoringdatacombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
	    SoundMonitoringDataInputConverting(null, newValue));
	    
	    //Listener for Data converting type Sound -> Monitoring -> Data Input -> Data converting combobox
	    soundmonitoringserialcombobox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->
	    SoundMonitoringDataLoadingforcorrespondingserialno(null, newValue));


		soundIndustryName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = soundIndustryName.getEditor();
            final String selected = soundIndustryName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	soundindustrynameFilteredlist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		soundIndustryName.setItems(soundindustrynameFilteredlist);
		
		
		
		soundMonitoringName.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = soundMonitoringName.getEditor();
            final String selected = soundMonitoringName.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	soundmonitoringdatainputFilterednamelist.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		soundMonitoringName.setItems(soundmonitoringdatainputFilterednamelist);
        
		soundindustryreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = soundindustryreportindustryname.getEditor();
            final String selected = soundindustryreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	soundindustrynameFilteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		soundindustryreportindustryname.setItems(soundindustrynameFilteredlistforreport);
		
		soundmonitoringreportindustryname.getEditor().textProperty().addListener((obs, oldValue, newValue) -> {
			
            final TextField editor = soundmonitoringreportindustryname.getEditor();
            final String selected = soundmonitoringreportindustryname.getSelectionModel().getSelectedItem();

            Platform.runLater(() -> {
                if (selected == null || !selected.equals(editor.getText())) {
                	soundmonitoringnameFilteredlistforreport.setPredicate(item -> {
                        if (item.toUpperCase().startsWith(newValue.toUpperCase())) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            });

        });
		soundmonitoringreportindustryname.setItems(soundmonitoringnameFilteredlistforreport);
		
		
	}
	
	
	public void actionSoundMonitoringReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from soundmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					soundmonitoringnamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionSoundIndustryReportIndustryNameCombobox(ActionEvent event) {
		try {
			String query = "select * from soundindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					soundindustrynamelistforreport.add(item);
				}
			}
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void actionSoundIndustryReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from soundindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (reportfullData.contains(item)) {
				} else {
					reportfullData += item;
					soundindustrynamelistforreport.add(item);
					soundindustryreportindustryname.setItems(soundindustrynamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}

	public void actionSoundMonitoringReportIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from soundmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");

				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (monitoringreportfullData.contains(item)) {
				} else {
					monitoringreportfullData += item;
					soundmonitoringnamelistforreport.add(item);
					soundmonitoringreportindustryname.setItems(soundmonitoringnamelistforreport);
				}
			}
		} catch (Exception e) {
		}
	}

	
	
	//********Industry Registration( Starts )*******//
	
	
	// Sound -> Industry -> Registration -> Industry Type for Initialize
	public void actionSoundIndustryRegistrationIndustryTypeComboboxForInitialize() {
		try {
			String query = "select * from soundindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (indsutrytypelist.contains(item)) {
				} 
				else {
					indsutrytypelist.add(item);
				}
			}
			soundIndustryRegistrationType.setItems(indsutrytypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}

	// Sound -> Industry -> Registration
	@FXML
	public void actionSoundIndustryRegistrationSave(ActionEvent event) throws SQLException {
		String Industrytype = soundIndustryRegistrationType.getValue();
		String IndustryName = soundIndustryRegistrationName.getText();
		String IndsutryLocation = soundIndustryRegistrationLocation.getText();

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
			String query = "INSERT INTO soundindustryregistration (industrytype, industryname, industrylocation)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, Industrytype);
			preparedStatement.setString(2, IndustryName);
			preparedStatement.setString(3, IndsutryLocation);
			preparedStatement.execute();

			soundIndustryRegistrationType.setValue(null);
			soundIndustryRegistrationName.setText(null);
			soundIndustryRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}
	}
	//********Indsutry Registration( ENDS )*******//
	
	//********Indsutry Data Input( Starts )*******//
	
	public void actionSoundIndustryDataInputIndustryNameCombobox() {
		try {
			String query = "select * from soundindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (SoundIndustryFullData.contains(item)) {
				} else {
					SoundIndustryFullData += item;
					soundindustrynamelist.add(item);
				}
			}
			soundIndustryName.setItems(soundindustrynamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	public void actionSoundIndustryDataInputIndustryNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from soundindustryregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industryname");

				// Filtering Industries name and Algorithm not to include_in_ComboBox
				if (SoundIndustryFullData.contains(item)) {
				} else {
					SoundIndustryFullData += item;
					soundindustrynamelist.add(item);
					soundIndustryName.setItems(soundindustrynamelist);
				}
			}
			soundindustrytypelist.clear();
			query = "select * from soundindustryregistration where " + "industryname like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("industrytype");
				String item2 = rSet.getString("industrylocation");
				soundindustrytypelist.add(item);
				soundIndustryType.setItems(soundindustrytypelist);
				soundIndustryLocation.setText(item2);
			}
			
			String dataconvertingtype = soundindustrydatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				soundindustrydatainputidlist.clear();
				query = "select id from soundindustrydatainput where " + "indsutryname like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					soundindustrydatainputidlist.add(item);
					soundindustryserialcombobox.setItems(soundindustrydatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	@FXML
	public void actionSoundIndustrySaveButton(ActionEvent event){
		
		boolean checkbox = soundindustrycheckbox.isSelected();
		String day = soundIndustryDay.getValue();
		String Month = soundIndustryMonth.getValue();
		String Year = soundIndustryYear.getValue();
		String IndustryName = soundIndustryName.getValue();
		String Labcode = soundIndustryLabCode.getText();
		String Location = soundIndustryLocation.getText();
		String samplelocation = soundIndustrySampleLocation.getValue();
		String IndustryType = soundIndustryType.getValue();
		String SoundLevel = soundIndustrySoundLevel.getText();
		String Remarks = soundIndustryDataInputRemarks.getText();
		
		SoundIndustryDataConvertingType = soundindustrydatacombobox.getValue();
		
		if (IndustryName != "Refresh" && IndustryName.length() > 1 && SoundIndustryDataConvertingType == "Add" ) {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO soundindustrydatainput (day, month, year, indsutryname, location, labcode, indsutrtype, soundlevel, remarks, samplelocation)" + " VALUES (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, IndustryType);
				preparedStatement.setString(8, SoundLevel);
				preparedStatement.setString(9, Remarks);
				preparedStatement.setString(10, samplelocation);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				//Clearing all items after data saving
				if(checkbox){
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
					soundIndustrySampleLocation.setValue(null);
				}
				else{

					soundIndustryDay.setValue(null);
					soundIndustryMonth.setValue(null);
					soundIndustryYear.setValue(null);
					soundIndustryType.setValue(null);
					soundIndustryName.setValue(null);
					soundIndustrySampleLocation.setValue(null);
					soundIndustryLocation.setText(null);
					soundIndustryLabCode.setText(null);
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
				}

				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} 
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && SoundIndustryDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = soundindustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update soundindustrydatainput set day=?,month=?,year=?,indsutryname=?,indsutrtype=?,location=?,labcode=?,soundlevel=?,remarks=?,samplelocation=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, IndustryName);
				preparedStatement.setString(5, IndustryType);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, SoundLevel);
				preparedStatement.setString(9, Remarks);
				preparedStatement.setString(10, samplelocation);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				//Clearing all items after data saving
				if(checkbox){
					soundIndustryDay.setValue(null);
					soundIndustryMonth.setValue(null);
					soundIndustryYear.setValue(null);
					soundIndustryType.setValue(null);
					soundIndustrySampleLocation.setValue(null);
					soundIndustryLocation.setText(null);
					soundIndustryLabCode.setText(null);
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
				}
				else{

					soundIndustryDay.setValue(null);
					soundIndustryMonth.setValue(null);
					soundIndustryYear.setValue(null);
					soundIndustryType.setValue(null);
					soundIndustryName.setValue(null);
					soundIndustrySampleLocation.setValue(null);
					soundIndustryLocation.setText(null);
					soundIndustryLabCode.setText(null);
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (IndustryName != "Refresh" && IndustryName.length() > 1 && SoundIndustryDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = soundindustryserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from soundindustrydatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data saving
				if(checkbox){
					soundIndustryDay.setValue(null);
					soundIndustryMonth.setValue(null);
					soundIndustryYear.setValue(null);
					soundIndustryType.setValue(null);
					soundIndustrySampleLocation.setValue(null);
					soundIndustryLocation.setText(null);
					soundIndustryLabCode.setText(null);
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
				}
				else{

					soundIndustryDay.setValue(null);
					soundIndustryMonth.setValue(null);
					soundIndustryYear.setValue(null);
					soundIndustryType.setValue(null);
					soundIndustryName.setValue(null);
					soundIndustrySampleLocation.setValue(null);
					soundIndustryLocation.setText(null);
					soundIndustryLabCode.setText(null);
					soundindustryserialcombobox.setValue(null);
					soundIndustrySoundLevel.setText(null);
					soundIndustryDataInputRemarks.setText(null);
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
	
	// Sound -> Industry -> Data Input -> Data Converting Comboobox
	public void SoundIndustryDataInputConverting(ActionEvent event, String value) {
    
		SoundIndustryDataConvertingType = soundindustrydatacombobox.getValue();
		if(SoundIndustryDataConvertingType == "Add"){
			soundindustryserialcombobox.setDisable(true);
			soundindustryserialcombobox.setOpacity(0);
			soundindustryseriallabel.setDisable(true);
			soundindustryseriallabel.setOpacity(0);
		}
		if(SoundIndustryDataConvertingType ==  "Edit"){
			soundindustryserialcombobox.setDisable(false);
			soundindustryserialcombobox.setOpacity(1);
			soundindustryseriallabel.setDisable(false);
			soundindustryseriallabel.setOpacity(1);
		}
		if(SoundIndustryDataConvertingType == "Delete"){
			soundindustryserialcombobox.setDisable(false);
			soundindustryserialcombobox.setOpacity(1);
			soundindustryseriallabel.setDisable(false);
			soundindustryseriallabel.setOpacity(1);
		}

	}
	

	// Sound -> Industry -> Data Input -> Loading for corresponding serial no to edit.
	public void SoundIndustryDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = soundindustrydatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from soundindustrydatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
		
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String indsutryname = rSet.getString("indsutryname");
					String location = rSet.getString("location");
					String samplelocation = rSet.getString("samplelocation");
					String labcode = rSet.getString("labcode");
					String indsutrytype = rSet.getString("indsutrtype");
					String soundlevel = rSet.getString("soundlevel");
					String remarks = rSet.getString("remarks");				
					
					soundIndustryDay.setValue(day);
					soundIndustryMonth.setValue(month);
					soundIndustryYear.setValue(year);
					soundIndustryType.setValue(indsutrytype);
					soundIndustryLabCode.setText(labcode);
					soundIndustrySampleLocation.setValue(samplelocation);
					soundIndustryLocation.setText(location);
					soundIndustrySoundLevel.setText(soundlevel);
					soundIndustryDataInputRemarks.setText(remarks);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
	}
	//********Indsutry Data Input( ENDS )*******//

	//********Monitoring Registration( Starts )*******//
	// Sound -> Monitoring -> Registration -> Industry Type for Initialize
	public void actionSoundMonitoringRegistrationTypeComboboxForInitialize() {
		try {
			String query = "select * from soundmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("type");
				// Filtering Industries name and Algorithm not to include in
				// ComboBox
				if (soundmonitoringtypelist.contains(item)) {
				} 
				else {
					soundmonitoringtypelist.add(item);
				}
			}
			soundMonitoringRegistrationType.setItems(soundmonitoringtypelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	@FXML
	public void actionsoundMonitoringRegistrationSave(ActionEvent event) throws SQLException{
		String type = soundMonitoringRegistrationType.getValue();
		String Name = soundMonitoringRegistrationName.getText();
		String Location = soundMonitoringRegistrationLocation.getText();

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
			String query = "INSERT INTO soundmonitoringregistration (type, name, location)"
					+ " VALUES (?,?,?)";
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);

			preparedStatement.setString(1, type);
			preparedStatement.setString(2, Name);
			preparedStatement.setString(3, Location);
			preparedStatement.execute();

			soundMonitoringRegistrationType.setValue(null);
			soundMonitoringRegistrationName.setText(null);
			soundMonitoringRegistrationLocation.setText(null);

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Information Message");
			alert.setHeaderText("Access Granted !!");
			alert.setContentText("Your data has been successfully saved.");
			alert.showAndWait();

		}
	}
	//********Monitoring Registration( ENDS )*******//
	
	//********Monitoring Data Input( Starts )*******//
	
	// Sound -> Monitoring -> Data Input -> Data Converting Comboobox
	public void SoundMonitoringDataInputConverting(ActionEvent event, String value) {
    
		SoundMonitoringDataConvertingType = soundmonitoringdatacombobox.getValue();
		if(SoundMonitoringDataConvertingType == "Add"){
			soundmonitoringserialcombobox.setDisable(true);
			soundmonitoringserialcombobox.setOpacity(0);
			soundmonitoringseriallabel.setDisable(true);
			soundmonitoringseriallabel.setOpacity(0);
		}
		if(SoundMonitoringDataConvertingType ==  "Edit"){
			soundmonitoringserialcombobox.setDisable(false);
			soundmonitoringserialcombobox.setOpacity(1);
			soundmonitoringseriallabel.setDisable(false);
			soundmonitoringseriallabel.setOpacity(1);
		}
		if(SoundMonitoringDataConvertingType == "Delete"){
			soundmonitoringserialcombobox.setDisable(false);
			soundmonitoringserialcombobox.setOpacity(1);
			soundmonitoringseriallabel.setDisable(false);
			soundmonitoringseriallabel.setOpacity(1);
		}

	}	
	
	public void SoundMonitoringDataInputNameCombobox() {
		try {
			String query = "select * from soundmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (SoundMonitoringFullData.contains(item)) {
				} else {
					SoundMonitoringFullData += item;
					soundmonitoringdatainputnamelist.add(item);
				}
			}
			soundMonitoringName.setItems(soundmonitoringdatainputnamelist);
		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	
	public void SoundMonitoringDataInputNameCombobox(ActionEvent event, String value) {
		try {
			String query = "select * from soundmonitoringregistration";
			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				String item = rSet.getString("name");
				if (SoundMonitoringFullData.contains(item)) {
				} else {
					SoundMonitoringFullData += item;
					soundmonitoringdatainputnamelist.add(item);
					soundMonitoringName.setItems(soundmonitoringdatainputnamelist);
				}
			}
			query = "select * from soundmonitoringregistration where " + "name like " + "'" + value + "'";
			rSet = stat.executeQuery(query);
			soundmonitoringdatainputtypelist.clear();
			while (rSet.next()) {
				String item = rSet.getString("type");
				String item2 = rSet.getString("location");
				soundmonitoringdatainputtypelist.add(item);
				soundMonitoringType.setItems(soundmonitoringdatainputtypelist);
				soundMonitoringLocation.setText(item2);
			}
			
			String dataconvertingtype = soundmonitoringdatacombobox.getValue();
			if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
				soundmonitoringdatainputidlist.clear();
				query = "select id from soundmonitoringdatainput where " + "name like " + "'" + value + "'" + " Order by id DESC";
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					int item = rSet.getInt("id");
					soundmonitoringdatainputidlist.add(item);
					soundmonitoringserialcombobox.setItems(soundmonitoringdatainputidlist);
				}
			}

		} catch (Exception e) {
			System.out.println("Searching Error : " + e);
			e.printStackTrace();
		}

	}
	@FXML
	public void actionSoundMonitoringSaveButton(ActionEvent event){
		boolean checkbox = soundmonitoringcheckbox.isSelected();
		String day = soundMonitoringDAY.getValue();
		String Month = soundMonitoringMonth.getValue();
		String Year = soundMonitoringYear.getValue();
		String Name = soundMonitoringName.getValue();
		String Labcode = soundMonitoringLabCode.getText();
		String Location = soundMonitoringLocation.getText();
		String Type = soundMonitoringType.getValue();
		String SoundLevel = soundMonitoringSoundLevel.getText();
		
		SoundMonitoringDataConvertingType = soundmonitoringdatacombobox.getValue();
		if (Name != "Refresh" && Name.length() > 1 && SoundMonitoringDataConvertingType == "Add" ) {
			System.out.println("Ok");
			try {
	
				String query = "INSERT INTO soundmonitoringdatainput (day, month, year, name, location, labcode, type, soundlevel)" + " VALUES (?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(query);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Location);
				preparedStatement.setString(6, Labcode);
				preparedStatement.setString(7, Type);
				preparedStatement.setString(8, SoundLevel);

				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully saved.");
				alert.showAndWait();
				
				//Clearing all items after data saving
				if(checkbox){
					soundmonitoringserialcombobox.setValue(null);
					soundMonitoringSoundLevel.setText(null);
				}
				else{

					//Clearing all items after data Editiing
					soundMonitoringDAY.setValue(null);
					soundMonitoringMonth.setValue(null);
					soundMonitoringYear.setValue(null);
					soundMonitoringType.setValue(null);
					soundMonitoringName.setValue(null);
					soundMonitoringLocation.setText(null);
					soundMonitoringLabCode.setText(null);
					soundmonitoringserialcombobox.setValue(null);
					soundMonitoringSoundLevel.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		} 
		

		else if (Name != "Refresh" && Name.length() > 1 && SoundMonitoringDataConvertingType == "Edit" ) {
			System.out.println("Ok");
			try {
				int id = soundmonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Update soundmonitoringdatainput set day=?,month=?,year=?,name=?,type=?,location=?,labcode=?,soundlevel=? where id like "+id;
				
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				preparedStatement.setString(1, day);
				preparedStatement.setString(2, Month);
				preparedStatement.setString(3, Year);
				preparedStatement.setString(4, Name);
				preparedStatement.setString(5, Type);
				preparedStatement.setString(6, Location);
				preparedStatement.setString(7, Labcode);
				preparedStatement.setString(8, SoundLevel);
				preparedStatement.execute();
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Updated.");
				alert.showAndWait();
				
				//Clearing all items after data saving
				if(checkbox){
					soundMonitoringSoundLevel.setText(null);
				}
				else{

					//Clearing all items after data Editiing
					soundMonitoringDAY.setValue(null);
					soundMonitoringMonth.setValue(null);
					soundMonitoringYear.setValue(null);
					soundMonitoringType.setValue(null);
					soundMonitoringName.setValue(null);
					soundMonitoringLocation.setText(null);
					soundMonitoringLabCode.setText(null);
					soundmonitoringserialcombobox.setValue(null);
					soundMonitoringSoundLevel.setText(null);
				}
				
			} catch (Exception ex) {
				System.out.println("Inserting Error : " + ex);
			}
		}
		else if (Name != "Refresh" && Name.length() > 1 && SoundMonitoringDataConvertingType == "Delete" ) {
			System.out.println("Ok");
			try {
				int id = soundmonitoringserialcombobox.getValue();
				System.out.println("ID : " +id);
				
				String sql="Delete from soundmonitoringdatainput where id = "+id;
				stat.executeUpdate(sql);

				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText("Access Granted !!");
				alert.setContentText("Your data has been successfully Removed.");
				alert.showAndWait();
				
				//Clearing all items after data saving
				if(checkbox){
					soundMonitoringSoundLevel.setText(null);
				}
				else{

					//Clearing all items after data Editiing
					soundMonitoringDAY.setValue(null);
					soundMonitoringMonth.setValue(null);
					soundMonitoringYear.setValue(null);
					soundMonitoringType.setValue(null);
					soundMonitoringName.setValue(null);
					soundMonitoringLocation.setText(null);
					soundMonitoringLabCode.setText(null);
					soundmonitoringserialcombobox.setValue(null);
					soundMonitoringSoundLevel.setText(null);
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
	
	// Sound -> Monitoring -> Data Input -> Loading for corresponding serial no to edit.
	public void SoundMonitoringDataLoadingforcorrespondingserialno(ActionEvent event, int serialno){
		String Serialno = ""+serialno;
		String dataconvertingtype = soundmonitoringdatacombobox.getValue();
		if(dataconvertingtype == "Edit" || dataconvertingtype == "Delete"){
			String query = "select * from soundmonitoringdatainput where " + "id like " + "'" + Serialno + "'";
			try {
				rSet = stat.executeQuery(query);
				while (rSet.next()) {
					
					String day = rSet.getString("day");
					String month = rSet.getString("month");
					String year = rSet.getString("year");
					String name = rSet.getString("name");
					String location = rSet.getString("location");
					String labcode = rSet.getString("labcode");
					String type = rSet.getString("type");
					String soundlevel = rSet.getString("soundlevel");				
					
					soundMonitoringDAY.setValue(day);
					soundMonitoringMonth.setValue(month);
					soundMonitoringYear.setValue(year);
					soundMonitoringType.setValue(type);
					soundMonitoringLabCode.setText(labcode);
					soundMonitoringLocation.setText(location);
					soundMonitoringSoundLevel.setText(soundlevel);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		
	}
	
	//********Monitoring Data Input( ENDS )*******//
	
	// Sound -> Industry -> Report
	@FXML
	public void actionSoundIndustryReport(ActionEvent event) throws JRException, SQLException{
		boolean reportPrintingForOrganization = ReportPrintingForOrganizationChecker.isSelected();
		
		String industryquery;
		String datefrom = soundindustryreportdatefrom.getValue();
		String monthfrom = soundindustryreportmonthfrom.getValue();
		String yearfrom = soundindustryreportyearfrom.getValue();
		String dateto = soundindustryreportdateto.getValue();
		String monthto = soundindustryreportmonthto.getValue();
		String yearto = soundindustryreportyearto.getValue();
		String IndustryName = soundindustryreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from soundindustryreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from soundindustrydatainput";
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
				String soundlevel = rSet.getString("soundlevel");
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
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				if(remarks == null || remarks == "" || remarks == " ")
					remarks = "-";

				// //Adding into database
				String insertquery = "INSERT INTO soundindustryreport (date, indsutryname, indsutrtype,  labcode,  soundlevel, remarks, location, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, remarks);
				preparedStatement.setString(7, indsutrylocation);
				preparedStatement.setString(8, samplelocation);
				preparedStatement.setString(9, serial);


				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundindustryreport.jrxml");
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

			String deleteQuery = "delete from soundindustryindividualreport";
			stat.execute(deleteQuery);

			String idealsoundlevel = "-";
			String sampledate = "-";
			String subject ="-";
			String reference = "-";
			String signaturetemplate = "-";
			String description = "-";
			String remarks = "-";

			String query = "select * from soundindustrystandarddatasave";

			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				sampledate = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				reference = rSet.getString("reference");
				signaturetemplate = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				idealsoundlevel = rSet.getString("idealsoundlevel");
				remarks = rSet.getString("remarks");
			}
			
			subject = "Subject : "+ subject;
			reference = "Reference : "+ reference;
			sampledate = "Date : "+sampledate;
			remarks = "*Remarks : "+remarks;

			if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
					&& yearto == null) {
				industryquery = "select * from soundindustrydatainput where " + "indsutryname like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			} else {
				industryquery = "select * from soundindustrydatainput where " + "year like " + "'" + Yearfrom
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
				String soundlevel = rSet.getString("soundlevel");
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
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				if(remarks == null || remarks == "")
					remarks = "-";

				fulldate = "Sample Collection Date : "+fulldate;
				id = "Memo No : "+ id;

				// //Adding into database
				String insertquery = "INSERT INTO soundindustryindividualreport (date, industryname, industrytype,  labcode, soundlevel, remarks, location, samplelocation,  idealsoundlevel,memono,sampledate,subject,reference,signaturetemplate,description)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, remarks);
				preparedStatement.setString(7, indsutrylocation);
				preparedStatement.setString(8, samplelocation);
				preparedStatement.setString(9, idealsoundlevel);
				preparedStatement.setString(10, id);
				preparedStatement.setString(11, sampledate);
				preparedStatement.setString(12, subject);
				preparedStatement.setString(13, reference);
				preparedStatement.setString(14, signaturetemplate);
				preparedStatement.setString(15, description);

				preparedStatement.execute();

			}
			if(soundindustrystandlimitfalse.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\soundindustryindividualreportwithoutstandardlimt.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}
			if(soundindustrystandardlimittrue.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\soundindustryindividualreport.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

		}
		// Just for Showing not printing.
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from soundindustryreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from soundindustrydatainput where " +  "indsutryname like " + "'" + IndustryName + "'";
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
				String soundlevel = rSet.getString("soundlevel");
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
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				if(remarks == null || remarks == "")
					remarks = "-";

				// //Adding into database
				String insertquery = "INSERT INTO soundindustryreport (date, indsutryname, indsutrtype,  labcode,  soundlevel, remarks, location, samplelocation, serial)"
						+ " VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, remarks);
				preparedStatement.setString(7, indsutrylocation);
				preparedStatement.setString(8, samplelocation);
				preparedStatement.setString(9, serial);


				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundindustryreport.jrxml");
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

			
			
			String deleteQuery = "delete from soundindustryreport";
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
							query = "select * from soundindustrydatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and indsutryname like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from soundindustrydatainput where " + "year like " + "'" + year
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
							String soundlevel = rSet.getString("soundlevel");
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
							if(soundlevel == null || soundlevel == "")
								soundlevel = "-";
							if(remarks == null || remarks == "")
								remarks = "-";
							

							// //Adding into database
							String insertquery = "INSERT INTO soundindustryreport (date, indsutryname, indsutrtype,  labcode,  soundlevel, remarks, location, samplelocation, serial)"
									+ " VALUES (?,?,?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, soundlevel);
							preparedStatement.setString(6, remarks);
							preparedStatement.setString(7, indsutrylocation);
							preparedStatement.setString(8, samplelocation);
							preparedStatement.setString(9, serial);

							preparedStatement.execute();

						}					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundindustryreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
		
	}
	
	
	
	
	// Sound -> Monitoring -> Report
	@FXML
	public void actionSoundMonitoringReport(ActionEvent event) throws JRException, SQLException{
		boolean reportPrintingForOrganization = monitoringReportPrintingForOrganizationChecker.isSelected();
		
		String industryquery;
		String datefrom = soundmonitoringreportdatefrom.getValue();
		String monthfrom = soundmonitoringreportmonthfrom.getValue();
		String yearfrom = soundmonitoringreportyearfrom.getValue();
		String dateto = soundmonitoringreportdateto.getValue();
		String monthto = soundmonitoringreportmonthto.getValue();
		String yearto = soundmonitoringreportyearto.getValue();
		String IndustryName = soundmonitoringreportindustryname.getValue();
        if(IndustryName == "All Data" && datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null ){
        	
        	String deleteQuery = "delete from soundmonitoringreport";
			stat.execute(deleteQuery);
			
			String allDataQuery = "select * from soundmonitoringdatainput";
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
				String soundlevel = rSet.getString("soundlevel");
			

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				
				if(labcode == null || labcode == "")
					labcode = "-";
				if(indsutrylocation == null || indsutrylocation == "")
					indsutrylocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";

				// //Adding into database
				String insertquery = "INSERT INTO soundmonitoringreport (date, name, type,  labcode,  soundlevel, location, serial)"
						+ " VALUES (?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, indsutrylocation);
				preparedStatement.setString(7, serial);

				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundmonitoringreport.jrxml");
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

			String deleteQuery = "delete from soundmonitoringindividualreport";
			stat.execute(deleteQuery);

			String idealsoundlevel = "-";
			String sampledate = "-";
			String subject ="-";
			String reference = "-";
			String signaturetemplate = "-";
			String description = "-";
			String remarks = "-";

			String query = "select * from soundmonitoringstandarddatasave";

			rSet = stat.executeQuery(query);
			while (rSet.next()) {
				sampledate = rSet.getString("sampledate");
				subject = rSet.getString("subject");
				reference = rSet.getString("reference");
				signaturetemplate = rSet.getString("signaturetemplate");
				description = rSet.getString("description");
				idealsoundlevel = rSet.getString("idealsoundlevel");
				remarks = rSet.getString("remarks");
			}
			
			subject = "Subject : "+ subject;
			reference = "Reference : "+ reference;
			sampledate = "Date : "+sampledate;
			remarks = "*Remarks : "+remarks;
			
			String orginallocation = "";
			query = "select location from soundmonitoringregistration where name like "+"'"+ IndustryName +"'";
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
				industryquery = "select * from soundmonitoringdatainput where " + "name like " + "'"
						+ IndustryName + "'";
				rSet = stat.executeQuery(industryquery);
			} else {
				industryquery = "select * from soundmonitoringdatainput where " + "year like " + "'" + Yearfrom
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
				String soundlevel = rSet.getString("soundlevel");
				String id = rSet.getString("id");

				String fulldate;

				if(samplelocation == null){
					samplelocation = "-";
				}
			
				samplelocation = " "+ samplelocation;
				
				samplelocation = samplelocation.replaceAll("\n", " ");
				samplelocation = samplelocation.replaceAll("\r", " ");

				if (orginallocation.length() > 2) {
					indsutryname = "Name and Address of Sample : "+IndustryName + " ( " + orginallocation + " ).";
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
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				if(remarks == null || remarks == "")
					remarks = "-";

				
				if(labcode == null || labcode == "")
					labcode = "-";
				if(orginallocation == null || orginallocation == "")
					orginallocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				
				fulldate = "Sample Collection Date : "+fulldate;
				id = "Memo No : "+ id;

				
				
				// //Adding into database
				String insertquery = "INSERT INTO soundmonitoringindividualreport (date, industryname, industrytype,  labcode, soundlevel, remarks, location, samplelocation,  idealsoundlevel,memono,sampledate,subject,reference,signaturetemplate,description)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, remarks);
				preparedStatement.setString(7, orginallocation);
				preparedStatement.setString(8, samplelocation);
				preparedStatement.setString(9, idealsoundlevel);
				preparedStatement.setString(10, id);
				preparedStatement.setString(11, sampledate);
				preparedStatement.setString(12, subject);
				preparedStatement.setString(13, reference);
				preparedStatement.setString(14, signaturetemplate);
				preparedStatement.setString(15, description);

				preparedStatement.execute();

			}
			if(soundmonitoringstandlimitfalse.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\soundmonitoringindividualreportwithoutstandardlimt.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}
			if(soundmonitoringstandardlimittrue.isSelected()){
				JasperReport jr = JasperCompileManager
						.compileReport(reprotDirectory + "\\soundmonitoringindividualreport.jrxml");
				JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
				JasperViewer.viewReport(jp, false);
			}

		}
		// Just for Showing not printing.
        else if (datefrom == null && monthfrom == null && yearfrom == null && dateto == null && monthto == null
				&& yearto == null && IndustryName != null && IndustryName != "Refresh"){
			
			String deleteQuery = "delete from soundmonitoringreport";
			stat.execute(deleteQuery);
			
			industryquery = "select * from soundmonitoringdatainput where " +  "name like " + "'" + IndustryName + "'";
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
				String soundlevel = rSet.getString("soundlevel");
			

				String fulldate;
				if (DAY == null || MONTH == null || YEAR == null) {
					fulldate = " ";
				} else {
					fulldate = DAY + "." + MONTH + "." + YEAR;
				}
				
				if(labcode == null || labcode == "")
					labcode = "-";
				if(indsutrylocation == null || indsutrylocation == "")
					indsutrylocation = "-";
				if(indsutrytype == null || indsutrytype == "")
					indsutrytype = "-";
				if(soundlevel == null || soundlevel == "")
					soundlevel = "-";
				
				// //Adding into database
				String insertquery = "INSERT INTO soundmonitoringreport (date, name, type,  labcode,  soundlevel, location, serial)"
						+ " VALUES (?,?,?,?,?,?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
				preparedStatement.setString(1, fulldate);
				preparedStatement.setString(2, indsutryname);
				preparedStatement.setString(3, indsutrytype);
				preparedStatement.setString(4, labcode);
				preparedStatement.setString(5, soundlevel);
				preparedStatement.setString(6, indsutrylocation);
				preparedStatement.setString(7, serial);

				preparedStatement.execute();

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundmonitoringreport.jrxml");
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

			
			
			String deleteQuery = "delete from soundmonitoringreport";
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
							query = "select * from soundmonitoringdatainput where " + "year like " + "'" + year
									+ "' and month like " + "'" + month + "' and day like " + "'" + date
									+ "' and name like " + "'" + IndustryName + "'";
						}
						else {
							query = "select * from soundmonitoringdatainput where " + "year like " + "'" + year
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
							String soundlevel = rSet.getString("soundlevel");
						

							String fulldate;
							if (DAY == null || MONTH == null || YEAR == null) {
								fulldate = " ";
							} else {
								fulldate = DAY + "." + MONTH + "." + YEAR;
							}
							

							if(labcode == null || labcode == "")
								labcode = "-";
							if(indsutrylocation == null || indsutrylocation == "")
								indsutrylocation = "-";
							if(indsutrytype == null || indsutrytype == "")
								indsutrytype = "-";
							if(soundlevel == null || soundlevel == "")
								soundlevel = "-";
							
							// //Adding into database
							String insertquery = "INSERT INTO soundmonitoringreport (date, name, type,  labcode,  soundlevel, location, serial)"
									+ " VALUES (?,?,?,?,?,?,?)";
							PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(insertquery);
							preparedStatement.setString(1, fulldate);
							preparedStatement.setString(2, indsutryname);
							preparedStatement.setString(3, indsutrytype);
							preparedStatement.setString(4, labcode);
							preparedStatement.setString(5, soundlevel);
							preparedStatement.setString(6, indsutrylocation);
							preparedStatement.setString(7, serial);

							preparedStatement.execute();

						}
						
					}
					Datefrom = 1;

				}
				Monthfrom = 1;

			}
			JasperReport jr = JasperCompileManager.compileReport(reprotDirectory + "\\soundmonitoringreport.jrxml");
			JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
			JasperViewer.viewReport(jp, false);

		}
	
		
		
		
		
		
	}
	
	public void actioncleardatesoundindustry(ActionEvent event){
		soundindustryreportdatefrom.setValue(null);
		soundindustryreportmonthfrom.setValue(null);
		soundindustryreportyearfrom.setValue(null);
		soundindustryreportdateto.setValue(null);
		soundindustryreportmonthto.setValue(null);
		soundindustryreportyearto.setValue(null);
	}
	public void actioncleardatesoundmonitoring(ActionEvent event){
		soundmonitoringreportdatefrom.setValue(null);
		soundmonitoringreportmonthfrom.setValue(null);
		soundmonitoringreportyearfrom.setValue(null);
		soundmonitoringreportdateto.setValue(null);
		soundmonitoringreportmonthto.setValue(null);
		soundmonitoringreportyearto.setValue(null);
	}
	
	public void actionsoundindustrystandardlimit(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/soundidealvalues.fxml"));
		Scene scene2 = new Scene(root2, 531, 679);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Standard Limit Setting For Industrial Sound");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}
	
	public void actionsoundmonitoringstandardlimit(ActionEvent event) throws IOException {
		Stage primarystage2 = new Stage();
		Parent root2 = FXMLLoader.load(getClass().getResource("/application/soundmonitoringidealvalues.fxml"));
		Scene scene2 = new Scene(root2, 531, 679);
		primarystage2.setScene(scene2);
		primarystage2.setTitle("Standard Limit Setting For Routine Monitoring Sound");
		primarystage2.getIcons().add(new Image("file:C:/Govt_Environment/picture/logodoe.png"));
		primarystage2.setResizable(false);
		primarystage2.show();
	}
	
	
	public void actionsoundindustrycheckbox(ActionEvent event) {
		boolean check = ReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			reportdatetext.setText("Date From :");
			reportdatetotext.setVisible(true);
			reportdatetotext.setOpacity(1);
			soundindustryreportdateto.setVisible(true);
			soundindustryreportdateto.setOpacity(1);
			soundindustryreportmonthto.setVisible(true);
			soundindustryreportmonthto.setOpacity(1);
			soundindustryreportyearto.setVisible(true);
			soundindustryreportyearto.setOpacity(1);

			soundindustrystandlimitfalse.setVisible(false);
			soundindustrystandlimitfalse.setOpacity(0);
			soundindustrystandardlimittrue.setVisible(false);
			soundindustrystandardlimittrue.setOpacity(0);

		} else if (check) {
			reportdatetext.setText("Report For :");
			reportdatetotext.setVisible(false);
			reportdatetotext.setOpacity(0);
			soundindustryreportdateto.setVisible(false);
			soundindustryreportdateto.setOpacity(0);
			soundindustryreportmonthto.setVisible(false);
			soundindustryreportmonthto.setOpacity(0);
			soundindustryreportyearto.setVisible(false);
			soundindustryreportyearto.setOpacity(0);

			soundindustrystandardlimittrue.setSelected(true);
			soundindustrystandlimitfalse.setVisible(true);
			soundindustrystandlimitfalse.setOpacity(1);
			soundindustrystandardlimittrue.setVisible(true);
			soundindustrystandardlimittrue.setOpacity(1);
		}
	}
	
	
	
	public void actionsoundmonitoringcheckbox(ActionEvent event) {
		boolean check = monitoringReportPrintingForOrganizationChecker.isSelected();

		if (check == false) {
			reportmonitoringdatetext.setText("Date From :");
			reportmonitoringdatetotext.setVisible(true);
			reportmonitoringdatetotext.setOpacity(1);
			soundmonitoringreportdateto.setVisible(true);
			soundmonitoringreportdateto.setOpacity(1);
			soundmonitoringreportmonthto.setVisible(true);
			soundmonitoringreportmonthto.setOpacity(1);
			soundmonitoringreportyearto.setVisible(true);
			soundmonitoringreportyearto.setOpacity(1);

			soundmonitoringstandlimitfalse.setVisible(false);
			soundmonitoringstandlimitfalse.setOpacity(0);
			soundmonitoringstandardlimittrue.setVisible(false);
			soundmonitoringstandardlimittrue.setOpacity(0);

		} else if (check) {
			reportmonitoringdatetext.setText("Report For :");
			reportmonitoringdatetotext.setVisible(false);
			reportmonitoringdatetotext.setOpacity(0);
			soundmonitoringreportdateto.setVisible(false);
			soundmonitoringreportdateto.setOpacity(0);
			soundmonitoringreportmonthto.setVisible(false);
			soundmonitoringreportmonthto.setOpacity(0);
			soundmonitoringreportyearto.setVisible(false);
			soundmonitoringreportyearto.setOpacity(0);

			soundmonitoringstandardlimittrue.setSelected(true);
			soundmonitoringstandlimitfalse.setVisible(true);
			soundmonitoringstandlimitfalse.setOpacity(1);
			soundmonitoringstandardlimittrue.setVisible(true);
			soundmonitoringstandardlimittrue.setOpacity(1);
		}
	}
	
	
}
