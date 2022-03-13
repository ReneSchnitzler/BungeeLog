package ape.rene.backdoorlabs.bungeelog.handler;

import ape.rene.backdoorlabs.bungeelog.association.IUse;
import lombok.Getter;

public abstract class AbstractHandler {

    @Getter
    public final IUse usage;


    public AbstractHandler(IUse usage) {
        this.usage = usage;
    }

}
