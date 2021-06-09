package cz.martinbrom.slimybees.core.genetics.alleles;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.inventory.ItemStack;

import me.mrCookieSlime.Slimefun.cscorelib2.collections.Pair;

@ParametersAreNonnullByDefault
public interface AlleleSpecies extends Allele {

    @Nonnull
    ItemStack getPrincessItemStack();

    void setPrincessItemStack(ItemStack princessItemStack);

    @Nonnull
    ItemStack getDroneItemStack();

    void setDroneItemStack(ItemStack droneItemStack);

    @Nullable
    List<Pair<ItemStack, Double>> getProducts();

    void setProducts(List<Pair<ItemStack, Double>> products);

}
