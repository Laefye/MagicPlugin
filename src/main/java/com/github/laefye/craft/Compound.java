package com.github.laefye.craft;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.StringTagVisitor;

public class Compound {
    private final NBTTagCompound compound;

    public Compound() {
        this.compound = new NBTTagCompound();
    }

    public Compound(NBTTagCompound compound) {
        this.compound = compound;
    }

    public Compound putInt(String key, int value) {
        this.compound.a(key, value);
        return this;
    }

    public Compound putString(String key, String value) {
        this.compound.a(key, value);
        return this;
    }

    public Compound putCompound(String key, Compound compound) {
        this.compound.a(key, compound.getNativeCompound());
        return this;
    }

    public Compound putBoolean(String key, boolean value) {
        this.compound.a(key, value);
        return this;
    }

    public int getInt(String key) {
        return this.compound.h(key);
    }

    public String getString(String key) {
        return this.compound.l(key);
    }

    public Compound getCompound(String key) {
        return new Compound(compound.p(key));
    }

    public boolean getBoolean(String key) {
        return compound.q(key);
    }

    public Compound remove(String key) {
        this.compound.r(key);
        return this;
    }

    public NBTTagCompound getNativeCompound() {
        return compound;
    }

    public boolean contains(String key) {
        return compound.e(key);
    }

    public static Compound fromJsonObject(JsonObject jsonObject) {
        var compound = new Compound();
        for (var key : jsonObject.asMap().keySet()) {
            if (jsonObject.get(key) instanceof JsonPrimitive primitive) {
                if (primitive.isNumber()) {
                    compound.putInt(key, primitive.getAsInt());
                }
            }
            if (jsonObject.get(key) instanceof JsonObject nextLayer) {
                compound.putCompound(key, fromJsonObject(nextLayer));
            }
        }
        return compound;
    }

    @Override
    public String toString() {
        return new StringTagVisitor().a((NBTBase) compound);
    }
}
