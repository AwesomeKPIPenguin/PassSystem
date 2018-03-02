package src.edu;

import java.util.*;

public class SkiPass {
	public static Map<String, Map> SkiPasses;

	static {
		SkiPasses = new HashMap<String, Map>(3);
		SkiPasses.put("Weekday", new HashMap<UUID, SkiPass>(5000));
		SkiPasses.put("Weekend", new HashMap<UUID, SkiPass>(5000));
		SkiPasses.put("Season", new HashMap<UUID, SkiPass>(5000));
	}

	private UUID ID = UUID.randomUUID();

	public UUID getID() {
		return ID;
	}
}
