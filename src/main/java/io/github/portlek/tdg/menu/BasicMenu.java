package io.github.portlek.tdg.menu;

import io.github.portlek.tdg.Icon;
import io.github.portlek.tdg.Menu;
import io.github.portlek.tdg.OpenedMenu;
import io.github.portlek.tdg.TDG;
import org.bukkit.entity.Player;
import org.cactoos.list.ListOf;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class BasicMenu implements Menu {

    @NotNull
    private final String id;

    @NotNull
    private final List<String> commands;

    @NotNull
    private final List<CloseAction> closeAction;

    @NotNull
    private final List<OpenAction> openAction;

    private final int x1;

    private final int x2;

    private final int x4;

    private final int x5;

    @NotNull
    private final List<Icon> icons;

    public BasicMenu(@NotNull String id, @NotNull List<String> commands, @NotNull List<CloseAction> closeAction,
                     @NotNull List<OpenAction> openAction, int x1, int x2, int x4, int x5, @NotNull List<Icon> icons) {
        this.id = id;
        this.commands = commands;
        this.closeAction = closeAction;
        this.openAction = openAction;
        this.x1 = x1;
        this.x2 = x2;
        this.x4 = x4;
        this.x5 = x5;
        this.icons = icons;
    }

    @NotNull
    @Override
    public String getId() {
        return id;
    }

    @NotNull
    @Override
    public List<String> getCommands() {
        return commands;
    }

    @Override
    public void open(@NotNull Player player) {
        final OpenedMenu openedMenu = new BasicOpenMenu(this, player);



        TDG.getAPI().opened.put(player.getUniqueId(), openedMenu);
    }

}
