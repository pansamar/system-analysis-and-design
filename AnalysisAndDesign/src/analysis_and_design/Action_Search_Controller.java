package analysis_and_design;

import java.util.Date;
import java.util.List;

public class Action_Search_Controller {
	private Activity_Log activityLog;
	private ActionTypeCatalogue actionTypeCatalogue;

	public Action_Search_Controller(Activity_Log activityLog, ActionTypeCatalogue actionTypeCatalogue) {
		this.activityLog = activityLog;
		this.actionTypeCatalogue = actionTypeCatalogue;
	}

	public List<Activity_Log.LogEntry> search(String actionType, Date startDate, Date endDate) {
		if (actionType != null && !actionTypeCatalogue.isValidActionType(actionType)) {
			System.out.println("Invalid action type: " + actionType);
			return List.of();
		}
		return activityLog.filterLogs(actionType, startDate, endDate);
	}
}
