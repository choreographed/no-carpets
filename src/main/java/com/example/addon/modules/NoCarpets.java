package com.example.addon.modules;

import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Set;

public class NoCarpets extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    // All carpet blocks in Minecraft
    private static final Set<Block> CARPET_BLOCKS = Set.of(
        Blocks.WHITE_CARPET,
        Blocks.ORANGE_CARPET,
        Blocks.MAGENTA_CARPET,
        Blocks.LIGHT_BLUE_CARPET,
        Blocks.YELLOW_CARPET,
        Blocks.LIME_CARPET,
        Blocks.PINK_CARPET,
        Blocks.GRAY_CARPET,
        Blocks.LIGHT_GRAY_CARPET,
        Blocks.CYAN_CARPET,
        Blocks.PURPLE_CARPET,
        Blocks.BLUE_CARPET,
        Blocks.BROWN_CARPET,
        Blocks.GREEN_CARPET,
        Blocks.RED_CARPET,
        Blocks.BLACK_CARPET
    );

    private final Setting<Boolean> showMessage = sgGeneral.add(new BoolSetting.Builder()
        .name("show-message")
        .description("Shows a message when the module is toggled.")
        .defaultValue(true)
        .build()
    );

    public NoCarpets() {
        super(Categories.Render, "no-carpets", "Removes client-side rendering of all carpet blocks.");
    }

    @Override
    public void onActivate() {
        if (showMessage.get()) {
            info("Carpet rendering disabled - carpets will be invisible!");
        }
        
        // Force chunk re-render to apply changes immediately
        if (mc.world != null) {
            mc.worldRenderer.reload();
        }
    }

    @Override
    public void onDeactivate() {
        if (showMessage.get()) {
            info("Carpet rendering enabled - carpets will be visible again.");
        }
        
        // Force chunk re-render to restore normal rendering
        if (mc.world != null) {
            mc.worldRenderer.reload();
        }
    }

    public boolean isCarpet(Block block) {
        return CARPET_BLOCKS.contains(block);
    }
}
