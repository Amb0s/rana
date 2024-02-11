package ambos.rana;

import java.util.List;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "rana")
public class ModConfig implements ConfigData {
    // Lists biomes where Rana can spawn.
    public List<String> spawnBiomes = List.of("modern_beta:infdev_415");
}
