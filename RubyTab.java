package com.boredce.ruby.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class RubyTab extends CreativeTabs{

	public RubyTab(String label) {
		super(label);
		this.setBackgroundImageName("ruby.png");
	}

	@Override
	public Item getTabIconItem() {
		return RubyItems.ruby;
	}

}
