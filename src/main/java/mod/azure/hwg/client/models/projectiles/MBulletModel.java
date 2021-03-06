package mod.azure.hwg.client.models.projectiles;

import mod.azure.hwg.HWGMod;
import mod.azure.hwg.entity.projectiles.MBulletEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MBulletModel extends AnimatedGeoModel<MBulletEntity> {
	@Override
	public Identifier getModelLocation(MBulletEntity object) {
		return new Identifier(HWGMod.MODID, "geo/bullet.geo.json");
	}

	@Override
	public Identifier getTextureLocation(MBulletEntity object) {
		return new Identifier(HWGMod.MODID, "textures/items/bullet.png");
	}

	@Override
	public Identifier getAnimationFileLocation(MBulletEntity animatable) {
		return new Identifier(HWGMod.MODID, "animations/bullet.animation.json");
	}
}
