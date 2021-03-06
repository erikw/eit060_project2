package server;

import java.util.Map;

public class DeleteCommand extends Command {
	private int recordID;

	public DeleteCommand (int recordID) {
		this.recordID = recordID;
	}

	public String execute(Map<Integer, Record> records) {
		if (subject.equals("agency")) {
			records.remove(recordID);
			log.info("Record with ID " + recordID + " removed by agency.");
			return "Record with ID " + recordID + " removed.";
		}
		log.warning("User with insufficient rights tried to remove record with ID " + recordID);
		return "You shall not pass!";
	}
}
