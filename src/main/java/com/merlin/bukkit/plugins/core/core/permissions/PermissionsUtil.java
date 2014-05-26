package com.merlin.bukkit.plugins.core.core.permissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class PermissionsUtil {

	   public static boolean hasPermission(CommandSender sender,String permission) {
		   if(sender.hasPermission(permission))return true;
		   
		   int dotIndex = permission.indexOf('.');
		   while(dotIndex>=0) {
			   permission = permission.substring(0,dotIndex);
			   if(sender.hasPermission(permission+".*"))return true;
			   if(sender.hasPermission(permission))return true;
			   dotIndex = permission.indexOf('.');
		   }
		   return false;
	   }
	   
	   public static void sendNoPermissionMessage(CommandSender sender, Command command, String[] args) {
		   
		   StringBuilder fullCommand = new StringBuilder("/"+command.getName());
		   
		   for(int i = 0;i<args.length;i++) {
			   fullCommand.append(" ").append(args[i]);
		   }
		   sender.sendMessage(ChatColor.RED+"You do not have permission to use the command " + fullCommand.toString());
	   }
}
