package in.redbus.command;

import org.stackspace.webfaces.command.Command;
import org.stackspace.webfaces.context.object.MapContextObject;

public class BookTicketCommand implements Command {
	@Override
	public String execute(MapContextObject contextObject) {
		String source = null;
		String destination = null;

		source = contextObject.getParameter("source");
		destination = contextObject.getParameter("destination");

		contextObject.addAttribute("source", source);
		contextObject.addAttribute("destination", destination);

		return "bookedTickets";
	}

}
