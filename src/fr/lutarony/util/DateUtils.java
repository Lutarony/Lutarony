package fr.lutarony.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static boolean isValid(String dateToCheck, String dateFromat) {

		if (dateToCheck == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToCheck);
			return true;
		} catch (ParseException e) {

			return false;
		}
	}

	public static Date getDate(String dateString, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		try {

			Date date = formatter.parse(dateString);
			return date;

		} catch (ParseException e) {
			return null;
		}
	}

}
