package ape.rene.backdoorlabs.bungeelog.logger.misc.priority;

import ape.rene.backdoorlabs.bungeelog.logger.misc.IPriority;
import ape.rene.backdoorlabs.bungeelog.logger.misc.Level;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class AbstractPriority implements IPriority {
    @Getter
    public final int index;
    @Getter
    @Setter
    public boolean shouldNotify = false;
    @Getter
    @Setter
    public boolean shouldShutdown = false;
    @Getter
    @Setter
    public boolean isCritical = false;
    @Getter
    public final String name;
    @Getter
    public String prefix;


    protected AbstractPriority(final int index, final boolean shouldNotify, final boolean shouldShutdown, final boolean isCritical, final String name, Optional<String> prefix) {
        this.index = index;
        this.shouldNotify = shouldNotify;
        this.shouldShutdown = shouldShutdown;
        this.isCritical = isCritical;
        this.name = name;
        prefix.ifPresent(s -> this.prefix = s);

    }

    @Override
    public void notifyPlayers(Optional<ProxiedPlayer> player, String message,Optional<Level> level) {
        if(shouldNotify) {
            if(player.isPresent()) {
                final ProxiedPlayer proxiedPlayer = player.get();
                if(proxiedPlayer.isConnected()) {
                        proxiedPlayer.sendMessage(messageHelper(Optional.ofNullable(this.prefix),level,message));
                }
            }
        }
    }

    @Override
    public void notifyPlayers(String hasPermission, String message,Optional<Level> level) {

    }

    private String messageHelper(Optional<String> prefix, Optional<Level> level,String message) {
        final StringBuilder stringBuilder = new StringBuilder();
        prefix.ifPresent(stringBuilder::append);
        stringBuilder.append(" ");
        if(level.isPresent()) {
            stringBuilder.append(capitalize(level.toString()));
            stringBuilder.append(" ");
        }
        stringBuilder.append(message);
        return stringBuilder.toString();
    }

    private String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
