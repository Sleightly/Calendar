import java.util.*;

public class Calendar {

	int defaultYear = 2017; //default year is 2017
	int defaultDay = 0; //Sunday
	String space = "   ";
	String noVal = " --";
	String monthSpace = "                                       "+space;
	String noValLine = "                                             ";

	//Days of the week
	String sun = "Sun";
	String mon = "Mon";
	String tue = "Tue";
	String wed = "Wed";
	String thu = "Thu";
	String fri = "Fri";
	String sat = "Sat";

	String days = sun+space+mon+space+tue+space+wed+
				  space+thu+space+fri+space+sat+space+space;

	int leapDiff = 2; //difference in days when leap year

	//days in each month
	int jan = 31;
	int feb = 28;
	int mar = 31;
	int apr = 30;
	int may = 31;
	int jun = 30;
	int jul = 31;
	int aug = 31;
	int sep = 30;
	int oct = 31;
	int nov = 30;
	int dec = 31;

	//Months 
	String mJan = "Jan";
	String mFeb = "Feb";
	String mMar = "Mar";
	String mApr = "Apr";
	String mMay = "May";
	String mJun = "Jun";
	String mJul = "Jul";
	String mAug = "Aug";
	String mSep = "Sep";
	String mOct = "Oct";
	String mNov = "Nov";
	String mDec = "Dec";

	String m1l1 = noValLine;
	String m1l2 = noValLine;
	String m1l3 = noValLine;
	String m1l4 = noValLine;
	String m1l5 = noValLine;
	String m1l6 = noValLine;

	String m2l1 = noValLine;
	String m2l2 = noValLine;
	String m2l3 = noValLine;
	String m2l4 = noValLine;
	String m2l5 = noValLine;
	String m2l6 = noValLine;

