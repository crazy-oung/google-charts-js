package vo;

public class Plot1 {
   private int year;
   private int temp;
   
   
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
   }
   public int getTemp() {
      return temp;
   }
   public void setTemp(int temp) {
      this.temp = temp;
   }
	@Override
	public String toString() {
		return "plot1 [year=" + year + ", temp=" + temp + "]";
	}
   
   
   
}