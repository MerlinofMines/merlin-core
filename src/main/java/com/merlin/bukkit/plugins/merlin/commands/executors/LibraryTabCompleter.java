package com.merlin.bukkit.plugins.merlin.commands.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.merlin.bukkit.plugins.merlin.core.commands.libraries.SimpleCommandLibrary;

public class LibraryTabCompleter implements TabCompleter {

	protected SimpleCommandLibrary library;

	public SimpleCommandLibrary getLibrary() {
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
		
		List<String> suggestions = library.getCommandPieceSuggestions(current,pieces);

		return suggestions;
	}

}