	String m3l1 = noValLine;
	String m3l2 = noValLine;
	String m3l3 = noValLine;
	String m3l4 = noValLine;
	String m3l5 = noValLine;
	String m3l6 = noValLine;





	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("What year would you like to find?");
		double x = -1;
		while (x < 0){
			x = scn.nextDouble();
			if (x < 0) {
				System.out.println("Year cannot be negative. Please try again.");
			}
		}
		int year = (int) x;
		System.out.println();
		Calendar c = new Calendar();
		c.printCalender(year);
	}

	public void printCalender(int x) {
		boolean leap = checkLeapYear(x);
		int startDay = checkStartDay(x);
		System.out.println("Calendar of "+x);
		System.out.println();
		printCalender(startDay, x, leap);
		


	}

	public void printCalender(int startDay, int year, boolean leap) {
		print3Months(mJan, startDay, leap);
		if (leap) {
			feb = feb+1;
		}
		startDay = (startDay + jan + feb + mar)%7;
		System.out.println();

		print3Months(mApr, startDay, leap);
		startDay = (startDay + apr + may + jun)%7;
		System.out.println();

		print3Months(mJul, startDay, leap);
		startDay = (startDay + jul + aug + sep)%7;
		System.out.println();

		print3Months(mOct, startDay, leap);
	}

	public void print3Months(String month, int startDay, boolean leap) {
		if (month == mJan) {
			System.out.println(mJan+monthSpace+mFeb+monthSpace+mMar);
			printMonth(jan, startDay, 1);
			startDay = (startDay + jan)%7;
			printMonth(feb, startDay, 2);
			if (leap) {
				feb = feb+1;
			}
			startDay = (startDay + feb)%7;
			printMonth(mar, startDay, 3);
		}
		else if (month == mApr) {
			System.out.println(mApr+monthSpace+mMay+monthSpace+mJun);
			printMonth(apr, startDay, 1);
			startDay = (startDay + apr)%7;
			printMonth(may, startDay, 2);
			startDay = (startDay + may)%7;
			printMonth(jun, startDay, 3);
		}
		else if (month == mJul) {
			System.out.println(mJul+monthSpace+mAug+monthSpace+mSep);
			printMonth(jul, startDay, 1);
			startDay = (startDay + jul)%7;
			printMonth(aug, startDay, 2);
			startDay = (startDay + aug)%7;
			printMonth(sep, startDay, 3);
		}
		else {
			System.out.println(mOct+monthSpace+mNov+monthSpace+mDec);
			printMonth(oct, startDay, 1);
			startDay = (startDay + oct)%7;
			printMonth(nov, startDay, 2);
			startDay = (startDay + nov)%7;
			printMonth(dec, startDay, 3);
		}
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print(days);
		}
		System.out.println();

		System.out.println(m1l1+m2l1+m3l1);
		System.out.println(m1l2+m2l2+m3l2);
		System.out.println(m1l3+m2l3+m3l3);
		System.out.println(m1l4+m2l4+m3l4);
		System.out.println(m1l5+m2l5+m3l5);
		System.out.println(m1l6+m2l6+m3l6);
		resetDefault();

		System.out.println();
	}

	public void printMonth(int month, int startDay, int monthNumber) {
		String str = "";
		int counter = 0;
		for (int i = 0; i < startDay; i++) {
			str = str + noVal + space;
			counter++;
		}
		int i = 1;
		int lineNum = 1;
		while (i <= month) {
			String add = "";
			if (i < 10) {
				add = "  "+i;
			}
			else {
				add = " "+i;
			}
			str = str + add + space;
			i++;
			counter++;

			while (counter < 7 && i == month+1) {
				str = str + noVal + space;
				counter++;
			}

			if (counter == 7) {
				counter = 0;
				str = str+space;
				if (monthNumber == 1) {
					if (lineNum == 1) {
						m1l1 = str;
					}
					else if (lineNum == 2) {
						m1l2 = str;
					}

					else if (lineNum == 3) {
						m1l3 = str;
					}

					else if (lineNum == 4) {
						m1l4 = str;
					}

					else if (lineNum == 5) {
						m1l5 = str;
					}

					else {
						m1l6 = str;
					}
				}
				else if (monthNumber == 2) {
					if (lineNum == 1) {
						m2l1 = str;
					}
					else if (lineNum == 2) {
						m2l2 = str;
					}

					else if (lineNum == 3) {
						m2l3 = str;
					}

					else if (lineNum == 4) {
						m2l4 = str;
					}

					else if (lineNum == 5) {
						m2l5 = str;
					}

					else {
						m2l6 = str;
					}
				}

				else {
					if (lineNum == 1) {
						m3l1 = str;
					}
					else if (lineNum == 2) {
						m3l2 = str;
					}

					else if (lineNum == 3) {
						m3l3 = str;
					}

					else if (lineNum == 4) {
						m3l4 = str;
					}

					else if (lineNum == 5) {
						m3l5 = str;
					}

					else {
						m3l6 = str;
					}
				}
				str = "";
				lineNum++;
			}
		}

		
	}

	//Method checks if int x is a leap year
	//var x - int, year
	public boolean checkLeapYear(int x) {
		if (x % 4 == 0 && x % 400 == 0) {
			return true;
		}

		else if (x % 4 == 0 && x % 100 == 0) {
			return false;
		}

		else if (x % 4 == 0) {
			return true;
		}

		else {
			return false;
		}
	}

	//Method checks what day of the week int x will start on
	//var x - int, year
	public int checkStartDay(int x) {
		int sum = 0;
		if (x == defaultYear) {
			return defaultDay;
		}
		int check = defaultYear;
		if (x < defaultYear) {
			while (x < check) {
				if (checkLeapYear(check)) {
					sum += leapDiff;
				}
				else {
					sum++;
				}
			check--;
			}
		}
		else {
			while (x > check) {
				if (checkLeapYear(check)) {
					sum += leapDiff;
				}
				else {
					sum++;
				}
			check++;
			}
		}
		return sum%7;
	}

	public void resetDefault() {
		m1l1 = noValLine;
		m1l2 = noValLine;
		m1l3 = noValLine;
		m1l4 = noValLine;
		m1l5 = noValLine;
		m1l6 = noValLine;

		m2l1 = noValLine;
		m2l2 = noValLine;
		m2l3 = noValLine;
		m2l4 = noValLine;
		m2l5 = noValLine;
		m2l6 = noValLine;

		m3l1 = noValLine;
		m3l2 = noValLine;
		m3l3 = noValLine;
		m3l4 = noValLine;
		m3l5 = noValLine;
		m3l6 = noValLine;
	}

}