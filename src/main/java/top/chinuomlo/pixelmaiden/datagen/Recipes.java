package top.chinuomlo.pixelmaiden.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import top.chinuomlo.pixelmaiden.Registies;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput output) {
        super(output);
    }
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registies.doll_shelf.get())
                .pattern("###")
                .pattern("*&*")
                .pattern("###")
                .define('#', ItemTags.PLANKS)
                .define('*', ItemTags.WOODEN_SLABS)
                .define('&', Items.SCAFFOLDING)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registies.doll_spawn_clockwork.get())
                .pattern(" # ")
                .pattern("#&#")
                .pattern(" # ")
                .define('#', Items.COPPER_BLOCK)
                .define('&', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(consumer);
    }
}
