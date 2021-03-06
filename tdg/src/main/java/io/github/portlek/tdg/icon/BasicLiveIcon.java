package io.github.portlek.tdg.icon;

import io.github.portlek.tdg.TDG;
import io.github.portlek.tdg.api.Icon;
import io.github.portlek.tdg.api.LiveIcon;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class BasicLiveIcon implements LiveIcon {

    public static final List<Player> view = new ArrayList<>();

    public static final List<Player> toHide = new ArrayList<>();

    @NotNull
    private final Icon parent;

    @NotNull
    private final List<ArmorStand> armorStands;

    public BasicLiveIcon(@NotNull Icon parent, @NotNull List<ArmorStand> armorStands) {
        this.parent = parent;
        this.armorStands = armorStands;
    }

    @Override
    public boolean is(@NotNull Entity entity) {
        if (entity instanceof ArmorStand) {
            return armorStands.contains(entity);
        }

        return false;
    }

    @Override
    public void close() {
        for (ArmorStand armorStand : armorStands) {
            TDG.getAPI().menus.entities.remove(armorStand);
            armorStand.remove();
        }
    }

    @NotNull
    @Override
    public Icon getParent() {
        return parent;
    }

}
