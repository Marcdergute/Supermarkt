package StorePanel;

public class ColorPalette {

	public static String getColorPalette(int colorNbr){
		String[] color = {
				"#71826B", 	//Xanadu Green 0
				"#CCDBBC",	//Pale Spring Bud Green 1
				"#c1292e",	//Fire Engine Red 2
				"#4d9de0",	//Coralina Blue 3
				"#94aedb",	//Wild Blue Yonder 4
				"#60BA00",	//conformation green 5
				"#DFDFDF"	//grey 6
		};
		return color[colorNbr];
	}
}
