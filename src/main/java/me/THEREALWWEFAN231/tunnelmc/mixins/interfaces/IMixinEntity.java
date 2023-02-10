package me.THEREALWWEFAN231.tunnelmc.mixins.interfaces;

import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public interface IMixinEntity {
    @Accessor("dataTracker")
    DataTracker getDataTracker();
}
