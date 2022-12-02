package StorePanel;

public class ColorPalette {

	public static String getColorPalette(int colorNbr){
		String[] color = {
				"#6b7967", 	//Xanadu Green
				"#d5e1a3",	//Pale Spring Bud Green
				"#c1292e",	//Fire Engine Red
				"#4d9de0",	//Coralina Blue
				"#94aedb"	//Wild Blue Yonder
		};
		return color[colorNbr];
	}
}
