package com.github.laefye.tools;

import net.minecraft.nbt.NBTTagCompound;

public class Compound {
    private final NBTTagCompound compound;

    public Compound(NBTTagCompound compound) {
        this.compound = compound;
    }

    public Compound setInt(String key, int value) {
        this.compound.a(key, value);
        return this;
    }

    public Compound setString(String key, String value) {
        this.compound.a(key, value);
        return this;
    }

    public int getInt(String key) {
        return this.compound.h(key);
    }

    public String getString(String key) {
        return this.compound.l(key);
    }

    public Compound remove(String key) {
        this.compound.r(key);
        return this;
    }

    public NBTTagCompound getCompound() {
        return compound;
    }

    public boolean contains(String key) {
        return compound.e(key);
    }
}
