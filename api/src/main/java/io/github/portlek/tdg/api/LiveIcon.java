package io.github.portlek.tdg.api;

import io.github.portlek.tdg.api.events.IconClickEvent;
import io.github.portlek.tdg.api.events.IconHoverEvent;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface LiveIcon extends Parent<Icon> {

    boolean is(@NotNull Entity entity);

    void close();

    void accept(@NotNull IconClickEvent event);

    void accept(@NotNull IconHoverEvent event);

}
