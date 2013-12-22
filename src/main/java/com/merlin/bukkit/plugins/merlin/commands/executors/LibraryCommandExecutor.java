package com.merlin.bukkit.plugins.merlin.commands.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.merlin.commands.Command;
import com.merlin.bukkit.plugins.merlin.core.commands.libraries.CommandLibrary;

public class LibraryCommandExecutor implements CommandExecutor {

	protected CommandLibrary library;
	public static String COMMAND_NOT_FOUND_MESSAGE = ChatColor.RED+"Unable to find the specified command.";
	public static String UNAUTHORIZED_EXECUTION_MESSAGE = ChatColor.RED+"You do not have permission to execute this command.";
	
	public LibraryCommandExecutor(CommandLibrary library) {
		this.library = library;
	}
	
	public CommandLibrary getLibrary() {
		return library;
	}

	public void setLibrary(CommandLibrary library) {
		this.library = library;
	}

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command,
			String label, String[] args) {
		
		List<String> pieces = new ArrayList<String>();
		pieces.add(command.getName());
		pieces.addAll(Arrays.asList(args));
		Command libraryCommand = null;
		try {
			libraryCommand = library.getCommand(pieces);
		} catch(Exception e) {
			sender.getServer().getLogger().warning("Exception locating command: " + e.getMessage());
			return false;
		}
		
		if(libraryCommand==null) {
			sender.sendMessage(COMMAND_NOT_FOUND_MESSAGE);
			return true;
		}
			
		if(libraryCommand.getPermission()!=null && !sender.hasPermission(libraryCommand.getPermission())) {
			sender.sendMessage(UNAUTHORIZED_EXECUTION_MESSAGE);
			return true;
		} else {
			boolean executed = libraryCommand.execute(sender);
			if(executed) {
				if(libraryCommand.getSuccessMessage()!=null) {
					sender.sendMessage(libraryCommand.getSuccessMessage());
				}
			} else {
				sender.sendMessage("Command did not execute successfully");
			}
			return executed;
		}
	}
}
