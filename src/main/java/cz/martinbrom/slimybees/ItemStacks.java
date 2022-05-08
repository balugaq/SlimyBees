package cz.martinbrom.slimybees;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cz.martinbrom.slimybees.utils.SlimyBeesHeadTexture;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;

/**
 * This class holds a static reference to every {@link SlimefunItemStack} found in SlimyBees.
 */
public class ItemStacks {

    // prevent instantiation
    private ItemStacks() {}

    // <editor-fold desc="Bee Products" defaultstate="collapsed">
    public static final SlimefunItemStack BEESWAX = new SlimefunItemStack(
            "BEESWAX",
            Material.GLOWSTONE_DUST,
            "&e蜂蜡油");
    public static final SlimefunItemStack HONEY_DROP = new SlimefunItemStack(
            "HONEY_DROP",
            Material.GOLD_NUGGET,
            "&6由蜜蜂掉落");

    public static final SlimefunItemStack HONEY_COMB = createHoneycomb("HONEY", "&6蜂蜜");
    public static final SlimefunItemStack DRY_COMB = createHoneycomb("DRY", "&e干");
    public static final SlimefunItemStack SWEET_COMB = createHoneycomb("SWEET", "&f甜");
    // </editor-fold>

    // <editor-fold desc="Specialty Products" defaultstate="collapsed">
    // TODO: 03.06.21 Prevent coloring
    public static final SlimefunItemStack ROYAL_JELLY = new SlimefunItemStack(
            "ROYAL_JELLY",
            Material.LIGHT_GRAY_DYE,
            "&6&l蜂王浆",
            meta -> meta.addItemFlags(ItemFlag.HIDE_ENCHANTS));
    // TODO: 03.06.21 Prevent placing
    public static final SlimefunItemStack POLLEN = new SlimefunItemStack(
            "POLLEN",
            Material.PUMPKIN_SEEDS,
            "&6&l花粉",
            meta -> meta.addItemFlags(ItemFlag.HIDE_ENCHANTS));

    static {
        ROYAL_JELLY.addUnsafeEnchantment(Enchantment.MENDING, 1);
        POLLEN.addUnsafeEnchantment(Enchantment.MENDING, 1);
    }
    // </editor-fold>

    // <editor-fold desc="Frames" defaultstate="collapsed">
    public static final SlimefunItemStack BASIC_FRAME = new SlimefunItemStack(
            "BASIC_FRAME",
            Material.BIRCH_SIGN,
            "&f基础框架",
            "",
            loreProductionModifier(1.25));

    // TODO: 01.07.21 Better name
    public static final SlimefunItemStack ADVANCED_FRAME = new SlimefunItemStack(
            "ADVANCED_FRAME",
            Material.BIRCH_SIGN,
            "&f高级框架",
            "",
            loreProductionModifier(2));

    public static final SlimefunItemStack SWEET_FRAME = new SlimefunItemStack(
            "SWEET_FRAME",
            Material.DARK_OAK_SIGN,
            "&4甜蜜框架",
            "",
            loreLifespanModifier(0.5));

    public static final SlimefunItemStack DEADLY_FRAME = new SlimefunItemStack(
            "DEADLY_FRAME",
            Material.DARK_OAK_SIGN,
            "&4致命框架",
            "",
            loreLifespanModifier(0.1));
    // </editor-fold>

    // <editor-fold desc="Machines" defaultstate="collapsed">
    public static final SlimefunItemStack HIVE_CASING_PLANK = new SlimefunItemStack(
            "HIVE_CASING_PLANK",
            Material.SPRUCE_SLAB,
            "&6蜂巢板",
            "",
            "&f可以组成蜂巢块");

    public static final SlimefunItemStack HIVE_CASING = new SlimefunItemStack(
            "HIVE_CASING",
            Material.SPRUCE_PLANKS,
            "&6蜂巢外壳",
            "",
            "&f一种蜂箱的重要组成部分",
            "&f用于工业级蜂箱");

    public static final SlimefunItemStack BEE_HIVE = new SlimefunItemStack(
            "BEE_HIVE",
            Material.OAK_PLANKS,
            "&6基础蜂箱",
            "",
            "&f给你的蜜蜂一个简单的家",
            "&f需要手动操作!",
            "",
            getTieredHiveString(MachineTier.BASIC));

    public static final SlimefunItemStack AUTO_BEE_HIVE = new SlimefunItemStack(
            "AUTO_BEE_HIVE",
            Material.STRIPPED_OAK_LOG,
            "&6全自动蜂箱",
            "",
            "&f一种自动化蜂箱",
            "&f将雄蜂和雌蜂放于输入槽内",
            "&f便可自动进行繁殖",
            "",
            getTieredHiveString(MachineTier.GOOD));

    public static final SlimefunItemStack INDUSTRIAL_BEE_HIVE = new SlimefunItemStack(
            "INDUSTRIAL_BEE_HIVE",
            Material.STRIPPED_CRIMSON_STEM,
            "&6&l工业蜂箱",
            "",
            "&f一种顶级的蜂箱",
            "&f这种蜂箱",
            "&f大幅度提升了生产效率",
            "",
            getTieredHiveString(MachineTier.END_GAME));

    @Nonnull
    private static String getTieredHiveString(MachineTier basic) {
        return basic + " Hive";
    }

