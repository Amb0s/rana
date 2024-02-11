package ambos.rana.config;

import java.util.List;

import ambos.rana.Rana;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Rana.MOD_ID)
public class ModConfig implements ConfigData {
    // Lists biomes where Rana can spawn.
    public List<String> spawnBiomes = List.of("modern_beta:infdev_415");
}
