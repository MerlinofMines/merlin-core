package com.merlin.bukkit.plugins.core.core.commands.libraries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.merlin.bukkit.plugins.core.core.commands.libraries.possibilites.CommandPatternPossibility;
import com.merlin.bukkit.plugins.core.core.commands.pieces.CommandPiece;

public class CommandLibraryUtil {

	public static double getPatternMatchPercentage(List<CommandPiece<?>> pattern,int piecesSize,int matches) {
		
		double patternSize = pattern.size();

		//If one is empty, there's no match.
		if(patternSize==0 || piecesSize == 0) return 0.0;
		double matchCap = Math.min(patternSize/piecesSize,piecesSize/patternSize);
		
		return matchCap*((double)matches/(double)piecesSize);
	}
	
	public static List<CommandPatternPossibility> getBestPatternMatches(List<CommandPiece<?>> pattern, List<String> pieces, boolean canReorder) {

		Map<Integer,List<Integer>> patternMatches = new HashMap<Integer,List<Integer>>();
		List<CommandPatternPossibility> bestPatternMatches = new ArrayList<CommandPatternPossibility>();
		
		//TODO: I think this is where my re-ordering change needs to be
		if(canReorder) {
			for(int i = 0;i<pattern.size();i++) {
				List<Integer> matches = new ArrayList<Integer>();
				for(int j = 0;j<pieces.size();j++) {
					if(pattern.get(i).matches(pieces.get(j))) {
						matches.add(j);
					}
				}
				patternMatches.put(i, matches);
			}
		} else {
			for(int i = 0;i<Math.min(pattern.size(),pieces.size());i++) {
				List<Integer> matches = new ArrayList<Integer>();
				if(pattern.get(i).matches(pieces.get(i))) {
					matches.add(i);
					patternMatches.put(i, matches);
				} else {
					break;
				}
			}
		}

		List<Map<Integer,Integer>> bestMatches = getBestMatches(patternMatches, new ArrayList<Integer>());
		
		for(int i = 0;i<bestMatches.size();i++) {
			CommandPatternPossibility commandMatch = new CommandPatternPossibility();
			
			Map<Integer,Integer> match = bestMatches.get(i);
			
			List<Integer> matchKeys = new ArrayList<Integer>(match.keySet());
			for(int j = 0;j<matchKeys.size();j++) {
				int patternIndex = matchKeys.get(j);
				int pieceIndex = match.get(matchKeys.get(j));
				
				commandMatch.put(pattern.get(patternIndex), pieces.get(pieceIndex));
			}
			bestPatternMatches.add(commandMatch);
		}
		
		return bestPatternMatches;
	}
	
	public static List<Map<Integer,Integer>> getBestMatches(Map<Integer,List<Integer>> possibilities,List<Integer> usedPieces) {
		
		List<Map<Integer,Integer>> bestMatches = new ArrayList<Map<Integer,Integer>>();
		
		if(possibilities.isEmpty()) return bestMatches;

		Map<Integer,List<Integer>> newPossibilities = new HashMap<Integer,List<Integer>>();
		newPossibilities.putAll(possibilities);

		Integer firstPosition = new ArrayList<Integer>(possibilities.keySet()).get(0);//TOOD: Might be a better way to do this.
		List<Integer> possibleValues = newPossibilities.remove(firstPosition);

		for(int i = 0;i<possibleValues.size();i++) {
			if(usedPieces.contains(possibleValues.get(i)))continue;
			usedPieces.add(possibleValues.get(i));

			List<Map<Integer,Integer>> nextBestMatches = getBestMatches(newPossibilities,usedPieces);
			usedPieces.remove((Object)possibleValues.get(i));

			if(nextBestMatches.isEmpty()) {
				Map<Integer,Integer> thisMatch = new HashMap<Integer,Integer>();
				thisMatch.put(firstPosition,possibleValues.get(i));
				nextBestMatches.add(thisMatch);
			} else {
				for(int j = 0;j<nextBestMatches.size();j++) {
					nextBestMatches.get(j).put(firstPosition,possibleValues.get(i));
				}
			}
			bestMatches.addAll(nextBestMatches);
		}
		
		List<Map<Integer,Integer>> nextBestMatches = getBestMatches(newPossibilities,usedPieces);

		bestMatches.addAll(nextBestMatches);

		consolidateBestMatches(bestMatches);
		
		return bestMatches;
	}
	
	public static <Key,Value> void consolidateBestMatches(List<Map<Key,Value>> matches) {
		
		List<Map<Key,Value>> matchesToRemove = new ArrayList<Map<Key,Value>>();
		int highestMatches = 0;
		
		for(int i = 0;i<matches.size();i++) {
			highestMatches = Math.max(highestMatches,matches.get(i).keySet().size());
		}

		for(int i = 0;i<matches.size();i++) {
			if(matches.get(i).keySet().size()<highestMatches) {
				matchesToRemove.add(matches.get(i));
			}
		}
		matches.removeAll(matchesToRemove);
	}
	
	public static double getPatternMatch(List<CommandPiece<?>> pattern, List<String> pieces, boolean canReorder) {

		List<CommandPiece<?>> commandPieces = new ArrayList<CommandPiece<?>>(pattern);

		double commandPiecesSize = commandPieces.size();
		double piecesSize = pieces.size();
		
		//If one is empty, there's no match.
		if(commandPiecesSize==0 || piecesSize == 0) return 0.0;
		double matchCap = Math.min(commandPiecesSize/piecesSize,piecesSize/commandPiecesSize);

		double matches = 0;

		List<CommandPatternPossibility> bestMatches = getBestPatternMatches(commandPieces, pieces, canReorder);

		matches = bestMatches.get(0).size();

		return matchCap*(matches/piecesSize);
	}
	
	public static void main(String[] args) {
		
		List<Integer> firstList = new ArrayList<Integer>();
		firstList.add(1);
		firstList.add(2);
		
		List<Integer> secondList = new ArrayList<Integer>();
		secondList.add(1);
		secondList.add(3);

		List<Integer> thirdList = new ArrayList<Integer>();
		thirdList.add(2);
		thirdList.add(4);

		List<Integer> fourthList = new ArrayList<Integer>();
		fourthList.add(4);

		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		map.put(1,firstList);
		map.put(2,secondList);
		map.put(3,thirdList);
		map.put(4,fourthList);
		
		List<Map<Integer,Integer>> bestMatches = getBestMatches(map, new ArrayList<Integer>());
		
		for(int i = 0;i<bestMatches.size();i++) {
			
			List<Integer> keys = new ArrayList<Integer>(bestMatches.get(i).keySet());
			for(int j = 0;j<keys.size();j++) {
				System.out.print("{"+keys.get(j)+","+bestMatches.get(i).get(keys.get(j))+"} ");
			}
		}
	}
}
