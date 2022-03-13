package ape.rene.backdoorlabs.bungeelog.logger;

import ape.rene.backdoorlabs.bungeelog.logger.misc.IPriority;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Level;

public abstract class AbstractLogger {

    @Setter
    @Getter
    public Level level;
    @Setter
    @Getter
    public IPriority priority;
    @Getter
    public final String name;

    public AbstractLogger(final String name) {
        this.name = name;
    }


}