    public static final String EXTRACTS_MATERIALS_FROM_COMBS = "&fExtracts materials from combs";
    public static final SlimefunItemStack SBEE_CENTRIFUGE = new SlimefunItemStack(
            "SBEE_CENTRIFUGE",
            Material.GRINDSTONE,
            "&7离心机",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS);

    public static final SlimefunItemStack ELECTRIC_CENTRIFUGE = new SlimefunItemStack(
            "ELECTRIC_CENTRIFUGE",
            Material.IRON_BLOCK,
            "&7电动离心机 &eI",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS,
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.speed(1),
            LoreBuilder.powerPerSecond(12));

    public static final SlimefunItemStack ELECTRIC_CENTRIFUGE_2 = new SlimefunItemStack(
            "ELECTRIC_CENTRIFUGE_2",
            Material.IRON_BLOCK,
            "&7电动离心机 &eII",
            "",
            EXTRACTS_MATERIALS_FROM_COMBS,
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(36));
    // </editor-fold>

    // <editor-fold desc="Various" defaultstate="collapsed">
    public static final SlimefunItemStack BEEALYZER = new SlimefunItemStack(
            "BEEALYZER",
            Material.ITEM_FRAME,
            "&7蜜蜂分析仪",
            "",
            LoreBuilder.powerCharged(0, 50),
            "",
            "&f养蜂人最信赖的工具",
            "&f该物品用于识别各种",
            "&f蜜蜂的特征",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE);

    public static final SlimefunItemStack TOME_OF_DISCOVERY_SHARING = new SlimefunItemStack(
            "TOME_OF_DISCOVERY_SHARING",
            Material.ENCHANTED_BOOK,
            "&6蜜蜂知识巨著",
            loreOwner("None"),
            "",
            "&e右击&7 绑定你的蜜蜂研究",
            "",
            "&e右击&7 获取绑定者的所有研究");

    public static final CustomItemStack CONSULT_BEE_ATLAS_RECIPE_ITEM = new CustomItemStack(
            Material.ENCHANTED_BOOK,
            ChatColor.WHITE + "蜜蜂图鉴",
            "",
            ChatColor.GRAY + "请查阅蜜蜂图鉴或wiki",
            ChatColor.GRAY + "以获取更多相关信息");

    public static final ItemStack[] CONSULT_BEE_ATLAS_RECIPE = new ItemStack[] {
            null, null, null,
            null, ItemStacks.CONSULT_BEE_ATLAS_RECIPE_ITEM, null,
            null, null, null };

    public static final CustomItemStack CENTRIFUGE_COMB_RECIPE_ITEM = new CustomItemStack(
            Material.HONEYCOMB,
            ChatColor.YELLOW + "任意蜂蜡",
            "",
            ChatColor.GRAY + "请将任意蜂蜡放入离心机内");

    public static final ItemStack[] CENTRIFUGE_COMB_RECIPE = new ItemStack[] {
            null, null, null,
            null, ItemStacks.CENTRIFUGE_COMB_RECIPE_ITEM, null,
            null, null, null };

    public static final SlimefunItemStack BEE_BREEDING_STACK = new SlimefunItemStack(
            "_RECIPE_BEE",
            SlimyBeesHeadTexture.PRINCESS.getAsItemStack(),
            "&e任意雄蜂+雌蜂");
    public static final SlimefunItemStack BEE_OFFSPRING_STACK = new SlimefunItemStack(
            "_RECIPE_BEE_OFFSPRING",
            Material.HONEYCOMB,
            "&6蜜蜂后代");
    public static final SlimefunItemStack BEE_PRODUCT_STACK = new SlimefunItemStack(
            "_RECIPE_BEE_PRODUCT",
            Material.HONEYCOMB,
            "&6蜜蜂产物");
    // </editor-fold>

    public static SlimefunItemStack createDrone(String id, String name, boolean enchanted, String... lore) {
        return createBee(
                id + "_DRONE",
                SlimyBeesHeadTexture.DRONE.getAsItemStack(),
                name + "雄蜂",
                enchanted,
                lore);
    }

    public static SlimefunItemStack createPrincess(String id, String name, boolean enchanted, String... lore) {
        return createBee(id + "_PRINCESS",
                SlimyBeesHeadTexture.PRINCESS.getAsItemStack(),
                name + "雌蜂",
                enchanted,
                lore);
    }

    private static SlimefunItemStack createBee(String id, ItemStack itemStack, String name, boolean enchanted, String... lore) {
        SlimefunItemStack item = new SlimefunItemStack(id, itemStack, name, lore);

        if (enchanted) {
            item.addUnsafeEnchantment(Enchantment.MENDING, 1);

            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);
            }
        }

        return item;
    }

    public static SlimefunItemStack createHoneycomb(String id, String name) {
        return new SlimefunItemStack(
                id + "_COMB",
                Material.HONEYCOMB,
                name + "蜂蜡");
    }

    public static String loreProductionModifier(double ratio) {
        return "&7产量: &8&lx" + String.format("%.1f", ratio);
    }

    public static String loreLifespanModifier(double ratio) {
        return "&7寿命: &8&lx" + String.format("%.1f", ratio);
    }

    public static String loreOwner(String owner) {
        return "&7主人: &b" + owner;
    }

}
