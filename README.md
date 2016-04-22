# BotMate [![Build Status](https://travis-ci.org/konrad-jamrozik/botmate.svg?branch=master)](https://travis-ci.org/konrad-jamrozik/botmate)

Author: Konrad Jamrozik, github.com/konrad-jamrozik

Software for controlling BotMate, a robot used for showcasing test generation tools @ [cispa.saarland](https://cispa.saarland/).

The robot is setup to work with Nexus 10 tablet in landscape mode. When full demo is run, it will look as
if the robot opens the apps screen, opens Google Keep, adds a "Hello!" note, deletes it, and goes back to home screen.

In reality, the tablet is controlled independently of the robot. The tablet is just synchronized with the robot to make an 
illusion the robot clicks, not software.

See also: [droidmate.org](https://www.droidmate.org/)

## Running

### Initial setup

* Ensure you have installed  `JDK 8` and `adb` from Android SDK. `adb` has to be on `PATH`.
  * On Windows you will probably need to install `Android SDK` and `Platform-tools` and adjust the `PATH`.
  * On Linux, instead just `sudo apt-get install android-tools-adb` is enough.
* `git clone https://github.com/konrad-jamrozik/botmate.git`
* `cd botmate`
* `./gradlew build`
* `./gradlew installDist`
  * On Windows always skip `./`
  * On Linux first do `chmod +x gradlew`
* `cd demo/build/install/demo/bin`
* `./demo ports` 
  * On Windows always run `demo.bat` instead of `./demo`
* Note down the ports. Plug in the robot USB cable and ensure the robot is powered on.
* `./demo ports`
* Note down the new port. Set appropriate environment variable to point to it. Variable name to set is explained by `./demo` 
(without any arguments) output. 
  * On Linux, if no ports are visible, first do `sudo su`. 
* Plug in the button USB cable.
* `./demo ports`
* Note down the new port. Set appropriate environment variable to point to it. Variable name to set is explained by `./demo` 
(without any arguments) output. 

### Testing
* `./demo demo testDevice` to check the Android device works.
* `./demo demo testRobot` to check the robot works.
* `./demo button stubBoth` to check the button works.

### Final, full setup
* `./demo button full`

## Interactive robot control

The class `RobotInteractiveTester` can be used for interactive controlling/testing 
of the robot. When running it remember to set the VM option `java.library.path`. For example, on Windows x64:  
`-Djava.library.path=C:\botmate\controller\libs_serialPort\Windows_x64`

## Sources

The code was developed in IntelliJ IDEA. 

### Demo project
The main project is `demo`. For the app entry point, look for `main.kt` in package 
`com.konradjamrozik.botmate.demo`.  
There are JUnit IntelliJ-runnable tests in `ButtonTest` and `DemoTest`.   
Gradle test tasks can be found in `test.gradle`.

### Controller project
The `controller` project contains legacy code written in March 2013 to control the robot, with some adaptations. The `demo` 
project uses this project, with main bridging class being `RobotControllerAdapter`, located in `demo` project.

### RXTXComm-src

The `cloned_repo_root/controller/libs_serialPort_origin/RXTXcomm-src` contains sources of the `RTXTComm` used in BotMate. It has
two modifications:
* Added turning on debug output to stdout if `RXTX_DEBUG` environment variable is set.
* Made RXTX scan much more ports on Linux.

Search for `Konrad Jamrozik` in the java sources to find the modifications. 
The original `RXTX-comm` src can be found in `libs_serialPort_origin/rxtx.zip`. 

The IntelliJ project has a jar artifact defined that on build will copy the output to the correct location. It will be picked up
by `./gradlew installDist` .