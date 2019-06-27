package ambos.ranamod.mixin;

import ambos.ranamod.RanaModInit;
import net.minecraft.entity.EntityCategory;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.PlainsBiome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlainsBiome.class)
public class PlainsBiomeMixin extends Biome {
    protected PlainsBiomeMixin(Settings biome$Settings_1) {
        super(biome$Settings_1);
    }

    @Inject(method = "<init>*", at = @At("RETURN"))
    private void onConstruct(CallbackInfo ci) {
        super.addSpawn(
                EntityCategory.CREATURE,
                new SpawnEntry(
                        RanaModInit.RANA,
                        8,
                        1,
                        3
                )
        );
    }
}
