package other;

import gameTrows.CfgValueNotFound;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Config {
	public static final String  HEALTH_HERO = "healthHero";
	public static final String  HEALTH_MINION = "healthMinion";
	public static final String HEALTH_TOWER = "healthTower";
	public static final String  DAMAGE_MINION = "damageMinion";
	public static final String  DAMAGE_TOWER = "damageTower";
	public static final String  SPEED_MINION = "speedMinion";
	public static final String  QUANTITY_MINION = "quantityMinions";
	private final static String NAME_CFG = "cfg_game";
	private Map<String, Integer> lines;

	public Config() {
		lines = new HashMap<String, Integer>();
		getInfoCfg();
	}

	private void getInfoCfg() {
		File cfg = new File(NAME_CFG);

		if (!cfg.exists()) {
			try {
				cfg.createNewFile();
			} catch (IOException e) {
				System.err.println("file does't created");
			}
			//TODO: need create init file cfg.
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

	private void readCfgFile(File cfg) {
		BufferedReader br;
		FileReader fr;
		String splitter = "=";
		String line;
		String[] nameValue;

		try {
			br = new BufferedReader(new FileReader(cfg));
			while ((line = br.readLine()) != null) {
				nameValue = line.split(splitter);
				if (nameValue.length == 2)
					lines.put(nameValue[0].trim(), Integer.parseInt(nameValue[1].trim()));
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
