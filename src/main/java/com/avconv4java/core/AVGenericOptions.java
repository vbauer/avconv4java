package com.avconv4java.core;

import com.avconv4java.util.AVUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Vladislav Bauer
 */

public class AVGenericOptions {

    private final List<AVGenericOptions> builders = new LinkedList<AVGenericOptions>();
    private final List<String> arguments = new LinkedList<String>();


    public static AVGenericOptions create() {
        return new AVGenericOptions();
    }


    @Override
    public String toString() {
        return AVUtils.join(build());
    }


    public AVGenericOptions flags(final Object... flags) {
        if (flags != null && flags.length > 0) {
            final List<String> newFlags = new LinkedList<String>();
            for (final Object flag : flags) {
                if (flag == null) {
                    return this;
                }
                newFlags.add(String.valueOf(flag));
            }
            arguments.addAll(newFlags);
        }
        return this;
    }

    public AVGenericOptions builders(final AVGenericOptions... builders) {
        if (builders != null && builders.length > 0) {
            for (final AVGenericOptions builder : builders) {
                if (builder instanceof AVOptions) {
                    throw new IllegalArgumentException("It's impossible to add root options as child node");
                }
                this.builders.add(builder);
            }
        }
        return this;
    }

    public List<String> build() {
        final List<String> result = new LinkedList<String>();
        result.addAll(arguments);
        for (final AVGenericOptions builder : builders) {
            result.addAll(builder.build());
        }
        return result;
    }


    public final String kb(final Number value) {
        return value == null ? null : value + "k";
    }

    public final String sec(final Double position) {
        return position == null ? null : String.format("%.2f", position);
    }

}
