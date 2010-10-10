package org.odlabs.wiquery.examples.themes;

import java.util.ArrayList;
import java.util.List;


public class Themes {

	public static final List<UITheme> themes = new ArrayList<UITheme>();
	
	static {
		themes.add(BlackTieTheme.getInstance());
		themes.add(BlitzerTheme.getInstance());				
		themes.add(CupertinoTheme.getInstance());		
		themes.add(DarkHiveTheme.getInstance());
		themes.add(DotLuvTheme.getInstance());
		themes.add(EggPlantTheme.getInstance());
		themes.add(ExciteBikeTheme.getInstance());
		themes.add(FlickTheme.getInstance());
		themes.add(HotSneaksTheme.getInstance());
		themes.add(HumanityTheme.getInstance());
		themes.add(LeFrogTheme.getInstance());
		themes.add(RedmondTheme.getInstance());			
		themes.add(FusionTheme.getInstance());	
		
	}
}
