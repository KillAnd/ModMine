package entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.level.Level;

public class MobAssassino extends PathfinderMob
{

    public MobAssassino(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    // Настройка характеристик (здоровье, скорость)
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.30D);
    }

    // Настройка поведения (цели AI)
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this)); // не тонуть в воде
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D)); // просто ходить
        // сюда можно добавить атакующие цели, если нужно
    }
}
