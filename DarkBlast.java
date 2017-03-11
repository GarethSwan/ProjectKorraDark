// ProjectKorra Light is an addition to add new abilities and a new Element to the game! I do not claim ownership of ProjectKorra Core or any other parts
// ProjectKorra Light was created by Gareth_Swan

package com.Swan.Korra.PKDark;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.projectkorra.projectkorra.GeneralMethods;
import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.util.DamageHandler;

public class DarkBlast extends DarkAbility {
	
	private double moveSpeed = 1.1;
	private double collisionRadius = 1.9;
	private double damage = 8;
	private int range = 30;
	private long cooldown = 2000;
	
	private Location location;
	private Location startLocation;
	
	
	public DarkBlast(Player player) {
		super(player);
		if (!bPlayer.canBend(this)) {
			return;
		}
		location = player.getEyeLocation().clone();
		startLocation = player.getEyeLocation().clone();
		
		bPlayer.addCooldown(this);
		player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 2, 0.1f);
		start();
		
	}

	public long getCooldown() {
		// TODO Auto-generated method stub
		return cooldown;
	}

	public Location getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "DarkBlast";
	}

	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSneakAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public void progress() {
		if (!bPlayer.canBendIgnoreCooldowns(this)){
			remove();
			return;
		}
		
		if (startLocation.distanceSquared(location) > range * range) {
			remove();
			return;
		}
		if (GeneralMethods.isSolid(location.getBlock())){
			remove();
			return;
		}
		
		location.add(this.location.getDirection().clone().normalize().multiply(moveSpeed));
		for (int i = 0; i < 20; i++) {
			GeneralMethods.displayColoredParticle(location, "000000");
			GeneralMethods.displayColoredParticle(location, "68228B");

		
		for (Entity entity : GeneralMethods.getEntitiesAroundPoint(location,
				collisionRadius)) {
			if (entity instanceof Entity) {
				DamageHandler.damageEntity(entity, player, damage, this);
				
			}
			
			remove();
			return;
		}
		}
	}
	

	public String getAuthor() {
		// TODO Auto-generated method stub
		return "Gareth Swan";
	}

	
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	public void load() {
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new DarkBlastListener(), ProjectKorra.plugin);
	}

	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getDescription() {
		return "An ability allowing the DarkBender to fire a blast of Darkness at their opponents, badly damaging them!";			
	}

	public boolean isExplosiveAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isIgniteAbility() {
		// TODO Auto-generated method stub
		return false;
	}

}
