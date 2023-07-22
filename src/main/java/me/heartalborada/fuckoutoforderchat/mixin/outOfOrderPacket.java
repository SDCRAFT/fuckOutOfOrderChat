package me.heartalborada.fuckoutoforderchat.mixin;

import me.heartalborada.fuckoutoforderchat.FuckOutOfOrderChat;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.time.Instant;

@Mixin(net.minecraft.server.network.ServerPlayNetworkHandler.class)
public class outOfOrderPacket {
    /*@Redirect(
            method = "validateMessage",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;isInProperOrder(Ljava/time/Instant;)Z"
            )
    )
    public boolean isInProperOrder(ServerPlayNetworkHandler instance, Instant timestamp){
        return true;
    }*/
    private static int fuckedCount =0;
    @Inject(
            method = "isInProperOrder",
            at = @At("RETURN"),
            cancellable = true
    )
    private void injected(CallbackInfoReturnable<Boolean> cir) {
        if(!cir.getReturnValue()) {
            fuckedCount++;
            FuckOutOfOrderChat.LOG.info("Today Fuck Out Of Order Chat Count: {}", fuckedCount);
            cir.setReturnValue(true);
        }
    }
}
