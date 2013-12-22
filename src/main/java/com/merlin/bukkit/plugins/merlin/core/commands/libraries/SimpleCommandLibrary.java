package com.merlin.bukkit.plugins.merlin.core.commands.libraries;

import static com.merlin.bukkit.plugins.merlin.core.commands.libraries.CommandLibraryUtil.getBestPatternMatches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;

import com.merlin.bukkit.plugins.merlin.commands.Command;
import com.merlin.bukkit.plugins.merlin.commands.CommandMetaData;
import com.merlin.bukkit.plugins.merlin.core.commands.libraries.possibilites.CommandPatternPossibility;
import com.merlin.bukkit.plugins.merlin.core.commands.libraries.possibilites.CommandPossibility;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;
public class SimpleCommandLibrary extends AbstractCommandLibrary {

	public SimpleCommandLibrary() {
		super(new CommandMetaData(true));
	}
	
	public SimpleCommandLibrary(CommandMetaData defaultCommandMetaData) {
		super(defaultCommandMetaData);
	}
	
	public Command getCommand(List<String> commandPieces) throws Exception{

		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {
			
			//Get Command MetaData
			CommandMetaData metaData = commandMap.get(command);
			if(metaData == null) {
				Bukkit.getServer().getLogger().warning("No Meta Data set for Command: " + command);
				continue;
			}

			//Get Command Pattern from MetaData
			List<CommandPiece<?>> pattern = metaData.getCommandPattern();
			if(pattern == null) {
				Bukkit.getServer().getLogger().warning("No Command Pattern set for Command: " + command);
				continue;
			}

			//Determine whether command is re-orderable.
			Boolean canReorder = metaData.getReorder();
			
			//Get Best Pattern Matches for this command
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,commandPieces,canReorder);
			
			//Created new possibility for this command
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setMetaData(metaData);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(commandPieces.size());

			//Add this possibility to our list of command possibilities.
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {//Shouldn't ever happen unless we forgot to add our commands to the library. 
			return null;
		} else {

			//Sorting is overloaded.  This will determine the best possibilities.
			Collections.sort(possibilities);
			CommandPossibility bestCommand = possibilities.get(0);//Best Possibility
			
			if(bestCommand.getBestCommandMatchPercentage()==1.0) {//Perfect Match
				CommandPatternPossibility bestPossibility = bestCommand.getBestCommandMatch();//Best pattern match for this command
				//Need to set the hooks for this command in order to execute it.  Essentially maps the pattern values to the command values.
				for(CommandPiece<?> piece : bestPossibility.keySet()) {
					piece.setValueFromString(bestPossibility.get(piece));
				}
				return bestCommand.getCommand();//Command is ready to execute and can be returned.
			} else {//No Perfect Match, return null
				return null;
			}
		}
	}

	@Override
	public List<String> getCommandPieceSuggestions(String commandPieceStart,
			List<String> otherCommandPieces) {
		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {

			//Get Command MetaData
			CommandMetaData metaData = commandMap.get(command);
			if(metaData == null) {
				Bukkit.getServer().getLogger().warning("No Meta Data set for Command: " + command);
				continue;
			}

			//Get Command Pattern from MetaData
			List<CommandPiece<?>> pattern = metaData.getCommandPattern();
			if(pattern == null) {
				Bukkit.getServer().getLogger().warning("No Command Pattern set for Command: " + command);
				continue;
			}

			//Determine whether command is re-orderable.
			Boolean canReorder = metaData.getReorder();

			//Get best pattern possibilities for this command.
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,otherCommandPieces,canReorder);
			
			
			//Create possibility for this command.
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setMetaData(metaData);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(otherCommandPieces.size());
			
			//Add possibility to our list of possibilities.
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {
			return new ArrayList<String>();
		} else {
			//Overloaded.  Best possibilities will be first.
			Collections.sort(possibilities);
			
			//This needs to be a set.  That way if there are duplicates, they'll automatically be ignored.
			Set<String> suggestions = new HashSet<String>();

			for(int i = 0;i<possibilities.size();i++) {
				
				CommandPossibility bestCommand = possibilities.get(i);
			
				List<CommandPatternPossibility> bestPatterns = bestCommand.getBestPatternMatches();
	
				//TODO: We already checked this above.  Unless this becomes multi-threaded then we can skip the safety checks.
				List<CommandPiece<?>> commandPattern = commandMap.get(bestCommand.getCommand()).getCommandPattern();
				

				//TODO:  This is where we need to make the change for re-ordering
				
				for(int j = 0;j<bestPatterns.size()&&bestPatterns.get(j).size()==otherCommandPieces.size();j++) {
					List<CommandPiece<?>> pieces = new ArrayList<CommandPiece<?>>(commandPattern);
					pieces.removeAll(bestPatterns.get(j).keySet());

					if(pieces.size()>0) {//If there are remaining pieces
						Boolean canReOrder = bestCommand.getMetaData().getReorder();
						if(canReOrder) {//If Can Re Order than get possibilities for all remaining parts of the command.
							for(CommandPiece<?> piece : pieces) {
								List<String> completions = piece.possibilites(commandPieceStart);
								if(completions!=null) {
									suggestions.addAll(completions);//It's a set so just add all the suggestions.
								}
							}
						} else { // If can not re order, than only get possibilities for the 1st entry of pieces.
							List<String> completions = pieces.get(0).possibilites(commandPieceStart);
							if(completions!=null) {
								suggestions.addAll(completions);
							}
						}
					}
				}
			}
			
			ArrayList<String> list = new ArrayList<String>(suggestions);
			
			//Sort this one alphabetically (Strings)
			Collections.sort(list);
			
			return list;
			
		}
	}

	@Override
	public List<CommandPossibility> getPossibleCommands(
			List<String> commandPieces) throws Exception {
		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {
			
			//Get Command MetaData
			CommandMetaData metaData = commandMap.get(command);
			if(metaData == null) {
				Bukkit.getServer().getLogger().warning("No Meta Data set for Command: " + command);
				continue;
			}

			//Get Command Pattern from MetaData
			List<CommandPiece<?>> pattern = metaData.getCommandPattern();
			if(pattern == null) {
				Bukkit.getServer().getLogger().warning("No Command Pattern set for Command: " + command);
				continue;
			}

			//Determine whether command is re-orderable.
			Boolean canReorder = metaData.getReorder();

			//Get best pattern matches for this command
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,commandPieces,canReorder);
			
			//Create Command Possibility for this command
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setMetaData(metaData);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(commandPieces.size());
			
			//Add this possibility to our list of possibilities
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {
			return new ArrayList<CommandPossibility>();
		} else {
			//Overloaded.  Best command possibilities will be first.
			Collections.sort(possibilities);
			return possibilities;
		}
	}
}
