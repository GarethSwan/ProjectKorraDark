// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

package com.Swan.Korra.PKDark;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.Element.ElementType;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.CoreAbility;
import com.projectkorra.projectkorra.configuration.ConfigManager;

public class Main extends JavaPlugin{

	public static Element Dark;
		public void onEnable() {
		
		Dark = new Element("Dark", ElementType.BENDING, this);
		
		
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		ConfigManager.languageConfig.get().addDefault("Chat.Colors.Dark", "GRAY");
		ConfigManager.languageConfig.get().addDefault("Chat.Prefixes.Dark", "[Dark]");
		ConfigManager.languageConfig.save();
		saveConfig();
		
		CoreAbility.registerPluginAbilities(this, "com.Swan.Korra.PKDark");
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new DarkBlastListener(), ProjectKorra.plugin);		

	}
		public void onDisable() {
			ProjectKorra.log.info("ProjectKorraDark by Gareth Swan has been disabled");
		}
	
	
	
}