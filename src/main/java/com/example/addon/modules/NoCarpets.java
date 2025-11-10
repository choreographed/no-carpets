package com.example.addon.modules;

import meteordevelopment.meteorclient.events.render.RenderBlockEntityEvent;
import meteordevelopment.meteorclient.events.world.ChunkEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;
import java.util.Set;

public class NoCarpets extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    // All carpet blocks in Minecraft
    private static final Set<Block> CARPET_BLOCKS = Set.of(
        Blocks.WHITE_CARPET,
        Blocks.ORANGE_CARPET,
        Blocks.MAGENTA_CARPET,
