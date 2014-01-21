Introduction
============

Project "avconv4java" is a pure-java interface to the avconv commandline.
Official avconv documentation is [here](http://libav.org/avconv.html).

Features
========

* Supports most avconv commands
* Reuse a commandline multiple times for different set of parameters
* Options and operators translate into similar method-names, e.g.
    * -vcodec libx264 -> .videoCodec(AVVideoCodecType.H264)
    * -vcodec libtheora -> .videoCodec(AVVideoCodecType.THEORA)
* Parallel processing out of box
* Architecture supports arbitrary commandline-tools
