package com.drunkdevelopers.microjs.language.types;

public class ZContainer extends ZProtoObject{

    public final String label;
    public final ZProtoObject content;

    public ZContainer(String label, ZProtoObject content) {
        this.label = label;
        this.content = content;
    }

    @Override
    public String toNiceString() {
        return content.toNiceString();
    }
}
