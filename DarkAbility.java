// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

package com.Swan.Korra.PKDark;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.Element;
import com.projectkorra.projectkorra.ability.ElementalAbility;


public abstract class DarkAbility extends ElementalAbility{

	public DarkAbility(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	
	public Element getElement() {
		// TODO Auto-generated method stub
		return Main.Dark;
	
	}
	
	public ChatColor getColor(){
		return ChatColor.BLACK;
	}
	
	
	
	
	
}
