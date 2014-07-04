package com.merlin.bukkit.plugins.core.commands.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.merlin.bukkit.plugins.core.commands.libraries.CommandLibrary;
import com.merlin.bukkit.plugins.core.commands.libraries.SimpleCommandLibrary;

public class LibraryTabCompleter implements TabCompleter {

	protected CommandLibrary library;

	public CommandLibrary getLibrary() {
		return library;
	}

	public void setLibrary(SimpleCommandLibrary library) {
		this.library = library;
	}
	
	public LibraryTabCompleter(SimpleCommandLibrary library) {
		super();
		this.library = library;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender,
			org.bukkit.command.Command command, String alias, String[] args) {
		List<String> pieces = new ArrayList<String>();
		pieces.add(command.getName());
		pieces.addAll(Arrays.asList(args));

		String current = pieces.get(pieces.size()-1);
		pieces.remove(pieces.size()-1);
		
		List<String> suggestions = library.getCommandPieceSuggestions(current,pieces,sender);

		return suggestions;
	}

}
