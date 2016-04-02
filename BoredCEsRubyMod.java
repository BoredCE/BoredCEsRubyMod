package com.boredce.ruby;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.boredce.ruby.init.CraftingHandler;
import com.boredce.ruby.init.RubyBlocks;
import com.boredce.ruby.init.RubyItems;
import com.boredce.ruby.init.RubyTab;
import com.boredce.ruby.init.world.RubyWorldGen;
import com.boredce.ruby.proxy.CommonProxy;

@Mod(modid = Strings.MOD_ID, name = Strings.NAME, version = Strings.VERSION)
public class BoredCEsRubyMod {
	
	public static CreativeTabs tabRuby = new RubyTab("ruby_tab");
	
	@SidedProxy(clientSide = Strings.CLIENT_PROXY_CLASS, serverSide = Strings.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/** Item and Block: Init | Registry */
		RubyItems.init();
		RubyItems.register();
		RubyBlocks.init();
		RubyBlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		/** Rendering Registry */
		proxy.registerRenders();
		
		/** Crafting Registry */
		CraftingHandler.CraftingRegistry();
		
		/** Ruby Generator Registry */
		GameRegistry.registerWorldGenerator(new RubyWorldGen(), 0);
	}
}
