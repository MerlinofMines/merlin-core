package com.merlin.bukkit.plugins.merlin.commands.executors;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.merlin.bukkit.plugins.merlin.core.commands.libraries.CommandLibrary;

public class DelimiterAwareLibraryCommandExecutor extends LibraryCommandExecutor {

	public static final String DEFAULT_DELIMITER = "\"";
	protected String delimiter;
	
	public DelimiterAwareLibraryCommandExecutor(CommandLibrary library) {
		this(library,DEFAULT_DELIMITER);
	}

	public DelimiterAwareLibraryCommandExecutor(CommandLibrary library,
			String delimiter) {
		super(library);
		this.delimiter = delimiter;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		ArrayList<String> newArgs = new ArrayList<String>();

		boolean foundFirstDelimeter = false;
		
		StringBuilder currentArg = null;
		
		
		for(int i = 0;i<args.length;i++) {
			
			String arg = args[i];
			
			if(!foundFirstDelimeter) {
				if(arg.startsWith(delimiter)) {
					currentArg = new StringBuilder();
					foundFirstDelimeter = true;
					currentArg.append(arg.substring(arg.indexOf(delimiter)+1)+" ");
				} else {
					newArgs.add(arg);
				}
			}  else {
				if(arg.endsWith(delimiter)) {
					//Should never be the case, but safety check anyway
					if(currentArg==null)currentArg = new StringBuilder();
					foundFirstDelimeter = false;
					currentArg.append(arg.substring(0,arg.indexOf(delimiter)));
					newArgs.add(currentArg.toString().trim());
				} else {
					currentArg.append(arg+" ");
				}
			}
		}

		if(foundFirstDelimeter == true && currentArg!=null) {
			newArgs.add(currentArg.toString().trim());
		}
		
		return super.onCommand(sender, command, label, newArgs.toArray(new String[newArgs.size()]));
	}
	
	
	
}
