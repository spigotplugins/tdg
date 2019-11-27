package io.github.portlek.tdg.target;

import io.github.portlek.tdg.api.Requirement;
import io.github.portlek.tdg.api.Target;
import io.github.portlek.tdg.api.events.abs.MenuEvent;
import org.cactoos.list.ListOf;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class BasicTarget<T extends MenuEvent> implements Target<T> {

    @NotNull
    private final Target<T> target;

    @NotNull
    private final List<Requirement> requirements;

    public BasicTarget(@NotNull Target<T> target, @NotNull List<Requirement> requirements) {
        this.target = target;
        this.requirements = requirements;
    }

    public BasicTarget(@NotNull Target<T> target, @NotNull Requirement... requirements) {
        this(target, new ListOf<>(requirements));
    }

    @Override
    public void handle(@NotNull T event) {
        if (requirements.stream().allMatch(requirement -> requirement.control(event))) {
            target.handle(event);
        }
    }

}
