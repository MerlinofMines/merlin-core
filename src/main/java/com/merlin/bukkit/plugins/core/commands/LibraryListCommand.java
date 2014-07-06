package com.merlin.bukkit.plugins.core.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.libraries.CommandLibrary;
import com.merlin.bukkit.plugins.core.commands.pieces.CommandPiece;
import com.merlin.bukkit.plugins.core.path.Path;

public class LibraryListCommand extends Command {

	protected Path title;
	protected String indent = ChatColor.GREEN+"/";
	protected List<Command> commandPossibilities;
	protected CommandLibrary library;
	
	@Override
	public boolean execute(CommandSender sender) {

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(title.getPath()).append("\n");
			
			for(int i = 0;i<commandPossibilities.size();i++) {
				Command command = commandPossibilities.get(i);
				builder.append(indent);
				List<CommandPiece<?>> pattern = library.getCommandPattern(command);

				for(int j = 0;j<pattern.size();j++) {
					builder.append(pattern.get(j).getDisplay()).append(" ");
				}
				
				
				String description = command.getDescription();
				if(description==null || description.length()==0) {
					description = "No Description";
				}
				builder.append(ChatColor.WHITE).append("- ").append(description).append("\n");
			}
			
			sender.sendMessage(builder.toString());
			return true;
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Could not execute command: " + e.getMessage());
			return false;
		}

	}

	public Path getTitle() {
		return title;
	}

	public void setTitle(Path title) {
		this.title = title;
	}

	public List<Command> getCommandPossibilities() {
		return commandPossibilities;
	}

	public void setCommandPossibilities(
			List<Command> commandPossibilities) {
		this.commandPossibilities = commandPossibilities;
	}

	public LibraryListCommand(Path title,
			List<Command> commandPossibilities,CommandLibrary library) {
		super();
		this.title = title;
		this.commandPossibilities = commandPossibilities;
		this.library = library;
	}
	
	public LibraryListCommand(Path title,CommandLibrary library) {
		this(title,new ArrayList<Command>(),library);
	}
	
	public void addPossibility(Command possibility) {
		commandPossibilities.add(possibility);
	}

	public String getIndent() {
		return indent;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}
	

}
