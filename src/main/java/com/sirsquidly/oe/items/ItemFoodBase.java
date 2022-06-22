package com.sirsquidly.oe.items;

import com.sirsquidly.oe.Main;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemFoodBase extends ItemFood 
{
	/** Number of ticks to run while 'EnumAction'ing until result. */
	public int useDuration;
	
	public ItemFoodBase(int amount, float saturation, int useDuration, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		this.useDuration = useDuration;
		this.setCreativeTab(Main.OCEANEXPTAB);
	}
    
	@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return this.useDuration;
    }
}