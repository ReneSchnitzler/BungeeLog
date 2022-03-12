package ape.rene.backdoorlabs.bungeelog;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class Bungeelog extends Plugin {

    @Getter
    public static Bungeelog bungeelog;

    @Override
    public void onEnable() {
        bungeelog = this;
    }
}
