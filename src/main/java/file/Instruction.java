package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import lawn.Grid;
import mower.Commands;
import mower.Mower;
import orientations.News;

public class Instruction {

	private static final String SEPARATOR = " ";
	private final String path;

	public Instruction(String path) {
		this.path = path;
	}

	private List<String> lines() {
		List<String> lines = new ArrayList<>();
		try (FileInputStream fstream = new FileInputStream(path)) {
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				lines.add(strLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	public List<Mower> mowers() {
		List<Mower> mowers = new ArrayList<>();
		List<String> lines = lines();
		Grid grid = grid(lines.get(0));
		for (int i = 1; i < lines.size(); i += 2) {
			String spawn = lines.get(i);
			int x = Integer.parseInt(spawn.split(SEPARATOR)[0]);
			int y = Integer.parseInt(spawn.split(SEPARATOR)[1]);
			News o = News.news(spawn.split(SEPARATOR)[2].charAt(0));
			String movement = lines.get(i + 1);
			Mower mower = new Mower(x, y, o, commands(movement), grid);
			mowers.add(mower);
		}
		return mowers;
	}

	private List<Commands> commands(String line) {
		List<Commands> commands = new ArrayList<>();
		for (int i = 0; i < line.length(); i++) {
			Commands command = Commands.command(line.charAt(i));
			commands.add(command);
		}
		return commands;
	}

	private Grid grid(String instruction) {
		int borderX = Integer.parseInt(instruction.split(SEPARATOR)[0]);
		int borderY = Integer.parseInt(instruction.split(SEPARATOR)[1]);
		Grid grid = new Grid(borderX, borderY);
		return grid;
	}
}
