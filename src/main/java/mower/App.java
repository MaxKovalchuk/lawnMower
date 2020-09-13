package mower;

import java.util.List;

import file.Instruction;

public class App {
	public static void main(String[] args) {
		Instruction instruction = new Instruction("instruction.txt");
		List<Mower> mowers = instruction.mowers();
		for(Mower mower : mowers) {
			new Thread(mower).start();
		}
	}
}
