package base;

import java.sql.Date;

public class PreDate {
	
	private int day;
	private int month;
	private int year;
	
	public PreDate(int year, int month, int day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public boolean estDateValide() {
		if (this.getDay() == 31) {
			if(this.getMonth() == 1 ||
					this.getMonth() == 3 ||
					this.getMonth() == 5 ||
					this.getMonth() == 8 ||
					this.getMonth() == 10) {
				return false;
			}
		}
		if(this.getMonth() == 1) {
			if(this.getDay() >= 29) {
				return false;
			}
		}
		return true;
	}
	
	public Date toDate() {
		return new Date(year, month, day);
	}
}
