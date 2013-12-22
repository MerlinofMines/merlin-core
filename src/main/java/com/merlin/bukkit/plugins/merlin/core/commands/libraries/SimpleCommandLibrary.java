package com.merlin.bukkit.plugins.merlin.core.commands.libraries;

import static com.merlin.bukkit.plugins.merlin.core.commands.libraries.CommandLibraryUtil.getBestPatternMatches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.merlin.bukkit.plugins.merlin.commands.Command;
import com.merlin.bukkit.plugins.merlin.core.commands.libraries.possibilites.CommandPatternPossibility;
import com.merlin.bukkit.plugins.merlin.core.commands.libraries.possibilites.CommandPossibility;
import com.merlin.bukkit.plugins.merlin.core.commands.pieces.CommandPiece;
public class SimpleCommandLibrary extends AbstractCommandLibrary {

	public Command getCommand(List<String> commandPieces) throws Exception{

		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {
			
			List<CommandPiece<?>> pattern = commandMap.get(command);
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,commandPieces);
			
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(commandPieces.size());
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {
			return null;
		} else {

			Collections.sort(possibilities);
			CommandPossibility bestCommand = possibilities.get(0);
			
			if(bestCommand.getBestCommandMatchPercentage()==1.0) {
				CommandPatternPossibility bestPossibility = bestCommand.getBestCommandMatch();
				for(CommandPiece<?> piece : bestPossibility.keySet()) {
					piece.setValueFromString(bestPossibility.get(piece));
				}
				return bestCommand.getCommand();
			} else {
				return null;
			}
		}
	}

	@Override
	public List<String> getCommandPieceSuggestions(String commandPieceStart,
			List<String> otherCommandPieces) {
		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {
			
			List<CommandPiece<?>> pattern = commandMap.get(command);
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,otherCommandPieces);
			
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(otherCommandPieces.size());
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {
			return new ArrayList<String>();
		} else {
			Collections.sort(possibilities);
			Set<String> suggestions = new HashSet<String>();

			for(int i = 0;i<possibilities.size();i++) {
				
				CommandPossibility bestCommand = possibilities.get(i);
			
				List<CommandPatternPossibility> bestPatterns = bestCommand.getBestPatternMatches();
	
				List<CommandPiece<?>> commandPattern = commandMap.get(bestCommand.getCommand());
				
				for(int j = 0;j<bestPatterns.size()&&bestPatterns.get(j).size()==otherCommandPieces.size();j++) {
					List<CommandPiece<?>> pieces = new ArrayList<CommandPiece<?>>(commandPattern);
					pieces.removeAll(bestPatterns.get(j).keySet());
					for(CommandPiece<?> piece : pieces) {
						
						List<String> completions = piece.possibilites(commandPieceStart);
						if(completions!=null) {
							suggestions.addAll(completions);
						}
					}
				}
			}
			
			ArrayList<String> list = new ArrayList<String>(suggestions);
			
			Collections.sort(list);
			
			return list;
			
		}
	}

	@Override
	public List<CommandPossibility> getPossibleCommands(
			List<String> commandPieces) throws Exception {
		List<CommandPossibility> possibilities = new ArrayList<CommandPossibility>();

		for(Command command : commandMap.keySet()) {
			
			List<CommandPiece<?>> pattern = commandMap.get(command);
			List<CommandPatternPossibility> patternPossibilities = getBestPatternMatches(pattern,commandPieces);
			
			CommandPossibility possibility = new CommandPossibility();
			possibility.setBestPatternMatches(patternPossibilities);
			possibility.setCommand(command);
			possibility.setCommandPattern(pattern);
			possibility.setPiecesSize(commandPieces.size());
			possibilities.add(possibility);
		}

		if(possibilities.isEmpty()) {
			return new ArrayList<CommandPossibility>();
		} else {
			Collections.sort(possibilities);
			return possibilities;
		}
	}
}
