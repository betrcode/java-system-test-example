#!/usr/bin/env bash

java -DconfigFile="${1}" -cp $(find ./build/libs/ -name "system-tests*.jar" -print) org.junit.runner.JUnitCore ${2}
