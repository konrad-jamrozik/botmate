# BotMate [![Build Status](https://travis-ci.org/konrad-jamrozik/botmate.svg?branch=master)](https://travis-ci.org/konrad-jamrozik/botmate)

Author: Konrad Jamrozik, github.com/konrad-jamrozik

Software for controlling BotMate, a robot used for showcasing test generation tools @ [cispa.saarland](https://cispa.saarland/).

See also: [droidmate.org](https://www.droidmate.org/)

## Running

### Initial setup

* Clone this repo.
* `cd cloned_repo_root`
* `./gradlew installDist` (on Windows always skip `./`)
* `cd demo/build/install/demo/bin`
* `./demo ports`  (on Windows, run `demo.bat` instead of `./demo`)
* Note down the ports. Plug in the robot USB cable and ensure the robot is powered on.
* `./demo ports`
* Note down the new port. Set appropriate environment variable to it, as given by `./demo` output.
* Plug in the button USB cable.
* `./demo ports`
* Note down the new port. Set appropriate environment variable to it, as given by `./demo` output.

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
