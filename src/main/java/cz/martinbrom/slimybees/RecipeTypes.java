package cz.martinbrom.slimybees;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

/**
 * This class holds a static reference to every {@link RecipeType} found in SlimyBees.
 */
public class RecipeTypes {

    // prevent instantiation
    private RecipeTypes() {}

    public static final RecipeType WILDERNESS = new RecipeType(
            SlimyBeesPlugin.getKey("wilderness"),
            new ItemStack(Material.SPRUCE_SAPLING));

    public static final RecipeType BREEDING = new RecipeType(
            SlimyBeesPlugin.getKey("breeding"),
            new CustomItemStack(Material.BEE_SPAWN_EGG,
                    "&c繁殖",
                    "",
                    "&f在蜂箱中",
                    "&f繁殖两种特定蜜蜂",
                    "&f获取"));

    public static final RecipeType BEE_PRODUCT = new RecipeType(
            SlimyBeesPlugin.getKey("bee_product"),
            new CustomItemStack(Material.HONEYCOMB,
                    "&c蜜蜂产物",
                    "",
                    "&f蜜蜂在蜂箱中工作",
                    "&f所生产的产物"));

    public static final RecipeType SBEE_CENTRIFUGE = new RecipeType(
            SlimyBeesPlugin.getKey("sbee_centrifuge"),
            new CustomItemStack(Material.GRINDSTONE,
                    "&f离心机",
                    "",
                    "&7放入离心机中获取"));

}
