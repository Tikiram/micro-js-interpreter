package com.drunkdevelopers.microjs.language.types;

import java.util.HashMap;
import java.util.Map;

public abstract class ZProtoObject {


    public final Map<String, ZProtoObject> members = new HashMap<>();

    public abstract String toNiceString();

}

