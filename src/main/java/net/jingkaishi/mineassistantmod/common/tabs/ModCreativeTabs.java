package net.jingkaishi.mineassistantmod.common.tabs;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModCreativeTabs {
    public static final ItemGroup MOD_TAB = new ItemGroup(MineAssistantMod.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
