package villageOfAssassino;

import com.mojang.logging.LogUtils;
import entity.MobAssassino;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import org.slf4j.Logger;


@Mod(VillageOfAssassins.MODID)
public class VillageOfAssassins
{
    public static final String MODID = "villageOfAssassins";

    public VillageOfAssassins(FMLJavaModLoadingContext context) {
        // Получаем шину событий из переданного контекста
        IEventBus modEventBus = context.getModEventBus();

        // Регистрируем все объекты из ModEntities.ENTITIES
        VillageOfAssassins.ENTITIES.register(modEventBus);

        // Здесь могут быть регистрации других вещей (блоков, предметов и т.д.)
    }


    private static final Logger LOGGER = LogUtils.getLogger();


    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<MobAssassino>> ASSASSINO = ENTITIES.register("assassino", () ->
            EntityType.Builder.of(MobAssassino::new, MobCategory.CREATURE)
                    .sized(0.7F, 1.0F) // ширина и высота моба
                    .clientTrackingRange(8) // дистанция прорисовки
                    .build("assassino"));
}
