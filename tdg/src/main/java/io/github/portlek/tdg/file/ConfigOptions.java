package io.github.portlek.tdg.file;

import io.github.portlek.itemstack.util.Colored;
import io.github.portlek.mcyaml.IYaml;
import io.github.portlek.tdg.TDG;
import io.github.portlek.tdg.hooks.PAPIHook;
import org.cactoos.Scalar;
import org.jetbrains.annotations.NotNull;

public class ConfigOptions implements Scalar<Config> {

    @NotNull
    private final IYaml yaml;

    public ConfigOptions(@NotNull IYaml yaml) {
        this.yaml = yaml;
    }

    @Override
    public Config value() {
        yaml.create();

        final String language = yaml.getString("Language").orElse("en");
        final boolean updateCheck = yaml.getBoolean("Update-Check");
        final String pluginPrefix = new Colored(yaml.getString("Plugin-Prefix").orElse("&6[&a&lTDG&6]")).value();
        final int menuCooldown = yaml.getInt("Menu-Cooldown");
        boolean placeholderAPI = yaml.getBoolean("Hooks.PlaceholderAPI");
        final PAPIHook papiHook = new PAPIHook();

        if (placeholderAPI) {
            placeholderAPI = papiHook.initiate();

            if (placeholderAPI) {
                TDG.getAPI().tdg.getServer().getLogger().info("PlaceholderAPI hooked!");
            }
        }

        return new Config(
            language,
            updateCheck,
            pluginPrefix,
            menuCooldown,
            placeholderAPI,
            papiHook
        );
    }

}