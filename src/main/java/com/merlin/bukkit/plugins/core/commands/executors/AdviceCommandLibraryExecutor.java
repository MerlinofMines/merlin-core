package com.merlin.bukkit.plugins.core.commands.executors;

import static com.merlin.bukkit.plugins.core.path.SimplePath.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.core.commands.Command;
import com.merlin.bukkit.plugins.core.commands.ListCommand;
import com.merlin.bukkit.plugins.core.commands.libraries.CommandLibrary;
import com.merlin.bukkit.plugins.core.commands.libraries.possibilities.CommandPossibility;

public class AdviceCommandLibraryExecutor extends LibraryCommandExecutor {

	protected int maxSuggestions = 5;
	
	public AdviceCommandLibraryExecutor(CommandLibrary library) {
		super(library);
	}

	public AdviceCommandLibraryExecutor(CommandLibrary library, int maxSuggestions) {
		super(library);
		this.maxSuggestions = maxSuggestions;
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command,
			String label, String[] args) {
		
		
		List<String> pieces = new ArrayList<String>();
		pieces.add(command.getName());
		pieces.addAll(Arrays.asList(args));
		Command libraryCommand = null;
		try {
			libraryCommand = library.getCommand(pieces,sender);
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Exception locating command: " + e.getMessage());
			return false;
		}
		
		if(libraryCommand==null) {
			try {
				List<CommandPossibility> possibles = library.getPossibleCommands(pieces,sender);
				
				
 				if(possibles.isEmpty()) {
					sender.sendMessage(COMMAND_NOT_FOUND_MESSAGE);
					return true;
				} else {
					ListCommand suggestions = new ListCommand(simple("Unable to find a matching command.  Suggestions: "));
					for(int i = 0;i<Math.min(possibles.size(),maxSuggestions);i++) {
						suggestions.addPossibility(possibles.get(i));
					}
					return suggestions.execute(sender);
				}
			} catch (Exception e) {
				sender.getServer().getLogger().warning("Exception locating possible commands: " + e.getMessage());
				return false;
			}
		}
			
		if(libraryCommand.getPermission()!=null && !sender.hasPermission(libraryCommand.getPermission())) {
			sender.sendMessage(UNAUTHORIZED_EXECUTION_MESSAGE);
			return true;
		} else {
			boolean executed = libraryCommand.execute(sender);
			if(executed) {
				if(libraryCommand.getSuccessMessage()!=null) {
					sender.sendMessage(libraryCommand.getSuccessMessage().toString());
				}
			} else {
				sender.sendMessage("Command did not execute successfully");
			}
			return executed;
		}
	}
}
