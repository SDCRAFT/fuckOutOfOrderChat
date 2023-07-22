package me.heartalborada.fuckoutoforderchat;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FuckOutOfOrderChat implements DedicatedServerModInitializer {
    public static final Logger LOG = LoggerFactory.getLogger("FuckOutOfOrderChat");
    @Override
    public void onInitializeServer() {
        LOG.info("Fuck Out Of Order Chat");
    }
}
