package com.example.addon;

import com.example.addon.modules.NoCarpets;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplate extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("No Carpets Addon");

    @Override
    public void onInitialize() {
        LOG.info("Initializing No Carpets Addon");

        // Register modules
        Modules.get().add(new NoCarpets());
        
        LOG.info("No Carpets Addon initialized successfully!");
    }

    @Override
    public void onRegisterCategories() {
        // Register custom categories if needed
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
