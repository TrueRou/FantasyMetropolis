package trou.fantasy_metropolis.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.ObjModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import trou.fantasy_metropolis.FantasyMetropolis;

public class FmItemModels extends ItemModelProvider {

    public FmItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FantasyMetropolis.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        getBuilder("whiter_sword")
                .rootTransforms().scale(0.1f).rotation(180, 0, 0, true).end()
                .transforms()
                    .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).scale(2, 2, 2).rightRotation(-30, -270, 15).translation(-10, -8, 0).end()
                    .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rightRotation(0, 90, 0).translation(-18.5f, 1.5f, 15f).end()
                    .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rightRotation(0, 90, 0).translation(-18.5f, 1.5f, -12.5f).end()
                .end()
                .customLoader(ObjModelBuilder::begin)
                .modelLocation(modLoc("textures/item/sword.obj"))
                .overrideMaterialLibrary(modLoc("textures/item/sword.mtl"))
                .flipV(true);
    }
}
