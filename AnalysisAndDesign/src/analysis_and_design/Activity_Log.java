package analysis_and_design;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Activity_Log {
	// Simple log entry class to hold action type, timestamp, description
	public static class LogEntry {
		private String actionType;
		private Date timestamp;
		private String description;

		public LogEntry(String actionType, Date timestamp, String description) {
			this.actionType = actionType;
			this.timestamp = timestamp;
			this.description = description;
		}

		public String getActionType() {
			return actionType;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return "[" + timestamp + "] (" + actionType + ") " + description;
		}
	}

	private List<LogEntry> logs;

	public Activity_Log() {
		logs = new ArrayList<>();
	}

	// Add a new log entry
	public void addLog(String actionType, String description) {
		LogEntry entry = new LogEntry(actionType, new Date(), description);
		logs.add(entry);
	}

	// Return all logs
	public List<LogEntry> getAllLogs() {
		return logs;
	}

	// Filter logs by action type (exact match) and date range (startDate to endDate
	// inclusive)
	public List<LogEntry> filterLogs(String actionType, Date startDate, Date endDate) {
		return logs.stream().filter(log -> (actionType == null || log.getActionType().equalsIgnoreCase(actionType)))
				.filter(log -> (startDate == null || !log.getTimestamp().before(startDate)))
				.filter(log -> (endDate == null || !log.getTimestamp().after(endDate))).collect(Collectors.toList());
	}

	// Utility method to print logs
	public void printLogs(List<LogEntry> entries) {
		if (entries.isEmpty()) {
			System.out.println("No log entries found.");
		} else {
			entries.forEach(entry -> System.out.println(entry.toString()));
		}
	}
}
