package other;

import gameTrows.CfgValueNotFound;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Config {
	private final static String NAME_CFG = "cfg_game";
	private Map<String, Integer> lines;

	public Config() {
		lines = new HashMap<String, Integer>();
		getInfoCfg();
//		printMap();
	}

	private void getInfoCfg() {
		File cfg = new File(NAME_CFG);

		if (!cfg.exists()) {
			try {
				cfg.createNewFile();
			} catch (IOException e) {
				System.err.println("file does't created");
			}
			//initCfg()
		}
		else {
			readCfgFile(cfg);
		}
	}

	public int getCfgValue(String name) throws CfgValueNotFound {
		if (!lines.containsKey(name))
			throw new CfgValueNotFound();
		else
			return (lines.get(name));
	}

	public static void main(String[] args) {
		Config cfg = new Config();
		int date = 0;

		try {
			date = cfg.getCfgValue("Other");
		} catch (CfgValueNotFound e) {
			System.out.println("Значение не найденно");
		}
		System.out.println("Other: " + date);
	}

	private void readCfgFile(File cfg) {
		BufferedReader br;
		FileReader fr;
		String line;
		String[] nameValue = new String[2];

		try {
			br = new BufferedReader(new FileReader(cfg));
			while ((line = br.readLine()) != null) {
				nameValue = line.split(":");
				lines.put(nameValue[0], Integer.parseInt(nameValue[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printMap() {
		for (Map.Entry<String, Integer> iter : lines.entrySet()) {
			System.out.printf("key: %s  value: %s\n", iter.getKey(), iter.getValue());
		}
	}
}
