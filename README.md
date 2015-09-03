
# avconv4java

[![Build Status](http://img.shields.io/travis/vbauer/avconv4java.svg?style=flat)](https://travis-ci.org/vbauer/avconv4java)
[![Coverage Status](https://coveralls.io/repos/vbauer/avconv4java/badge.svg)](https://coveralls.io/r/vbauer/avconv4java)
[![License](http://img.shields.io/badge/License-Apache%2C%20Version%202.0-blue.svg?style=flat)](http://opensource.org/licenses/Apache-2.0)
[![Maven](https://img.shields.io/github/tag/vbauer/avconv4java.svg?label=maven)](https://jitpack.io/#vbauer/avconv4java)


## Introduction

<img align="right" style="margin-left: 15px; box-shadow: 5px 5px 5px #888;" width="250" height="250" src="misc/logo.png">

**avconv** tool is a part of the [Libav](http://libav.org) project (originates from the FFmpeg codebase).
It is a fast and powerful video and audio converter.
Libav supports most common instruction set architectures (including IA-32, x86-64, PowerPC, ARM, etc.) with great performance.

**avconv4java** is a simple pure-java interface to the [avconv](http://libav.org/avconv.html) command-line tool.
API was designed with KISS principle in mind to be as simple as possible.


## Features

* Most avconv commands are supported (and tested in real projects).
* Parallel processing is supported out of box.
* It has a very simple API with fluent interfaces and method chaining.
* Options and operators are transformed into similar method-names, e.g.
    * -vcodec libx264 -> .videoCodec(AVVideoCodecType.H264)
    * -vcodec libtheora -> .videoCodec(AVVideoCodecType.THEORA)
    * -vcodec libtheora -> .videoCodec("libtheora")


## Setup

Maven:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.vbauer</groupId>
    <artifactId>avconv4java</artifactId>
    <version>1.1.0</version>
</dependency>
```

Gradle:
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.vbauer:avconv4java:1.1.0'
}
```


## Example

First of all you need to configure options for avconv command. Builder pattern allows to do it as simple as possible:

```java
final AVRootOptions options = AVRootOptions.create("input.avi", "output.mp4")
    .builders(
        AVMainOptions.create()
            .overwriteOutput(),
        AVVideoOptions.create()
            .proportionalResizeUsingWidth(800)
            .videoCodec(AVVideoCodecType.H264)
            .movFlags(AVMovFlagsType.FAST_START),
        AVAudioOptions.create()
            .audioCodec(AVAudioCodecType.VISUAL_ON_AAC)
            .audioBitRate(128)
            .audioChannelsCount(2)
            .sampleRate(11025),
        AVCodecOptions.create()
            .bitRate(1000)
    )
```

To execute avconv command with needed options you should use the class com.avconv4java.core.AVCommnad:

```java
// It'll be better to configure timeout always. Debug is useful sometimes.
final AVCommand command = AVCommand.create()
    .setDebug(true)
    .setTimeout(timeout);

final int returnCode = command.run(options);
final String outputFile = options.getOutputFile();

Logger.getGlobal().info(
    String.format("Output file: %s, return code: %d", outputFile, returnCode)
);

```

This command is equivalent to the following:


```bash
/usr/bin/avconv -i input.avi -y -vf scale=w=800:h=trunc(ow/a/2)*2 -vcodec libx264 -movflags faststart -acodec libvo_aacenc -ab 128k -b 1000k -ac 2 -ar 11025 output.mp4
```


## FAQ

<dl>
    <dt>What is the default avconv path value?</dt>
    <dd>Environment variable "AVCONV4JAVA_TOOLPATH" will be checked in priority, otherwise it will be "/usr/bin/avconv".</dd>
</dl>


## Might also like

* [jconditions](https://github.com/vbauer/jconditions) - Extra conditional annotations for JUnit.
* [jackdaw](https://github.com/vbauer/jackdaw) - Java Annotation Processor which allows to simplify development.
* [houdini](https://github.com/vbauer/houdini) - Type conversion system for Spring framework.
* [herald](https://github.com/vbauer/herald) - Logging annotation for Spring framework.
* [caesar](https://github.com/vbauer/caesar) - Library that allows to create async beans from sync beans.
* [commons-vfs2-cifs](https://github.com/vbauer/commons-vfs2-cifs) - SMB/CIFS provider for Commons VFS.


## License

```
Copyright 2014 Vladislav Bauer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
