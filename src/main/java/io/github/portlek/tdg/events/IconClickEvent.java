package io.github.portlek.tdg.events;

import io.github.portlek.tdg.LiveIcon;
import io.github.portlek.tdg.OpenedMenu;
import io.github.portlek.tdg.events.abs.IconEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

public final class IconClickEvent extends IconEvent implements Cancellable {

    private boolean cancelled;

    public IconClickEvent(@NotNull Player who, @NotNull OpenedMenu menu, @NotNull LiveIcon liveIcon, boolean cancelled) {
        super(who, menu, liveIcon);
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}