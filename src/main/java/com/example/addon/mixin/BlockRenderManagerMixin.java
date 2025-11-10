package com.example.addon.mixin;

import com.example.addon.modules.NoCarpets;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModelRenderer.class)
public class BlockRenderManagerMixin {
    
    @Inject(method = "render(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;JI)V", 
            at = @At("HEAD"), 
            cancellable = true)
    private void onRenderBlock(BlockRenderView world, BakedModel model, BlockState state, BlockPos pos, 
                               MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, 
                               Random random, long seed, int overlay, CallbackInfoReturnable<Boolean> cir) {
        NoCarpets module = Modules.get().get(NoCarpets.class);
        
        if (module != null && module.isActive() && module.isCarpet(state.getBlock())) {
            // Cancel rendering by returning early
            cir.cancel();
        }
    }
}
