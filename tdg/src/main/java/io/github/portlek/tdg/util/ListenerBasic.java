package io.github.portlek.tdg.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListenerBasic<T extends Event> {

    @NotNull
    private final Class<T> tClass;

    @NotNull
    private final Predicate<T> predicate;

    @NotNull
    private final Consumer<T> consumer;

    public ListenerBasic(@NotNull Class<T> tClass, @NotNull Predicate<T> predicate, @NotNull Consumer<T> consumer) {
        this.tClass = tClass;
        this.predicate = predicate;
        this.consumer = consumer;
    }

    public ListenerBasic(@NotNull Class<T> tClass, @NotNull Consumer<T> consumer) {
        this(tClass, t -> true, consumer);
    }

    public void register(@NotNull Plugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvent(
            tClass,
            new Listener() {},
            EventPriority.NORMAL,
            (listener, event) -> {
                if (event.getClass().isAssignableFrom(tClass) && predicate.test((T) event)) {
                    consumer.accept((T) event);
                }
            },
            plugin
        );
    }

}
