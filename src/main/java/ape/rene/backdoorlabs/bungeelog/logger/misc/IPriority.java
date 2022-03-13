package ape.rene.backdoorlabs.bungeelog.logger.misc;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Optional;

public interface IPriority {

    void notifyPlayers(Optional<ProxiedPlayer> player,String message,Optional<Level> level);

    void notifyPlayers(String hasPermission,String message,Optional<Level> level);




}
