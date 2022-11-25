package StorePanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CartNamePopUpPane {
	String CartNameValue;
	JFrame CartName;
	public CartNamePopUpPane() {
		CartName = new JFrame();
		CartNameValue = JOptionPane.showInputDialog(CartName,"Enter a Name for your new Cart!");   
	}

	public String getCartNameValue() {
		return CartNameValue;
		
	}
	
	public String getRandomName() {
		String[] easterEgg = {"Yule Angelbox",
				"Perky Chocolateplum",
				"Evergreen Muffinjoy",
				"Fig Frostgame",
				"Cocoa Wigglebeard",
				"Elm Sleepyhat",
				"Cinnamon Hotwish",
				"Buddy Chimneyicicle",
				"Blue Mittenhope",
				"Chestnut Firesong",
				"Frosty Nibblestar",
				"Tiny Snowwrap",
				"Bling Chillgift",
				"Coco Jinglefoot",
				"Buster Frostyjoke",
				"Perky Fruitsleigh",
				"Peppetmint Ribbonnight",
				"Trinket Plumhug",
				"Buddy Toffeejoke",
				"Sprinkles Hotbell",
				"Fluffy Chillbeard",
				"Trinket Chocolatescarf",
				"Trinket Everfrost",
				"Trinket Sugarscarf",
				"Mistle Muffinbox",
				"Fluffy Carolwarmth",
				"Jolly Holifrost",
				"Topper Cuddletree",
				"Jangle Nippydash",
				"Stripes Goodywine",
				"Starlight Ivyhug",
				"Peppetmint Giftbox",
				"Snowdrop Sparklemyrrh",
				"Fuzzle Milkgift",
				"Jingle Grottofoot",
				"Dash Jigglewarmth",
				"Topper Jollyfrost",
				"Tiny Sugarcard",
				"Jangle Morningmilk",
				"Fuzzle Puddingivy",
				"Yule Flippystar",
				"Faith Hollyhope",
				"Snowflake Picklegift",
				"Angel Chillycake",
				"Hazel Fruittoy",
				"Fuzzle Ivyjoy",
				"Sprinkle Twinklejoke",
				"Blue Frostytoy",
				"Clove Nibblebeard",
				"Twinkle Rhymepie",
				"Noelle Carolicicle",
				"Twinkletoes Chimneyfun",
				"Sprinkle Ciderflake",
				"Wink Ciderjoke",
				"Bubbles Firesledge",
				"Fuzzle Angellove",
				"Gingernuts Bustlecheer",
				"Tinsel Everguest",
				"Sugar Chimneymilk",
				"Sprinkles Magicfoot"};
		int rand = (int)Math.round(Math.random()*(easterEgg.length+1));  
		CartNameValue = easterEgg[rand];
		return CartNameValue;
		
	}
}