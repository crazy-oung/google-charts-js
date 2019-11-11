package vo;

public class Flight {
	int index;
	int year;
	String month;
	int passangers;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getPassangers() {
		return passangers;
	}
	public void setPassangers(int passangers) {
		this.passangers = passangers;
	}
	@Override
	public String toString() {
		return "flight [index=" + index + ", year=" + year + ", month=" + month + ", passangers=" + passangers + "]";
	}
	
}
