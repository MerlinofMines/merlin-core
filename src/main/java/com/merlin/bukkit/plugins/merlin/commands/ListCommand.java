package com.merlin.bukkit.plugins.merlin.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.merlin.core.commands.libraries.possibilites.CommandPossibility;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;

public class ListCommand extends Command {

	protected String title;
	protected String indent = " ";
	protected List<CommandPossibility> commandPossibilities;
	
	@Override
	public boolean execute(CommandSender sender) {

		try {
			StringBuilder builder = new StringBuilder();
			builder.append(title).append("\n");
			
			for(int i = 0;i<commandPossibilities.size();i++) {
				
				builder.append(indent);
				CommandPossibility possibility = commandPossibilities.get(i);
				List<CommandPiece<?>> pattern = possibility.getCommandPattern();

				for(int j = 0;j<pattern.size();j++) {
					builder.append(pattern.get(j).getDisplay()).append(" ");
				}
				
				
				String description = possibility.getCommand().getDescription();
				
				builder.append(ChatColor.WHITE).append("- ").append(description).append("\n");
			}
			
			sender.sendMessage(builder.toString());
			return true;
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Could not execute command: " + e.getMessage());
			return false;
		}

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CommandPossibility> getCommandPossibilities() {
		return commandPossibilities;
	}

	public void setCommandPossibilities(
			List<CommandPossibility> commandPossibilities) {
		this.commandPossibilities = commandPossibilities;
	}

	public ListCommand(String title,
			List<CommandPossibility> commandPossibilities) {
		super();
		this.title = title;
		this.commandPossibilities = commandPossibilities;
	}
	
	public ListCommand(String title) {
		super();
		this.title = title;
		this.commandPossibilities = new ArrayList<CommandPossibility>();
	}
	
	public void addPossibility(CommandPossibility possibility) {
		commandPossibilities.add(possibility);
	}

	public void addPossibility(Command command, List<CommandPiece<?>> pattern) {
		CommandPossibility possibility = new CommandPossibility();
		possibility.setCommand(command);
		possibility.setCommandPattern(pattern);
		commandPossibilities.add(possibility);
	}

	public String getIndent() {
		return indent;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}
	
	
}
