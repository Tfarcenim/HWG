package mod.azure.hwg.client.models;

import mod.azure.hwg.HWGMod;
import mod.azure.hwg.entity.TechnodemonGreaterEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class TechnodemonGreater1Model extends AnimatedGeoModel<TechnodemonGreaterEntity> {

	public TechnodemonGreater1Model() {
	}

	@Override
	public Identifier getModelLocation(TechnodemonGreaterEntity object) {
		return new Identifier(HWGMod.MODID, "geo/technodemon_greater_1.geo.json");
	}

	@Override
	public Identifier getTextureLocation(TechnodemonGreaterEntity object) {
		return new Identifier(HWGMod.MODID, "textures/entity/technodemon_greater_1.png");
	}

	@Override
	public Identifier getAnimationFileLocation(TechnodemonGreaterEntity object) {
		return new Identifier(HWGMod.MODID, "animations/technodemon_greater_1.animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(TechnodemonGreaterEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
			head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
		}
	}
}