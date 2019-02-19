package application;

public class WaterIndustryUser {
	   private String serial;
	   private String date;
	   private String name;

	 
	   public WaterIndustryUser(String serial, String date, String name) {
	       this.serial = serial;
	       this.date = date;
	       this.name = name;
	   }
	 
	   public String getserial() {
	       return serial;
	   }
	 
	   public void setserial(String serial) {
	       this.serial = serial;
	   }
	 
	   public String getdate() {
	       return date;
	   }
	 
	   public void setdate(String date) {
	       this.date = date;
	   }
	 
	   public String getname() {
	       return name;
	   }
	 
	   public void setname(String name) {
	       this.name = name;
	   }
	 
}
