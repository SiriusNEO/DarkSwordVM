COMPILER = g++

SRC_DIR = src
INCLUDE_DIR = include

SRC_FILES = $(SRC_DIR)/assembler/*.cpp $(SRC_DIR)/interpreter/*.cpp $(SRC_DIR)/linker/*.cpp $(SRC_DIR)/simulator.cpp $(SRC_DIR)/implement.cpp

build: $(SRC_FILES)
	$(COMPILER) -std=c++17 -I./${INCLUDE_DIR} $(SRC_FILES) -I/usr/lib/jvm/default-java/include/ -I/usr/lib/jvm/default-java/include/linux/ -shared -fPIC -o libravel-sim.so