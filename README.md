Wildflower Raspberry Pi Yocto Image
===================================

This creats an image for MicroSD cards for the Raspberry Pi for use in the
classrooms.



To Build
========

1. Clone

  $ git clone --recursive git@github.com:WildflowerSchools/classroom_yocto_build.git

2. Init OE Environment

  $ cd classroom_yocto_build
  $ source poky/oe-init-build-env

3. Build

  $ bitbake core-image-wildflower

4. Write image to SD card

  $ pv tmp/deploy/images/raspberrypi3/core-image-wildflower-raspberrypi3.rpi-sdimg | sudo dd oflag=sync bs=4M of=/dev/sdX
