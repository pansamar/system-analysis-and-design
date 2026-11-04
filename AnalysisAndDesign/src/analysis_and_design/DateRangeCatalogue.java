package analysis_and_design;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateRangeCatalogue {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/**
	 * Validates a date range string of the form "YYYY-MM-DD to YYYY-MM-DD". Returns
	 * true if valid format and startDate <= endDate.
	 */
	public boolean validateDateRange(String dateRange) {
		if (dateRange == null || !dateRange.contains(" to ")) {
			return false;
		}

		String[] parts = dateRange.split(" to ");
		if (parts.length != 2) {
			return false;
		}

		try {
			LocalDate startDate = LocalDate.parse(parts[0].trim(), formatter);
			LocalDate endDate = LocalDate.parse(parts[1].trim(), formatter);

			return !endDate.isBefore(startDate); // endDate >= startDate
		} catch (DateTimeParseException e) {
			return false; // invalid date format
		}
	}
}
