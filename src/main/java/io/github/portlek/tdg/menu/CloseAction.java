package io.github.portlek.tdg.menu;

import io.github.portlek.mcyaml.IYaml;
import org.cactoos.list.ListOf;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class CloseAction {

    @NotNull
    public static List<CloseAction> parse(@NotNull IYaml yaml, @NotNull String menuId) {
        return new ListOf<>();
    }

}
