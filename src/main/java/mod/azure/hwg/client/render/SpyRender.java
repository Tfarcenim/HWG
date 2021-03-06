package mod.azure.hwg.client.render;

import mod.azure.hwg.client.models.SpyModel;
import mod.azure.hwg.entity.SpyEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.model.json.ModelTransformation.Mode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderer.geo.GeoEntityRenderer;

public class SpyRender extends GeoEntityRenderer<SpyEntity> {

	public SpyRender(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new SpyModel());
		this.shadowRadius = 0.7F;
	}

	@Override
	public RenderLayer getRenderType(SpyEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void renderRecursively(GeoBone bone, MatrixStack stack, VertexConsumer bufferIn, int packedLightIn,
			int packedOverlayIn, float red, float green, float blue, float alpha) {
		if (bone.getName().equals("rArmRuff")) {
			stack.push();
			stack.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(-75));
			stack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(0));
			stack.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(0));
			stack.translate(0.4D, 0.3D, 0.6D);
			stack.scale(1.0f, 1.0f, 1.0f);
			MinecraftClient.getInstance().getItemRenderer().renderItem(mainHand, Mode.THIRD_PERSON_RIGHT_HAND,
					packedLightIn, packedOverlayIn, stack, this.rtb);
			stack.pop();
			bufferIn = rtb.getBuffer(RenderLayer.getEntityTranslucent(whTexture));
		}
		super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

}